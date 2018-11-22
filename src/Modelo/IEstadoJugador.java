package Modelo;

import Modelo.Edificios.*;
import Modelo.Unidades.*;
import Modelo.Unidades.IAtacante;
import Modelo.Unidades.IUnidadMovible;

import java.util.ArrayList;

public interface IEstadoJugador {

    void mover( IUnidadMovible unidad, Posicion origen, Posicion destino, Jugador jugador );

    void crearAldeano(PlazaCentral plazaCentral, Jugador jugador);

    void crearArquero(Cuartel cuartel, Jugador jugador);

    void crearEspadachin(Cuartel cuartel, Jugador jugador);

    void crearArmaDeAsedio(Castillo castillo, Jugador jugador);

    void montarArmaDeAsedio(ArmaDeAsedio armaDeAsedio);

    void desmontarArmaDeAsedio(ArmaDeAsedio armaDeAsedio);

    void atacar(IAtacante atacante, Unidad unidadAAtacar);

    void atacar(IAtacante atacante, Edificio edificioAAtacar);

    Cuartel construirCuartel(Aldeano aldeano, ArrayList<Posicion> posicionesCuartel);

    void continuarConstruccionCuartel(Aldeano aldeano, Cuartel cuartel);

    PlazaCentral construirPlazaCentral(Aldeano aldeano, ArrayList<Posicion> posicionesPlazaCentral);

    void continuarConstruccionPlazaCentral(Aldeano aldeano, PlazaCentral plazaCentral);

    void reparar(Aldeano aldeano, Edificio edificio);

    int recolectarOro(Jugador jugador);
}
