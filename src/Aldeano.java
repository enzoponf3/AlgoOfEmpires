public class Aldeano extends Unidad{

    public static final int VIDA = 50;
    public static final int COSTO = 25;
    public EstadoAldeano estado;

    public Aldeano() {
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
        this.estado.continuarConstruccion(plaza, this);
    }

    public void continuarConstruccionCuartel(Cuartel cuartel){
        this.estado.continuarConstruccion(cuartel, this);
    }

    public void ocupar(){
        this.estado = new EstadoAldeanoOcupado();
    }

    public void desocupar() {
        this.estado = new EstadoAldeanoLibre();
    }

    public int generaOro(){
        return this.estado.generaOro();
    }

    //Estoy haciendolo con la precondicion de que el mapa chequeo que la posicion de destino es valida y que
    //no esta ocupada por otro objeto. Solo necesita la de destino dado que directamente hace un swap y el mapa antes
    //desocupo la origen
    @Override
    public void mover(Posicion destino){
        this.estado.mover(destino, this);
    }

    @Override
    public void cambiarPosicion(Posicion destino){
        this.posicion = destino;
    }

}
