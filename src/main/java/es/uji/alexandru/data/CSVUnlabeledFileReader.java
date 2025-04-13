package es.uji.alexandru.data;

import es.uji.alexandru.data.table.Table;
import es.uji.alexandru.data.table.Row;
import java.awt.*;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CSVUnlabeledFileReader extends FileReader<Table> {
    private List<String> headers=new ArrayList<>();
    private List<Row> rows=new ArrayList<>();
    public CSVUnlabeledFileReader(String source){
        super(source);
    }

    @Override
    void processHeaders(String headersLine) {
        String[] cabeceras=headersLine.split(",");
        for (String cabecera: cabeceras)
            headers.add(cabecera.trim());
        table=new Table(headers,rows);
    }
    void processData(String dataLine){
        String[] valores=dataLine.split(",");
        List<Double> fila=new ArrayList<>();
        for (String valor: valores) {
                fila.add(Double.parseDouble(valor.trim()));
        }
        rows.add(new Row(fila));
        table=new Table(headers,rows);

    }

}
