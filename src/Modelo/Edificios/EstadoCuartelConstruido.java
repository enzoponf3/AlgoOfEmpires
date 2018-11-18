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
        if (cuartel.vida == cuartel.vidaMax)
            throw new EdificioConVidaAlMaximoException();
        cuartel.enReparacion();
        if ((cuartel.vida + cuartel.velocidadReparacion) >= cuartel.vidaMax)
            cuartel.vida = cuartel.vidaMax;
        else
            cuartel.vida += cuartel.velocidadReparacion;
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
