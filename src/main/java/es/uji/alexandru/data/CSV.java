package es.uji.alexandru.data;

import es.uji.alexandru.data.table.Table;
import es.uji.alexandru.data.table.TableWithLabels;

import java.net.URISyntaxException;

public class CSV {

    //Lee la tabla sin etiquetas del archivo que se pasa
    public Table readTable(String archivo) throws URISyntaxException {
        return new CSVUnlabeledFileReader(archivo).readTableFromSource();
    }

    //Lee la tabla con etiquetas del archivo que se pasa
    public TableWithLabels readTableWithLabels(String archivo) throws URISyntaxException {
        return (TableWithLabels) new CSVLabeledFileReader(archivo).readTableFromSource();
    }
}