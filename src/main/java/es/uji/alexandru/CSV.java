package es.uji.alexandru;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class CSV {
    private String archivo;

    public static Table readTable(String archivo) throws FileNotFoundException {

        Table table = null;
        String ruta = getClass().getClassLoader().getResource(archivo).toURI().getPath();
        BufferedReader br = new BufferedReader(new FileReader(ruta));
        String linea = br.readLine();

        while (br.readLine() !=null) {

        }

    }
}
