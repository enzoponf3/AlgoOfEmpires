package Modelo.Edificios;

import Modelo.Exceptions.EdificioEnReparacionException;

public class EstadoCastilloEnReparacion implements EstadoCastillo {


    @Override
    public void reparar(Castillo castillo) {
        throw new EdificioEnReparacionException();
    }

    @Override
    public void volverAEstadoOriginal(Castillo castillo) {
        castillo.construido();
    }
}
