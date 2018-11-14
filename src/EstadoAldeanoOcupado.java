
public class EstadoAldeanoOcupado implements EstadoAldeano{

    /*public PlazaCentral construirPlazaCentral(Unidad unidad){
        throw new UnidadNoPuedeConstruirException();
    }

    public Cuartel construirCuartel(Unidad unidad){
        throw new UnidadNoPuedeConstruirException();
    }

    public void repararEdificio(Edificio edificio,Unidad unidad) {
        throw new UndidadNoPuedeRepararException();
    }

    public void continuarConstruccion(Edificio edificio,Unidad unidad){
        throw new UnidadNoPuedeConstruirException();
    }
*/
    public int generaOro(){
        return 0;
    }

    @Override
    public void mover(Movimiento movimiento, Posicion posicion, Aldeano aldeano){
        throw new UnidadEstaOcupadoException();
    }
}

