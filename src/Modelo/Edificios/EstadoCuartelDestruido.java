package Modelo.Edificios;

import Modelo.Exceptions.EdificioDestruidoException;
import Modelo.Mapa;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;

public class EstadoCuartelDestruido implements IEstadoCuartel {

    @Override
    public Espadachin crearEspadachin(Mapa mapa, Cuartel cuartel) {
        throw new EdificioDestruidoException();
    }

    @Override
    public Arquero crearArquero(Mapa mapa, Cuartel cuartel) {
        throw new EdificioDestruidoException();
    }

    @Override
    public void reparar(Cuartel cuartel) {
        throw new EdificioDestruidoException();
    }

    @Override
    public void construir(Cuartel cuartel) {
        throw new EdificioDestruidoException();
    }

    // El metodo me informa que el edificio fue destruido
    @Override
    public void volverAEstadoOriginal(Cuartel cuartel) {
        throw new EdificioDestruidoException();
    }

}
