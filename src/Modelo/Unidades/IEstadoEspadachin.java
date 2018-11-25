package Modelo.Unidades;
import Modelo.Posicion;
import Modelo.Edificios.Edificio;

public interface IEstadoEspadachin {

    void mover(Posicion destino);
    void atacar(Edificio edificio);
    void atacar(Unidad unidad);
}
