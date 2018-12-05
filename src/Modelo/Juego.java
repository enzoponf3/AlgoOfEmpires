package Modelo;

import Modelo.Jugador.Jugador;

public class Juego {

    //Esto es para que cada jugador, al inicializarse pueda generar las posiciones de inicio
    //de su castillo y su plaza central.
    //Elegi las constantes para que queden en extremos opuestos.

    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador ganador;
    private Mapa mapa;

    public Juego() {
        this.mapa = new Mapa(Constantes.ANCHO_MAPA, Constantes.ALTO_MAPA);
        jugador1 = new Jugador( mapa, Constantes.SEED_CASTILLO_J1, Constantes.SEED_PLAZA_CENTRAL_J1);
        jugador2 = new Jugador( mapa, Constantes.SEED_CASTILLO_J2, Constantes.SEED_PLAZA_CENTRAL_J2);
        ganador = null;
        jugador1.turnoActivo();
        jugador2.turnoInactivo();
        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);
    }


    public void cambiarDeTurno() {
        jugador1.cambiarTurno();
        jugador1.recolectarOro();
        jugador2.cambiarTurno();
        jugador2.recolectarOro();

    }


    public Jugador getJugador1() {
        return this.jugador1;
    }

    public Jugador getJugador2() {
        return this.jugador2;
    }

    public void finalizarJuego(Jugador jugadorGanador) {
        ganador = jugadorGanador;
    }

    public boolean esGanador(Jugador jugador) {
        return jugador.getOponente().derrotado();
    }

    public Jugador getGanador() {
        return this.ganador;
    }
}
