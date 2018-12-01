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

import java.util.Observable;
import java.util.Observer;


public class DisplayBarraDatos extends HBox implements Observer {
    private ActualizarView actualizador;
    Label oro;
    Label poblacion;
    Label vida;
    Label nombre;
    HBox hbox;



    public DisplayBarraDatos(JugadorView jugadorView,ActualizarView actualizador){
        Rectangle2D limitesPantalla = Screen.getPrimary().getVisualBounds();
        this.setPrefSize(limitesPantalla.getWidth(),limitesPantalla.getHeight()/24);

        this.actualizador = actualizador;
        actualizador.addObserver(this);

        this.oro = new Label(jugadorView.getOro());
        oro.setStyle("-fx-text-fill: white");
        oro.setLayoutX(limitesPantalla.getWidth()/16);

        this.poblacion = new Label(jugadorView.getPoblacion());
        poblacion.setStyle("-fx-text-fill: white");
        poblacion.setTranslateX((3*limitesPantalla.getWidth())/32);

        this.vida = new Label(jugadorView.getVida());
        vida.setStyle("-fx-text-fill: white");
        vida.setTranslateX((13*limitesPantalla.getWidth())/64);

        this.nombre = new Label(jugadorView.getNombre());
        nombre.setStyle("-fx-text-fill: white;\n -fx-font-size: 15");
        nombre.setPadding(new Insets(0,0,0,(23*limitesPantalla.getWidth())/32));

        this.hbox = new HBox(oro,poblacion,vida,nombre);
        hbox.setTranslateX(limitesPantalla.getWidth()/16);
        hbox.setAlignment(Pos.CENTER);

        this.setStyle("-fx-background-image: url(\"View/img/BarraDatos.png\");\n -fx-background-size: cover");
        this.getStylesheets().add(getClass().getResource("/View/estilos/buttonsStylesheet.css").toString());
        this.getChildren().addAll(hbox);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o != actualizador)
            return;

        JugadorView jugadorActualizado = actualizador.getJugadorViewActual();
        this.vida.setText(jugadorActualizado.getVida());
        this.oro.setText(jugadorActualizado.getOro());
        this.nombre.setText(jugadorActualizado.getNombre());
        this.poblacion.setText(jugadorActualizado.getPoblacion());
        this.hbox.getChildren().setAll(this.oro,this.poblacion,this.vida,this.nombre);
    }
}
