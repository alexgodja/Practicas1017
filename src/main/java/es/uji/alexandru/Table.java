package es.uji.alexandru;

import java.util.ArrayList;
import java.util.List;

public class Table extends Row{
    private List<String> headers;
    private List<Row> rows;
    public Table(List<String> headers){
        this.headers=new ArrayList<>(headers);
        this.rows=new ArrayList<>();
    }
    public Row getRowAt(int index) throws IndexOutOfBoundsException{
        if (index>=0 && index<rows.size()){
            return rows.get(index);
        }
        else
            throw IndexOutOfBoundsException;
    }
    public List<Double> getColumnAt(int index){
        List<Double> columnas=new ArrayList<>();
        for (Row row: rows){

        }
    }
}
