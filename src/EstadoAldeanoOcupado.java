
public class EstadoAldeanoOcupado implements EstadoAldeano{

    @Override
    public PlazaCentral construirPlazaCentral(Aldeano aldeano){
        throw new UnidadNoPuedeConstruirException();
    }

    @Override
    public Cuartel construirCuartel(Aldeano aldeano){
        throw new UnidadNoPuedeConstruirException();
    }

    @Override
    public void repararEdificio(Edificio edificio, Aldeano aldeano) {
        throw new UndidadNoPuedeRepararException();
    }

    @Override
    public void continuarConstruccion(Edificio edificio, Aldeano aldeano){
        throw new UnidadNoPuedeConstruirException();
    }

    @Override
    public int generaOro(){
        return 0;
    }

    @Override
    public void mover(Posicion destino, Aldeano aldeano){
        throw new UnidadEstaOcupadoException();
    }
}

