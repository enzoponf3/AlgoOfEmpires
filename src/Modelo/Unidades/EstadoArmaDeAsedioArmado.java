package Modelo.Unidades;
import Modelo.Posicion;
import Modelo.Exceptions.*;

public class EstadoArmaDeAsedioArmado extends EstadoAtacante implements IEstadoArmaDeAsedio {


    public EstadoArmaDeAsedioArmado(ArmaDeAsedio arma){
       super(arma);
    }

    @Override
    public void mover(Posicion destino){
        throw new UnidadEstaMontadaException();
    }
    public IEstadoArmaDeAsedio desocupar(ArmaDeAsedio arma){ return new EstadoArmaDeAsedioArmado(arma);}
    public IEstadoArmaDeAsedio montar (ArmaDeAsedio arma){ throw new UnidadEstaMontadaException();}
    public IEstadoArmaDeAsedio desmontar (ArmaDeAsedio arma){ return new EstadoArmaDeAsedioDesarmadoOcupado(arma);}
    public IEstadoArmaDeAsedio ocupar(ArmaDeAsedio arma){ return new EstadoArmaDeAsedioArmadoOcupado(arma);}
}
