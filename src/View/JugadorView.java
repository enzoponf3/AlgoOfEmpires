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
import java.util.Map;


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
        plazaCentralView.setImagenPlazaConstruida();

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
        Mapa mapaModelo = Mapa.getInstancia();
        jugadorModelo.continuarConstruccionCuartel(mapaModelo, aldeanoModelo, cuartelAConstruir);
    }

    public void construirPlazaCentral(Aldeano aldeanoModelo, ArrayList<Posicion> posiciones) {
        Mapa mapaModelo = Mapa.getInstancia();
        PlazaCentral plazaCentral = jugadorModelo.construirPlazaCentral(mapaModelo, aldeanoModelo, posiciones);
        PlazaCentralView plazaCentralView = new PlazaCentralView(plazaCentral);
        plazaCentralView.setTurnosFaltantes();
        MapaView mapaView = MapaView.getInstancia();
        mapaView.agregarPieza(plazaCentralView);
    }

    public void continuarConstruccionPlazaCentral(Aldeano aldeanoModelo, PlazaCentral plazaCentralAConstruir){
        Mapa mapaModelo = Mapa.getInstancia();
        jugadorModelo.continuarConstruccionPlazaCentral(mapaModelo, aldeanoModelo, plazaCentralAConstruir);
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
        MapaView mapa = MapaView.getInstancia();
        try{
            jugadorModelo.atacar(atacante,(Unidad) objetivo);
            if(((Unidad) objetivo).estaMuerto()){
                System.out.println("ESTO NO DEBERIA APARECER NUNCA!");
                mapa.removerPiezaSeleccionada();
            }
        }catch(ClassCastException e){
            System.out.println("ENTRE AL EXCEPTION DEL UNIDAD");
        }

        try{
            System.out.println("ANTES DE ATACAR EDIF, la vida es :" + ((Edificio) objetivo).getVida());
            jugadorModelo.atacar(atacante,(Edificio) objetivo);
            System.out.println("DSP DE ATACAR");
            System.out.println("Vida edif: " + ((Edificio) objetivo).getVida());
            if(((Edificio) objetivo).estaDestruido()){
                mapa.removerPiezaSeleccionada();
                System.out.println("HOLA!");
            }
        }catch(ClassCastException e2){}
    }

    public Jugador getJugadorModeloParaTest(){              //Metodo solo para test
        return jugadorModelo;
    }


    public void crearEspadachin(Cuartel cuartelMod) {
        Espadachin espadachin = jugadorModelo.crearEspadachin(mapaModelo,cuartelMod);
        EspadachinView espadachinView = new EspadachinView(espadachin);
        MapaView mapaView = MapaView.getInstancia();
        mapaView.agregarPieza(espadachinView);
    }

    public void crearArquero(Cuartel cuartelMod) {
        Arquero arquero = jugadorModelo.crearArquero(mapaModelo,cuartelMod);
        ArqueroView arqueroView = new ArqueroView(arquero);
        MapaView mapaView = MapaView.getInstancia();
        mapaView.agregarPieza(arqueroView);
    }
}
