package Modelo.algorithms;

import Modelo.data.table.RowWithLabel;
import Modelo.data.table.TableWithLabels;

import java.util.List;

public class KNN implements Algorithm<TableWithLabels,Integer,List<Double>> {
    private TableWithLabels trainingData;
    private final Distance distance;

    public KNN (Distance distance)
    {
        this.distance = distance;
    }

    public void train(TableWithLabels iris) {
        this.trainingData=iris;
    }

    public Integer estimate(List<Double> sample) {
        if (trainingData==null){
            throw new IllegalStateException();
        }
        double distanciaMinima=Double.MAX_VALUE;
        Integer closestLabel=null;
        for (int i=0;i<trainingData.getRowCount();i++){
            RowWithLabel row= trainingData.getRowAt(i);
            double distancia=distance.calculateDistance(sample,row.getData());
            if (distancia<distanciaMinima){
                distanciaMinima=distancia;
                closestLabel=trainingData.getLabelAsInteger(row.getLabel());
            }
        }
        return closestLabel;
    }

}