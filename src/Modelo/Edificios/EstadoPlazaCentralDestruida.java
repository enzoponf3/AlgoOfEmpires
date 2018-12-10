package Modelo.Edificios;

import Modelo.Exceptions.EdificioDestruidoException;
import Modelo.Mapa;
import Modelo.Unidades.Aldeano;


public class EstadoPlazaCentralDestruida implements IEstadoPlazaCentral {

    @Override
    public Aldeano crearAldeano(Mapa mapa, PlazaCentral plazaCentral) {
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

    @Override
    public boolean estaDestruido() {
        return true;
    }

    @Override
    public int turnosRestantes() {
        return 0;
    }
}
