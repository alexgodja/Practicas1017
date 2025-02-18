package es.uji.alexandru;


import java.util.ArrayList;
import java.util.List;


public class Row {
    private List<Double> data;
        public Row(List<Double> data){
            this.data=new ArrayList<>(data);
        }

    public List<Double> getData(){
        return new ArrayList<>(data);
    }
}
