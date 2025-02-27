package es.uji.alexandru.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table {

    private Map<String, Integer> labelsToIndex;

    //Constructor
    public TableWithLabels(List<String> headers, List<RowWithLabel> rows) {
        super(headers, new ArrayList<>(rows)); // Pasa las filas como List<Row> al padre
        this.labelsToIndex = new HashMap<>();;
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
