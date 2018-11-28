package Controller;

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
    public BeginButtonHandler(Stage stage, JugadorView jugador1, JugadorView jugador2) {
        this.stage = stage;
        this.jugador1 = jugador1;
        this.jugador2 = jugador2;
    }

    public void handle(ActionEvent event){
        if(this.jugador1.getNombre() == "" || this.jugador2.getNombre() == "" || jugador1.getFigura() == null || jugador2.getFigura() == null){
            Alert faltanDatos = new Alert(Alert.AlertType.ERROR);
            faltanDatos.setHeaderText(null);
            faltanDatos.setContentText("FALTAN DATOS!");
            faltanDatos.show();
        }else{
            Scene scene = new Scene(new PantallaJuego());

            Rectangle2D limitesPantalla = Screen.getPrimary().getVisualBounds();
            this.stage.setHeight(limitesPantalla.getHeight()/5);
            this.stage.setWidth(limitesPantalla.getHeight()/5);
            this.stage.setScene(scene);
            this.stage.show();
        }

    }
}
