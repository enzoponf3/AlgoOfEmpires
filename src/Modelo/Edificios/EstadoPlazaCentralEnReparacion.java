package Modelo.Edificios;

import Modelo.Exceptions.EdificioEnReparacionException;
import Modelo.Exceptions.EdificioYaConstruidoException;
import Modelo.Unidades.Aldeano;

public class EstadoPlazaCentralEnReparacion implements EstadoPlazaCentral {

    @Override
    public Aldeano crearAldeano() {
        Aldeano aldeano = new Aldeano();
        return aldeano;
    }

    @Override
    public void reparar(PlazaCentral plaza) {
        throw new EdificioEnReparacionException();
    }

    @Override
    public void construir(PlazaCentral plaza) {
        throw new EdificioYaConstruidoException();
    }

    @Override
    public int getTurnosConstruccion() {
        throw new EdificioYaConstruidoException();
    }

    @Override
    public void volverAEstadoOriginal(PlazaCentral plazaCentral) {
        plazaCentral.construida();
    }
}
