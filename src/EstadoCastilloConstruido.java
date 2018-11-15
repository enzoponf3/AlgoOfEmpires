public class EstadoCastilloConstruido implements EstadoCastillo {

    @Override
    public void reparar(Castillo castillo) {
        if (castillo.vida == castillo.vidaMax)
            throw new EdificioConVidaAlMaximoException();
        castillo.enReparacion();
        if ((castillo.vida + castillo.velocidadReparacion) >= castillo.vidaMax)
            castillo.vida = castillo.vidaMax;
        else
            castillo.vida += castillo.velocidadReparacion;
    }

    @Override
    public void volverAEstadoOriginal(Castillo castillo) {
        // Estado continua siendo construido
    }
}
