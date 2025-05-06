package Modelo.data;

import Modelo.data.table.Table;
import Modelo.data.table.Row;

import java.util.ArrayList;
import java.util.List;

public class CSVUnlabeledFileReader extends FileReader<Table> {
    private final List<String> headers=new ArrayList<>();
    private final List<Row> rows=new ArrayList<>();

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
