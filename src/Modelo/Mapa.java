package Modelo;

import Modelo.Exceptions.*;
import Modelo.Unidades.IUnidadMovible;

import java.util.ArrayList;

public class Mapa {

    private int ancho;
    private int alto;
    protected ArrayList<Casillero> casilleros = new ArrayList<>();

    public Mapa(int ancho, int alto){
        verificarDimensionesCorrectas(ancho, alto);
        this.ancho = ancho;
        this.alto = alto;
        this.inicializarCasilleros(ancho, alto);
    } 

    public void verificarDimensionesCorrectas(int ancho, int alto){
        if( ancho <= 0 || alto <= 0 )
            throw new MapaConDimensionesIncorrectasException();
    }

    public void inicializarCasilleros(int ancho, int alto){
        for (int i = 0; i < ancho; i++)
            for (int j = 0; j < alto; j++) {
                Posicion posicion = new Posicion(i,j);
                Casillero casillero = new Casillero(posicion);
                this.casilleros.add(casillero);
            }
    }

    public int getAlto(){
        return this.alto;
    }

    public int getAncho(){
        return this.ancho;
    }

    public ArrayList devolverCasilleros(){
        return this.casilleros;
    }

    public boolean estaVacio(){
        return casilleros.isEmpty();
    }
    /*
    public Modelo.Casillero seleccionarCasillero(Modelo.Casillero casillero){

        for (Iterator<Modelo.Casillero> iterator = casilleros.iterator(); iterator.hasNext();) {
            Modelo.Casillero casilleroActual = iterator.next();
            if( casilleroActual.esIgualA(casillero) )
                return casilleroActual;
        }

        return null;

    }*/ //El metodo esta repetido porque uno rompe el encapsulamiento pero necesita que se cree un objeto casillero
        // que nunca se va a usar solo para efectuar la comparacion y el otro rompe el encapsulamiento.

    public Casillero seleccionarCasillero(Posicion posicion){

        for (Casillero casilleroActual : casilleros) {
            if (casilleroActual.tienePosicion(posicion))
                return casilleroActual;
        }

        return null;
    }

    public void ocuparCasillero(Posicion posicion, IEntidad IEntidad){
        verificarPosicionValida(posicion);
        Casillero casillero = seleccionarCasillero(posicion);

        casillero.colocarObjeto(IEntidad);
    }

    public IEntidad desocuparCasillero(Posicion posicion){
        verificarPosicionValida(posicion);
        Casillero casillero = seleccionarCasillero(posicion);

        IEntidad IEntidad = (IEntidad) casillero.removerObjeto();
        return IEntidad;
    }


    public boolean posicionEnRango(Posicion posicion){
        return posicion.estaDentroDelMapa(this.ancho, this.alto);
    }

    public void verificarPosicionValida(Posicion posicion){
        if(!this.posicionEnRango(posicion))
            throw new PosicionFueraDelMapaException();
    }


    public void verificarPosicionDesocupada(Posicion posicion) {
        Casillero casillero = this.seleccionarCasillero(posicion);
        if( casillero.estaOcupado() )
            throw new PosicionOcupadaException();
    }


    public void verificarPosicionesAledanias(Posicion origen, Posicion destino) {
        if ( !origen.aledaniaA(destino) )
            throw new PosicionInvalidaException();

    }


    public void moverUnidadMovil( Posicion origen, Posicion destino ){
        verificarPosicionValida(destino);
        verificarPosicionesAledanias(origen, destino);
        verificarPosicionDesocupada(destino);
        IUnidadMovible unidad = (IUnidadMovible) this.desocuparCasillero(origen);
        unidad.mover(destino);
        ocuparCasillero(destino, unidad);
    }


}
