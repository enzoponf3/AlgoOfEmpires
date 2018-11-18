package Modelo.Unidades;
import Modelo.Posicion;
import Modelo.Edificios.Edificio;

import java.util.ArrayList;

public class EstadoEspadachinLibre implements EstadoEspadachin {
    @Override
    public void mover(Posicion destino, Espadachin espadachin){
        espadachin.cambiarPosicion(destino);
        espadachin.ocupar();
    }

    @Override
    public void atacar(Espadachin espadachin, Unidad unidad){
        espadachin.estaEnRango(unidad.getPosicion());
        unidad.reducirVida(espadachin.getDanioUnidad());
        espadachin.ocupar();
    }
    @Override
    public void atacar(Espadachin espadachin, Edificio edificio){
        ArrayList<Posicion> posiciones = edificio.getPosiciones();
        for (Posicion pos : posiciones ){
            espadachin.estaEnRango(pos);
        }
        edificio.reducirVida(espadachin.getDanioEdificio());
        espadachin.ocupar();
    }
}
