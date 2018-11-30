package View;

import Modelo.Edificios.PlazaCentral;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import View.entidades.AldeanoView;
import View.entidades.CastilloView;
import View.entidades.PlazaCentralView;

import javafx.scene.Group;
import javafx.scene.layout.Pane;


public class MapaView extends Pane {

    private Group casilleros;
    private Group piezas;
    private JugadorView jugadorView1;
    private JugadorView jugadorView2;
    private Mapa mapaModelo;

    private CasilleroView casilleroSeleccionada;
    private PiezaView piezaView;

    public MapaView(Mapa mapa, int anchoMapa, int altoMapa, JugadorView jugadorView1, JugadorView jugadorView2){
        this.casilleros = new Group();
        this.mapaModelo = mapa;
        this.jugadorView1 = jugadorView1;
        this.jugadorView2 = jugadorView2;

        this.setPrefSize(anchoMapa*Constantes.TAMANIO_CASILLERO, altoMapa*Constantes.TAMANIO_CASILLERO);

        //this.setPrefSize(anchoMapa, altoMapa);

        //creo los casilleros para poner en el Pane
        for(int y = 0; y< altoMapa ; y++){
            for(int x = 0; x< anchoMapa; x++){
                CasilleroView unCasillero = new CasilleroView(x,y);
                casilleros.getChildren().add(unCasillero);
            }
        }

        colocarPiezasIniciales(jugadorView1, jugadorView2);

        getChildren().addAll(casilleros, piezas);
    }


    public void colocarPiezasIniciales(JugadorView jugadorView1, JugadorView jugadorView2){
        Group piezasJ1 = jugadorView1.getPiezas();
        Group piezasJ2 = jugadorView2.getPiezas();

        this.piezas = new Group();
        this.piezas.getChildren().addAll(piezasJ1, piezasJ2);
    }



}
