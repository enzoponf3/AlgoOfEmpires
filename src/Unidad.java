public abstract class Unidad{
    protected int vida;
    protected int costo;
    protected Posicion posicion;
    protected int danio;
    protected Estado estado;        //Unidad no deberia tener estado entonces no ?

    public int getVida(){
        return vida;
    }

    public int getCosto(){
        return costo;
    }

    /*public void moverHaciaArriba(){                                   ver como hacer
        Movimiento movimiento = new MovimientoArriba();
        this.estado.moverUnidad(this,movimiento);
    }
    public void moverHaciaAbajo(){
        this.estado.moverHaciaAbajo(this);
    }
    public void moverHaciaIzquierda(){
        this.estado.moverHaciaIzquierda(this);
    }
    public void moverHaciaDerecha(){
        this.estado.moverHaciaDerecha(this);
    }
    public void moverHaciaAbajoIzquierda(){
        this.estado.moverHaciaAbajoIzquierda(this);
    }
    public void moverHaciaAbajoDerecha(){
        this.estado.moverHaciaAbajoDerecha(this);
    }
    public void moverHaciaArribaIzquierda(){
        this.estado.moverHaciaArribaIzquierda(this);
    }
    public void moverHaciaArribaDerecha(){
        this.estado.moverHaciaArribaDerecha(this);
    }*/



    public boolean estaEnPos(int x, int y){
        Posicion posicionNueva= new Posicion(x,y);
        return this.posicion.compararPosiciones(posicionNueva);
    }

    public void reducirVida(int danio){
        this.vida -= danio;
    }

    public void setPosicion(int x,int y){
        posicion = new Posicion (x,y);
    }

    public int getDanio(){
        return this.danio;
    }

    public void ocuparse(){}

    public void desocuparse(){}

    //Luego de testear ataque y baja vida agregar codigo
}
