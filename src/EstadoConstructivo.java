public class EstadoConstructivo extends EstadoLibre {

    public int generaOro(){
        return 20;
    }

    public Cuartel construirCuartel(Unidad unidad){
        unidad.ocuparse();
        return new Cuartel();
    }

    public PlazaCentral construirPlazaCentral(Unidad unidad){
        unidad.ocuparse();
        return new PlazaCentral();
    }

    public void repararEdificio(Edificio edificio,Unidad unidad){
        edificio.reparar();
        unidad.ocuparse();
    }

    public void continuarConstruccion(Edificio edificio,Unidad unidad){
        edificio.construir();
        unidad.ocuparse();
    }

    public void atacar(Unidad unidad, Unidad atacante){
        throw new ElAldeanoNoPuedeAtacarException();
    }
}
