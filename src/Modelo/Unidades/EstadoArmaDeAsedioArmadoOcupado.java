package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;
import Modelo.Exceptions.*;


public class EstadoArmaDeAsedioArmadoOcupado implements IEstadoArmaDeAsedio{

    ArmaDeAsedio armaDeAsedio;
    public EstadoArmaDeAsedioArmadoOcupado(ArmaDeAsedio arma){
        this.armaDeAsedio = arma;
    }

    @Override
    public void mover(Posicion destino){
        throw new UnidadEstaOcupadoException();
    }

    public void desocupar(){ armaDeAsedio.estado = new EstadoArmaDeAsedioArmado(armaDeAsedio); }

    public void montar(){throw new UnidadEstaOcupadoException();}
    public void desmontar (){ throw new UnidadEstaOcupadoException();}

    @Override
    public void atacar(Edificio edificio){ throw new UnidadEstaOcupadoException();}
}
