package View.contenedores;

import View.JugadorView;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;



public class displayIconJugador extends Pane {

    public displayIconJugador(ImageView figura){
        ImageView icono = new ImageView(figura.getImage());
        icono.relocate(-27,-20);
        this.getChildren().add(icono);
    }
}
