package es.uji.alexandru.csv;

import es.uji.alexandru.table.Table;
import es.uji.alexandru.table.TableWithLabels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;

public class CSV {

    //Lee la tabla del archivo que se pasa
    public Table readTable(String archivo) throws IOException, URISyntaxException {

        String ruta = getClass().getClassLoader().getResource(archivo).toURI().getPath();
        BufferedReader reader = new BufferedReader(new FileReader(archivo));
    }
    public TableWithLabels readTableWithLabels(String ruta) throws IOException {

    }
}
