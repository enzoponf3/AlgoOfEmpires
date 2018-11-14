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

    public void ocuparse (){
        this.estado = new EstadoAldeanoOcupado();
    }

    public void desocuparse () {
        this.estado = new EstadoAldeanoLibre();
    }

    public int generaOro(){
        return this.estado.generaOro();
    }

}
