package Modelo;

import Modelo.Jugador.Jugador;
import View.Constantes;

import java.util.Random;

public class Juego {

    //Esto es para que cada jugador, al inicializarse pueda generar las posiciones de inicio
    //de su castillo y su plaza central.
    //Elegi las constantes para que queden en extremos opuestos.

    private Jugador jugador1;
    private Jugador jugador2;
    private Mapa mapa;

    public Juego() {
        this.mapa = new Mapa(Constantes.ANCHO_MAPA, Constantes.ALTO_MAPA);
        jugador1 = new Jugador( mapa, Constantes.SEED_CASTILLO_J1, Constantes.SEED_PLAZA_CENTRAL_J1);
        jugador2 = new Jugador( mapa, Constantes.SEED_CASTILLO_J2, Constantes.SEED_PLAZA_CENTRAL_J2);

        jugador1.turnoActivo();
        jugador2.turnoInactivo();
    }


    public void cambiarDeTurno() {
        jugador1.cambiarTurno();
        jugador2.cambiarTurno();

    }


    public Jugador getJugador1() {
        return this.jugador1;
    }

    public Jugador getJugador2() {
        return this.jugador2;
    }
}
