public class EstadoArqueroOcupado implements EstadoArquero {
    //Aca van los movimientos

    @Override
    public void mover(Posicion destino, Arquero arquero){
        throw new UnidadEstaOcupadoException();
    }


}
