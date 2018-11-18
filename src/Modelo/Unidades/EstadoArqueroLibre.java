package Modelo.Unidades;
import Modelo.Posicion;

public class EstadoArqueroLibre implements EstadoArquero {
    //Aca van los movimientos

    @Override
    public void mover(Posicion destino, Arquero arquero){
        arquero.cambiarPosicion(destino);
        arquero.ocupar();
    }

}
