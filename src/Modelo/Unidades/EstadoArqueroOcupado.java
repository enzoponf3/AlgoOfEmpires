package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;
import Modelo.Exceptions.UnidadEstaOcupadoException;

public class EstadoArqueroOcupado implements EstadoArquero {
    @Override
    public void mover(Posicion destino, Arquero arquero){
        throw new UnidadEstaOcupadoException();
    }

    public void atacar(Arquero arquero, Edificio edificio) { throw new UnidadEstaOcupadoException();}

    public void atacar(Arquero arquero, Unidad unidad){ throw new UnidadEstaOcupadoException();}
}
