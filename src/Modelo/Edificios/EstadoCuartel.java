package Modelo.Edificios;

import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;

public interface EstadoCuartel {

    Espadachin crearEspadachin();

    Arquero crearArquero();

    void reparar(Cuartel cuartel);

    void construir(Cuartel cuartel);

    int getTurnosConstruccion();

    void volverAEstadoOriginal(Cuartel cuartel);
}
