package Modelo.Edificios;

import Modelo.Mapa;
import Modelo.Unidades.ArmaDeAsedio;

public interface IEstadoCastillo {

    void reparar(Castillo castillo);

    void volverAEstadoOriginal(Castillo castillo);

    ArmaDeAsedio crearArmaDeAsedio(Mapa mapa, Castillo castillo);
}
