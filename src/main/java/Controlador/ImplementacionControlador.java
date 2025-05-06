package Controlador;

import Modelo.InterrogaModelo;
import Vista.InformaVista;
import Vista.InterrogaVista;

import java.util.List;

public class ImplementacionControlador implements Controlador {
    private InterrogaModelo modelo;
    private InformaVista informaVista;
    private InterrogaVista interrogaVista;

    @Override
    public void setModelo(InterrogaModelo modelo) {
        this.modelo = modelo;
    }

    @Override
    public void setVista(Object vista) {
        // Vista implementa tanto InformaVista como InterrogaVista
        this.informaVista  = (InformaVista) vista;
        this.interrogaVista = (InterrogaVista) vista;
    }

    /**
     * Llamado desde la vista cuando el usuario pulsa "Generar recomendaciones".
     * Recupera los parámetros desde la vista, invoca al modelo y vuelca el resultado
     * de nuevo en la vista.
     */
    public void EventoGenerarRecomendaciones() {
        try {
            String algoritmo  = interrogaVista.getAlgoritmo();
            String distancia  = interrogaVista.getDistancia();
            String cancion    = interrogaVista.getCancionSeleccionada();
            int    numRecs    = interrogaVista.getNumRecomendaciones();

            List<String> recs = modelo.generarRecomendaciones(
                    algoritmo, distancia, cancion, numRecs
            );

            informaVista.mostrarRecomendaciones(recs);

        } catch (Exception e) {
            System.out.println("Error al generar recomendaciones");
        }
    }
}
