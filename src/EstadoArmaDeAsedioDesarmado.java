public class EstadoArmaDeAsedioDesarmado implements EstadoArmaDeAsedio {
    @Override
    public void mover(Posicion destino, ArmaDeAsedio armaDeAsedio){
        armaDeAsedio.cambiarPosicion(destino);
        armaDeAsedio.estado = new EstadoArmaDeAsedioMovio();
    }

    public void desocupar(ArmaDeAsedio armaDeAsedio){
        throw new UnidadYaEstaLibreException();
    }
}
