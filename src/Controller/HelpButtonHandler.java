package Controller;

import View.contenedores.PantallaAyuda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class HelpButtonHandler implements EventHandler<ActionEvent> {

    Stage stage;

    public HelpButtonHandler (Stage stage){
        this.stage = stage;
    }

    public void handle(ActionEvent event) {
        Scene ayuda = new Scene(new PantallaAyuda(stage));
        stage.setScene(ayuda);
        stage.setResizable(false);
        stage.show();
    }
}
