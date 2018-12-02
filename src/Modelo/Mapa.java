package Modelo;

import Modelo.Edificios.Castillo;
import Modelo.Edificios.Edificio;
import Modelo.Exceptions.*;
import Modelo.Unidades.IUnidadMovible;
import Modelo.Unidades.Unidad;

import java.util.ArrayList;

public class Mapa {

    private static Mapa INSTANCIA;

    private int ancho;
    private int alto;
    protected ArrayList<Casillero> casilleros = new ArrayList<>();

    public Mapa(int ancho, int alto){
        verificarDimensionesCorrectas(ancho, alto);
        this.ancho = ancho;
        this.alto = alto;
        this.inicializarCasilleros(ancho, alto);

        INSTANCIA = this;
    } 

    public static Mapa getInstancia(){
        return INSTANCIA;
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

    public IEntidad obtenerEntidad(Posicion posicion) {
        verificarPosicionValida(posicion);
        Casillero casillero = seleccionarCasillero(posicion);
        IEntidad IEntidad = (IEntidad) casillero.obtenerObjeto();
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

    public void mover(Posicion origen, Posicion destino ){
        verificarPosicionValida(destino);
        verificarPosicionesAledanias(origen, destino);
        verificarPosicionDesocupada(destino);
        ocuparCasillero(destino, this.desocuparCasillero(origen));
    }

    public Posicion devolverPosicionAledaniaLibre(Edificio edificio) {
        ArrayList<Posicion> posicionesEdificio = edificio.getPosiciones();
        for (Posicion posicion : posicionesEdificio) {
            ArrayList<Posicion> posicionesAledanias = this.getPosicionesAledanias(posicion);
            for (Posicion posicionAledania : posicionesAledanias) {
                Casillero casillero = this.seleccionarCasillero(posicionAledania);
                if (!casillero.estaOcupado())
                    return posicionAledania;
            }
        }
        throw new PosicionesAledaniasOcupadasException();
    }

    public ArrayList<Posicion> getPosicionesAledanias(Posicion posicion) {
        ArrayList<Posicion> posicionesAledanias = new ArrayList<>();
        for (Casillero casillero : this.casilleros) {
            Posicion posicionCasillero = casillero.getPosicion();
            if ((posicionCasillero.aledaniaA(posicion)) & (!posicionCasillero.igualA(posicion)))
                posicionesAledanias.add(posicionCasillero);
        }
        return posicionesAledanias;
    }

    public void ocuparCasilleros(ArrayList<Posicion> posiciones, Edificio edificio) {
        for (Posicion posicion : posiciones)
            this.ocuparCasillero(posicion,edificio);
    }

    public void desocuparCasilleros(ArrayList<Posicion> posiciones) {
        for (Posicion posicion : posiciones)
            this.desocuparCasillero(posicion);
    }
}
