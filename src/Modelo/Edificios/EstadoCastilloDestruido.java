package Modelo.Edificios;

import Modelo.Exceptions.EdificioDestruidoException;
import Modelo.Mapa;
import Modelo.Unidades.ArmaDeAsedio;
import jdk.nashorn.internal.ir.CatchNode;

public class EstadoCastilloDestruido implements IEstadoCastillo {

    @Override
    public void reparar(Castillo castillo) {
        throw new EdificioDestruidoException();
    }

    @Override
    public void volverAEstadoOriginal(Castillo castillo) {
        throw new EdificioDestruidoException();
    }

    @Override
    public ArmaDeAsedio crearArmaDeAsedio(Mapa mapa, Castillo castillo) {
        throw new EdificioDestruidoException();
    }

    @Override
    public boolean estaDestruido() {
        return true;
    }
}
