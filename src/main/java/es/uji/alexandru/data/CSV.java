package es.uji.alexandru.data;

import es.uji.alexandru.data.table.Table;
import es.uji.alexandru.data.table.TableWithLabels;

import java.net.URISyntaxException;

public class CSV {

    //Lee la tabla sin etiquetas del archivo que se pasa
    public Table readTable(String archivo) throws URISyntaxException {
        CSVUnlabeledFileReader reader = new CSVUnlabeledFileReader(archivo);
        return reader.readTableFromSource();
    }

    //Lee la tabla con etiquetas del archivo que se pasa
    public TableWithLabels readTableWithLabels(String archivo) throws URISyntaxException {
        CSVLabeledFileReader reader = new CSVLabeledFileReader(archivo);
        return (TableWithLabels) reader.readTableFromSource();
    }
}