package Modelo;

import Modelo.Exceptions.TurnoDelOponenteException;
import Modelo.Unidades.IUnidadMovible;

public class EstadoJugadorInactivo implements IEstadoJugador {


    @Override
    public void mover(IUnidadMovible unidad, Posicion origen, Posicion destino){
        throw new TurnoDelOponenteException();
    }

}
