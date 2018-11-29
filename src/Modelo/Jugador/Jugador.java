package Modelo.Jugador;

import Modelo.Edificios.*;
import Modelo.Exceptions.*;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.*;
import javafx.geometry.Pos;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
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

    // Setters y Getters

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

    // Constructor e Inicializadores
/*
    public Jugador( int seedCastillo, int seedPlazaCentral, Mapa mapa){
        this.cantidadOro = CANTIDAD_ORO_INICIAL;
        this.ejercito = new ArrayList<>();
        this.aldeanos = new ArrayList<>();
        this.edificios = new ArrayList<>();
        this.castillo = new Castillo( obtenerPosicionesInicialesCastillo(seedCastillo) );
        inicializarEdificios( mapa, seedCastillo, seedPlazaCentral );
        inicializarAldeanos(mapa);
        // El estado se inicializa en el juego.
    }
*/
    // EN DESARROLLO - Constructor con el mapa para poder inicializar correctamente los aldeanos
    public Jugador( Mapa mapa, int seedCastillo, int seedPlazaCentral ){
        this.cantidadOro = CANTIDAD_ORO_INICIAL;
        this.ejercito = new ArrayList<>();
        this.aldeanos = new ArrayList<>();
        this.edificios = new ArrayList<>();
        inicializarEdificios(mapa, seedCastillo,seedPlazaCentral);  // Primero inicializar los edificios, despues los aldeanos
        inicializarAldeanos(mapa);
        // El estado se inicializa en el juego.
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


    // EN DESARROLLO
    private void inicializarEdificios(Mapa mapa, int seedCastillo, int seedPlaza){
        ArrayList<Posicion> posicionesCastillo = obtenerPosicionesInicialesCastillo(seedCastillo);
        this.castillo = new Castillo(posicionesCastillo);
        mapa.ocuparCasilleros(posicionesCastillo,castillo);
        ArrayList<Posicion> posicionesPlaza = obtenerPosicionesInicialesPlazaCentral(seedPlaza, seedCastillo);
        PlazaCentral plazaCentral = new PlazaCentral(posicionesPlaza);
        plazaCentral.finalizarConstruccion();        // Finalizo construccion automaticamente
        mapa.ocuparCasilleros(posicionesPlaza, plazaCentral);
        edificios.add(plazaCentral);
    }

    // EN DESARROLLO - Inicializar pidiendo al mapa posicion donde colocarlo
    private void inicializarAldeanos(Mapa mapa){
        // Se que unico edificio en este momento es la plaza central
        PlazaCentral plaza = (PlazaCentral) edificios.get(0);
        for(int i = 0; i < CANTIDAD_ALDEANOS_INICIAL; i++) {
            Posicion posicionAldeano = mapa.devolverPosicionAledaniaLibre(plaza);
            Aldeano aldeano = new Aldeano(posicionAldeano);
            mapa.ocuparCasillero(posicionAldeano,aldeano);
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

    // Creacion Unidades

    public void crearAldeano(Mapa mapa, PlazaCentral plazaCentral){
        this.estado.crearAldeano(mapa, plazaCentral, this);
    }

    public void crearArquero(Mapa mapa, Cuartel cuartel){
        this.estado.crearArquero(mapa, cuartel, this);
    }

    public void crearEspadachin(Mapa mapa, Cuartel cuartel){
        this.estado.crearEspadachin(mapa, cuartel, this);
    }

    public void crearArmaDeAsedio(Mapa mapa){
        this.estado.crearArmaDeAsedio(mapa, this.castillo, this);
    }
    //Ojo que aca no verifica que es el suyo porque no le paso un castillo. Aca la verificacion se hace
    //en otro lado o como hacemos?
    //De ultima para este caso particular le puede pasar las posiciones y se verifica por posicion.

    // Construccion y reparar

    public void construirPlazaCentral(Aldeano aldeano,ArrayList<Posicion> posicionesPlazaCentral ){
        edificios.add(this.estado.construirPlazaCentral(this, aldeano, posicionesPlazaCentral) );
    }

    public void continuarConstruccionPlazaCentral(Aldeano aldeano, PlazaCentral plazaEnConstruccion){
        this.estado.continuarConstruccionPlazaCentral(this, aldeano, plazaEnConstruccion);
    }

    public void construirCuartel(Aldeano aldeano, ArrayList<Posicion> posicionesCuartel){
        edificios.add(this.estado.construirCuartel(this, aldeano, posicionesCuartel) );
    }

    public void continuarConstruccionCuartel(Aldeano aldeano, Cuartel cuartelEnConstruccion){
        this.estado.continuarConstruccionCuartel(this, aldeano, cuartelEnConstruccion);
    }

    public void reparar(Aldeano aldeano, Edificio edificio){
        this.estado.reparar(this, aldeano, edificio);
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

    public IUnidadMovible devolverUnidadMovible(Posicion posicionUnidad){
        try {
            return (IUnidadMovible) devolverAldeanoEnPosicion(posicionUnidad);
        } catch( AldeanoNoExisteException ignored){}
        try{
            return (IUnidadMovible) devolverAtacanteEnPosicion(posicionUnidad);
        } catch( AtacanteNoExisteException e ){}

        throw new UnidadMovibleNoExisteException();
    }

    // Verificar Entidad propia

    void verificarAldeanoPropio(Aldeano aldeano) {
        if (!this.aldeanos.contains(aldeano))
            throw new AldeanoNoExisteException();
    }
    void verificarAtacantePropio(IAtacante atacante){
        if( !this.ejercito.contains(atacante) )
            throw new AtacanteNoExisteException();
    }

    void verificarUnidadEnemiga(Unidad unidad){
        if( this.ejercito.contains(unidad) || this.aldeanos.contains(unidad) )
            throw new UnidadPropiaException();
    }

    void verificarEdificioPropio(Edificio edificio){
        if( !this.edificios.contains(edificio)  && this.castillo != edificio)
            throw new EdificioNoExisteException();
    }

    void verificarEdificioEnemigo(Edificio edificio){
        if( this.edificios.contains(edificio) || this.castillo == edificio )
            throw new EdificioPropioException();
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
