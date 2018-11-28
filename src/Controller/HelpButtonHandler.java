package Controller;

import View.contenedores.pantallaAyuda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import java.awt.*;


public class HelpButtonHandler implements EventHandler<ActionEvent> {

    Stage stage;

    public HelpButtonHandler (Stage stage){
        this.stage = stage;

    }
    public void handle(ActionEvent event) {

        Scene ayuda = new Scene(new pantallaAyuda(stage));
        stage.setScene(ayuda);
        stage.setResizable(false);
        stage.show();
    }
}
