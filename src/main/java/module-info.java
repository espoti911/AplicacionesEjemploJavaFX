module es.ieslosmontecillos.aplicacionesejemplojavafxhelloworld {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.aplicacionesejemplojavafxhelloworld to javafx.fxml;
    exports es.ieslosmontecillos.aplicacionesejemplojavafxhelloworld;
}