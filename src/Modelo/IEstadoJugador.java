package Modelo;

import Modelo.Unidades.IUnidadMovible;

public interface IEstadoJugador {

    void mover( IUnidadMovible unidad, Posicion origen, Posicion destino );

}
