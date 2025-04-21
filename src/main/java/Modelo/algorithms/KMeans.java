package Modelo.algorithms;

import Modelo.data.table.Row;
import Modelo.data.table.Table;
import Modelo.excepciones.InvalidClusterNumberException;

import java.util.*;

public class KMeans implements Algorithm<Table,Integer,List<Double>> {
    private final int numClusters; // número de grupos
    private final int numIterations; // iteraciones
    private final long seed; //semilla
    private final Map<Integer, List<Double>> centroides=new HashMap<>();// centroides
    private Map<Integer,List<Row>> grupos; //Mapa que almacena los grupos de flores
    private final Distance distance; // Objeto Distance

    // Constructor. Almacena número de grupos, iteraciones y semilla.
    public KMeans(int numClusters, int numIterations, long seed, Distance distance) {
        this.numClusters = numClusters;
        this.numIterations = numIterations;
        this.seed = seed;
        this.distance = distance;
    }

    //Método train. Encuentra unos centroides como representantes de cada grupo.
    @Override
    public void train(Table data) {

        //Excepción
        if (numClusters > data.getRowCount()) {
            throw new InvalidClusterNumberException(numClusters, data.getRowCount());
        }

        //Para cada grupo de flores se escoge un centroide aleatoriamente la primera vez
        Random random=new Random(seed);

        for (int i=1;i<=numClusters;i++){
            int randomIndex = random.nextInt(data.getRowCount());
            List<Double> fila = data.getRowAt(randomIndex).getData();
            centroides.put(i, fila);
        }

        //Asigar los datos a un grupo y recalcular los centroides numIteraciones veces
        for (int i=0; i < numIterations; i++){
            //Se inicializan los grupos
            inicializarGrupos();

            //Añadir cada punto a su grupo correspondiente
            asignarPuntos(data);

            //Se calcula el centroide de cada grupo
            calculoCentroides();
        }

    }

    public void inicializarGrupos(){
        grupos = new HashMap<>(); //Mapa que almacena los grupos de flores
        for (int k = 1; k <= numClusters; k++) {
            grupos.put(k, new ArrayList<>());
        }
    }

    public void asignarPuntos(Table data) {
        for(int j = 0; j < data.getRowCount(); j++)
        {
            Row fila = data.getRowAt(j);
            List<Double> listaDato = fila.getData();
            int numGrupo = estimate(listaDato);

            grupos.get(numGrupo).add(fila);
        }
    }


    public void calculoCentroides(){
        for(int j = 1; j <= numClusters; j++)
        {
            List<Row> filasGrupo = grupos.get(j);

            int numDatos = filasGrupo.getFirst().getData().size();
            List<Double> centroideRecalculado = new ArrayList<>();

            //Se obtiene cada coordenada del centroide recalculado
            for (int k = 0; k < numDatos; k++) {
                double sumatorioDato = 0;
                for (Row fila : filasGrupo)
                    sumatorioDato += fila.getData().get(k);
                centroideRecalculado.add(sumatorioDato / filasGrupo.size());
            }

            centroides.put(j, centroideRecalculado);
        }
    }

    //Determina el grupo al que pertenece un punto
    @Override
    public Integer estimate(List<Double> punto) {

        double distanciaMinima = Double.MAX_VALUE;
        int numGrupo = 0;

        for(int i =1; i<= numClusters; i++)
        {
            List<Double> centroide = centroides.get(i);
            double distanciaEuclidea = distance.calculateDistance(centroide, punto);

            if(distanciaEuclidea<distanciaMinima)
            {
                distanciaMinima = distanciaEuclidea;
                numGrupo = i;
            }
        }

        return numGrupo;
    }
}
