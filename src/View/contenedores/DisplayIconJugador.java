package View.contenedores;

import View.JugadorView;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;



public class DisplayIconJugador extends Pane {

    public DisplayIconJugador(ImageView figura){
        ImageView icono = new ImageView(figura.getImage());
        Rectangle2D limitesPantalla = Screen.getPrimary().getVisualBounds();
        icono.setPreserveRatio(true);
        icono.relocate(limitesPantalla.getWidth()/5,limitesPantalla.getHeight()/5);
        this.getChildren().add(icono);
    }
}
