package es.uji.alexandru.table;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table {

    Map<String,Integer> labelsToIndex = new HashMap<String,Integer>();

    //Constructor
    public TableWithLabels(List<String> headers, List<Row> rows, Map<String, Integer> labelsToIndex) {
        super(headers, rows);
        this.labelsToIndex = labelsToIndex;
    }

    //Devuelve la fila del número que se pasa
    @Override
    public RowWithLabel getRowAt(int numFila) {
        return null;
    }


    public Integer getLabelAsInteger(String label){
        return null;
    }
}
