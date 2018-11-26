package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;
import Modelo.Exceptions.*;

public class EstadoArmaDeAsedioDesarmadoOcupado implements IEstadoArmaDeAsedio {
    
    ArmaDeAsedio armaDeAsedio;
    public EstadoArmaDeAsedioDesarmadoOcupado(ArmaDeAsedio arma){
        this.armaDeAsedio = arma;
    }
    
    @Override
    public void mover(Posicion destino){
        throw new UnidadEstaOcupadoException();
    }
    public void montar(){throw new UnidadEstaOcupadoException();}
    public void desocupar(){armaDeAsedio.estado = new EstadoArmaDeAsedioDesarmado(armaDeAsedio);}
    public void desmontar (){ throw new UnidadEstaOcupadoException();}

    @Override
    public void atacar (Edificio edificio){ throw new UnidadDesarmadaException();}
}
