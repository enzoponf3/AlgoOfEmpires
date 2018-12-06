package Modelo.Edificios;

import Modelo.Exceptions.EdificioConVidaAlMaximoException;
import Modelo.Exceptions.EdificioYaConstruidoException;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;

public class EstadoPlazaCentralConstruida implements IEstadoPlazaCentral {

    @Override
    public Aldeano crearAldeano(Mapa mapa, PlazaCentral plazaCentral) {
        Posicion posicionAldeano = mapa.devolverPosicionAledaniaLibre(plazaCentral);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        return aldeano;
    }

    @Override
    public void reparar(PlazaCentral plaza) {
        plaza.aumentarVida();
    }

    @Override
    public void construir(PlazaCentral plaza) {
        throw new EdificioYaConstruidoException();
    }

    @Override
    public void volverAEstadoOriginal(PlazaCentral plazaCentral) {
        // Mantiene estado construida
    }

    @Override
    public boolean estaDestruido() {
        return false;
    }
}
