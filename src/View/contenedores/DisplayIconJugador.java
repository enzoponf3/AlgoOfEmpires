package View.contenedores;

import View.JugadorView;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

import java.util.Observable;
import java.util.Observer;

public class DisplayIconJugador extends BorderPane implements Observer {
    private ImageView icono;
    private ActualizarView actualizador;
    private Rectangle2D limitesPantalla;


    public DisplayIconJugador(ActualizarView actualizador){
        this.limitesPantalla = Screen.getPrimary().getVisualBounds();
        this.actualizador = actualizador;
        actualizador.addObserver(this);
        this.setPrefSize((limitesPantalla.getWidth())/6,limitesPantalla.getHeight()/5);
        ImageView fondo = new ImageView(new Image("View/img/fondoDisplay.png",(limitesPantalla.getWidth()/6)+1,limitesPantalla.getHeight()/5,false,false));
        this.getChildren().addAll(fondo,new ImageView());
        update(actualizador,actualizador);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o != actualizador)
            return;

        this.icono = new ImageView(this.actualizador.getJugadorView().getFigura().getImage());
        this.icono.setPreserveRatio(true);
        this.icono.prefHeight(limitesPantalla.getWidth()/6);
        this.icono.prefWidth(limitesPantalla.getHeight()/5);
        this.setCenter(this.icono);
    }
}
