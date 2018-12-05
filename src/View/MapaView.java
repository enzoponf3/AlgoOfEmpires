package View;

import Modelo.*;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.CasilleroNoSeleccionadoException;
import Modelo.Unidades.ArmaDeAsedio;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;
import View.contenedores.Log;
import View.entidades.ArmaDeAsedioView;
import View.entidades.ArqueroView;
import View.entidades.EspadachinView;
import View.entidades.PlazaCentralView;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;


public class MapaView extends Pane {

    private static MapaView INSTANCIA;
    private Log log;

    private Group casilleros;
    private Group piezas;
    private JugadorView jugadorView1;
    private JugadorView jugadorView2;
    private Mapa mapaModelo;

    private CasilleroView casilleroSeleccionada;
    private PiezaView piezaSeleccionada;


    public MapaView(Mapa mapa, int anchoMapa, int altoMapa, JugadorView jugadorView1, JugadorView jugadorView2, Log log){
        this.casilleros = new Group();
        this.mapaModelo = mapa;
        this.jugadorView1 = jugadorView1;
        this.jugadorView2 = jugadorView2;
        this.log = log;

        this.setPrefSize(anchoMapa* Constantes.TAMANIO_CASILLERO, altoMapa*Constantes.TAMANIO_CASILLERO);

        //creo los casilleros para poner en el Pane
        for(int y = 0; y< altoMapa ; y++){
            for(int x = 0; x< anchoMapa; x++){
                Posicion posicion = new Posicion(x,y);
                Casillero casillero = mapa.seleccionarCasillero(posicion);
                CasilleroView unCasillero = new CasilleroView(x, y, casillero);
                casilleros.getChildren().add(unCasillero);
            }
        }

        colocarPiezasIniciales(jugadorView1, jugadorView2);
        getChildren().addAll(casilleros, piezas);
        agregarAtacantesParaTest();                     //Metodo para test

        this.casilleroSeleccionada = null;

        INSTANCIA = this;
    }

    public static MapaView getInstancia(){
        return INSTANCIA;
    }


    public void colocarPiezasIniciales(JugadorView jugadorView1, JugadorView jugadorView2){
        Group piezasJ1 = jugadorView1.inicializarPiezas();
        Group piezasJ2 = jugadorView2.inicializarPiezas();

        this.piezas = new Group();
        this.piezas.getChildren().addAll(piezasJ1, piezasJ2);
    }

    public void seleccionarCasillero(CasilleroView casilleroView){
        if (this.casilleroSeleccionada != null)
            this.casilleroSeleccionada.quitarEfecto();
        this.casilleroSeleccionada = casilleroView;
    }

    public void seleccionarPieza(PiezaView piezaView){
        this.piezaSeleccionada = piezaView;
    }

    public Posicion getDestino(){
        if( casilleroSeleccionada == null)
            throw new CasilleroNoSeleccionadoException();
        return this.casilleroSeleccionada.getPosicion();
    }

    public void agregarPieza(PiezaView piezaView){
        this.piezas.getChildren().add(piezaView);
    }

    // Seba
    public IEntidad getEntidad() {
        return this.piezaSeleccionada.getEntidad();
    }

    public Mapa getMapa (){ return this.mapaModelo;}

    public void agregarAtacantesParaTest() {                          //Metodo para test, tiene un error con el mover, pero es de este metodo, no del mover
        Posicion pos1 = new Posicion(11,20);
        Posicion pos2 = new Posicion(14,20);

        ArmaDeAsedio atacante1 = new ArmaDeAsedio(pos1);
        jugadorView1.getJugadorModeloParaTest().agregarAEjercito(atacante1,mapaModelo);
        ArmaDeAsedioView atacante1View = new ArmaDeAsedioView(atacante1);
        this.agregarPieza(atacante1View);

        ArrayList<Posicion> posiciones = mapaModelo.getBloque2x2(pos2);
        PlazaCentral plaza = new PlazaCentral(posiciones);
        plaza.finalizarConstruccion();
        System.out.println("Vida plaza antes de ataque:" + plaza.getVida());
        jugadorView2.getJugadorModeloParaTest().agregarEdificio(plaza,mapaModelo);
        PlazaCentralView plazaView = new PlazaCentralView(plaza);
        this.agregarPieza(plazaView);
    }

    public void enviarMensaje(String msj){
        log.enviarMensaje(msj);
    }
}
