package View.contenedores;


import Modelo.Juego;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import View.JugadorView;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;

import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.*;


public class PantallaJuego extends Pane {

    private Mapa mapaModelo;
    private DisplayBarraDatos barraDatos;
    private Stage stage;
    private Log log;
    private DisplayLog displayLog;
    private double altoPantalla;
    private double anchoPantalla;
    private JugadorView jugadorView1;
    private JugadorView jugadorView2;
    private Jugador jugador1;
    private Jugador jugador2;
    private DisplayIconJugador icono;
    private ActualizarView iconoActualizar;
    private DisplayBotoneraOpciones botonera;
    private Juego juego;

    private int anchoMapa = 50;
    private int altoMapa = 25;
    private View.MapaView mapa;
    private ScrollPane layout;

    public  PantallaJuego( Stage stage,JugadorView j1, JugadorView j2){
        this.mapaModelo = new Mapa(anchoMapa, altoMapa);
        this.juego = new Juego();
        this.jugador1 = juego.getJugador1();
        this.jugador2 = juego.getJugador2();
        this.stage = stage;
        Rectangle2D limitesPantalla = Screen.getPrimary().getVisualBounds();
        this.altoPantalla = limitesPantalla.getHeight();
        this.anchoPantalla = limitesPantalla.getWidth();
        this.setPrefWidth(anchoPantalla);
        this.setPrefHeight(altoPantalla);

        this.jugadorView1 = j1;
        this.jugadorView2 = j2;
        this.log = new Log();
        this.displayLog = dibujarLog();
        this.iconoActualizar = new ActualizarView();
        this.icono = dibujarIcono();
        this.botonera = dibujarBotones();
        this.barraDatos = dibujarBarraDatosJugador();
        this.log.enviarMensaje("HOLA!");
        this.log.enviarMensaje("CHAU!");

        this.dibujarMapa();

        this.getChildren().addAll(this.icono,this.displayLog, this.botonera,this.barraDatos,this.layout);

    }

    private DisplayLog dibujarLog(){
        DisplayLog dis = new DisplayLog(this.log);
        dis.setLayoutX(anchoPantalla/6);
        dis.setLayoutY((4*altoPantalla)/5);
        return dis;
    }

    private DisplayIconJugador dibujarIcono(){
        DisplayIconJugador icono = new DisplayIconJugador(this.iconoActualizar);
        icono.setLayoutX(0);
        icono.setLayoutY((4*altoPantalla)/5);
        this.iconoActualizar.enviarJugador(this.jugadorView1);        //Esto cuando inicializa pantalla y cuando pasa turno, agregar el Jugador jugador para getear datos
        return icono;
    }

    private DisplayBarraDatos dibujarBarraDatosJugador(){
        DisplayBarraDatos barraDatos = new DisplayBarraDatos();
        barraDatos.setLayoutX(0);
        barraDatos.setLayoutY(0);
        return barraDatos;
    }

    private DisplayBotoneraOpciones dibujarBotones(){
        DisplayBotoneraOpciones botonera = new DisplayBotoneraOpciones(this.stage,this.juego,this.iconoActualizar);
        botonera.setLayoutX((5*anchoPantalla)/6);
        botonera.setLayoutY((4*altoPantalla)/5);
        return botonera;
    }

    private void dibujarMapa(){

        View.MapaView mapaView = new View.MapaView(this.mapaModelo,anchoMapa, altoMapa,jugador1,jugador2);
        ScrollPane layout = new ScrollPane(mapaView);
        layout.setLayoutX(0);
        layout.setLayoutY(((altoPantalla)/24));
        layout.setPrefSize(anchoPantalla,(91*altoPantalla)/120);
        this.layout = layout;
        this.mapa =  mapaView;
    }

}
