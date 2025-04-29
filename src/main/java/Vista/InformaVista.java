package Vista;

import java.util.List;

public interface InformaVista {
    void actualizarListaCanciones(List<String> canciones);
    void mostrarRecomendaciones(List<String> recomendaciones);
    void habilitarBoton(boolean habilitar);
}
