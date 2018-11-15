public class EstadoArmaDeAsedioArmado implements EstadoArmaDeAsedio {

    @Override
    public void mover(Posicion destino, ArmaDeAsedio armaDeAsedio){
        throw new UnidadEstaMontadaException();
    }
    public void desocupar(ArmaDeAsedio armaDeAsedio){ }
    public void montar (ArmaDeAsedio armaAsedio){ throw new UnidadEstaMontadaException();}
    public void desmontar (ArmaDeAsedio armaAsedio){ armaAsedio.estado = new EstadoArmaDeAsedioDesarmadoOcupado();}
}
