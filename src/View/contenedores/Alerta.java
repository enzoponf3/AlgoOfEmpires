package View.contenedores;

import javafx.scene.control.Alert;

public class Alerta {

    private Alert alerta;

    public Alerta() {
        alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setHeaderText(null);
    }

    // Para usar cuando catch Exception y no alguna en particular
    public void inesperada() {
        alerta.setContentText("Error no tenido en cuenta");
        alerta.show();
    }

    public void oroInsuficiente() {
        alerta.setContentText("Oro insuficiente");
        alerta.show();
    }

    public void posicionOcupada() {
        alerta.setContentText("Una o más posiciones se encuentran ocupadas");
        alerta.show();
    }

    public void posicionNoAledania() {
        alerta.setContentText("La posición seleccionada esta fuera de alcance");
        alerta.show();
    }



    public void posicionFueraDelMapa() {
        alerta.setContentText("Posicion cae fuera del mapa");
        alerta.show();
    }

    public void faltanDatos() {
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("Faltan datos!");
        alerta.show();
    }

    public void unidadEnemiga() {
        alerta.setContentText("La unidad seleccionada es del enemigo");
        alerta.show();
    }

    public void armaDesmontada() {
        alerta.setContentText("Este arma esta desmontada");
        alerta.show();
    }

    public void unidadOcupada() {
        alerta.setContentText("La unidad seleccionada esta ocupada");
        alerta.show();
    }

    public void armaMontada() {
        alerta.setContentText("Esta arma esta montada");
        alerta.show();
    }

    public void faltaNombre() {
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("Falta ingresar un nombre");
        alerta.show();
    }

    public void faltaFigura() {
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("Falta seleccionar una figura");
        alerta.show();
    }

    public void faltaObjetivo(){
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("Falta seleccionar un objetivo");
        alerta.show();
    }

    public void armaNoAtacaUnidades(){
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("El arma de asedio no ataca unidades");
        alerta.show();
    }

    public void unidadPropia(){
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("La unidad que intentas atacar es tuya");
        alerta.show();
    }

    public void edificioPropio(){
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("El edificio que intentas atacar es tuyo");
        alerta.show();
    }

    public void edificioNoConstruido(){
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("El edificio no esta construido");
        alerta.show();
    }

    public void edifcioEnConstNoSeleccionado(){
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("No has seleccionado un edificio en construccion");
        alerta.show();
    }
}
