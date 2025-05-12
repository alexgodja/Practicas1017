package Modelo;

import Modelo.algorithms.*;
import Modelo.data.CSVLabeledFileReader;
import Modelo.data.table.Table;
import Modelo.data.table.TableWithLabels;
import Modelo.recommender.RecSys;

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
        // 1) Cargar nombres y datos
        List<String> nombres = cargarListaCanciones();
        CSVLabeledFileReader reader = new CSVLabeledFileReader(songsFolder + separator + "songs_train.csv");
        TableWithLabels tabla = (TableWithLabels) reader.readTableFromSource();

        // 2) Crear la métrica de distancia
        Distance dist = "Euclidea".equalsIgnoreCase(distancia)
                ? new EuclideanDistance()
                : new ManhattanDistance();

        // 3) Instanciar el algoritmo adecuado según el tipo
        Algorithm<TableWithLabels, Integer, List<Double>> algorithm;
        if ("Similitudes".equalsIgnoreCase(algoritmo)) {
            // Usamos KNN con 1 vecino más cercano para la parte de similitudes
            algorithm = new KNN(dist);
        } else if ("Género".equalsIgnoreCase(algoritmo)) {
            // Obtener los géneros únicos a partir de las etiquetas
            List<String> etiquetas = tabla.getHeaders();  // Suponiendo que 'getLabels' devuelve las etiquetas (géneros)
            Set<String> generosUnicos = new HashSet<>(etiquetas);  // Usamos un Set para obtener géneros únicos
            int numClusters = generosUnicos.size();  // Número de clusters es igual a los géneros únicos

            // Usamos KMeans con el número adecuado de clusters, 100 iteraciones y una semilla aleatoria
            long seed = System.currentTimeMillis();  // Semilla aleatoria basada en el tiempo
            algorithm = new KMeans(numClusters, 100, seed, dist);
        } else {
            throw new IllegalArgumentException("Algoritmo desconocido: " + algoritmo);
        }

        // 4) Inicializar RecSys y generar recomendaciones
        RecSys recSys = new RecSys(algorithm);
        recSys.train(tabla);
        recSys.initialise(tabla, nombres);
        return recSys.recommend(cancionBase, numRecs);
    }







}
