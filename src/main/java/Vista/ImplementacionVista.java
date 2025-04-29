package Vista;

import Modelo.InterrogaModelo;
import Controlador.Controlador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;


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
        VBox leftPanel = new VBox(10);
        Label recomendacion =new Label("Tipo de recomendación");
        ObservableList<String> tiposRecomendaciones = FXCollections.observableArrayList("Género","Similitudes");
        ComboBox<String> combo = new ComboBox<>(tiposRecomendaciones);


        //EJEMPLO
        Label label=new Label("Diego es gay?");
        Button bNuevo = new Button("Si");

        Button bAtras = new Button("Obvio");

        Button bAdelante = new Button("no hay otra opcion correcta");

        HBox fpEntrada = new HBox(10, label, bNuevo, bAtras, bAdelante);
        fpEntrada.setAlignment(Pos.CENTER); // Opcional, para centrar los elementos

        Scene scene = new Scene(fpEntrada, 400, 100); // Ancho y alto de la ventana
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void actualizarListaCanciones(List<String> canciones) {

    }

    @Override
    public void mostrarRecomendaciones(List<String> recomendaciones) {

    }

    @Override
    public void habilitarBoton(boolean habilitar) {

    }

    @Override
    public String getAlgoritmo() {
        return "";
    }

    @Override
    public String getDistancia() {
        return "";
    }

    @Override
    public int getNumRecomendaciones() {
        return 0;
    }

}