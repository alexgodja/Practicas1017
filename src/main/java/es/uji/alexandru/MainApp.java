package es.uji.alexandru;

import Controlador.ImplementacionControlador;
import Modelo.ImplementacionModelo;
import Vista.ImplementacionVista;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.awt.*;

public class MainApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        ImplementacionControlador controlador = new ImplementacionControlador();
        ImplementacionModelo modelo = new ImplementacionModelo();
        ImplementacionVista vista = new ImplementacionVista(stage);
        modelo.setVista(vista);
        controlador.setVista(vista);
        controlador.setModelo(modelo);
        vista.setModelo(modelo);
        vista.setControlador(controlador);
        vista.creaGUI();

    }
}
