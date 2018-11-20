package Modelo.Unidades;
import Modelo.Posicion;
import Modelo.Edificios.Edificio;

public interface IEstadoEspadachin {

    void mover(Posicion destino, Espadachin espadachin);
    void atacar(Espadachin espadachin, Edificio edificio);
    void atacar(Espadachin espadachin, Unidad unidad);
}