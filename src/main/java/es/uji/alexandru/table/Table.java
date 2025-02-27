package es.uji.alexandru.table;

import java.util.ArrayList;
import java.util.List;

public class Table {
    private List<String> headers;
    private List<Row> rows;

    //Constructor Tabla
    public Table(List<String> headers, List<Row> rows) {
        this.headers = new ArrayList<>(headers);
        this.rows = new ArrayList<>(rows);
    }

    // Devuelve una fila de la tabla
    public Row getRowAt(int numFila) {
        if (numFila < 0 || numFila >= rows.size())
            throw new IndexOutOfBoundsException();
        return rows.get(numFila);
    }

    //Devuelve una columna de la tabla
    public List<Double> getColumnAt(int numColumna){
        List<Double> columna = new ArrayList<>();
        for(Row fila : rows){
            List<Double> filaValores = fila.getData();
            if(numColumna < 0 || numColumna >= filaValores.size()){
                throw new IndexOutOfBoundsException();
            }
            columna.add(filaValores.get(numColumna));
        }
        return columna;
    }

    //Devuelve una lista con las etiquetas
    public List<String> getHeaders() {
        return headers;
    }

    // Devuelve el número de filas de la tabla
    public int getRowCount() {
        return rows.size();
    }

}
