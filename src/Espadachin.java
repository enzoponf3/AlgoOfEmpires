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

    public void desocupar(){ this.estado = new EstadoEspadachinLibre();}

    public void ocupar(){ this.estado = new EstadoEspadachinOcupado();}

    @Override
    public void mover(Posicion destino){
        this.estado.mover(destino, this);
    }

    @Override
    public void cambiarPosicion(Posicion destino){
        this.posicion = destino;
    }
}