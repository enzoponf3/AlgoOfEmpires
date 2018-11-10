

public class Aldeano extends Unidad{

    public static final int VIDA = 50;
    public static final int COSTO = 25;
    public static final String LIBRE = "Libre";

    public Aldeano(int x,int y) {
        super(x,y);
        this.vida = VIDA;
        this.costo = COSTO;
        this.estado = LIBRE;

    }


    /*public construirCuartel(){

    }*/
}
