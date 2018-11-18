package Modelo;
import Modelo.*;
import Modelo.Exceptions.CasilleroOcupadoException;

public class EstadoCasilleroOcupado implements IEstadoCasillero {

    @Override
    public void colocarObjeto(IEntidad IEntidad, Casillero casillero){
        throw new CasilleroOcupadoException();
    }

    @Override
    public void removerObjeto(Casillero casillero){
        casillero.setEntidad(null);
        casillero.desocupar();
    }

}
