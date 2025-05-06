package Modelo.data;

import Modelo.data.table.RowWithLabel;
import Modelo.data.table.TableWithLabels;

import java.util.ArrayList;
import java.util.List;

public class CSVLabeledFileReader extends FileReader<TableWithLabels> {
    private final List<String> headers = new ArrayList<>();
    private final List<RowWithLabel> rows = new ArrayList<>();

    public CSVLabeledFileReader(String source) {
        super(source);
    }

    @Override
    void processHeaders(String headersLine) {
        String[] cabeceras = headersLine.split(",");
        for (int i = 0; i < cabeceras.length - 1; i++) {
            headers.add(cabeceras[i].trim());
        }
        table = new TableWithLabels(headers, rows);
    }

    @Override
    void processData(String dataLine) {
        String[] valores = dataLine.split(",");
        List<Double> datos = new ArrayList<>();
        String etiqueta = valores[valores.length - 1].trim();

        for (int i = 0; i < valores.length - 1; i++) {
            datos.add(Double.parseDouble(valores[i].trim()));
        }
        rows.add(new RowWithLabel(datos, etiqueta));
        table=new TableWithLabels(headers,rows);

    }
}