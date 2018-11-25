package Modelo.Edificios;

import Modelo.Exceptions.EdificioEnReparacionException;
import Modelo.Exceptions.EdificioYaConstruidoException;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;

public class EstadoPlazaCentralEnReparacion implements IEstadoPlazaCentral {

    @Override
    public Aldeano crearAldeano(Mapa mapa, PlazaCentral plazaCentral) {
        Posicion posicionAldeano = mapa.devolverPosicionAledaniaLibre(plazaCentral);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        mapa.ocuparCasillero(posicionAldeano,aldeano);

        return aldeano;
    }

    @Override
    public void reparar(PlazaCentral plaza) {
        throw new EdificioEnReparacionException();
    }

    @Override
    public void construir(PlazaCentral plaza) {
        throw new EdificioYaConstruidoException();
    }

    @Override
    public void volverAEstadoOriginal(PlazaCentral plazaCentral) {
        plazaCentral.construida();
    }
}
