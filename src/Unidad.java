public abstract class Unidad{
    protected int vida;
    protected int costo;
    protected Posicion posicion;
    protected int danio;
    protected Estado estado;

    public Unidad(int x, int y){
        posicion = new Posicion(x,y);
    }

    public int getVida(){
        return vida;
    }

    public int getCosto(){
        return costo;
    }

    public void moverHaciaArriba(){
        MovimientoArriba movimiento = new MovimientoArriba();
        this.posicion = movimiento.desplazarPosicion(this.posicion);
    }
    public void moverHaciaAbajo(){
        MovimientoAbajo movimiento = new MovimientoAbajo();
        this.posicion = movimiento.desplazarPosicion(this.posicion);
    }
    public void moverHaciaIzquierda(){
        MovimientoIzquierda movimiento = new MovimientoIzquierda();
        this.posicion = movimiento.desplazarPosicion(this.posicion);
    }
    public void moverHaciaDerecha(){
        MovimientoDerecha movimiento = new MovimientoDerecha();
        this.posicion = movimiento.desplazarPosicion(this.posicion);
    }
    public void moverHaciaAbajoIzquierda(){
        MovimientoAbajoIzquierda movimiento = new MovimientoAbajoIzquierda();
        this.posicion = movimiento.desplazarPosicion(this.posicion);
    }
    public void moverHaciaAbajoDerecha(){
        MovimientoAbajoDerecha movimiento = new MovimientoAbajoDerecha();
        this.posicion = movimiento.desplazarPosicion(this.posicion);
    }
    public void moverHaciaArribaIzquierda(){
        MovimientoArribaIzquierda movimiento = new MovimientoArribaIzquierda();
        this.posicion = movimiento.desplazarPosicion(this.posicion);
    }
    public void moverHaciaArribaDerecha(){
        MovimientoArribaDerecha movimiento = new MovimientoArribaDerecha();
        this.posicion = movimiento.desplazarPosicion(this.posicion);
    }

    public boolean estaEnPos(int x, int y){
        Posicion posicionNueva= new Posicion(x,y);
        return this.posicion.compararPosiciones(posicionNueva);
    }

    public void reducirVida(int danio){
        this.vida -= danio;
    }

    public void atacar (Unidad unidad){
        this.estado.atacar(unidad,this);
    }

    public String getEstado(){
        return this.estado.getEstado();
    }

    public void ocuparse(){}

    //Luego de testear ataque y baja vida agregar codigo
}
