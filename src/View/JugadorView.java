package View;


import Modelo.Edificios.Castillo;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.Edificio;
import Modelo.Edificios.PlazaCentral;
import Modelo.IEntidad;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.*;
import View.contenedores.PantallaGanador;
import View.entidades.*;
import javafx.beans.property.IntegerProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import sun.rmi.runtime.Log;

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

    public IntegerProperty getOro() {
        return jugadorModelo.getOroProperty();
    }

    public IntegerProperty getPoblacion() {
        return jugadorModelo.getCantidadPoblacionProperty();
    }

    public String getVida() {
        return Integer.toString(jugadorModelo.getVida()); //Este pregunta por vida castillo, le puse vida y no vidaCastillo para no revelar implementacion o la flasheo fuerte?
    }


    public void mover(Unidad unidadModelo, Posicion destino){
        jugadorModelo.mover(unidadModelo, destino, mapaModelo);
    }

    public void construirCuartel(Aldeano aldeanoModelo, ArrayList<Posicion> posiciones){
        Mapa mapaModelo = Mapa.getInstancia();
        Cuartel cuartelModelo = jugadorModelo.construirCuartel(mapaModelo, aldeanoModelo, posiciones);
        CuartelView cuartelView = new CuartelView(cuartelModelo);
        MapaView mapaView = MapaView.getInstancia();
        mapaView.agregarPieza(cuartelView);
    }

    public void continuarConstruccionCuartel(Aldeano aldeanoModelo, Cuartel cuartelAConstruir){
        jugadorModelo.continuarConstruccionCuartel(aldeanoModelo, cuartelAConstruir);
    }

    public void construirPlazaCentral(Aldeano aldeanoModelo, ArrayList<Posicion> posiciones) {
        Mapa mapaModelo = Mapa.getInstancia();
        PlazaCentral plazaCentral = jugadorModelo.construirPlazaCentral(mapaModelo, aldeanoModelo, posiciones);
        PlazaCentralView plazaCentralView = new PlazaCentralView(plazaCentral);
        MapaView mapaView = MapaView.getInstancia();
        mapaView.agregarPieza(plazaCentralView);
    }

    public void continuarConstruccionPlazaCentral(Aldeano aldeanoModelo, PlazaCentral plazaCentralAConstruir){
        jugadorModelo.continuarConstruccionPlazaCentral(aldeanoModelo, plazaCentralAConstruir);
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

    public void atacar(IEntidad objetivo, IAtacante atacante) {         // Agregar msj a log
        try{
            jugadorModelo.atacar(atacante,(Unidad) objetivo);
        }catch(ClassCastException e){}

        try{
            jugadorModelo.atacar(atacante,(Edificio) objetivo);
        }catch(ClassCastException e2){}
    }

    public Jugador getJugadorModeloParaTest(){              //Metodo solo para test
        return jugadorModelo;
    }




}
