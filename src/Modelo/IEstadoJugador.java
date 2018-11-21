package Modelo;

import Modelo.Edificios.*;
import Modelo.Unidades.IUnidadMovible;

public interface IEstadoJugador {

    void mover( IUnidadMovible unidad, Posicion origen, Posicion destino, Jugador jugador );

    void crearAldeano(PlazaCentral plazaCentral, Jugador jugador);

    void crearArquero(Cuartel cuartel, Jugador jugador);

    void crearEspadachin(Cuartel cuartel, Jugador jugador);

    void crearArmaDeAsedio(Castillo castillo, Jugador jugador);


}
