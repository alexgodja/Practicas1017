package es.uji.alexandru.machinelearning;

import es.uji.alexandru.table.RowWithLabel;
import es.uji.alexandru.table.TableWithLabels;

import java.util.List;

public class KNN {
    private TableWithLabels trainingData;
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
            double distancia=distanciaEuclidea(sample,row.getData());
            if (distancia<distanciaMinima){
                distanciaMinima=distancia;
                closestLabel=trainingData.getLabelAsInteger(row.getLabel());
            }
        }
        return closestLabel;
    }
    private double distanciaEuclidea(List<Double> a,List<Double> b){
        double sum=0;
        for (int i=0;i<a.size();i++){
            sum+=Math.pow(a.get(i) - b.get(i),2);
        }
        return Math.sqrt(sum);
    }
}
