package es.uji.alexandru.machinelearning;

import es.uji.alexandru.table.Table;
import java.util.List;

public class KMeans implements Algorithm <Table,Integer,List<Double>> {

    // Constructor. Almacena número de grupos, iteraciones y semilla.
    public KMeans(int numClusters, int numIterations, long seed) {

    }

    @Override
    public void train(Table data) {

    }

    @Override
    public Integer estimate(List<Double> sample) {
        return null;
    }
}
