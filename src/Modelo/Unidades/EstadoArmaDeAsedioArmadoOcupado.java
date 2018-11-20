package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;
import Modelo.Exceptions.*;


public class EstadoArmaDeAsedioArmadoOcupado implements IEstadoArmaDeAsedio{

    @Override
    public void mover(Posicion destino, ArmaDeAsedio armaDeAsedio){
        throw new UnidadEstaOcupadoException();
    }

    public void desocupar(ArmaDeAsedio armaDeAsedio){ armaDeAsedio.estado = new EstadoArmaDeAsedioArmado(); }

    public void montar(ArmaDeAsedio armaAsedio){throw new UnidadEstaOcupadoException();}
    public void desmontar (ArmaDeAsedio armaAsedio){ throw new UnidadEstaOcupadoException();}

    @Override
    public void atacar(ArmaDeAsedio armaDeAsedio, Edificio edificio){ throw new UnidadEstaOcupadoException();}
}
