package es.ieslosmontecillos.aplicacionesejemplojavafxhelloworld;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.effect.BoxBlur;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.stage.Stage;
import javafx.util.Duration;

import static java.lang.Math.random;

public class HelloApplication extends Application
{
    @Override
    public void start(Stage primaryStage)
    {

        //Un grupo contiene una lista observable de nodos hijos los cuales seran renderizados en orden
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.BLACK);
        primaryStage.setScene(scene);

        //Creamos un grupo que contendra circulos
        Group circles = new Group();

        //Crearemos 30 circulos y los añadimos al grupo
        for (int i = 0; i < 30; i++) {
            Circle circle = new Circle(150, Color.web("white", 0.05));
            circle.setStrokeType(StrokeType.OUTSIDE);
            circle.setStroke(Color.web("white", 0.16));
            circle.setStrokeWidth(4);
            circles.getChildren().add(circle);
        }

        //Le aplicamos al grupo de circulos un efecto para que se vean borrosos
        circles.setEffect(new BoxBlur(10, 10, 3));

        /*
        Crearemos un rectangulo el cual tendra un gradiente, para ajustar el gradiente se usan los stops
        Cada stop necesitara saber donde se encuentra en el gradiente desde el 0 al 1 siendo 0 derecha, 1 izquierda
        y el color del stop
         */
        Rectangle colors = new Rectangle(scene.getWidth(), scene.getHeight(),
                new LinearGradient(0f, 1f, 1f, 0f, true, CycleMethod.NO_CYCLE, new Stop(0, Color.web("#f8bd55")),
                        new Stop(0.14, Color.web("#c0fe56")),
                        new Stop(0.28, Color.web("#5dfbc1")),
                        new Stop(0.43, Color.web("#64c2f8")),
                        new Stop(0.57, Color.web("#be4af7")),
                        new Stop(0.71, Color.web("#ed5fc2")),
                        new Stop(0.85, Color.web("#ef504c")),
                        new Stop(1, Color.web("#f2660f"))));
        //El rectangulo se ajustara al tamaño de la scena
        colors.widthProperty().bind(scene.widthProperty());
        colors.heightProperty().bind(scene.heightProperty());

        /*
        De normal las 2 "capas" no interactuan entre si, el rectangulo va por un lado y los circulos por otro
        asi que necesitaremos crear un grupo en el cual añadiremos un cuadrado en negro, los circulos y los colores,
        ya que es un grupo se pintaran en ese orden pisando los colores a los circulos y los circulos al "fondo" negro
         */
        Group blendModeGroup =
                new Group(
                        new Group(
                                new Rectangle(scene.getWidth(), scene.getHeight(),
                        Color.BLACK), circles), colors);
        //Le diremos a los colores que mezclen con los circulos
        colors.setBlendMode(BlendMode.OVERLAY);
        root.getChildren().add(blendModeGroup);

        //Instanciamos un objeto timeline para poder animar los circulos
        Timeline timeline = new Timeline();

        //Por cada circulo
        for (Node circle: circles.getChildren()) {
            /*
            Añadimos al timeline 2 KeyFrames, el primero al momento de iniciar la timeline y el segundo dentro de 40 segundos
            A cada keyframe le indicamos una posicion X e Y del circulo aleatoria de forma que se mueva desde
            una posicion inicial aleatoria a otra en 40 segundos
             */
            timeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO, // set start position at 0
                            new KeyValue(circle.translateXProperty(), random() * 800),
                            new KeyValue(circle.translateYProperty(), random() * 600)
                    ),
                    new KeyFrame(new Duration(40000), // set end position at 40s
                            new KeyValue(circle.translateXProperty(), random() * 800),
                            new KeyValue(circle.translateYProperty(), random() * 600)
                    )
            );
        }
        //Iniciamos la timeline y mostramos el stage
        timeline.play();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}