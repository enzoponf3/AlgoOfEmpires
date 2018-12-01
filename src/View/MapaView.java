package View;

import Modelo.Casillero;
import Modelo.Edificios.PlazaCentral;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import Modelo.Posicion;
import View.entidades.AldeanoView;
import View.entidades.CastilloView;
import View.entidades.PlazaCentralView;

import javafx.scene.Group;
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

        this.setPrefSize(anchoMapa*Constantes.TAMANIO_CASILLERO, altoMapa*Constantes.TAMANIO_CASILLERO);

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

        INSTANCIA = this;
    }

    public static MapaView getInstancia(){
        return INSTANCIA;
    }


    public void colocarPiezasIniciales(JugadorView jugadorView1, JugadorView jugadorView2){
        Group piezasJ1 = jugadorView1.getPiezas();
        Group piezasJ2 = jugadorView2.getPiezas();

        this.piezas = new Group();
        this.piezas.getChildren().addAll(piezasJ1, piezasJ2);
    }

    public void seleccionarCasillero(CasilleroView casilleroView){
        this.casilleroSeleccionada = casilleroView;
    }

    public void seleccionarPieza(PiezaView piezaView){
        this.piezaSeleccionada = piezaView;
    }

    public Posicion getDestino(){
        return this.casilleroSeleccionada.getPosicion();
    }

    public void agregarPieza(PiezaView piezaView){
        this.piezas.getChildren().add(piezaView);
    }

}
