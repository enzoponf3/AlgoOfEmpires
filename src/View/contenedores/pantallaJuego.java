package View.contenedores;

import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class PantallaJuego extends Pane {

    Log log = new Log();

    public  PantallaJuego(){

        this.getChildren().add(new DisplayLog(this.log));

    }
}
