public class ArmaDeAsedio extends Unidad{

    private int VIDA = 150;
    private int COSTO = 200;
    protected EstadoArmaDeAsedio estado;

    public ArmaDeAsedio(){
        this.vida = VIDA;
        this.costo = COSTO;
        this.estado = new EstadoArmaDeAsedioDesarmado();
    }
    public int getVida() {
        return this.vida;
    }

    public int getCosto() {
        return this.costo;
    }

    public void montar(){ this.estado.montar(this);}

    public void desmontar(){ this.estado.desmontar(this);}

    public void desocupar(){this.estado.desocupar(this);}

    @Override
    public void mover(Posicion destino){
        this.estado.mover(destino, this);
    }

    @Override
    public void cambiarPosicion(Posicion destino){
        this.posicion = destino;
    }

}
