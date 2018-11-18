package Modelo.Unidades;

import Modelo.Posicion;
import Modelo.Objeto;

public interface UnidadMovil extends Objeto {

    void mover(Posicion destino);

    void cambiarPosicion(Posicion destino);
}
