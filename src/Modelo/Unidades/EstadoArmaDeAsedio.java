package Modelo.Unidades;
import Modelo.Posicion;

public interface EstadoArmaDeAsedio {

    void mover(Posicion destino, ArmaDeAsedio armaDeAsedio);
    void desocupar(ArmaDeAsedio armaDeAsedio);
    void montar (ArmaDeAsedio armaAsedio);
    void desmontar (ArmaDeAsedio armaAsedio);
}
