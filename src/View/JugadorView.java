package View;


import Modelo.Edificios.Castillo;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.Edificio;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.EdificioNoExisteException;
import Modelo.Exceptions.TurnoDelOponenteException;
import Modelo.Exceptions.UnidadEstaOcupadoException;
import Modelo.Exceptions.UnidadMovibleNoExisteException;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import Modelo.Unidades.ArmaDeAsedio;
import Modelo.Unidades.Unidad;
import View.contenedores.PantallaGanador;
import View.entidades.*;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;


public class JugadorView {

    private ImageView personaje;
    private String nombre = "";
    private Jugador jugadorModelo;
    private CastilloView castilloView;
    private Mapa mapaModelo;

    public void setPersonaje(ImageView figura){
        this.personaje = figura;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public ImageView getFigura(){
        return this.personaje;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void mostrarQueGane(){
        Scene ayuda = new Scene(new PantallaGanador(this));        //Display de pantalla ganador
        Stage stage = new Stage();
        stage.setScene(ayuda);
        stage.setResizable(false);
        stage.show();

    }

    public void setJugadorModelo(Jugador jugadorModelo){
        this.jugadorModelo = jugadorModelo;
        this.mapaModelo = Mapa.getInstancia();

    }

    public Group inicializarPiezas(){
        Group piezas = new Group();
        this.castilloView = new CastilloView(this.jugadorModelo.getCastillo());
        PlazaCentralView plazaCentralView = new PlazaCentralView((PlazaCentral) this.jugadorModelo.getEdificios().get(0));
        piezas.getChildren().addAll(castilloView,plazaCentralView);
        for(Aldeano aldeanoModelo : jugadorModelo.getAldeanos()){
            AldeanoView aldeanoView = new AldeanoView(aldeanoModelo);
            piezas.getChildren().add(aldeanoView);
        }
        return piezas;
    }

    public String getOro() {
        return Integer.toString(jugadorModelo.getCantidadOro());
    }

    public String getPoblacion() {
        return Integer.toString(jugadorModelo.getCantidadPoblacion());
    }

    public String getVida() {
        return Integer.toString(jugadorModelo.getVida()); //Este pregunta por vida castillo, le puse vida y no vidaCastillo para no revelar implementacion o la flasheo fuerte?
    }


    public void mover(Unidad unidadModelo, Posicion destino){
        jugadorModelo.mover(unidadModelo, destino, mapaModelo);
    }

    public void construirCuartel(Aldeano aldeanoModelo, ArrayList<Posicion> posiciones){
        Mapa mapaModelo = Mapa.getInstancia();
        try {
            Cuartel cuartelModelo = jugadorModelo.construirCuartel(mapaModelo, aldeanoModelo, posiciones);
            CuartelView cuartelView = new CuartelView(cuartelModelo);
            MapaView mapaView = MapaView.getInstancia();
            mapaView.agregarPieza(cuartelView);
        } catch (Exception e) {
            Alert errorConstruccion = new Alert(Alert.AlertType.WARNING);
            errorConstruccion.setHeaderText(null);
            errorConstruccion.setContentText("Construcción no permitida.");
            errorConstruccion.show();
        }
    }

    public void construirPlazaCentral(Aldeano aldeanoModelo, ArrayList<Posicion> posiciones) {
        Mapa mapaModelo = Mapa.getInstancia();
        try {
            PlazaCentral plazaCentral = jugadorModelo.construirPlazaCentral(mapaModelo, aldeanoModelo, posiciones);
            PlazaCentralView cuartelView = new PlazaCentralView(plazaCentral);
            MapaView mapaView = MapaView.getInstancia();
            mapaView.agregarPieza(cuartelView);
        } catch (Exception e) {
            Alert errorConstruccion = new Alert(Alert.AlertType.WARNING);
            errorConstruccion.setHeaderText(null);
            errorConstruccion.setContentText("Construcción no permitida.");
            errorConstruccion.show();
        }
    }

    public void reparar(Aldeano aldeano, Edificio edificio) {
        jugadorModelo.reparar(aldeano,edificio);
    }

    public void crearArmaDeAsedio(Castillo castilloMod) {
        ArmaDeAsedio arma;
        arma = jugadorModelo.crearArmaDeAsedio(mapaModelo, castilloMod);
        ArmaDeAsedioView armaView = new ArmaDeAsedioView(arma);
        MapaView mapaView = MapaView.getInstancia();
        mapaView.agregarPieza(armaView);
    }

    public void montarArma(ArmaDeAsedio arma) {
        jugadorModelo.montarArmaDeAsedio(arma);
    }

    public void desmontarArma(ArmaDeAsedio arma) {
        jugadorModelo.desmontarArmaDeAsedio(arma);
    }
}
