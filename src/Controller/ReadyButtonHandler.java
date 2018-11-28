package Controller;

import View.JugadorView;
import View.contenedores.pantallaGanador;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ReadyButtonHandler implements EventHandler<ActionEvent> {
    private JugadorView jugador;
    private TextField nombre;

    public ReadyButtonHandler(JugadorView jugador, TextField nombre) {
        this.jugador = jugador;
        this.nombre = nombre;
    }

    public void handle(ActionEvent event) {
        if (this.nombre.getText().trim().isEmpty()) {
            Alert faltaNombre = new Alert(Alert.AlertType.ERROR);
            faltaNombre.setHeaderText(null);
            faltaNombre.setContentText("NO ESCRIBISTE UN NOMBRE!");
            faltaNombre.show();
        }
        else if(this.jugador.getFigura() == null){
            Alert faltaImagen = new Alert(Alert.AlertType.ERROR);
            faltaImagen.setHeaderText(null);
            faltaImagen.setContentText("NO SELECCIONASTE UNA FIGURA!");
            faltaImagen.show();
        }else {
            this.jugador.setNombre(nombre.getText().trim());

            /*Scene ayuda = new Scene(new pantallaGanador(jugador));
            Stage stage = new Stage();
            stage.setScene(ayuda);
            stage.setResizable(false);
            stage.show();*/
        }
        /*Popup pop = new Popup();
        Stage stage = new Stage();
        VBox box = new VBox(20);
        Label label = new Label();
        label.setText(this.nombre.getText().trim());
        box.getChildren().add(label);
        System.out.println(this.nombre);
        box.getChildren().add(this.jugador.getFigura());
        Scene scene = new Scene(box, 200, 300);
        stage.setScene(scene);
        stage.show();
*/
    }
}
