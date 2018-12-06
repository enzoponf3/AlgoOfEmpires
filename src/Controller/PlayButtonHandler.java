package Controller;

import View.contenedores.PantallaConfigJugador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import View.JugadorView;

public class PlayButtonHandler implements EventHandler<ActionEvent> {
    Stage stage;
    JugadorView jugador1;
    JugadorView jugador2;
    ControladorMusicaFx musica;

    public PlayButtonHandler(Stage stage,ControladorMusicaFx musica){
        this.stage = stage;
        this.jugador1 = new JugadorView();
        this.jugador2 = new JugadorView();
        this.musica = musica;
    }
    public void handle(ActionEvent event){

        Scene pantallaSeleccion = new Scene(new PantallaConfigJugador(stage,jugador1,jugador2, musica));
        stage.setScene(pantallaSeleccion);
        stage.setResizable(false);
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        this.stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        this.stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 4);

        stage.show();

    }
}
