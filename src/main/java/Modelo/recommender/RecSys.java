package Modelo.recommender;

import Modelo.algorithms.Algorithm;
import Modelo.data.table.Table;
import Modelo.excepciones.LikedItemNotFoundException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecSys{
    private Algorithm algorithm; //Algoritmo genérico a usar
    private Table trainData;
    private Table testData;
    private List<String> testItemNames;
    private Map<String,String> mapa;
    public RecSys(Algorithm algorithm){
        this.algorithm=algorithm;
        this.mapa=new HashMap<>();
    }
    public void train (Table trainData){
        this.trainData=trainData;
        algorithm.train(trainData);
    }
    public void initialise(Table testData, List<String> testItemNames){
        this.testData=testData;
        this.testItemNames=testItemNames;
        for (int i=0;i<testData.getRowCount();i++){
            List<Double> valores=testData.getRowAt(i).getData();
            String estimacion= String.valueOf(algorithm.estimate(valores));
            mapa.put(testItemNames.get(i),estimacion);
        }

    }
    public List<String> recommend(String nameLikedItem, int numRecommendations){
        if (!mapa.containsKey(nameLikedItem)){
            throw new LikedItemNotFoundException(nameLikedItem);
        }
        String likes=mapa.get(nameLikedItem);
        List<String> recomendaciones=new ArrayList<>();
        for (String item : testItemNames){
            if (recomendaciones.size()>=numRecommendations)
                break;
            if (!item.equals(nameLikedItem) && mapa.get(item).equals(likes))
                recomendaciones.add(item);
        }
        return recomendaciones;
    }
}
