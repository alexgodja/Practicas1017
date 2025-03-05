package es.uji.alexandru.machinelearning;

import es.uji.alexandru.table.Table;
import java.util.List;

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

    }

    @Override
    public Integer estimate(List<Double> sample) {
        return null;
    }
}
