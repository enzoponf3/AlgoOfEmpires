package View.contenedores;


import View.JugadorView;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;

import javafx.stage.Screen;
import javafx.scene.layout.*;
import javafx.geometry.Insets;

import javax.swing.text.html.ImageView;


public class PantallaJuego extends Pane {

    private Log log;
    private DisplayLog displayLog;
    private double altoPantalla;
    private double anchoPantalla;
    private JugadorView jugador1;
    private JugadorView jugador2;
    private DisplayIconJugador icono;
    private ActualizarView iconoActualizar;

    public  PantallaJuego(JugadorView j1, JugadorView j2){
        Rectangle2D limitesPantalla = Screen.getPrimary().getVisualBounds();
        this.altoPantalla = limitesPantalla.getHeight();
        this.anchoPantalla = limitesPantalla.getWidth();
        this.setPrefWidth(anchoPantalla);
        this.setPrefHeight(altoPantalla);

        this.jugador1 = j1;
        this.jugador2 = j2;
        this.log = new Log();
        this.iconoActualizar = new ActualizarView();
        this.displayLog = dibujarLog();
        this.icono = dibujarIcono();



        this.getChildren().addAll(displayLog,icono);

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

    //private dibujarBarraDatosJugador(){}
}
