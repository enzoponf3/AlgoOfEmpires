public class EstadoArmaDeAsedioArmado implements EstadoArmaDeAsedio {

    @Override
    public void mover(Posicion destino, ArmaDeAsedio armaDeAsedio){
        throw new UnidadEstaMontadaException();
    }

    public void desocupar(ArmaDeAsedio armaDeAsedio){
        throw new UnidadYaEstaLibreException();
    }
}
