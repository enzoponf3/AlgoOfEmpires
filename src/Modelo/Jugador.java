package Modelo;

import Modelo.Edificios.*;
import Modelo.Exceptions.AldeanoNoExisteException;
import Modelo.Exceptions.AtacanteNoExisteException;
import Modelo.Exceptions.EdificioNoExisteException;
import Modelo.Exceptions.LimiteDePoblacionException;
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

    private ArrayList<Edificio> edificiosEnConstruccion; //No se si vale la pena, lo charlamos luego


    public Jugador(){
        this.castillo = new Castillo();
        this.edificios = new ArrayList<>();
        inicializarEdificios();
        this.aldeanos = new ArrayList<>();
        inicializarAldeanos();
        this.cantidadOro = CANTIDAD_ORO_INICIAL;
        this.ejercito = new ArrayList<>();

        this.edificiosEnConstruccion = new ArrayList<>();
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

    private ArrayList<Posicion> posicionesInicial(){
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

    private void inicializarEdificios(){
        PlazaCentral plazaCentral = new PlazaCentral( posicionesInicial() );
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


/*
    public IEntidad devolverEntidadEnPosicion(Posicion posicion, ArrayList<IEntidad> entidades){

    }
*/
    public Aldeano devolverAldeanoEnPosicion(Posicion posicion){
        for( Aldeano aldeano : this.aldeanos ){
            if( aldeano.enPosicion(posicion) )
                return aldeano;
        }
        throw new AldeanoNoExisteException();
    }

    public Edificio devolverEdificioEnPosicion(Posicion posicion){
        for( Edificio edificio : this.edificios ){
            if( edificio.getPosiciones().contains(posicion) )//Rompe encaps...
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

    public void recolectarOro(){
        for( Aldeano aldeano : this.aldeanos ){
            cantidadOro += aldeano.generaOro();
        }
    }


}
