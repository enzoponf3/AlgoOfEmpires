package Modelo.Edificios;

import Modelo.Unidades.ArmaDeAsedio;

public interface IEstadoCastillo {

    void reparar(Castillo castillo);

    void volverAEstadoOriginal(Castillo castillo);

    ArmaDeAsedio crearArmaDeAsedio();
}
