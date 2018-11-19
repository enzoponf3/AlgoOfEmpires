package Modelo.Edificios;

import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;

public interface IEstadoCuartel {

    Espadachin crearEspadachin();

    Arquero crearArquero();

    void reparar(Cuartel cuartel);

    void construir(Cuartel cuartel);

    void volverAEstadoOriginal(Cuartel cuartel);
}
