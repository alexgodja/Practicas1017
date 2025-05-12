// src/Vista/ImplementacionVista.java
package Vista;

import Controlador.Controlador;
import Modelo.InterrogaModelo;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class ImplementacionVista implements InterrogaVista, InformaVista {
    private final Stage stage;
    private Controlador controlador;
    private InterrogaModelo modelo;

    // controles como campos de instancia
    private ComboBox<String> cbRecomendacion;
    private ComboBox<String> cbDistancia;
    private TextField numRecs;
    private ListView<String> lvCanciones;
    private ListView<String> lvRecomendaciones;
    private Button btnRecomendar;
    private VBox izquierda;
    private VBox centro;
    private VBox derecha;

    public ImplementacionVista(Stage stage) {
        this.stage = stage;
    }

    public void setModelo(final InterrogaModelo modelo) {
        this.modelo = modelo;
    }

    public void setControlador(final Controlador controlador) {
        this.controlador = controlador;
    }

    //Crea la interfaz gráfica. Se divide en tres secciones
    public void creaGUI() throws Exception {

        //SECCIÓN IZQUIERDA
        creaGuiIzquierda();
        izquierda.setAlignment(Pos.TOP_LEFT);

        // SECCIÓN CENTRO
        creaGuiCentro();
        centro.setAlignment(Pos.TOP_CENTER);

        // SECCIÓN DERECHA
        creaGUIDerecha();
        derecha.setAlignment(Pos.TOP_LEFT);

        HBox root = new HBox(20, izquierda, centro, derecha);
        Scene scene = new Scene(root, 900, 500);
        root.setStyle("-fx-background-color: #2b2b2b;");

        stage.setScene(scene);
        stage.show();
    }

    // Método para crear Vbox izquierda
    public void creaGuiIzquierda(){
        // Izquierda: opciones
        Label l1 = new Label("TIPO RECOMENDACIÓN");
        cbRecomendacion = new ComboBox<>(FXCollections.observableArrayList("Género","Similitudes"));
        Label l2 = new Label("TIPO DE DISTANCIA");
        cbDistancia = new ComboBox<>(FXCollections.observableArrayList("Euclidea","Manhattan"));
        Label l3 = new Label("Número de recomendaciones:");
        numRecs = new TextField("5");

        btnRecomendar = new Button("Generar recomendaciones");
        btnRecomendar.setDisable(true);
        btnRecomendar.setOnAction(evt -> controlador.EventoGenerarRecomendaciones());


        izquierda = new VBox(10, l1, cbRecomendacion, l2, cbDistancia, l3, numRecs, btnRecomendar);
        l1.setStyle("-fx-text-fill: white;");
        l2.setStyle("-fx-text-fill: white;");
        l3.setStyle("-fx-text-fill: white;");
        cbRecomendacion.setStyle("-fx-background-color: #3c3f41; -fx-text-fill: white;");
        cbDistancia.setStyle("-fx-background-color: #3c3f41; -fx-text-fill: white;");
        numRecs.setStyle("-fx-control-inner-background: #3c3f41; -fx-text-fill: white;");
        btnRecomendar.setStyle("-fx-background-color: #555; -fx-text-fill: white;");

    }

    //Método para crear Vbox Centro
    public void creaGuiCentro() throws Exception {
        Label l4 = new Label("Canciones disponibles");

        List<String> canciones = modelo.cargarListaCanciones();

        lvCanciones = new ListView<>(FXCollections.observableArrayList(canciones));

        lvCanciones.getSelectionModel().selectedItemProperty().addListener((item, valorViejo, valorNuevo) -> {
            System.out.println("Has seleccionado: " + valorNuevo);
            updateBoton();
        });

        centro = new VBox(10, l4, lvCanciones);
        lvCanciones.setStyle("-fx-control-inner-background: #3c3f41; -fx-text-fill: white;");

    }

    public void creaGUIDerecha(){
        Label l5 = new Label("Recomendaciones");
        lvRecomendaciones = new ListView<>();
        derecha = new VBox(10, l5, lvRecomendaciones);
        lvRecomendaciones.setStyle("-fx-control-inner-background: #3c3f41; -fx-text-fill: white;");

    }

    private void updateBoton() {
        boolean ok = lvCanciones.getSelectionModel().getSelectedItem()!=null
                && cbRecomendacion.getValue()!=null
                && cbDistancia.getValue()!=null
                && numRecs.getText().matches("\\d+");

        btnRecomendar.setDisable(!ok);
        habilitarBoton(ok);
    }

    @Override
    public void mostrarRecomendaciones(List<String> recomendaciones) {
        lvRecomendaciones.getItems().setAll(recomendaciones);
    }

    @Override
    public void habilitarBoton(boolean habilitar) {
        btnRecomendar.setDisable(!habilitar);
    }

    // InterrogaVista
    @Override
    public String getAlgoritmo() {
        return cbRecomendacion.getValue();
    }

    @Override
    public String getDistancia() {
        return cbDistancia.getValue();
    }

    @Override
    public int getNumRecomendaciones() {
        return Integer.parseInt(numRecs.getText());
    }

    @Override
    public String getCancionSeleccionada() {
        return lvCanciones.getSelectionModel().getSelectedItem();
    }

}
