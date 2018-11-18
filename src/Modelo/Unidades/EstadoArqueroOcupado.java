package Modelo.Unidades;
import Modelo.Posicion;
import Modelo.Exceptions.UnidadEstaOcupadoException;

public class EstadoArqueroOcupado implements EstadoArquero {
    //Aca van los movimientos

    @Override
    public void mover(Posicion destino, Arquero arquero){
        throw new UnidadEstaOcupadoException();
    }


}
