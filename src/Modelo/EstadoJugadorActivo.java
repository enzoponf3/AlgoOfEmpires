package Modelo;

import Modelo.Unidades.IUnidadMovible;

public class EstadoJugadorActivo implements IEstadoJugador {

    @Override
    public void mover( IUnidadMovible unidad, Posicion origen, Posicion destino ){
        unidad.mover(destino);
    }


}
