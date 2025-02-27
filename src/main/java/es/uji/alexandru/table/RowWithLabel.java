package es.uji.alexandru.table;

import java.util.List;

public class RowWithLabel extends Row {
    private String label;

    public RowWithLabel(List<Double> data, String label) {
        super(data);
    }

    public String getLabel() {
        return label;
    }
}
