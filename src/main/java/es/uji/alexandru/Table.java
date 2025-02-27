package es.uji.alexandru;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> headers;
    private List<Row> rows;

    public Table(List<String> headers){
        super();
        this.headers=new ArrayList<>(headers);
        this.rows=new ArrayList<>();

    }
    public Row getRowAt(int index) throws ArrayIndexOutOfBoundsException{
        if (index>=0 && index<rows.size()){
            return rows.get(index);
        }
        else
            throw new ArrayIndexOutOfBoundsException();
    }
    public List<Double> getColumnAt(int index){
        List<Double> columnas=new ArrayList<>();
        for (Row row: rows){
            List<Double> rowData=new ArrayList<>();
            rowData.add(row.getData());
            if (index>=0 && index < rowData.size()){
                columnas.add(row.getData(index));
            }
        }
        return columnas;
    }
}
