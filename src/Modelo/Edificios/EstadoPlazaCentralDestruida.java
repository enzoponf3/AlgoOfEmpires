package Modelo.Edificios;

import Modelo.Exceptions.EdificioDestruidoException;
import Modelo.Unidades.Aldeano;


public class EstadoPlazaCentralDestruida implements IEstadoPlazaCentral {

    @Override
    public Aldeano crearAldeano() {
        throw new EdificioDestruidoException();
    }

    @Override
    public void reparar(PlazaCentral plaza) {
        throw new EdificioDestruidoException();
    }

    @Override
    public void construir(PlazaCentral plaza) {
        throw new EdificioDestruidoException();
    }

    @Override
    public void volverAEstadoOriginal(PlazaCentral plazaCentral) {
        throw new EdificioDestruidoException();
    }
}
