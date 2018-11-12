public class EstadoEspadachinLibre implements Estado {

    private boolean LIBRE = true;

    public void atacar(Unidad unidad,Unidad atacante){
        unidad.reducirVida(atacante.danio);
    }
    public boolean comprobarEstado(){return LIBRE;}
    public boolean estaOcupado(){ return !LIBRE;}

    public PlazaCentral construirPlazaCentral(Aldeano aldeano){ throw  new EspadachinNoConstruyeException(); }
    public Cuartel construirCuartel(Aldeano aldeano){throw  new EspadachinNoConstruyeException();}
    public void repararEdificio(Edificio edificio,Aldeano aldeano){throw  new EspadachinNoConstruyeException();}
    public void continuarConstruccionPlazaCentral(PlazaCentral plaza, Aldeano aldeano){throw  new EspadachinNoConstruyeException();}
    public void continuarConstruccionCuartel(Cuartel cuartel, Aldeano aldeano){throw  new EspadachinNoConstruyeException();}
}
