package Controller;

import View.contenedores.configJugador;
import View.contenedores.pantallaAyuda;
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

    public PlayButtonHandler(Stage stage){
        this.stage = stage;
        this.jugador1 = new JugadorView();
        this.jugador2 = new JugadorView();
    }
    public void handle(ActionEvent event){

        Scene pantallaSeleccion = new Scene(new configJugador(stage,jugador1,jugador2));
        stage.setScene(pantallaSeleccion);
        stage.setResizable(false);
        Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
        this.stage.setX((primScreenBounds.getWidth() - stage.getWidth()) / 2);
        this.stage.setY((primScreenBounds.getHeight() - stage.getHeight()) / 4);

        stage.show();

    }
}
