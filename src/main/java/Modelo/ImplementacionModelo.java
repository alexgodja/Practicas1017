package Modelo;

import Vista.InformaVista;

public class ImplementacionModelo implements CambioModelo,
        InterrogaModelo {
    private InformaVista vista;

    @Override
    public void anyadeEntrada(String entrada) {

    }

    @Override
    public void incrementaPosicionActual() {

    }

    @Override
    public void decrementaPosicionActual() {

    }

    @Override
    public int getNumeroEntradas() {
        return 0;
    }

    @Override
    public String getEntradaActual() {
        return "";
    }

    @Override
    public int getPoscionEntradaActual() {
        return 0;
    }
}
