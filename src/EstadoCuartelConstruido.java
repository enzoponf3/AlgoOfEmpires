
public class EstadoCuartelConstruido implements EstadoCuartel {

    @Override
    public Espadachin crearEspadachin() {
        Espadachin espadachin = new Espadachin();
        return espadachin;
    }

    @Override
    public Arquero crearArquero() {
        Arquero arquero = new Arquero();
        return arquero;
    }

    @Override
    public void reparar(Cuartel cuartel) {
        if (cuartel.vida == cuartel.vidaMax)
            throw new EdificioConVidaAlMaximoException();
        if ((cuartel.vida + cuartel.velocidadReparacion) >= cuartel.vidaMax)
            cuartel.vida = cuartel.vidaMax;
        else
            cuartel.vida += cuartel.velocidadReparacion;
    }

    @Override
    public void construir(Cuartel cuartel) {
        throw new EdificioYaConstruidoException();
    }

    @Override
    public int getTurnosConstruccion() {
        throw new EdificioYaConstruidoException();
    }
}
