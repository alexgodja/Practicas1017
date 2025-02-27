package es.uji.alexandru.table;

import es.uji.alexandru.table.Row;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> headers;
    private List<Row> rows;

    public Table(List<String> headers, List<Row> rows) {
        this.headers = new ArrayList<>(headers);
        this.rows = new ArrayList<>(rows);
    }

    public Row getRowAt(int numFila) {

    }
    public List<Double> getColumnAt(int numColumna){

    }

    public List<String> getHeaders() {
        return new ArrayList<>(headers);
    }

    public int getRowCount() {
    }

}
