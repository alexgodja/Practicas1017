package Modelo.algorithms;

import java.util.List;

public class EuclideanDistance implements Distance{

    @Override
    public double calculateDistance(List<Double> centroide, List<Double> punto)
    {
        double sum = 0;
        for(int i = 0; i < centroide.size(); i++)
        {
            sum+=Math.pow(centroide.get(i) - punto.get(i),2);
        }
        return Math.sqrt(sum);
    }
}
