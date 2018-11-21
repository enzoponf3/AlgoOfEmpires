package Modelo;

import Modelo.*;
import java.util.Random;

public class Juego {

    private Jugador jugador1;
    private Jugador jugador2;

    public void inicializar() {
        jugador1 = new Jugador();
        jugador2 = new Jugador();
        int turnoInicial = new Random().nextInt(2);
        if (turnoInicial == 0) {
//            jugador1.turnoActivo();
//            jugador2.turnoInactivo();
        }
        else {
//            jugador1.turnoInactivo();
//            jugador2.turnoActivo();
        }
    }

    public void cambiarDeTurno() {
//        jugador1.cambiarTurno();
//        jugador2.cambiarTurno();
    }

}
