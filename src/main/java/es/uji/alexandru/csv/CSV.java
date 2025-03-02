package es.uji.alexandru.csv;

import es.uji.alexandru.table.Row;
import es.uji.alexandru.table.RowWithLabel;
import es.uji.alexandru.table.Table;
import es.uji.alexandru.table.TableWithLabels;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.*;

public class CSV {

    //Lee la tabla sin etiquetas del archivo que se pasa
    public Table readTable(String archivo) throws IOException, URISyntaxException {

        List<String> headers = new ArrayList<>();
        List<Row> rows = new ArrayList<>();

        //Obtener ruta
        String ruta = getClass().getClassLoader().getResource(archivo).toURI().getPath();

        //Leer archivo
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))){
            //Leer primera línea con cabeceras y añadirla a headers
            String linea = reader.readLine();
            if(linea != null){
                String[] cabeceras = linea.split(",");
                for (String cabecera : cabeceras) {
                    headers.add(cabecera);
                }
            }
            //Leer filas con valores y añadirlas a rows
            while ((linea = reader.readLine()) != null) {
                String[] valores = linea.split(",");
                List<Double> valoresDouble = new ArrayList<>();
                for (String valor : valores) {
                    valoresDouble.add(Double.parseDouble(valor));
                }
                rows.add(new Row(valoresDouble));

            }
        }

        return new Table (headers, rows);
    }
    public TableWithLabels readTableWithLabels(String archivo) throws IOException, URISyntaxException {
        List<String> headers = new ArrayList<>();
        List<RowWithLabel> rowsWithLabels = new ArrayList<>();

        //Obtener ruta
        String ruta = getClass().getClassLoader().getResource(archivo).toURI().getPath();

        //Leer archivo
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            //Leer primera línea con cabeceras y añadirla a headers
            String linea = reader.readLine();
            if (linea != null) {
                String[] cabeceras = linea.split(",");

                for (int i = 0; i < cabeceras.length - 1; i++) {
                    headers.add(cabeceras[i]);
                }
            }

            //Leer filas con valores y etiquetas y añadirlas a rowsWithLabels
            while ((linea = reader.readLine()) != null) {
                String[] valores = linea.split(",");
                List<Double> valoresDouble = new ArrayList<>();
                String etiqueta = valores[valores.length - 1];

                for (int i = 0; i < valores.length - 1; i++) {
                    valoresDouble.add(Double.parseDouble(valores[i]));
                }

                rowsWithLabels.add(new RowWithLabel(valoresDouble, etiqueta));
            }
        }

        return new TableWithLabels(headers, rowsWithLabels);
    }
}