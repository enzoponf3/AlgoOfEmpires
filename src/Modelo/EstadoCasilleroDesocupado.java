package Modelo;
import Modelo.*;
import Modelo.Exceptions.CasilleroDesocupadoException;

public class EstadoCasilleroDesocupado implements IEstadoCasillero {

    @Override
    public void colocarObjeto(IEntidad entidad, Casillero casillero){
        casillero.setEntidad(entidad);
        casillero.ocupar();
    }

    @Override
    public void removerObjeto(Casillero casillero){
        throw new CasilleroDesocupadoException();
    }

    @Override
    public void obtenerObjeto() {
        throw new CasilleroDesocupadoException();
    }

}
