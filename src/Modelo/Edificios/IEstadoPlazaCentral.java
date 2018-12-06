package Modelo.Edificios;

import Modelo.Mapa;
import Modelo.Unidades.Aldeano;

public interface IEstadoPlazaCentral {

    Aldeano crearAldeano(Mapa mapa, PlazaCentral plazaCentral);

    void reparar(PlazaCentral plaza);

    void construir(PlazaCentral plaza);

    void volverAEstadoOriginal(PlazaCentral plazaCentral);

    boolean estaDestruido();
}
