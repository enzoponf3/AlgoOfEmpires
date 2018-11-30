package Controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class CerrarJuegoButtonHandler implements EventHandler<ActionEvent> {
    Stage stage;
    public CerrarJuegoButtonHandler(Stage stage) {
        this.stage = stage;
    }


    @Override
    public void handle(ActionEvent event) {
        stage.close();
    }
}
