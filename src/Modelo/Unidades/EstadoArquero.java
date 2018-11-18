package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;

public interface EstadoArquero {
    void mover(Posicion destino, Arquero arquero);
    void atacar(Arquero arquero, Unidad unidad);
    void atacar(Arquero arquero, Edificio edificio);

}
