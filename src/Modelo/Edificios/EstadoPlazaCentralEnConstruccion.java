package Modelo.Edificios;

import Modelo.Exceptions.EdificioEnConstruccionException;
import Modelo.Unidades.Aldeano;

public class EstadoPlazaCentralEnConstruccion implements IEstadoPlazaCentral {

    private int turnos;

    EstadoPlazaCentralEnConstruccion(int turnosRestantes) {
        this.turnos = turnosRestantes;
    }

    @Override
    public Aldeano crearAldeano() {
        throw new EdificioEnConstruccionException();
    }

    @Override
    public void reparar(PlazaCentral plaza) {
        throw new EdificioEnConstruccionException();
    }

    @Override
    public void construir(PlazaCentral plaza) {
        throw new EdificioEnConstruccionException();
    }

    // Cuando se llevaron a cabo los tres turnos volverAEstadoOriginal indica al
    // edificio que debe finalizar la construccion.
    @Override
    public void volverAEstadoOriginal(PlazaCentral plazaCentral) {
        if (this.turnos == 0)
            plazaCentral.finalizarConstruccion();
        else
            plazaCentral.noConstruida(this.turnos);
    }
}
