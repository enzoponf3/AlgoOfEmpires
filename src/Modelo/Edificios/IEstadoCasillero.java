package Modelo.Edificios;
import Modelo.*;
public interface IEstadoCasillero {

    void colocarObjeto(IEntidad IEntidad, Casillero casillero);

    void removerObjeto(Casillero casillero);

}
