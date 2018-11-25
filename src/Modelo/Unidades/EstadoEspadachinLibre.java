package Modelo.Unidades;
import Modelo.Exceptions.EntidadFueraDeRangoException;
import Modelo.Posicion;
import Modelo.Edificios.Edificio;

import java.util.ArrayList;

public class EstadoEspadachinLibre implements IEstadoEspadachin {

    Espadachin espadachin;
    public EstadoEspadachinLibre(Espadachin espadachin){
        this.espadachin = espadachin;
    }
    @Override
    public void mover(Posicion destino){
        espadachin.cambiarPosicion(destino);
        espadachin.ocupar();
    }

    @Override
    public void atacar(Unidad unidad){
        if (!espadachin.enRangoDeAtaque(unidad.getPosicion())) {
           throw new EntidadFueraDeRangoException();
        }
        unidad.reducirVida(espadachin.getDanioUnidad());
        espadachin.ocupar();
    }
    @Override
    public void atacar(Edificio edificio){
        ArrayList<Posicion> posiciones = edificio.getPosiciones();
        for (Posicion pos : posiciones ){
            if (espadachin.enRangoDeAtaque(pos)){
                edificio.reducirVida(espadachin.getDanioEdificio());
                espadachin.ocupar();
                return;
            }
        }
        throw new EntidadFueraDeRangoException();
    }
}
