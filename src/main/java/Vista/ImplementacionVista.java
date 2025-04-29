package Vista;

import Modelo.InterrogaModelo;
import Controlador.Controlador;


public class ImplementacionVista implements InterrogaVista, InformaVista {
    private Controlador controlador;
    private InterrogaModelo modelo;

    @Override
    public void entradaActualCambiada() {

    }

    @Override
    public void nuevaEntrada() {

    }

    @Override
    public String getEntrada() {
        return "";
    }
}