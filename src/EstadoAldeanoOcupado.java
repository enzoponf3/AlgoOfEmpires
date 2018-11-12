
public class EstadoAldeanoOcupado implements Estado{
    private static int TURNO = 3;
    private int turno = TURNO;

    public PlazaCentral construirPlazaCentral(Aldeano aldeano){
        this.reducirTurno(aldeano);
        throw new AldeanoOcupadoException();
    }

    public Cuartel construirCuartel(Aldeano aldeano){
        this.reducirTurno(aldeano);
        throw new AldeanoOcupadoException();
    }

    @Override
    public void repararEdificio(Edificio edificio,Aldeano aldeano) {
        turno = 1;
        this.reducirTurno(aldeano);

    }


    public void continuarConstruccionPlazaCentral(PlazaCentral plaza,Aldeano aldeano){
        plaza.construir();
        this.reducirTurno(aldeano);
    }

    public void continuarConstruccionCuartel(Cuartel cuartel, Aldeano aldeano){
        cuartel.construir();
        this.reducirTurno(aldeano);
    }

    public void reducirTurno(Aldeano aldeano){
        this.turno -= 1 ;
        if (this.turno == 0){
            aldeano.desocuparse();
        }
    }

    @Override
    public void atacar(Unidad unidad,Unidad atacante) {
        throw new ElAldeanoNoPuedeAtacarException();
    }

    public String getEstado(){
        return "Ocupado";
    }

}

