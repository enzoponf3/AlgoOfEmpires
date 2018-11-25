package Modelo.Edificios;

import Modelo.Mapa;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;

public interface IEstadoCuartel {

    Espadachin crearEspadachin(Mapa mapa, Cuartel cuartel);

    Arquero crearArquero(Mapa mapa, Cuartel cuartel);

    void reparar(Cuartel cuartel);

    void construir(Cuartel cuartel);

    void volverAEstadoOriginal(Cuartel cuartel);
}
