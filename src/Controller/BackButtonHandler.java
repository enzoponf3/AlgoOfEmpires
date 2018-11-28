package Controller;

import View.contenedores.PantallaInicio;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class BackButtonHandler implements EventHandler<ActionEvent> {
    Stage stage;

    public BackButtonHandler(Stage stage){
        this.stage = stage;
    }

    public void handle (ActionEvent event){
            Scene inicio = new Scene(new PantallaInicio(stage));
            stage.setScene(inicio);
            stage.setResizable(false);
            stage.show();
    }
}
