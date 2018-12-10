package Modelo.Edificios;

import Modelo.Exceptions.EdificioEnConstruccionException;
import Modelo.Mapa;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;

import java.util.Map;

public class EstadoCuartelEnConstruccion implements IEstadoCuartel {

    private int turnos;

    EstadoCuartelEnConstruccion(int turnosRestantes) {
        this.turnos = turnosRestantes;
    }

    @Override
    public Espadachin crearEspadachin(Mapa mapa, Cuartel cuartel) {
        throw new EdificioEnConstruccionException();
    }

    @Override
    public Arquero crearArquero(Mapa mapa, Cuartel cuartel) {
        throw new EdificioEnConstruccionException();
    }

    @Override
    public void reparar(Cuartel cuartel) {
        throw new EdificioEnConstruccionException();
    }

    @Override
    public void construir(Cuartel cuartel) {
        throw new EdificioEnConstruccionException();
    }

    // Cuando se llevaron a cabo los tres turnos volverAEstadoOriginal indica al
    // edificio que debe finalizar la construccion.
    @Override
    public void volverAEstadoOriginal(Cuartel cuartel) {
        if (this.turnos == 0)
            cuartel.finalizarConstruccion();
        else
            cuartel.noConstruido(this.turnos);
    }

    @Override
    public boolean estaDestruido() {
        return false;
    }

    @Override
    public int turnosRestantes() {
        return this.turnos;
    }
}
