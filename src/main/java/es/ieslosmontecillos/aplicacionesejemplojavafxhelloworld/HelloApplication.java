package es.ieslosmontecillos.aplicacionesejemplojavafxhelloworld;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage primaryStage)
    {
        //Creamos un grid
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        /*
            Insets: A set of inside offsets for the 4 side of a rectangular area
            Source: https://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Insets.html
         */
        grid.setPadding(new Insets(25, 25, 25, 25));

        //Le metemos el contenido
        gridContent(grid);

        //Creamos la escena con el grid como root
        Scene scene = new Scene(grid, 300, 275);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX Welcome");
        primaryStage.show();
    }

    /**
     * Mete el contenido al Gridpane inidicado
     * @param grid Gridpane de la aplicacion
     */
    private static void gridContent(GridPane grid)
    {
        //Texto en grande
        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        //Parametros: numero columna, fila, span de columna, span de fila
        grid.add(sceneTitle, 0, 0, 2, 1);

        //Etiqueta
        Label userName = new Label("User Name:");
        //Parametros: numero columna, fila
        grid.add(userName, 0, 1);

        //Campo de texto
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        //Etiqueta y campo para la password
        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);
        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        //Creamos un boton y su contenedor horizontal, este contenedor alineara su contenido a la derecha
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        //Creamos este texto que usaremos para mostrarle algo al usuario cuando interactue con el boton
        final Text actionTarget = new Text();
        grid.add(actionTarget, 1, 6);

        //Cuando se pulse el boton se cambiara el color y el texto
        btn.setOnAction(_ -> {
            actionTarget.setFill(Color.FIREBRICK);
            actionTarget.setText("Sign in button pressed");
        });
    }

    public static void main(String[] args) {
        launch();
    }
}