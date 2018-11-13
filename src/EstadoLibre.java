
public class EstadoLibre implements Estado{
    private boolean LIBRE = true;

    public void moverHaciaArriba(Unidad unidad){
        unidad.moverHaciaArriba();
    }
    public void moverHaciaAbajo(){}
    public void moverHaciaIzquierda(){}
    public void moverHaciaDerecha(){}
    public void moverHaciaArribaIzquierda(){}
    public void moverHaciaArribaDerecha(){}
    public void moverHaciaAbajoIzquierda(){}
    public void moverHaciaAbajoDerecha(){}


    @Override
    public void atacar(Unidad unidad,Unidad atacante) {
        throw new ElAldeanoNoPuedeAtacarException();
    }

    @Override
    public boolean estaOcupado(){
        return false;
    }

    public int generaOro(){
        return 20;
    }

    public boolean comprobarEstado(){
        return LIBRE;
    }

}

