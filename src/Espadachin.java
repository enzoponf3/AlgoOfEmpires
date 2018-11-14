public class Espadachin extends Unidad{
   protected int VIDA = 100;
   protected int COSTO = 50;
   protected EstadoEspadachin estado;

    public Espadachin(){
        this.vida = VIDA;
        this.costo = COSTO;
        this.estado = new EstadoEspadachinLibre();
    }
    public int getVida() {
        return this.vida;
    }

    public int getCosto() {
        return this.costo;
    }

    public void desocuparse(){ this.estado = new EstadoEspadachinLibre();}

    public void ocuparse(){ this.estado = new EstadoEspadachinOcupado();}

    @Override
    public void mover(Movimiento movimiento, Posicion posicion){

    }
}