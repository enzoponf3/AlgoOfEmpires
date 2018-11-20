package Modelo;

import Modelo.Edificios.*;
import Modelo.Exceptions.*;
import Modelo.Unidades.*;
import java.util.ArrayList;

public class Jugador {

    private Castillo castillo;
    private ArrayList<Edificio> edificios;
    private ArrayList<Aldeano> aldeanos;
    private static final int CANTIDAD_ALDEANOS_INICIAL = 3;
    private int cantidadOro;
    private static final int CANTIDAD_ORO_INICIAL = 100;
    private ArrayList<IAtacante> ejercito;
    private static final int LIMITE_POBLACION = 50;

    private IEstadoJugador estado;


    public Jugador(){
        this.castillo = new Castillo();
        this.edificios = new ArrayList<>();
        inicializarEdificios();
        this.aldeanos = new ArrayList<>();
        inicializarAldeanos();
        this.cantidadOro = CANTIDAD_ORO_INICIAL;
        this.ejercito = new ArrayList<>();
        // El estado se inicializa en el juego.
    }

    public void setEstado(IEstadoJugador estado){
        this.estado = estado;
    }

    public Castillo getCastillo(){
        return this.castillo;
    }

    public ArrayList<Edificio> getEdificios(){
        return this.edificios;
    }

    public ArrayList<Aldeano> getAldeanos(){
        return this.aldeanos;
    }

    public int getCantidadOro(){
        return this.cantidadOro;
    }

    public ArrayList<IAtacante> getEjercito(){
        return this.ejercito;
    }

    private ArrayList<Posicion> posicionesPlazaCentralInicial(){
        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(4,5);
        Posicion posicion2 = new Posicion(4,6);
        Posicion posicion3 = new Posicion(5,5);
        Posicion posicion4 = new Posicion(5,6);
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);

