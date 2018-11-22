package Modelo.Unidades;

import Modelo.Edificios.Edificio;
import Modelo.Posicion;

public interface IAtacante {

    void atacar(Unidad unidad);

    void atacar(Edificio edificio);

    void reducirVida(int danio);

    int getVida();
}
