public class Arquero extends Unidad{
    protected int vida = 75;
    protected int costo= 75;

    public int getVida() {
        return this.vida;
    }
    public int getCosto() {
        return this.costo;
    }

    @Override
    public void mover(Movimiento movimiento, Posicion posicion){

    }
}
