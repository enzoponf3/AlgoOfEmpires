public class Aldeano extends Unidad{

    public static final int VIDA = 50;
    public static final int COSTO = 25;
    public static final int TURNOS = 3;

    public Aldeano() {
        this.vida = VIDA;
        this.costo = COSTO;
        this.estado = new EstadoConstructivo();
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
        this.estado = new EstadoOcupado();
    }

    public void desocuparse () {
        this.estado = new EstadoConstructivo();
    }

    public int generaOro(){
        return this.estado.generaOro();
    }

}
