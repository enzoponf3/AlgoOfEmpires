package Modelo.Jugador;

import Modelo.Edificios.*;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.*;
import Modelo.Unidades.IAtacante;

import java.util.ArrayList;

public interface IEstadoJugador {

    void mover(Unidad unidad, Posicion destino, Mapa mapa, Jugador jugador);

    Aldeano crearAldeano(Mapa mapa, PlazaCentral plazaCentral, Jugador jugador);

    Arquero crearArquero(Mapa mapa, Cuartel cuartel, Jugador jugador);

    Espadachin crearEspadachin(Mapa mapa, Cuartel cuartel, Jugador jugador);

    ArmaDeAsedio crearArmaDeAsedio(Mapa mapa, Castillo castillo, Jugador jugador);

    void montarArmaDeAsedio(ArmaDeAsedio armaDeAsedio, Jugador jugador);

    void desmontarArmaDeAsedio(ArmaDeAsedio armaDeAsedio, Jugador jugador);

    void atacar(Jugador jugador, IAtacante atacante, Unidad unidadAAtacar);

    void atacar(Jugador jugador, IAtacante atacante, Edificio edificioAAtacar);

    Cuartel construirCuartel(Jugador jugador, Mapa mapa, Aldeano aldeano, ArrayList<Posicion> posicionesCuartel);

    void continuarConstruccionCuartel(Jugador jugador, Mapa mapa, Aldeano aldeano, Cuartel cuartel);

    PlazaCentral construirPlazaCentral(Jugador jugador, Mapa mapa, Aldeano aldeano, ArrayList<Posicion> posicionesPlazaCentral);

    void continuarConstruccionPlazaCentral(Jugador jugador, Mapa mapa, Aldeano aldeano, PlazaCentral plazaCentral);

    void reparar(Jugador jugador, Aldeano aldeano, Edificio edificio);

    int recolectarOro(Jugador jugador);

    void cambiarTurno(Jugador jugador);
}
