public abstract class Unidad{
    protected int vida;
    protected int costo;
    protected Posicion posicion;
    protected int danio;
    protected Estado estado = new EstadoLibre();

    public int getVida(){
        return vida;
    }

    public int getCosto(){
        return costo;
    }

    public void moverHaciaArriba(){
        this.estado.moverHaciaArriba(this);
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
    }

    public boolean estaEnPos(int x, int y){
        Posicion posicionNueva= new Posicion(x,y);
        return this.posicion.compararPosiciones(posicionNueva);
    }

    public void reducirVida(int danio){
        this.vida -= danio;
    }

    public void atacar(Unidad unidad){
        this.estado.atacar(unidad,this);
    }

    public void ocuparse(){
        estado = new EstadoOcupado();
    }

    public void desocuparse(){
        estado = new EstadoLibre();
    }

    public void setPosicion(int x,int y){
        posicion = new Posicion (x,y);
    }

    public int getDanio(){
        return this.danio;
    }

    //Luego de testear ataque y baja vida agregar codigo
}
