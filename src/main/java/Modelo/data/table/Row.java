package Modelo.data.table;

import java.util.List;

public class Row {
    private final List<Double> data;

    //Constructor Fila
    public Row(List<Double>data){
        this.data = data;
    }

    //Devuelve una fila con los valores y sin etiqueta
    public List<Double> getData(){
        return data;
    }
}