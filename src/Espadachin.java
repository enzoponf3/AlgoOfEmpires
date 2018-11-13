public class Espadachin extends Unidad{
   protected int VIDA = 100;
   protected int COSTO = 50;


    public Espadachin(){
        this.vida = VIDA;
        this.costo = COSTO;
        this.estado = new EstadoLibre();
    }
    public int getVida() {
        return this.vida;
    }

    public int getCosto() {
        return this.costo;
    }

}