public class EstadoEspadachinLibre implements EstadoEspadachin {
    @Override
    public void mover(Posicion destino, Espadachin espadachin){
        espadachin.cambiarPosicion(destino);
        espadachin.ocupar();
    }

    @Override
    public void atacar(Espadachin espadachin,Unidad unidad){
        espadachin.estaEnRango(unidad.getPosicion());
        unidad.reducirVida(espadachin.getDanioUnidad());
        espadachin.ocupar();
    }
    @Override
    public void atacar(Espadachin espadachin,Edificio edificio){
        edificio.reducirVida(espadachin.getDanioEdificio());
        espadachin.ocupar();
    }
}
