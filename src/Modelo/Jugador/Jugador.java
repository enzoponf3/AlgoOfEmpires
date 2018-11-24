package Modelo.Jugador;

import Modelo.Edificios.*;
import Modelo.Exceptions.*;
import Modelo.Posicion;
import Modelo.Unidades.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Jugador {

    private Jugador oponente;
    private IEstadoJugador estado;
    private Castillo castillo;
    private ArrayList<Edificio> edificios;
    private ArrayList<Aldeano> aldeanos;
    private ArrayList<IAtacante> ejercito;
    private int cantidadOro;
    private static final int CANTIDAD_ALDEANOS_INICIAL = 3;
    private static final int CANTIDAD_ORO_INICIAL = 100;
    private static final int LIMITE_POBLACION = 50;

    public Jugador( int seedCastillo, int seedPlazaCentral ){
        this.cantidadOro = CANTIDAD_ORO_INICIAL;
        this.castillo = new Castillo( obtenerPosicionesInicialesCastillo(seedCastillo) );
        this.ejercito = new ArrayList<>();
        this.aldeanos = new ArrayList<>();
        this.edificios = new ArrayList<>();
        inicializarAldeanos();
        inicializarEdificios( obtenerPosicionesInicialesPlazaCentral(seedPlazaCentral, seedCastillo) );
        // El estado se inicializa en el juego.
    }

    public void setOponente(Jugador jugadorOponente){
        this.oponente = jugadorOponente;
    }

    public void setEstado(IEstadoJugador estado){
        this.estado = estado;
    }

    public Jugador getOponente(){
        return this.oponente;
    }

    public ArrayList<Edificio> getEdificios(){
        return this.edificios;
    }

    public ArrayList<IAtacante> getEjercito(){
        return this.ejercito;
    }

    public ArrayList<Aldeano> getAldeanos(){
        return this.aldeanos;
    }

    public Castillo getCastillo(){
        return this.castillo;
    }

    public int getCantidadOro(){
        return this.cantidadOro;
    }

    // Inicializacion del Jugador

    public ArrayList<Posicion> obtenerPosicionesInicialesCastillo(int seedCastillo){
        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i = seedCastillo; i < seedCastillo + 4; i++)
            for(int j = seedCastillo; j < seedCastillo + 4; j++)
                posiciones.add(new Posicion(i,j));
        return posiciones;
    }

    public ArrayList<Posicion> obtenerPosicionesInicialesPlazaCentral(int seedPlaza, int seedCastillo){
        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i = seedPlaza; i < seedPlaza + 2; i++)
            for(int j = seedCastillo; j < seedCastillo + 2; j++)
                posiciones.add(new Posicion(i,j));
        return posiciones;
    }

    private void inicializarEdificios(ArrayList<Posicion> posicionesPlaza ){
        PlazaCentral plazaCentral = new PlazaCentral(posicionesPlaza);
        // Finalizo construccion automaticamente
        plazaCentral.finalizarConstruccion();
        edificios.add(plazaCentral);
    }

    private void inicializarAldeanos(){
        for(int i = 0; i < CANTIDAD_ALDEANOS_INICIAL; i++) {
            Aldeano aldeano = new Aldeano();
            Posicion posicion = new Posicion(i,i);
            aldeano.setPosicion(posicion);
            aldeanos.add(aldeano);
        }
    }

    //  Funcionalidades Jugador

    void verificarLimitePoblacion(){
        if (llegoAlLimiteDePoblacion())
            throw new LimiteDePoblacionException();
    }

    private boolean llegoAlLimiteDePoblacion(){
        return (this.aldeanos.size() + this.ejercito.size()) == LIMITE_POBLACION ;
    }

    public void recolectarOro(){
        cantidadOro += this.estado.recolectarOro(this);
    }

    // Agregar Entidades

    public void agregarAldeano(Aldeano aldeano){
        verificarLimitePoblacion();
        this.aldeanos.add(aldeano);
    }

    public void agregarAEjercito(IAtacante atacante){
        verificarLimitePoblacion();
        this.ejercito.add(atacante);
    }

    public void agregarEdificio(Edificio edificio){
        this.edificios.add(edificio);
    }

    // Remover Entidades

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

    // Devolver Entidad a partir de Posicion

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

    // Verificar Entidad propia

    void verificarAtacantePropio(IAtacante atacante){
        if( !this.ejercito.contains(atacante) )
            throw new AtacanteNoExisteException();
    }

    void verificarUnidadEnemiga(Unidad unidad){
        if( this.ejercito.contains(unidad) || this.aldeanos.contains(unidad) )
            throw new UnidadPropiaException();
    }

    void verificarEdificioPropio(Edificio edificio){
        if( !this.edificios.contains(edificio) )
            throw new EdificioNoExisteException();
    }

    void verificarEdificioEnemigo(Edificio edificio){
        if( this.edificios.contains(edificio) || this.castillo == edificio )
            throw new EdificioPropioException();
    }

    // Devolver Entidad


    public IUnidadMovible devolverUnidadMovible(Posicion posicionUnidad){
        try {
            return (IUnidadMovible) devolverAldeanoEnPosicion(posicionUnidad);
        } catch( AldeanoNoExisteException ignored){}
        try{
            return (IUnidadMovible) devolverAtacanteEnPosicion(posicionUnidad);
        } catch( AtacanteNoExisteException e ){}

        throw new UnidadMovibleNoExisteException();
    }

    // Cambio de estado

    public void activar(){
        this.estado = new EstadoJugadorActivo();
    }

    public void inactivar(){
        this.estado = new EstadoJugadorInactivo();
    }

    // Mover y cambios Arma Asedio

    public void mover( Posicion origen, Posicion destino ){
        IUnidadMovible unidad = devolverUnidadMovible(origen);
        this.estado.mover(unidad, origen, destino, this);
    }

    public void montarArmaDeAsedio(ArmaDeAsedio armaDeAsedio){
        verificarAtacantePropio(armaDeAsedio);
        this.estado.montarArmaDeAsedio(armaDeAsedio);
    }

    public void desmontarArmaDeAsedio(ArmaDeAsedio armaDeAsedio){
        verificarAtacantePropio(armaDeAsedio);
        this.estado.desmontarArmaDeAsedio(armaDeAsedio);
    }

    // Creacion Unidades

    public void crearAldeano(PlazaCentral plazaCentral){
        this.estado.crearAldeano(plazaCentral, this);
        //Hay que setearle las posiciones...
    }

    public void crearArquero(Cuartel cuartel){
        this.estado.crearArquero(cuartel, this);
    }

    public void crearEspadachin(Cuartel cuartel){
        this.estado.crearEspadachin(cuartel, this);
    }

    public void crearArmaDeAsedio(){
        this.estado.crearArmaDeAsedio(this.castillo, this);
    }
    //Ojo que aca no verifica que es el suyo porque no le paso un castillo. Aca la verificacion se hace
    //en otro lado o como hacemos?
    //De ultima para este caso particular le puede pasar las posiciones y se verifica por posicion.

    // Ataques

    public void atacar(IAtacante atacante, Unidad unidadAAtacar){
        this.estado.atacar(this, atacante, unidadAAtacar);
    }

    public void atacar(IAtacante atacante, Edificio edificioAAtacar){
        this.estado.atacar(this, atacante, edificioAAtacar);
    }

    public void castilloAtacar(ArrayList<Aldeano> aldeanos,ArrayList<Edificio> edificios, ArrayList<IAtacante> ejercito){
        this.castillo.atacarEdificios(edificios);
        this.castillo.atacarUnidades(aldeanos,ejercito);
    }

    // Construccion y reparar

    public void construirPlazaCentral(Aldeano aldeano,ArrayList<Posicion> posicionesPlazaCentral ){
        edificios.add(this.estado.construirPlazaCentral(aldeano, posicionesPlazaCentral) );
    }

    public void continuarConstruccionPlazaCentral(Aldeano aldeano, PlazaCentral plazaEnConstruccion){
        this.estado.continuarConstruccionPlazaCentral(aldeano, plazaEnConstruccion);
    }

    public void construirCuartel(Aldeano aldeano, ArrayList<Posicion> posicionesCuartel){
        edificios.add(this.estado.construirCuartel(aldeano, posicionesCuartel) );
    }

    public void continuarConstruccionCuartel(Aldeano aldeano, Cuartel cuartelEnConstruccion){
        this.estado.continuarConstruccionCuartel(aldeano, cuartelEnConstruccion);
    }

    public void reparar(Aldeano aldeano, Edificio edificio){
        this.estado.reparar(aldeano, edificio);
    }


    // Borrar entidades sin vida

    public void limpiarEntidadesMuertas() {
        Iterator aldeanoIter = this.aldeanos.iterator();
        Iterator ejercitoIter = this.ejercito.iterator();
        Iterator edificioIter = this.edificios.iterator();

        while(aldeanoIter.hasNext()){
            Aldeano aldeano = (Aldeano) aldeanoIter.next();
            if (aldeano.estaMuerto())
                aldeanoIter.remove();
        }
        while(ejercitoIter.hasNext()){
            IAtacante atacante = (IAtacante) ejercitoIter.next();
            if (atacante.estaMuerto())
                ejercitoIter.remove();
        }
        while(edificioIter.hasNext()){
            Edificio edificio = (Edificio) edificioIter.next();
            if (edificio.estaDestruido())
                edificioIter.remove();
        }
    }
}
