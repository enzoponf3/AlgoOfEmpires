package Modelo;

import Modelo.*;

import java.util.ArrayList;
import java.util.Random;

public class Juego {

    private static final int SEED_CASTILLO_J1 = 5;
    private static final int SEED_PLAZA_CENTRAL_J1 = 14;
    private static final int SEED_CASTILLO_J2 = 41;
    private static final int SEED_PLAZA_CENTRAL_J2 = 35;
    //Esto es para que cada jugador, al inicializarse pueda generar las posiciones de inicio
    //de su castillo y su plaza central.
    //Elegi las constantes para que queden en extremos opuestos.

    private Jugador jugador1;
    private Jugador jugador2;

    public void inicializar() {

        jugador1 = new Jugador( SEED_CASTILLO_J1, SEED_PLAZA_CENTRAL_J1 );
        jugador2 = new Jugador( SEED_CASTILLO_J2, SEED_PLAZA_CENTRAL_J2 );
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
