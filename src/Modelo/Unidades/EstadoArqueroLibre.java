package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Exceptions.EntidadFueraDeRangoException;
import Modelo.Posicion;

import java.util.ArrayList;

public class EstadoArqueroLibre implements EstadoArquero {
    @Override
    public void mover(Posicion destino, Arquero arquero){
        arquero.cambiarPosicion(destino);
        arquero.ocupar();
    }

    @Override
    public void atacar(Arquero arquero, Unidad unidad){
        if (!arquero.posicion.estaEnRango(unidad.getPosicion(), arquero.getRango())) {
            throw new EntidadFueraDeRangoException();
        }
        unidad.reducirVida(arquero.getDanioUnidad());
        arquero.ocupar();
    }
    @Override
    public void atacar(Arquero arquero, Edificio edificio){
        ArrayList<Posicion> posiciones = edificio.getPosiciones();
        for (Posicion pos : posiciones ){
            if (arquero.posicion.estaEnRango(pos, arquero.getRango())){
                edificio.reducirVida(arquero.getDanioEdificio());
                arquero.ocupar();
                return;
            }
        }
        throw new EntidadFueraDeRangoException();
    }
}
