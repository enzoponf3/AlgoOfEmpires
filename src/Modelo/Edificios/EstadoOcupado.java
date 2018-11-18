package Modelo.Edificios;
import Modelo.*;
import Modelo.Exceptions.CasilleroOcupadoException;

public class EstadoOcupado implements IEstadoCasillero {

    @Override
    public void colocarObjeto(IEntidad IEntidad, Casillero casillero){
        throw new CasilleroOcupadoException();
    }

    @Override
    public void removerObjeto(Casillero casillero){
        //¿como borro la instancia?
        casillero.setEntidad(null);
        casillero.desocupar();
    }

}
