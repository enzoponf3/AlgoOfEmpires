package Modelo.Edificios;

import Modelo.Unidades.Aldeano;

public interface IEstadoPlazaCentral {

    Aldeano crearAldeano();

    void reparar(PlazaCentral plaza);

    void construir(PlazaCentral plaza);

    void volverAEstadoOriginal(PlazaCentral plazaCentral);
}
