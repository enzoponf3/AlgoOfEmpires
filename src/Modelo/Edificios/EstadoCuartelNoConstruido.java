package Modelo.Edificios;

import Modelo.Exceptions.EdificioNoConstruidoException;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;

public class EstadoCuartelNoConstruido implements IEstadoCuartel {

    private int turnos;

    EstadoCuartelNoConstruido(int turnosRestantes) {
        this.turnos = turnosRestantes;
    }

    @Override
    public Espadachin crearEspadachin() {
        throw new EdificioNoConstruidoException();
    }

    @Override
    public Arquero crearArquero() {
        throw new EdificioNoConstruidoException();
    }

    @Override
    public void reparar(Cuartel cuartel) {
        throw new EdificioNoConstruidoException();
    }

    @Override
    public void construir(Cuartel cuartel) {
        this.turnos -=1;
        cuartel.enConstruccion(this.turnos);
    }

    @Override
    public void volverAEstadoOriginal(Cuartel cuartel) {
//        Matiene estado no construido
    }
}
