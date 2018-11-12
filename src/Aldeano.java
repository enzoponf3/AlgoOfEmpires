public class Aldeano extends Unidad{

    public static final int VIDA = 50;
    public static final int COSTO = 25;
    public static final int TURNOS = 3;

    public Aldeano(int x,int y) {
        super(x,y);
        this.vida = VIDA;
        this.costo = COSTO;
        this.estado = new EstadoAldeanoLibre();
    }

    public Cuartel construirCuartel(){
        return this.estado.construirCuartel(this);
    }
    public PlazaCentral construirPlazaCentral(){
        return this.estado.construirPlazaCentral(this);
    }

    public void repararEdificio(Edificio edificio){
        this.estado.repararEdificio(edificio,this);
    }
    public void continuarConstruccionPlazaCentral(PlazaCentral plaza){
        this.estado.continuarConstruccionPlazaCentral(plaza, this);
    }

    public void continuarConstruccionCuartel(Cuartel cuartel){
        this.estado.continuarConstruccionCuartel(cuartel, this);
    }

    public void moverHaciaArriba(){
        super.moverHaciaArriba();
        this.ocuparse();
    }
    public void moverHaciaAbajo(){
        super.moverHaciaAbajo();
        this.ocuparse();
    }
    public void moverHaciaIzquierda(){
        super.moverHaciaIzquierda();
        this.ocuparse();
    }

    public void moverHaciaDerecha(){
        super.moverHaciaDerecha();
        this.ocuparse();
    }

    public void moverHaciaAbajoIzquierda(){
        super.moverHaciaAbajoIzquierda();
        this.ocuparse();
    }

    public void moverHaciaAbajoDerecha(){
        super.moverHaciaAbajoDerecha();
        this.ocuparse();
    }

    public void moverHaciaArribaIzquierda(){
        super.moverHaciaArribaIzquierda();
        this.ocuparse();
    }

    public void moverHaciaArribaDerecha(){
        super.moverHaciaArribaDerecha();
        this.ocuparse();
    }


    public void ocuparse (){
        this.estado = new EstadoAldeanoOcupado();
    }

    public void desocuparse () {
        this.estado = new EstadoAldeanoLibre();
    }

    public boolean generaOro(){
        return this.getEstado().equals("Libre");
    }

}
