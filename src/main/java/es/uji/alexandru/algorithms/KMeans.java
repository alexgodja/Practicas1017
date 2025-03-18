package es.uji.alexandru.algorithms;

import es.uji.alexandru.data.table.Row;
import es.uji.alexandru.data.table.Table;

import java.util.*;

public class KMeans implements Algorithm<Table,Integer,List<Double>> {
    private final int numClusters;
    private final int numIterations;
    private final long seed;

    // Constructor. Almacena número de grupos, iteraciones y semilla.
    public KMeans(int numClusters, int numIterations, long seed) {
        this.numClusters = numClusters;
        this.numIterations = numIterations;
        this.seed = seed;
    }

    @Override
    public void train(Table data) {
        Random random=new Random(long semilla);
        Map<Integer, Row> centroides=new HashMap();
        Map<Integer,List<Row>> grupos = new HashMap<>();

        for (int i=0;i<numClusters;i++){
            Row fila = data.getRowAt(random.nextInt());
            centroides.put(i,fila);
        }

        for (int i=0;i<numIterations;i++){
            data.getRowAt(i);
        }

    }

    @Override
    public Integer estimate(List<Double> punto) {
        double distanciaCercana = 0;
        double distanciaEuclidea = 0;
        Integer numGrupo = null;
        for(int i = 0; i < 3; i++)
        {
            distanciaEuclidea = distanciaEuclidea();
        }

        return numGrupo;
    }

    public double distanciaEuclidea(List<Double> centroide, List<Double> punto)
    {
        double sum = 0;
        for(int i = 0; i < punto.size(); i++)
        {
            sum+=Math.pow(centroide.get(i) - punto.get(i),2);
        }
        return Math.sqrt(sum);
    }
}
