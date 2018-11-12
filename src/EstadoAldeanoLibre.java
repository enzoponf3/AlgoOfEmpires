
public class EstadoAldeanoLibre implements Estado{

    public PlazaCentral construirPlazaCentral(Aldeano aldeano){
        PlazaCentral plaza = new PlazaCentral();
        aldeano.ocuparse();
        return plaza;
    }
    public Cuartel construirCuartel(Aldeano aldeano){
        Cuartel cuartel = new Cuartel();
        aldeano.ocuparse();
        return cuartel;
    }
    @Override
    public void repararEdificio(Edificio edificio,Aldeano aldeano) {
       edificio.reparar();
       aldeano.ocuparse();
    }

    @Override
    public void continuarConstruccionPlazaCentral(PlazaCentral plaza, Aldeano aldeano) {

    }

    @Override
    public void continuarConstruccionCuartel(Cuartel cuartel, Aldeano aldeano) {

    }

    @Override
    public void atacar(Unidad unidad,Unidad atacante) {
        throw new ElAldeanoNoPuedeAtacarException();
    }

    public String getEstado(){
        return "Libre";
    }

}

