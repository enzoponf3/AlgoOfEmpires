package Modelo.Edificios;
import Modelo.*;
import Modelo.Exceptions.CasilleroDesocupadoException;

public class EstadoDesocupado implements IEstadoCasillero {

    @Override
    public void colocarObjeto(IEntidad entidad, Casillero casillero){
        casillero.setEntidad(entidad);
        casillero.ocupar();
    }

    @Override
    public void removerObjeto(Casillero casillero){
        throw new CasilleroDesocupadoException();
    }

}
