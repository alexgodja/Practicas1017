package es.uji.alexandru.data.table;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TableWithLabels extends Table {

    /*Diccionario para almacenar el número de cada tipo de flor.
    Se asigna un valor númerico a cada etiqueta */

    private Map<String, Integer> labelsToIndex;

    //Constructor
    public TableWithLabels(List<String> headers, List<RowWithLabel> rowsWithLabels) {
        super(headers,new ArrayList<>(rowsWithLabels));
        this.labelsToIndex = new HashMap<>();
        hacerMapEtiquetas(rowsWithLabels);
    }

    //Método para inicializar el Map. Añade los tipos de flores con un código como número
    private void hacerMapEtiquetas(List<RowWithLabel> rowsWithLabels) {
        for (RowWithLabel rowWithLabel : rowsWithLabels) {
            if(!labelsToIndex.containsKey(rowWithLabel.getLabel())) {
                labelsToIndex.put(rowWithLabel.getLabel(), labelsToIndex.size());
            }
        }
    }

    //Devuelve la fila del número que se pasa
    @Override
    public RowWithLabel getRowAt(int numFila) {
        return (RowWithLabel) super.getRowAt(numFila);
    }

    //Devuelve el número asocioado a la etiqueta del Map
    public Integer getLabelAsInteger(String label){
        return labelsToIndex.get(label);
    }

}
