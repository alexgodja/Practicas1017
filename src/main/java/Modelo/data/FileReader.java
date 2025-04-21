package Modelo.data;

import Modelo.data.table.Table;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public abstract class FileReader <T extends Table> extends ReaderTemplate  {
    Scanner sc;
    private String siguiente;

    public FileReader(String source) {
        super(source);
    }

    @Override
    void openSource(String source) throws URISyntaxException {
        try
        {
            URL resource = getClass().getClassLoader().getResource(source);
            if (resource == null) {
                throw new URISyntaxException(source, "Archivo no encontrado en recursos");
            }
            Path ruta= Paths.get(resource.toURI());

            sc = new Scanner(ruta);
            siguiente = sc.hasNextLine() ? sc.nextLine() : null;

        }
        catch (IllegalArgumentException | IOException e) {
            throw new URISyntaxException(source,"error");
        }
    }



    @Override
    void closeSource() {
        if (sc!=null)
            sc.close();
    }

    @Override
    boolean hasMoreData() {

        return siguiente!=null;
    }

    @Override
    String getNextData() {
        String actual = siguiente;
        siguiente = sc.hasNextLine() ? sc.nextLine() : null;
        return actual;
    }
}
