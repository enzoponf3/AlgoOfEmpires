public class EstadoEspadachinOcupado implements EstadoEspadachin {
    @Override
    public void mover(Posicion destino, Espadachin espadachin){
        throw new UnidadEstaOcupadoException();
    }

    @Override
    public void atacar(Espadachin espadachin,Unidad unidad){ throw new UnidadEstaOcupadoException();}
    @Override
    public void atacar(Espadachin espadachin,Edificio edificio){ throw new UnidadEstaOcupadoException();}
}
