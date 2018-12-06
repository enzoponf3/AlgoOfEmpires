package Controller;

import View.contenedores.Alerta;
import View.JugadorView;
import View.contenedores.DisplayIconJugador;
import View.contenedores.PantallaJuego;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class BeginButtonHandler implements EventHandler<ActionEvent> {
    private JugadorView jugador1;
    private JugadorView jugador2;
    private Stage stage;
    private ControladorMusicaFx musica;
    public BeginButtonHandler(Stage stage, JugadorView jugador1, JugadorView jugador2,ControladorMusicaFx musica) {
        this.stage = stage;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
        this.musica = musica;
    }

    public void handle(ActionEvent event){
        if(this.jugador1.getNombre() == "" || this.jugador2.getNombre() == "" || jugador1.getFigura() == null || jugador2.getFigura() == null){
            new Alerta().faltanDatos();
        }else{
            ControladorMusicaFx.getINSTANCIA().parar();
            Scene scene = new Scene(new PantallaJuego(this.stage,this.jugador1,this.jugador2,musica));

            Rectangle2D limitesPantalla = Screen.getPrimary().getVisualBounds();
            this.stage.setHeight(limitesPantalla.getHeight());
            this.stage.setWidth(limitesPantalla.getWidth());
            this.stage.setX((limitesPantalla.getWidth() - stage.getWidth()) / 2);
            this.stage.setY((limitesPantalla.getHeight() - stage.getHeight()) / 4);
            this.stage.setScene(scene);
            this.stage.show();
        }

    }
}
