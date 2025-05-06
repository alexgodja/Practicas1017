package Modelo;

import Modelo.algorithms.*;
import Modelo.data.CSVLabeledFileReader;
import Modelo.data.table.TableWithLabels;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class ImplementacionModelo implements InterrogaModelo {


    private final String songsFolder = "recommender";
    private final String separator = System.getProperty("file.separator");

    public ImplementacionModelo(){}

    //InformaVista
    @Override
    public List<String> cargarListaCanciones() throws IOException, URISyntaxException {


        String ruta = songsFolder + separator  + "songs_train_names.csv";
        URL resource = getClass().getClassLoader().getResource(ruta);
        if (resource == null) {
            throw new URISyntaxException(ruta, "Archivo no encontrado");
        }


        return Files.readAllLines(Paths.get(resource.toURI()))
                .stream().map(String::trim).collect(Collectors.toList());
    }

    @Override
    public List<String> generarRecomendaciones(String algoritmo, String distancia, String cancionBase, int numRecs) throws Exception {

        // 1) Cargo nombres
        List<String> nombres = cargarListaCanciones();

        // 2) Leo TODO el CSV (features + etiqueta) de golpe
        CSVLabeledFileReader reader =
                new CSVLabeledFileReader(songsFolder + separator  + "songs_train.csv");
        TableWithLabels tabla = (TableWithLabels) reader.readTableFromSource();

        // 3) Índice y vector de la base
        int idxBase = nombres.indexOf(cancionBase);
        if (idxBase < 0) throw new IllegalArgumentException("No existe: " + cancionBase);
        List<Double> vectorBase = tabla.getRowAt(idxBase).getData();

        // 4) Instancio la métrica
        Distance dist = "Euclidea".equalsIgnoreCase(distancia)
                ? new EuclideanDistance()
                : new ManhattanDistance();

        List<Map.Entry<String,Double>> lista = new ArrayList<>();

        if ("Similitudes".equalsIgnoreCase(algoritmo)) {
            // 5a) Calculo distancia a todas (ignoro la etiqueta)
            for (int i = 0; i < nombres.size(); i++) {
                if (i == idxBase) continue;
                double d = dist.calculateDistance(
                        vectorBase,
                        tabla.getRowAt(i).getData()
                );
                lista.add(new AbstractMap.SimpleEntry<>(nombres.get(i), d));
            }

        } else if ("Género".equalsIgnoreCase(algoritmo)) {
            // 5b) Sólo mismas etiquetas
            String etiquetaBase = tabla.getRowAt(idxBase).getLabel();
            for (int i = 0; i < nombres.size(); i++) {
                if (i == idxBase) continue;
                if (!etiquetaBase.equals(tabla.getRowAt(i).getLabel()))
                    continue;
                double d = dist.calculateDistance(
                        vectorBase,
                        tabla.getRowAt(i).getData()
                );
                lista.add(new AbstractMap.SimpleEntry<>(nombres.get(i), d));
            }

        } else {
            throw new IllegalArgumentException("Algoritmo desconocido: " + algoritmo);
        }

        // 6) Ordenar y quedarnos con los top-k
        return lista.stream()
                .sorted(Comparator.comparingDouble(Map.Entry::getValue))
                .limit(numRecs)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }









}
