package es.uji.alexandru.machinelearning;

import es.uji.alexandru.table.Row;
import es.uji.alexandru.table.Table;

import java.util.*;

public class KMeans implements Algorithm <Table,Integer,List<Double>> {
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
        Map<Integer,>

        for (int i=0;i<numClusters;i++){
            List<double>=data.getRowAt(random.nextInt());
            centroides.put(i,fila);
        }

        for (int i=0;i<numIterations;i++){
            data.getRowAt(i);
        }

    }

    @Override
    public Integer estimate(List<Double> sample) {
        return null;
    }
}
