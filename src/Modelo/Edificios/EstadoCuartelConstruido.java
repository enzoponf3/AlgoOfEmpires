package Modelo.Edificios;

import Modelo.Exceptions.EdificioConVidaAlMaximoException;
import Modelo.Exceptions.EdificioYaConstruidoException;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;

public class EstadoCuartelConstruido implements IEstadoCuartel {

    @Override
    public Espadachin crearEspadachin(Mapa mapa, Cuartel cuartel) {
        Posicion posicionEspadachin = mapa.devolverPosicionAledaniaLibre(cuartel);
        Espadachin espadachin = new Espadachin(posicionEspadachin);
        return espadachin;
    }

    @Override
    public Arquero crearArquero(Mapa mapa, Cuartel cuartel) {
        Posicion posicionArquero = mapa.devolverPosicionAledaniaLibre(cuartel);
        Arquero arquero = new Arquero(posicionArquero);
        return arquero;
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
    public void volverAEstadoOriginal(Cuartel cuartel) {
        // Matiene estado construido
    }

    @Override
    public boolean estaDestruido() {
        return false;
    }
}
