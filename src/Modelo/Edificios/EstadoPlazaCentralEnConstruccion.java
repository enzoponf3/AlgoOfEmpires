package Modelo.Edificios;

import Modelo.Exceptions.EdificioEnConstruccionException;
import Modelo.Unidades.Aldeano;

public class EstadoPlazaCentralEnConstruccion implements IEstadoPlazaCentral {

    private static final int TURNOS = 3;

    private int turnos;

    public EstadoPlazaCentralEnConstruccion() {
        this.turnos = TURNOS;
    }

    @Override
    public Aldeano crearAldeano() {
        if (this.turnos > 0)
            throw new EdificioEnConstruccionException();
        return null;
    }

    @Override
    public void reparar(PlazaCentral plaza) {
        if (this.turnos > 0)
            throw new EdificioEnConstruccionException();
    }

    @Override
    public void construir(PlazaCentral plaza) {
        this.turnos -=1;
        if (this.turnos == 0)
            plaza.finalizarConstruccion();
    }

    @Override
    public int getTurnosConstruccion() {
        return this.turnos;
    }

    @Override
    public void volverAEstadoOriginal(PlazaCentral plazaCentral) {
        // Mantiene estado en construccion
    }
}
