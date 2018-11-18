package Modelo.Edificios;

import Modelo.Exceptions.EdificioConVidaAlMaximoException;
import Modelo.Exceptions.EdificioYaConstruidoException;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;

public class EstadoCuartelConstruido implements IEstadoCuartel {

    @Override
    public Espadachin crearEspadachin() {
        return new Espadachin();
    }

    @Override
    public Arquero crearArquero() {
        return new Arquero();
    }

    @Override
    public void reparar(Cuartel cuartel) {
        cuartel.aumentarVida();
    }

    @Override
    public void construir(Cuartel cuartel) {
        throw new EdificioYaConstruidoException();
    }

    @Override
    public int getTurnosConstruccion() {
        throw new EdificioYaConstruidoException();
    }

    @Override
    public void volverAEstadoOriginal(Cuartel cuartel) {
        // Matiene estado construido
    }
}
