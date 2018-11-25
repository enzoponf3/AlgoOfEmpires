package Modelo.Edificios;

import Modelo.Exceptions.EdificioNoConstruidoException;
import Modelo.Mapa;
import Modelo.Unidades.Aldeano;

public class EstadoPlazaCentralNoConstruida implements IEstadoPlazaCentral {

    private int turnos;

    EstadoPlazaCentralNoConstruida(int turnosRestantes) {
        this.turnos = turnosRestantes;
    }

    @Override
    public Aldeano crearAldeano(Mapa mapa, PlazaCentral plazaCentral) {
        throw new EdificioNoConstruidoException();
    }

    @Override
    public void reparar(PlazaCentral plaza) {
        throw new EdificioNoConstruidoException();

    }

    @Override
    public void construir(PlazaCentral plaza) {
        this.turnos -=1;
        plaza.enConstruccion(this.turnos);
    }

    @Override
    public void volverAEstadoOriginal(PlazaCentral plazaCentral) {
//        Matiene estado no construido
    }
}
