package Modelo.Edificios;
import Modelo.*;
public interface EstadoCasillero {

    boolean estaOcupado();

    void colocarObjeto(Objeto objeto, Casillero casillero);

    void removerObjeto(Casillero casillero);

}
