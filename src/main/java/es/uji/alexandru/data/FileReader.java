package es.uji.alexandru.data;

import es.uji.alexandru.data.table.Table;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class FileReader <T extends Table> extends ReaderTemplate  {
    Scanner sc;

    public FileReader(String source) {
        super(source);
    }

    @Override
    void openSource(String source) throws URISyntaxException {
        try
        {
            String ruta = getClass().getClassLoader().getResource(source).toURI().getPath();
            sc = new Scanner(new File(ruta));
        }
        catch (FileNotFoundException e) {
            throw new RuntimeException("No se ha encontrado el archivo ",e);
        }
    }

    @Override
    void processHeaders(String headers) {

    }

    @Override
    void processData(String data) {

    }

    @Override
    void closeSource() {
        sc.close();
    }

    @Override
    boolean hasMoreData() {

    }

    @Override
    String getNextData() {
        return ;
    }
}
