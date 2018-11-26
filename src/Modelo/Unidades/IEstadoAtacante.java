package Modelo.Unidades;

import Modelo.Edificios.Edificio;
import Modelo.Posicion;

public interface IEstadoAtacante {
    void atacar(Edificio edificio);
    void atacar(Unidad unidad);
    void mover(Posicion destino);
}
