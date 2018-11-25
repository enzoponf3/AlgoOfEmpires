package Modelo.Edificios;

import Modelo.Exceptions.EdificioEnReparacionException;
import Modelo.Exceptions.EdificioYaConstruidoException;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;

public class EstadoCuartelEnReparacion implements IEstadoCuartel {

    @Override
    public Espadachin crearEspadachin(Mapa mapa, Cuartel cuartel) {
        Posicion posicionEspadachin = mapa.devolverPosicionAledaniaLibre(cuartel);
        Espadachin espadachin = new Espadachin(posicionEspadachin);
        mapa.ocuparCasillero(posicionEspadachin,espadachin);

        return espadachin;
    }

    @Override
    public Arquero crearArquero(Mapa mapa, Cuartel cuartel) {
        Posicion posicionArquero = mapa.devolverPosicionAledaniaLibre(cuartel);
        Arquero arquero = new Arquero(posicionArquero);
        mapa.ocuparCasillero(posicionArquero,arquero);

        return arquero;
    }

    @Override
    public void reparar(Cuartel cuartel) {
        throw new EdificioEnReparacionException();
    }

    @Override
    public void construir(Cuartel cuartel) {
        throw new EdificioYaConstruidoException();
    }

    @Override
    public void volverAEstadoOriginal(Cuartel cuartel) {
        cuartel.construido();
    }
}
