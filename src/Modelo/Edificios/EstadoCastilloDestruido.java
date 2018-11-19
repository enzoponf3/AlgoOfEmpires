package Modelo.Edificios;

import Modelo.Exceptions.EdificioDestruidoException;
import Modelo.Unidades.ArmaDeAsedio;

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
    public ArmaDeAsedio crearArmaDeAsedio() {
        throw new EdificioDestruidoException();
    }
}
