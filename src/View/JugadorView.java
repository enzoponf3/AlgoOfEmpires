package View;


import Modelo.Edificios.Cuartel;
import Modelo.Edificios.Edificio;
import Modelo.Edificios.PlazaCentral;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import Modelo.Unidades.Unidad;
import View.contenedores.PantallaGanador;
import View.entidades.AldeanoView;
import View.entidades.CastilloView;
import View.entidades.CuartelView;
import View.entidades.PlazaCentralView;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.ArrayList;


public class JugadorView {

    private ImageView personaje;
    private String nombre = "";

    private Jugador jugadorModelo;
    private Group aldeanosView;
    private Group ejercitoView;
    private Group edificiosView;
    private CastilloView castilloView;

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
        inicializarPiezas();
    }

    public Group getPiezas(){
        Group piezas = new Group();
        piezas.getChildren().addAll(castilloView, aldeanosView, ejercitoView, edificiosView);

        return piezas;
    }

    public void inicializarPiezas(){
        this.castilloView = new CastilloView(this.jugadorModelo.getCastillo());

        PlazaCentralView plazaCentralView = new PlazaCentralView((PlazaCentral) this.jugadorModelo.getEdificios().get(0));
        this.edificiosView = new Group();
        this.edificiosView.getChildren().add(plazaCentralView);

        this.aldeanosView = new Group();
        for(Aldeano aldeanoModelo : jugadorModelo.getAldeanos()){
            AldeanoView aldeanoView = new AldeanoView(aldeanoModelo);
            this.aldeanosView.getChildren().add(aldeanoView);
        }

        this.ejercitoView = new Group();
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

    public boolean contienePieza(PiezaView piezaView){
        if( this.aldeanosView.getChildren().contains(piezaView) )
            return true;
        else if( this.ejercitoView.getChildren().contains(piezaView) )
            return true;
        else if( this.edificiosView.getChildren().contains(piezaView) )
            return true;
        else if( this.edificiosView.getChildren().contains(piezaView) )
            return true;
        else
            return false;

    }

    public boolean mover(Unidad unidadModelo, Posicion destino){
        Mapa mapaModelo = Mapa.getInstancia();
        return jugadorModelo.mover(unidadModelo, destino, mapaModelo);
    }

    public void construirCuartel(Aldeano aldeanoModelo, ArrayList<Posicion> posiciones){
        Mapa mapaModelo = Mapa.getInstancia();
        Cuartel cuartelModelo = jugadorModelo.construirCuartel(mapaModelo, aldeanoModelo, posiciones);
        CuartelView cuartelView = new CuartelView(cuartelModelo);
        this.edificiosView.getChildren().add(cuartelView);
        MapaView mapaView = MapaView.getInstancia();
        mapaView.agregarPieza(cuartelView);
    }

    // Seba
    public void reparar(Aldeano aldeano, Edificio edificio) {
        jugadorModelo.reparar(aldeano,edificio);
    }

    public void construirPlazaCentral(Aldeano aldeanoModelo, ArrayList<Posicion> posiciones) {
        Mapa mapaModelo = Mapa.getInstancia();
        PlazaCentral plazaCentral = jugadorModelo.construirPlazaCentral(mapaModelo, aldeanoModelo, posiciones);
        PlazaCentralView cuartelView = new PlazaCentralView(plazaCentral);
        this.edificiosView.getChildren().add(cuartelView);
        MapaView mapaView = MapaView.getInstancia();
        mapaView.agregarPieza(cuartelView);
    }
}
