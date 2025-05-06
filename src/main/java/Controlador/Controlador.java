package Controlador;

import Modelo.InterrogaModelo;

/**
 * Interfaz que define el contrato del controlador:
 *  - inyectar modelo y vista,
 *  - orquestar la generación de recomendaciones.
 */
public interface Controlador {

    /**
     * Asigna el modelo sobre el que operará el controlador.
     */
    void setModelo(InterrogaModelo modelo);

    /**
     * Asigna la vista. Como la vista implementa tanto
     * InterrogaVista como InformaVista, aquí la recibimos
     * como Object y luego se castea internamente.
     */
    void setVista(Object vista);

    /**
     * Invocado cuando el usuario pide generar recomendaciones.
     * El controlador debe leer de la vista los parámetros,
     * llamar al modelo y volcar luego el resultado en la vista.
     */
    void EventoGenerarRecomendaciones();
}
