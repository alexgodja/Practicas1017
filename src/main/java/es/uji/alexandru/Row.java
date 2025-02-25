package es.uji.alexandru;


import java.util.ArrayList;
import java.util.List;


public class Row {
    private List<Double> data;
        public Row(String linea,String separador){
            this.data=linea.split(separador);
        }

    public Row() {

    }

    public List<Double> getData(){
        return new ArrayList<>(data);
    }
}
