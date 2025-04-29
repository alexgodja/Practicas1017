package Modelo;

import Vista.ImplementacionVista;
import Vista.InformaVista;

public class ImplementacionModelo implements CambioModelo, InterrogaModelo {
    private InformaVista vista;

    public ImplementacionModelo(){}

    public void setVista(InformaVista vista) {
        this.vista = vista;
    }



}
