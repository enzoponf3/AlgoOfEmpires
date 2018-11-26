package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;

public interface IEstadoArquero {
    void mover(Posicion destino);
    void atacar(Unidad unidad);
    void atacar(Edificio edificio);
}
