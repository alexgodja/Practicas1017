package Vista;

import Modelo.InterrogaModelo;
import Controlador.Controlador;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ImplementacionVista implements InterrogaVista, InformaVista {
    private final Stage stage;
    private Controlador controlador;
    private InterrogaModelo modelo;

    public ImplementacionVista(final Stage stage) {
        this.stage = stage;
    }

    public void setModelo(final InterrogaModelo modelo) {
        this.modelo = modelo;
    }

    public void setControlador(final Controlador controlador) {
        this.controlador = controlador;
    }

    public void creaGUI() {

        //PRUEBA
        Label label=new Label("Diego es gay?");
        Button bNuevo = new Button("Si");
        bNuevo.setOnAction(actionEvent -> controlador.anyadeEntrada());

        Button bAtras = new Button("Obvio");
        bAtras.setOnAction(actionEvent -> controlador.atras());

        Button bAdelante = new Button("no hay otra opcion correcta");
        bAdelante.setOnAction(actionEvent -> controlador.adelante());

        HBox fpEntrada = new HBox(10, label, bNuevo, bAtras, bAdelante);
        fpEntrada.setAlignment(Pos.CENTER); // Opcional, para centrar los elementos

        Scene scene = new Scene(fpEntrada, 400, 100); // Ancho y alto de la ventana
        stage.setScene(scene);
        stage.show();
    }


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