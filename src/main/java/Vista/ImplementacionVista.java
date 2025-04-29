package Vista;

import Modelo.InterrogaModelo;
import Controlador.Controlador;
import Modelo.data.CSVUnlabeledFileReader;
import Modelo.data.table.Table;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URISyntaxException;
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

    public void creaGUI() throws URISyntaxException {

        Label subtitulo1 =new Label("CARACTERÍSTICAS");

        Label tipoRecomendación =new Label("TIPO RECOMENDACIÓN");
        ObservableList<String> tiposRecomendaciones = FXCollections.observableArrayList("Género","Similitudes");
        ComboBox<String> elegirRecomendacion = new ComboBox<>(tiposRecomendaciones);

        Label tipoDeDistancia = new Label("TIPO DE DISTANCIA");
        ObservableList<String> tiposDistancia = FXCollections.observableArrayList("Euclidea","Manhattan");
        ComboBox<String> elegirDistancia = new ComboBox<>(tiposDistancia);
        Label nRecom = new Label("Número de recomendaciones:");
        TextField numRecom = new TextField("5");

        VBox panelIzquierda = new VBox(10,subtitulo1,elegirRecomendacion,tipoDeDistancia,elegirDistancia,nRecom,numRecom);
        panelIzquierda.setAlignment(Pos.TOP_LEFT);

        Label subtitulo2 = new Label("Escoge una canción");

        ObservableList<String> canciones = FXCollections.observableArrayList();
        for (int i = 1; i <= 50; i++) {
            canciones.add("Canción " + i);
        }

        ListView<String> listaCanciones = new ListView<>(canciones);
        listaCanciones.setPrefHeight(400); // Ajusta altura visible

        listaCanciones.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); // o MULTIPLE

        VBox panelCentro = new VBox(10, subtitulo2, listaCanciones);
        panelCentro.setAlignment(Pos.TOP_CENTER);

        Label subtitulo3 = new Label("Recomendaciones:");
        VBox panelDerecha = new VBox(subtitulo3);

        HBox todo = new HBox(50,panelIzquierda,panelCentro,panelDerecha);
        Scene scene = new Scene(todo, 800, 500);
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