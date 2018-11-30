package View.contenedores;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;

public class DisplayBarraDatos extends HBox {

    public DisplayBarraDatos(){
        Rectangle2D limitesPantalla = Screen.getPrimary().getVisualBounds();
        this.setPrefSize(limitesPantalla.getWidth(),limitesPantalla.getHeight()/24);
        Image fondoBarra = new Image("View/img/BarraDatos.png", limitesPantalla.getWidth(), limitesPantalla.getHeight()/24, false, true);
        ImageView im = new ImageView(fondoBarra);
        this.getChildren().add(im);
    }
}
