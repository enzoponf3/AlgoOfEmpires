package Modelo.Unidades;

import Modelo.Edificios.Edificio;
import Modelo.Exceptions.EntidadFueraDeRangoException;
import Modelo.Posicion;

public abstract class EstadoAtacante implements IEstadoAtacante{

    IAtacante atacante;
    public EstadoAtacante(IAtacante atacante){
        this.atacante = atacante;
    }

    @Override
    public void atacar(Unidad unidad){
        if (!atacante.enRangoDeAtaque(unidad.getPosicion())) {
            throw new EntidadFueraDeRangoException();
        }
        unidad.reducirVida(atacante.getDanioUnidad());
        atacante.ocupar();
    }

    @Override
    public void atacar(Edificio edificio){
        if(!atacante.enRangoDeAtaque(edificio.getPosiciones()))
            throw new EntidadFueraDeRangoException();

        edificio.reducirVida(atacante.getDanioEdificio());
        atacante.ocupar();
    }

    @Override
    public void mover(Posicion destino){
        atacante.cambiarPosicion(destino);
        atacante.ocupar();
    }

}
