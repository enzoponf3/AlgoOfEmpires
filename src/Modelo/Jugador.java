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


    public Jugador( int seedCastillo, int seedPlazaCentral ){
        this.castillo = new Castillo( obtenerPosicionesInicialesCastillo(seedCastillo) );
        this.edificios = new ArrayList<>();
        inicializarEdificios( obtenerPosicionesInicialesPlazaCentral(seedPlazaCentral, seedCastillo) );
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

    //Inicializacion jugador1

    public ArrayList<Posicion> obtenerPosicionesInicialesCastillo( int seedCastillo ){
        ArrayList<Posicion> posiciones = new ArrayList<>();

        for(int i=seedCastillo; i<seedCastillo+4; i++ ){
            for(int j=seedCastillo; j<seedCastillo+4; j++){
                Posicion posicion = new Posicion(i,j);
                posiciones.add(posicion);
            }
        }

        return posiciones;
    }

    public ArrayList<Posicion> obtenerPosicionesInicialesPlazaCentral(int seedPlaza, int seedCastillo){
        ArrayList<Posicion> posiciones = new ArrayList<>();

        for(int i=seedPlaza; i<seedPlaza+2; i++ ){
            for(int j=seedCastillo; j<seedCastillo+2; j++){
                Posicion posicion = new Posicion(i,j);
                posiciones.add(posicion);
            }
        }

        return posiciones;
    }


    private void inicializarEdificios(ArrayList<Posicion> posicionesPlaza ){
        PlazaCentral plazaCentral = new PlazaCentral( posicionesPlaza);
        // Finalizo construccion automaticamente
        plazaCentral.finalizarConstruccion();
        edificios.add(plazaCentral);
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
        verificarLimitePoblacion();
        this.aldeanos.add(aldeano);
    }

    public void agregarAEjercito(IAtacante atacante){
        verificarLimitePoblacion();
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

    private void verificarAtacantePropio(IAtacante atacante){
        if( !this.ejercito.contains(atacante) )
            throw new AtacanteNoExisteException();
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


    private void verificarEdificioPropio(Edificio edificio){
        if( !this.edificios.contains(edificio) )
            throw new EdificioNoExisteException();
    }

    private void verificarLimitePoblacion(){
        if( llegoAlLimiteDePoblacion() )
            throw new LimiteDePoblacionException();
    }



    //Aca empiexo a cambiar a estados...
    public void activar(){
        this.estado = new EstadoJugadorActivo();
    }

    public void inactivar(){
        this.estado = new EstadoJugadorInactivo();
    }

    public void mover( Posicion origen, Posicion destino ){
        IUnidadMovible unidad = devolverUnidadMovible(origen);
        this.estado.mover(unidad, origen, destino, this);
    }

    public void crearAldeano(PlazaCentral plazaCentral){
        verificarEdificioPropio(plazaCentral);
        verificarLimitePoblacion();
        this.estado.crearAldeano(plazaCentral, this);
        //Hay que setearle las posiciones...
    }//No se si las verificaciones se hacen aca o dentro del estado, porque si ya es turno del oponente tal vez no tiene sentido
    //verificar.

    public void crearArquero(Cuartel cuartel){
        verificarEdificioPropio(cuartel);
        verificarLimitePoblacion();
        this.estado.crearArquero(cuartel, this);
    }

    public void crearEspadachin(Cuartel cuartel){
        verificarEdificioPropio(cuartel);
        verificarLimitePoblacion();
        this.estado.crearEspadachin(cuartel, this);
    }

    public void crearArmaDeAsedio(){
        verificarLimitePoblacion();
        this.estado.crearArmaDeAsedio(this.castillo, this);
    } //Ojo que aca no verifica que es el suyo porque no le paso un castillo. Aca la verificacion se hace
    //en otro lado o como hacemos?
    //De ultima para este caso particular le puede pasar las posiciones y se verifica por posicion.

    public void montarArmaDeAsedio(ArmaDeAsedio armaDeAsedio){
        this.estado.montarArmaDeAsedio(armaDeAsedio);
    }
    public void desmontarArmaDeAsedio(ArmaDeAsedio armaDeAsedio){
        this.estado.desmontarArmaDeAsedio(armaDeAsedio);
    }

    public void atacar(IAtacante atacante, Unidad unidadAAtacar){
        verificarAtacantePropio(atacante);
        this.estado.atacar(atacante, unidadAAtacar);
    }

    public void atacar(IAtacante atacante, Edificio edificioAAtacar){
        verificarAtacantePropio(atacante);
        this.estado.atacar(atacante, edificioAAtacar);
    }

}
