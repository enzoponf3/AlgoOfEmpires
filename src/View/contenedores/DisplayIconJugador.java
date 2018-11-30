package View.contenedores;

import View.JugadorView;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Screen;

import java.util.Observable;
import java.util.Observer;

public class DisplayIconJugador extends BorderPane implements Observer {
    private ImageView icono;
    private ActualizarView vista;
    private Rectangle2D limitesPantalla;


    public DisplayIconJugador(ActualizarView vista){
        this.limitesPantalla = Screen.getPrimary().getVisualBounds();
        this.vista = vista;
        vista.addObserver(this);
        setStyle("-fx-background-color: #ad6c11");
        this.setPrefSize((limitesPantalla.getWidth())/6,limitesPantalla.getHeight()/5);
        this.getChildren().add(new ImageView());
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o != vista)
            return;

        this.icono = new ImageView(this.vista.getJugadorView().getFigura().getImage());
        this.icono.setPreserveRatio(true);
        this.icono.prefHeight(limitesPantalla.getWidth()/6);
        this.icono.prefWidth(limitesPantalla.getHeight()/5);
        this.setCenter(this.icono);
    }
}
