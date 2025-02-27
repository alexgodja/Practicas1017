package es.uji.alexandru.table;

import java.util.List;

public class TableWithLabels extends Table {

    //Constructor
    public TableWithLabels(List<String> headers, List<Row> rows) {
        super(headers, rows);
    }

    //Devuelve la fila del número que se pasa
    public RowWithLabel getRowAt(int numFila){
        return null;
    }


    public Integer getLabelAsInteger(String label){
        return null;
    }
}
