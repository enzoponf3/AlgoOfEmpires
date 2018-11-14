public class EstadoEspadachinLibre implements EstadoEspadachin {
    //Aca van los movimientos

    @Override
    public void mover(Posicion destino, Espadachin espadachin){
        espadachin.cambiarPosicion(destino);
        espadachin.ocupar();
    }

}
