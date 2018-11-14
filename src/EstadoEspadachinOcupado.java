public class EstadoEspadachinOcupado implements EstadoEspadachin {
    //Aca van los exceptions a los movimientos

    @Override
    public void mover(Posicion destino, Espadachin espadachin){
        throw new UnidadEstaOcupadoException();
    }

}
