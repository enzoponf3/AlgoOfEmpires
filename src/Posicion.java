public class Posicion {

    protected int horizontal;
    protected int vertical;
    protected Movimiento movimiento;

    Posicion(int x,int y) {
        horizontal = x;
        vertical = y;
        movimiento = new Movimiento();
    }



    public void moverHaciaArriba() {
        vertical = movimiento.moverHaciaArriba(vertical);
    }

    public void moverHaciaAbajo(){
        vertical = movimiento.moverHaciaAbajo(vertical);
    }

    public void moverHaciaDerecha() {
        horizontal = movimiento.moverHaciaDerecha(horizontal);
    }

    public void moverHaciaIzquierda() {
        horizontal = movimiento.moverHaciaIzquierda(horizontal);
    }

    public void moverHaciaAbajoIzquierda() {
        this.moverHaciaAbajo();
        this.moverHaciaIzquierda();
    }

    public void moverHaciaAbajoDerecha() {
        this.moverHaciaAbajo();
        this.moverHaciaDerecha();
    }

    public void moverHaciaArribaIzquierda() {
        this.moverHaciaArriba();
        this.moverHaciaIzquierda();
    }

    public void moverHaciaArribaDerecha() {
        this.moverHaciaArriba();
        this.moverHaciaDerecha();
    }

    public boolean estaEnPos(int x, int y) {
        return ((horizontal == x)&& (vertical == y));
    }

    public boolean compararPosiciones(Posicion unaposicion){
        return ( (this.horizontal == unaposicion.horizontal) && (this.vertical == unaposicion.vertical) );
    } //Aca estoy rompiendo el encapsulamiento?

}
