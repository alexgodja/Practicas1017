package es.uji.alexandru.recommender;

import es.uji.alexandru.algorithms.Algorithm;
import es.uji.alexandru.data.table.Table;

import java.util.List;

public class RecSys{
    private Algorithm algorithm;
    public RecSys(Algorithm algorithm){
        this.algorithm=algorithm;
    }
    public void train (Table trainData){

    }
    public void initialise(Table testData, List<String> testItemNames){

    }
    public List<String> recommend(String nameLikedItem, int numRecommendations){
        return null;
    }
}