        return posiciones;
    }

    private ArrayList<Posicion> posicionesCastilloInicial(){
        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(1,4);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,4);
        Posicion posicion4 = new Posicion(2,3);
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);

        return posiciones;
    }

    private void inicializarEdificios(){
        PlazaCentral plazaCentral = new PlazaCentral( posicionesPlazaCentralInicial() );
        // Finalizo construccion automaticamente
        plazaCentral.finalizarConstruccion();
        edificios.add(plazaCentral);

        this.castillo.setPosiciones( posicionesCastilloInicial() ); //Agrego el constructor despues
    }

    private void inicializarAldeanos(){
        for(int i=0; i<CANTIDAD_ALDEANOS_INICIAL; i++) {
            Aldeano aldeano = new Aldeano();
            Posicion posicion = new Posicion(i,i);
            aldeano.setPosicion(posicion);
            aldeanos.add(aldeano);
        }
    }

    public void agregarAldeano(Aldeano aldeano){
        if( llegoAlLimiteDePoblacion() )
            throw new LimiteDePoblacionException();
        this.aldeanos.add(aldeano);
    }

    public void agregarAEjercito(IAtacante atacante){
        if( llegoAlLimiteDePoblacion() )
            throw new LimiteDePoblacionException();
        this.ejercito.add(atacante);
    }

    private boolean llegoAlLimiteDePoblacion(){
        return (this.aldeanos.size() + this.ejercito.size()) == LIMITE_POBLACION ;
    }

    public void agregarEdificio(Edificio edificio){
        this.edificios.add(edificio);
    }

    public Aldeano removerAldeano(Aldeano aldeanoARemover){
        if( !aldeanos.contains(aldeanoARemover) )
            throw new AldeanoNoExisteException();
        this.aldeanos.remove(aldeanoARemover);
        return aldeanoARemover;
    }

    public IAtacante removerDeEjercito(IAtacante atacanteARemover){
        if( !ejercito.contains(atacanteARemover) )
            throw new AtacanteNoExisteException();
        this.ejercito.remove(atacanteARemover);
        return atacanteARemover;
    }

    public Edificio removerEdificio(Posicion posicionEdificioARemover){
        Edificio edificioARemover = devolverEdificioEnPosicion(posicionEdificioARemover);
        if( !this.edificios.contains(edificioARemover) )
            throw new EdificioNoExisteException();
        this.edificios.remove(edificioARemover);
        return edificioARemover;
    }    //Aca los tres remover deberian ya mataer la referencia? o devolver lo que se remueve?

    public Aldeano devolverAldeanoEnPosicion(Posicion posicion){
        for( Aldeano aldeano : this.aldeanos ){
            if( aldeano.enPosicion(posicion) )
                return aldeano;
        }
        throw new AldeanoNoExisteException();
    }

    //Aca hay un problema que hay que preguntar, porque es un IAtacante y no entiende el enPosicion de Unidad
    public IAtacante devolverAtacanteEnPosicion(Posicion posicion){
        for( IAtacante atacante : this.ejercito ){
            Unidad atacanteU = (Unidad) atacante;
            if( atacanteU.enPosicion(posicion) )
                return atacante;
        }
        throw new AtacanteNoExisteException();
    }

    public Edificio devolverEdificioEnPosicion(Posicion posicion){
        for( Edificio edificio : this.edificios ){
            if( edificio.contienePosicion(posicion) )//Rompe encaps...
                return edificio;
        }
        throw new EdificioNoExisteException();
    }


    public void construirPlazaCentral(Posicion posicionAldeano, ArrayList<Posicion> posiciones){
        Aldeano aldeano = devolverAldeanoEnPosicion(posicionAldeano);
        edificios.add( aldeano.construirPlazaCentral(posiciones) );
    }

    public void continuarConstruccionPlazaCentral(Posicion posicionAldeano, Posicion posicionPlazaCentral){
        Aldeano aldeano = devolverAldeanoEnPosicion(posicionAldeano);
        PlazaCentral plazaCentral = (PlazaCentral) devolverEdificioEnPosicion(posicionPlazaCentral);

        aldeano.continuarConstruccionPlazaCentral(plazaCentral);
    }

    public void construirCuartel(Posicion posicionAldeano, ArrayList<Posicion> posiciones){
        Aldeano aldeano = devolverAldeanoEnPosicion(posicionAldeano);
        edificios.add( aldeano.construirCuartel(posiciones) );
    }

    public void continuarConstruccionCuartel(Posicion posicionAldeano, Posicion posicionCuartel){
        Aldeano aldeano = devolverAldeanoEnPosicion(posicionAldeano);
        Cuartel cuartel = (Cuartel) devolverEdificioEnPosicion(posicionCuartel);

        aldeano.continuarConstruccionCuartel(cuartel);
    }

    public void reparar(Posicion posicionAldeano, Posicion posicionEdificio){
        Aldeano aldeano = devolverAldeanoEnPosicion(posicionAldeano);
        Edificio edificio = devolverEdificioEnPosicion(posicionEdificio);

        aldeano.repararEdificio(edificio);
    }

    public void reparar(Posicion posicionAldeano){
        Aldeano aldeano = devolverAldeanoEnPosicion(posicionAldeano);

        aldeano.repararEdificio( this.castillo );
    }

    public void recolectarOro(){
        for( Aldeano aldeano : this.aldeanos ){
            cantidadOro += aldeano.generaOro();
        }
    }

    public void atacar(Posicion posicionAtacante, Unidad unidadAAtacar){
        IAtacante atacante = devolverAtacanteEnPosicion(posicionAtacante);
        atacante.atacar(unidadAAtacar);
    }

    public void atacar(Posicion posicionAtacante, Edificio edificioAAtacar){
        IAtacante atacante = devolverAtacanteEnPosicion(posicionAtacante);
        atacante.atacar(edificioAAtacar);
    }

    //El jugador deberia armar y desarmar el ArmaDeAsedio?

    public void montarArmaDeAsedio(Posicion posicionArmaDeAsedio){
        ArmaDeAsedio armaDeAsedio = (ArmaDeAsedio) devolverAtacanteEnPosicion(posicionArmaDeAsedio);
        armaDeAsedio.montar();
    }

    public void desmontarArmaDeAsedio(Posicion posicionArmaDeAsedio){
        ArmaDeAsedio armaDeAsedio = (ArmaDeAsedio) devolverAtacanteEnPosicion(posicionArmaDeAsedio);
        armaDeAsedio.desmontar();
    }

    public IUnidadMovible devolverUnidadMovible(Posicion posicionUnidad){
        try {
            IUnidadMovible unidad = (IUnidadMovible) devolverAldeanoEnPosicion(posicionUnidad);
            return unidad;
        } catch( AldeanoNoExisteException e){}
        try{
            IUnidadMovible unidad = (IUnidadMovible) devolverAtacanteEnPosicion(posicionUnidad);
            return unidad;
        } catch( AtacanteNoExisteException e ){}

        throw new UnidadMovibleNoExisteException();
    }

    public void mover( Posicion origen, Posicion destino ){
        IUnidadMovible unidad = devolverUnidadMovible(origen);
        unidad.mover(destino);
    }

}
