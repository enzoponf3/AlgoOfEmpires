package View.contenedores;

import View.MapaView;
import javafx.scene.control.Alert;

public class Alerta {

    private Alert alerta;

    public Alerta() {
        alerta = new Alert(Alert.AlertType.WARNING);
        alerta.setHeaderText(null);
    }

    // Para usar cuando catch Exception y no alguna en particular
    public void inesperada() {
        sonidoError();
        alerta.setContentText("Error no tenido en cuenta");
        alerta.show();
    }

    public void oroInsuficiente() {
        sonidoError();
        alerta.setContentText("Oro insuficiente");
        alerta.show();
    }

    public void posicionOcupada() {
        sonidoError();
        alerta.setContentText("Una o más posiciones se encuentran ocupadas");
        alerta.show();
    }

    public void posicionNoAledania() {
        sonidoError();
        alerta.setContentText("La posición seleccionada esta fuera de alcance");
        alerta.show();
    }



    public void posicionFueraDelMapa() {
        sonidoError();
        alerta.setContentText("Posicion cae fuera del mapa");
        alerta.show();
    }

    public void faltanDatos() {
        sonidoError();
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("Faltan datos!");
        alerta.show();
    }

    public void unidadEnemiga() {
        sonidoError();
        alerta.setContentText("La unidad seleccionada es del enemigo");
        alerta.show();
    }

    public void armaDesmontada() {
        sonidoError();
        alerta.setContentText("Este arma esta desmontada");
        alerta.show();
    }

    public void unidadOcupada() {
        sonidoError();
        alerta.setContentText("La unidad seleccionada esta ocupada");
        alerta.show();
    }

    public void armaMontada() {
        sonidoError();
        alerta.setContentText("Esta arma esta montada");
        alerta.show();
    }

    public void faltaNombre() {
        sonidoError();
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("Falta ingresar un nombre");
        alerta.show();
    }

    public void faltaFigura() {
        sonidoError();
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("Falta seleccionar una figura");
        alerta.show();
    }

    public void faltaObjetivo(){
        sonidoError();
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("Falta seleccionar un objetivo");
        alerta.show();
    }

    public void armaNoAtacaUnidades(){
        sonidoError();
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("El arma de asedio no ataca unidades");
        alerta.show();
    }

    public void unidadPropia(){
        sonidoError();
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("La unidad que intentas atacar es tuya");
        alerta.show();
    }

    public void edificioPropio(){
        sonidoError();
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("El edificio que intentas atacar es tuyo");
        alerta.show();
    }

    public void edificioNoConstruido(){
        sonidoError();
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("El edificio no esta construido");
        alerta.show();
    }

    public void edifcioEnConstNoSeleccionado(){
        sonidoError();
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("No has seleccionado un edificio en construccion");
        alerta.show();
    }

    public void edificioYaConstruido(){
        sonidoError();
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("El edificio ya esta construido");
        alerta.show();
    }

    public void objetivoIncorrecto(){
        sonidoError();
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("El objetivo seleccionado no es el esperado");
        alerta.show();
    }

    public void edificioDestruido(){
        sonidoError();
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("El edificio esta destruido");
        alerta.show();
    }

    public void edificioAunEnConst(){
        sonidoError();
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("Debes pasar el turno para poder crear unidades");
        alerta.show();
    }

    private void sonidoError(){
        MapaView.getInstancia().reproducirEfecto().error();
    }

    public void  atacanteEnemig(){
        sonidoError();
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("El atacante es enemigo");
        alerta.show();
    }

    public void  objetivoFueraRango(){
        sonidoError();
        alerta.setAlertType(Alert.AlertType.ERROR);
        alerta.setContentText("El objetivo esta fuera de rango");
        alerta.show();
    }

    public void edificioAjeno() {
        sonidoError();
        alerta.setContentText("El edificio que se quiere construir no es suyo.");
        alerta.show();
    }

    public void edificioConVidaMax() {
        sonidoError();
        alerta.setContentText("El edificio que se quiere reparar tiene la vida al máximo.");
        alerta.show();
    }

    public void edificioEnReparacion(){
        sonidoError();
        alerta.setContentText("El edificio ya esta siendo reparado.");
        alerta.show();
    }
}
