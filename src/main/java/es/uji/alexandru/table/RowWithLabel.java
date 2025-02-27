package es.uji.alexandru.table;

import java.util.List;

public class RowWithLabel extends Row {
    private String label;

    //Constructor RowWithLabel
    public RowWithLabel(List<Double> data, String label) {
        super(data);
    }

    //Devuelve la etiqueta
    public String getLabel() {
        return label;
    }
}
