package es.ieslosmontecillos.aplicacionesejemplojavafxhelloworld;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        //Creacion del boton y asignacion del evento
        Button btn = new Button();
        btn.setText("Say 'Hello World'");

        //Evento ejecutado
        btn.setOnAction(_ -> System.out.println("Hello World!"));

        //Creacion de un contenedor donde alojaremos el boton
        StackPane root = new StackPane();
        root.getChildren().add(btn);

        //Creacion de escena y la mostramos
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}