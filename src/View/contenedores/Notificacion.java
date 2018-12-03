package View.contenedores;

import javafx.scene.control.Alert;

public class Notificacion {
    public Notificacion(String mensaje){
        Alert alerta = new Alert(Alert.AlertType.ERROR);
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.show();
    }
}
