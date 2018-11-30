package View.contenedores;

import Modelo.Jugador.Jugador;
import View.JugadorView;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Screen;



public class DisplayBarraDatos extends HBox {

    public DisplayBarraDatos(JugadorView jugadorView){
        Rectangle2D limitesPantalla = Screen.getPrimary().getVisualBounds();
        this.setPrefSize(limitesPantalla.getWidth(),limitesPantalla.getHeight()/24);

        Label oro = new Label(jugadorView.getOro());
        oro.setStyle("-fx-text-fill: white");
        oro.setLayoutX(limitesPantalla.getWidth()/16);

        Label poblacion = new Label(jugadorView.getPoblacion());
        poblacion.setStyle("-fx-text-fill: white");
        poblacion.setTranslateX((3*limitesPantalla.getWidth())/32);

        Label vida = new Label(jugadorView.getVida());
        vida.setStyle("-fx-text-fill: white");
        vida.setTranslateX((13*limitesPantalla.getWidth())/64);

        Label nombre = new Label(jugadorView.getNombre());
        nombre.setStyle("-fx-text-fill: white;\n -fx-font-size: 15");
        nombre.setPadding(new Insets(0,0,0,(23*limitesPantalla.getWidth())/32));

        HBox hbox = new HBox(oro,poblacion,vida,nombre);
        hbox.setTranslateX(limitesPantalla.getWidth()/16);
        hbox.setAlignment(Pos.CENTER);

        this.setStyle("-fx-background-image: url(\"View/img/BarraDatos.png\");\n -fx-background-size: cover");
        this.getStylesheets().add(getClass().getResource("/View/estilos/buttonsStylesheet.css").toString());
        this.getChildren().addAll(hbox);
    }
}
