package Modelo.excepciones;

public class InvalidClusterNumberException extends IllegalArgumentException {
    private final int numClusters;
    private final int rowCount;

    public InvalidClusterNumberException(int numClusters, int rowCount) {
        this.numClusters = numClusters;
        this.rowCount = rowCount;
    }

    public Integer getNumberOfCusters() {
        return numClusters;
    }
}
