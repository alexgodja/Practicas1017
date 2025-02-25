package es.uji.alexandru;

public class CSV {
    private String archivo
    public Table readTable(String archivo){
        getClass().getClassLoader().getResource(archivo).toURI()
                .getPath();
    }
}
