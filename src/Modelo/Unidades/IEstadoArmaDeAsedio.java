package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;

public interface IEstadoArmaDeAsedio {
    void mover(Posicion destino);
    IEstadoArmaDeAsedio desocupar(ArmaDeAsedio arma);
    IEstadoArmaDeAsedio montar (ArmaDeAsedio arma);
    IEstadoArmaDeAsedio desmontar (ArmaDeAsedio arma);
    void atacar(Edificio edificio);
    IEstadoArmaDeAsedio ocupar(ArmaDeAsedio arma);
}
