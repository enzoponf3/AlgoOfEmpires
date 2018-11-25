package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;

public interface IEstadoArmaDeAsedio {
    void mover(Posicion destino);
    void desocupar();
    void montar ();
    void desmontar ();
    void atacar(Edificio edificio);
}
