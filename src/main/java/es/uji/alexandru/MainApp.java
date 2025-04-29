package es.uji.alexandru;

import Controlador.ImplementacionControlador;
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
    public void start(Stage primaryStage) throws Exception {
        ImplementacionControlador controlador = new ImplementacionControlador();

        VBox layout =new VBox();
        Label label=new Label("Hola");
        Button button=new Button("Diego es gay xd");
        layout.getChildren().addAll(label,button);
        layout.setAlignment(Pos.CENTER);
        primaryStage.setScene(new Scene(layout,200,100));
        primaryStage.setTitle("Recomendador");
        primaryStage.show();
    }
}
