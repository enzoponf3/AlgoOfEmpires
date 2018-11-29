package View;

import Modelo.Edificios.PlazaCentral;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import View.entidades.AldeanoView;
import View.entidades.CastilloView;
import View.entidades.PlazaCentralView;
import Vista.*;
import javafx.scene.Group;
import javafx.scene.layout.Pane;


public class MapaView extends Pane {

    public static final int TAMANIO_CASILLERO = 30;
    public static final int ANCHO = 20;
    public static final int ALTO = 20;

    private Group casilleros;
    private Group piezas;

    private Mapa mapaModelo;

    public MapaView(Mapa mapa, int anchoMapa, int altoMapa){
        casilleros = new Group();
        this.mapaModelo = mapa;

        //this.setPrefSize(anchoMapa*TAMANIO_CASILLERO, altoMapa*TAMANIO_CASILLERO);
        this.setPrefSize(anchoMapa, altoMapa);

        //creo los casilleros para poner en el Pane
        for(int y = 0; y< ALTO ; y++){
            for(int x = 0; x< ANCHO; x++){
                CasilleroView unCasillero = new CasilleroView(x,y);
                casilleros.getChildren().add(unCasillero);
            }
        }

        getChildren().addAll(casilleros);

        crearContenido(this);
    }


    private void crearContenido(MapaView mapaView){
        //Un grupo de casilleros
        this.casilleros = new Group();
        this.piezas = new Group();

        //CONTENIDO------------------
        Jugador jugador1 = new Jugador(mapaModelo, 0, 6);
        Jugador jugador2 = new Jugador(mapaModelo, 16, 13);


        colocarPiezasIniciales(jugador1, jugador2);

        //-------------------
        mapaView.getChildren().add(piezas);
    }

    public void colocarPiezasIniciales(Jugador jugador1, Jugador jugador2){
        //Piezas jug 1
        CastilloView castilloView1 = new CastilloView(jugador1.getCastillo());
        PlazaCentralView plazaView1 = new PlazaCentralView((PlazaCentral) jugador1.getEdificios().get(0));
        for(int i=0; i<3; i++) {
            AldeanoView aldeano = new AldeanoView(jugador1.getAldeanos().get(i));
            this.piezas.getChildren().add(aldeano);
        }

        //Piezas jug 2
        CastilloView castilloView2 = new CastilloView(jugador2.getCastillo());
        PlazaCentralView plazaView2 = new PlazaCentralView((PlazaCentral) jugador2.getEdificios().get(0));
        for(int i=0; i<3; i++) {
            AldeanoView aldeano = new AldeanoView(jugador2.getAldeanos().get(i));
            this.piezas.getChildren().add(aldeano);
        }

        this.piezas.getChildren().addAll(castilloView1, plazaView1, castilloView2, plazaView2);
    }



}
