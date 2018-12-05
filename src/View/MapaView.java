package View;

import Modelo.*;
import Modelo.Exceptions.CasilleroNoSeleccionadoException;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;
import View.entidades.ArqueroView;
import View.entidades.EspadachinView;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;


public class MapaView extends Pane {

    private static MapaView INSTANCIA;

    private Group casilleros;
    private Group piezas;
    private JugadorView jugadorView1;
    private JugadorView jugadorView2;
    private Mapa mapaModelo;

    private CasilleroView casilleroSeleccionada;
    private PiezaView piezaSeleccionada;


    public MapaView(Mapa mapa, int anchoMapa, int altoMapa, JugadorView jugadorView1, JugadorView jugadorView2){
        this.casilleros = new Group();
        this.mapaModelo = mapa;
        this.jugadorView1 = jugadorView1;
        this.jugadorView2 = jugadorView2;

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

    public void agregarAtacantesParaTest() {                          //Metodo para test
        Posicion pos1 = new Posicion(14,20);
        Posicion pos2 = new Posicion(13,20);

        Espadachin atacante1 = new Espadachin(pos1);
        jugadorView2.getJugadorModeloParaTest().agregarAEjercito(atacante1,mapaModelo);
        EspadachinView atacante1View = new EspadachinView(atacante1);
        this.agregarPieza(atacante1View);

        Arquero atacante2 = new Arquero(pos2);
        jugadorView1.getJugadorModeloParaTest().agregarAEjercito(atacante2,mapaModelo);
        ArqueroView atacante2View = new ArqueroView(atacante2);
        this.agregarPieza(atacante2View);
    }

}
