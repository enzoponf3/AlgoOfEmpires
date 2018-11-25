package Modelo.Unidades;
import Modelo.Edificios.Edificio;
import Modelo.Posicion;
import Modelo.Exceptions.*;

import java.util.ArrayList;

public class EstadoArmaDeAsedioArmado implements IEstadoArmaDeAsedio {

    ArmaDeAsedio armaDeAsedio;
    public EstadoArmaDeAsedioArmado(ArmaDeAsedio arma){
       this.armaDeAsedio = arma;
    }

    @Override
    public void mover(Posicion destino){
        throw new UnidadEstaMontadaException();
    }
    public void desocupar(){}
    public void montar (){ throw new UnidadEstaMontadaException();}
    public void desmontar (){ armaDeAsedio.estado = new EstadoArmaDeAsedioDesarmadoOcupado(armaDeAsedio);}

    @Override
    public void atacar(Edificio edificio){
        ArrayList<Posicion> posiciones = edificio.getPosiciones();
        for (Posicion pos : posiciones ){
            if (armaDeAsedio.enRangoDeAtaque(pos)){
                edificio.reducirVida(armaDeAsedio.getDanioEdificio());
                armaDeAsedio.estado = new EstadoArmaDeAsedioArmadoOcupado(armaDeAsedio);
                return;
            }
        }
        throw new EntidadFueraDeRangoException();
    }
}
