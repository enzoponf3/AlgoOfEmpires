
public class EstadoOcupado implements Estado{

    public void atacar(Unidad unidad,Unidad atacante){
        throw new UnidadEstaOcupadoException();
    }
    public void moverHaciaArriba(Unidad unidad){
        throw new UnidadEstaOcupadoException();
    }
    public void moverHaciaAbajo(Unidad unidad){
        throw new UnidadEstaOcupadoException();
    }
    public void moverHaciaIzquierda(Unidad unidad){
        throw new UnidadEstaOcupadoException();
    }
    public void moverHaciaDerecha(Unidad unidad){
        throw new UnidadEstaOcupadoException();
    }
    public void moverHaciaArribaIzquierda(Unidad unidad){
        throw new UnidadEstaOcupadoException();
    }
    public void moverHaciaArribaDerecha(Unidad unidad){
        throw new UnidadEstaOcupadoException();
    }
    public void moverHaciaAbajoIzquierda(Unidad unidad){
        throw new UnidadEstaOcupadoException();
    }
    public void moverHaciaAbajoDerecha(Unidad unidad){
        throw new UnidadEstaOcupadoException();
    }

    public PlazaCentral construirPlazaCentral(Unidad unidad){
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

    public int generaOro(){
        return 0;
    }
}

