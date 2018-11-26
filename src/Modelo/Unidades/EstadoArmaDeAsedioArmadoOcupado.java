package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;
import Modelo.Exceptions.*;


public class EstadoArmaDeAsedioArmadoOcupado extends EstadoAtacante implements IEstadoArmaDeAsedio{

    public EstadoArmaDeAsedioArmadoOcupado(ArmaDeAsedio arma){
        super(arma);
    }
    public IEstadoArmaDeAsedio ocupar(ArmaDeAsedio arma){
        throw new UnidadEstaOcupadoException();
    }

    @Override
    public void mover(Posicion destino){
        throw new UnidadEstaOcupadoException();
    }

    public IEstadoArmaDeAsedio desocupar(ArmaDeAsedio arma){ return new EstadoArmaDeAsedioArmado(arma); }


    public IEstadoArmaDeAsedio montar(ArmaDeAsedio arma){throw new UnidadEstaOcupadoException();}
    public IEstadoArmaDeAsedio desmontar (ArmaDeAsedio arma){ throw new UnidadEstaOcupadoException();}

    @Override
    public void atacar(Edificio edificio){ throw new UnidadEstaOcupadoException();}

}
