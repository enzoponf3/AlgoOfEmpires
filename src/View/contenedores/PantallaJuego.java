package View.contenedores;


import Modelo.Juego;
import View.JugadorView;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;

import javafx.stage.Screen;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.stage.Stage;

import javax.swing.text.html.ImageView;


public class PantallaJuego extends Pane {

    private DisplayBarraDatos barraDatos;
    private Stage stage;
    private Log log;
    private DisplayLog displayLog;
    private double altoPantalla;
    private double anchoPantalla;
    private JugadorView jugador1;
    private JugadorView jugador2;
    private DisplayIconJugador icono;
    private ActualizarView iconoActualizar;
    private DisplayBotoneraOpciones botonera;
    private Juego juego;

    public  PantallaJuego( Stage stage,JugadorView j1, JugadorView j2){
        this.juego = new Juego();
        this.stage = stage;
        Rectangle2D limitesPantalla = Screen.getPrimary().getVisualBounds();
        this.altoPantalla = limitesPantalla.getHeight();
        this.anchoPantalla = limitesPantalla.getWidth();
        this.setPrefWidth(anchoPantalla);
        this.setPrefHeight(altoPantalla);

        this.jugador1 = j1;
        this.jugador2 = j2;
        this.log = new Log();
        this.displayLog = dibujarLog();
        this.iconoActualizar = new ActualizarView();
        this.icono = dibujarIcono();
        this.botonera = dibujarBotones();
        this.barraDatos = dibujarBarraDatosJugador();



        this.getChildren().addAll(this.icono,this.displayLog,this.botonera,this.barraDatos);

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
        this.iconoActualizar.enviarJugador(this.jugador1);        //Esto cuando inicializa pantalla y cuando pasa turno, agregar el Jugador jugador para getear datos
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
}
