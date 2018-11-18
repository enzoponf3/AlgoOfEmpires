package Modelo.Edificios;

import Modelo.Exceptions.EdificioConVidaAlMaximoException;
import Modelo.Exceptions.EdificioYaConstruidoException;
import Modelo.Unidades.Aldeano;

public class EstadoPlazaCentralConstruida implements IEstadoPlazaCentral {

    @Override
    public Aldeano crearAldeano() {
        return new Aldeano();
    }

    @Override
    public void reparar(PlazaCentral plaza) {
        plaza.aumentarVida();
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
        // Mantiene estado construida
    }
}
