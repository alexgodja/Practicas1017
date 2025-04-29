package Controlador;

import Modelo.CambioModelo;
import Vista.InterrogaVista;

public class ImplementacionControlador implements Controlador {
    private InterrogaVista vista;
    private CambioModelo modelo;

    public ImplementacionControlador() {}

    public void setModelo(CambioModelo modelo) {
        this.modelo = modelo;
    }

    public void setVista(InterrogaVista vista) {
        this.vista = vista;
    }

    @Override
    public void anyadeEntrada() {

    }

    @Override
    public void adelante() {

    }

    @Override
    public void atras() {

    }
}
