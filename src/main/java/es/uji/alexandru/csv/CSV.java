package es.uji.alexandru.csv;

import es.uji.alexandru.table.Row;
import es.uji.alexandru.table.Table;
import es.uji.alexandru.table.TableWithLabels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CSV {

    //Lee la tabla del archivo que se pasa
    public Table readTable(String archivo) throws IOException, URISyntaxException {

        List<String> headers = new ArrayList<>();
        List<Row> rows = new ArrayList<>();

        String ruta = getClass().getClassLoader().getResource(archivo).toURI().getPath();

        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))){
            String linea = reader.readLine();
            if(linea != null){
                String[] cabeceras = linea.split(",");
                for (String cabecera : cabeceras) {
                    headers.add(cabecera.trim());
                }
            }
            while ((linea = reader.readLine()) != null) {
                String[] valores = linea.split(",");
                List<Double> valoresDouble = new ArrayList<>();
                for (String valor : valores) {
                    valoresDouble.add(Double.parseDouble(valor.trim()));
                }
                rows.add(new Row(valoresDouble));

            }
        }
        return new Table (headers, rows);
    }
    public TableWithLabels readTableWithLabels(String ruta) throws IOException {
        return null;
    }
}
