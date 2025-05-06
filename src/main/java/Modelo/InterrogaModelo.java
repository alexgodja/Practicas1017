package Modelo;


import java.util.List;

public interface InterrogaModelo {

    List<String> cargarListaCanciones() throws Exception;

    List<String> generarRecomendaciones(String algoritmo, String distancia, String cancionBase, int numRecs) throws Exception;
}