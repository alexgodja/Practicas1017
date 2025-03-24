package es.uji.alexandru.excepciones;

public class InvalidClusterNumberException extends IllegalArgumentException {
    private int numClusters;
    private int rowCount;

    public InvalidClusterNumberException(int numClusters, int rowCount) {
        this.numClusters = numClusters;
        this.rowCount = rowCount;
    }

    public Integer getNumberOfCusters() {
        return numClusters;
    }
}
