package Modelo.Unidades;

import Modelo.IEntidad;
import Modelo.Posicion;

public interface IUnidadMovible extends IEntidad {

    void mover(Posicion destino);

    void cambiarPosicion(Posicion destino);

    void verificarPosicionAledania(Posicion destino);
}
