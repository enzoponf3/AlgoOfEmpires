public class ArmaDeAsedio extends Unidad{
    protected int VIDA = 150;
    protected int COSTO = 200;
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

    public void montar(){ this.estado = new EstadoArmaDeAsedioArmado();}

    public void desmontar(){ this.estado = new EstadoArmaDeAsedioDesarmado();}

    @Override
    public void mover(Movimiento movimiento, Posicion posicion){

    }
}
