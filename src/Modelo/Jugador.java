package Modelo;

import Modelo.Edificios.*;
import Modelo.Exceptions.LimiteDePoblacionException;
import Modelo.Unidades.*;
import Modelo.Exceptions.LimiteDePoblacionException;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Jugador {

    private Castillo castillo;
    private PlazaCentral plaza;
    private ArrayList<Aldeano> aldeanos;
    private static final int CANTIDAD_ALDEANOS_INICIAL = 3;
    private int cantidadOro;
    private static final int CANTIDAD_ORO_INICIAL = 100;
    private ArrayList<IAtacante> ejercito;
    private static final int LIMITE_POBLACION = 50;

    public Jugador(){
        this.castillo = new Castillo();
        this.plaza = new PlazaCentral();
        this.aldeanos = new ArrayList<>();
        inicializarAldeanos();
        this.cantidadOro = CANTIDAD_ORO_INICIAL;
        this.ejercito = new ArrayList<>();
    }

    public Castillo getCastillo(){
        return this.castillo;
    }

    public PlazaCentral getPlazaCentral(){
        return this.plaza;
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

    public void inicializarAldeanos(){
        for(int i=0; i<CANTIDAD_ALDEANOS_INICIAL; i++) {
            Aldeano aldeano = new Aldeano();
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

    public boolean llegoAlLimiteDePoblacion(){
        return (this.aldeanos.size() + this.ejercito.size()) == 50 ;
    }//no se me ocurre un buen nombre


}
