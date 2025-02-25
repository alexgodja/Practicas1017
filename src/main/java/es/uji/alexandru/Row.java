package es.uji.alexandru;


import java.util.ArrayList;
import java.util.List;


public class Row {
    private List<Double> data;
        public Row(List<Double>data){
            this.data = data;
        }

    public Row() {

    }

    public List<Double> getData(){
            return data;
    }
}
