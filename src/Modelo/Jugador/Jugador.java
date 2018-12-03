package Modelo.Jugador;

import Modelo.Edificios.*;
import Modelo.Exceptions.*;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.*;

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

    public Jugador( Mapa mapa, int seedCastillo, int seedPlazaCentral ){
        this.cantidadOro = CANTIDAD_ORO_INICIAL;
        this.ejercito = new ArrayList<>();
        this.aldeanos = new ArrayList<>();
        this.edificios = new ArrayList<>();
        // Primero inicializar edificios, despues aldeanos
        inicializarEdificios(mapa, seedCastillo,seedPlazaCentral);
        inicializarAldeanos(mapa);
        // El estado se inicializa en el juego.
    }

    // Inicializacion del Jugador

    public ArrayList<Posicion> obtenerPosicionesInicialesCastillo(int seedCastillo){
        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i = seedCastillo; i < seedCastillo + 4; i++)
            for(int j = (seedCastillo/2); j < (seedCastillo/2) + 4; j++)
                posiciones.add(new Posicion(i,j));
        return posiciones;
    }

    public ArrayList<Posicion> obtenerPosicionesInicialesPlazaCentral(int seedPlaza, int seedCastillo){
        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i = seedPlaza; i < seedPlaza + 2; i++)
            for(int j = (seedCastillo/2); j < (seedCastillo/2) + 2; j++)
                posiciones.add(new Posicion(i,j));
        return posiciones;
    }

    private void inicializarEdificios(Mapa mapa, int seedCastillo, int seedPlaza){
        ArrayList<Posicion> posicionesPlaza = obtenerPosicionesInicialesPlazaCentral(seedPlaza, seedCastillo);
        ArrayList<Posicion> posicionesCastillo = obtenerPosicionesInicialesCastillo(seedCastillo);
        PlazaCentral plazaCentral = new PlazaCentral(posicionesPlaza);
        this.castillo = new Castillo(posicionesCastillo);
        plazaCentral.finalizarConstruccion();        // Finalizo construccion automaticamente
        edificios.add(plazaCentral);
        mapa.ocuparCasilleros(posicionesPlaza, plazaCentral);
        mapa.ocuparCasilleros(posicionesCastillo,castillo);
    }

    private void inicializarAldeanos(Mapa mapa){
        // Unico edificio al inicio es la plaza central
        PlazaCentral plaza = (PlazaCentral) edificios.get(0);
        for(int i = 0; i < CANTIDAD_ALDEANOS_INICIAL; i++) {
            Posicion posicionAldeano = mapa.devolverPosicionAledaniaLibre(plaza);
            Aldeano aldeano = new Aldeano(posicionAldeano);
            aldeanos.add(aldeano);
            mapa.ocuparCasillero(posicionAldeano,aldeano);
        }
    }

    public void turnoActivo(){
        this.setEstado(new EstadoJugadorActivo());
    }

    public void turnoInactivo(){
        this.setEstado(new EstadoJugadorInactivo());
    }

    public void cambiarTurno(){
        this.estado.cambiarTurno(this);
    }

    //  Funcionalidades Jugador

    private boolean llegoAlLimiteDePoblacion(){
        return (this.aldeanos.size() + this.ejercito.size()) == LIMITE_POBLACION ;
    }

    void verificarLimitePoblacion(){
        if (llegoAlLimiteDePoblacion())
            throw new LimiteDePoblacionException();
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

    public ArmaDeAsedio crearArmaDeAsedio(Mapa mapa, Castillo castillo){
        return this.estado.crearArmaDeAsedio(mapa, castillo, this);

    }

    // Construccion y reparar

    public void construirPlazaCentral(Mapa mapa, Aldeano aldeano,ArrayList<Posicion> posicionesPlazaCentral ){
        this.estado.construirPlazaCentral(this, mapa, aldeano, posicionesPlazaCentral);
    }

    public void continuarConstruccionPlazaCentral(Aldeano aldeano, PlazaCentral plazaEnConstruccion){
        this.estado.continuarConstruccionPlazaCentral(this, aldeano, plazaEnConstruccion);
    }

    public Cuartel construirCuartel(Mapa mapa, Aldeano aldeano, ArrayList<Posicion> posicionesCuartel){
        return this.estado.construirCuartel(this, mapa, aldeano, posicionesCuartel);
    }

    public void continuarConstruccionCuartel(Aldeano aldeano, Cuartel cuartelEnConstruccion){
        this.estado.continuarConstruccionCuartel(this, aldeano, cuartelEnConstruccion);
    }

    public void reparar(Aldeano aldeano, Edificio edificio){
        this.estado.reparar(this, aldeano, edificio);
    }

    // Agregar Entidades

    public void agregarAldeano(Aldeano aldeano, Mapa mapa){
        verificarLimitePoblacion();
        this.aldeanos.add(aldeano);
        mapa.ocuparCasillero(aldeano.getPosicion(),aldeano);
    }

    public void agregarAEjercito(IAtacante atacante, Mapa mapa){
        verificarLimitePoblacion();
        this.ejercito.add(atacante);
        mapa.ocuparCasillero(atacante.getPosicion(),atacante);
    }

    public void agregarEdificio(Edificio edificio, Mapa mapa){
        this.edificios.add(edificio);
        mapa.ocuparCasilleros(edificio.getPosiciones(),edificio);
    }

    // Remover Entidades

    public Aldeano removerAldeano(Aldeano aldeanoARemover, Mapa mapa){
        if( !aldeanos.contains(aldeanoARemover) )
            throw new AldeanoNoExisteException();
        this.aldeanos.remove(aldeanoARemover);
        mapa.desocuparCasillero(aldeanoARemover.getPosicion());
        return aldeanoARemover;
    }

    public IAtacante removerDeEjercito(IAtacante atacanteARemover, Mapa mapa){
        if( !ejercito.contains(atacanteARemover) )
            throw new AtacanteNoExisteException();
        this.ejercito.remove(atacanteARemover);
        mapa.desocuparCasillero(atacanteARemover.getPosicion());
        return atacanteARemover;
    }

    public Edificio removerEdificio(Edificio edificioARemover, Mapa mapa){
        if( !this.edificios.contains(edificioARemover) )
            throw new EdificioNoExisteException();
        this.edificios.remove(edificioARemover);
        mapa.desocuparCasilleros(edificioARemover.getPosiciones());
        return edificioARemover;
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

    public boolean mover(Unidad unidad, Posicion destino, Mapa mapa){
        return this.estado.mover(unidad, destino, mapa, this);
    }

    public void montarArmaDeAsedio(ArmaDeAsedio armaDeAsedio){
        this.estado.montarArmaDeAsedio(armaDeAsedio,this);
    }

    public void desmontarArmaDeAsedio(ArmaDeAsedio armaDeAsedio){
        this.estado.desmontarArmaDeAsedio(armaDeAsedio, this);
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

    public void rendirse(){
        this.castillo.autodestruir();
    }

    // Borrar entidades sin vida

    public void limpiarEntidadesMuertas(Mapa mapa) {
        Iterator aldeanoIter = this.aldeanos.iterator();
        Iterator ejercitoIter = this.ejercito.iterator();
        Iterator edificioIter = this.edificios.iterator();

        while(aldeanoIter.hasNext()){
            Aldeano aldeano = (Aldeano) aldeanoIter.next();
            if (aldeano.estaMuerto()) {
                aldeanoIter.remove();
                mapa.desocuparCasillero(aldeano.getPosicion());
            }

        }
        while(ejercitoIter.hasNext()){
            IAtacante atacante = (IAtacante) ejercitoIter.next();
            if (atacante.estaMuerto()) {
                ejercitoIter.remove();
                mapa.desocuparCasillero(atacante.getPosicion());
            }
        }
        while(edificioIter.hasNext()){
            Edificio edificio = (Edificio) edificioIter.next();
            if (edificio.estaDestruido()) {
                edificioIter.remove();
                mapa.desocuparCasilleros(edificio.getPosiciones());
            }
        }
    }

    public int getCantidadPoblacion() {
        return this.aldeanos.size() + this.ejercito.size();
    }

    public int getVida() {
        return this.castillo.getVida();
    }

    public void desocuparUnidades() {
        for(Aldeano aldeano: this.aldeanos){
            aldeano.desocupar();
        }
        for(IAtacante atacante: this.ejercito){
            atacante.desocupar();
        }
    }
}
