import java.util.ArrayList;
import java.util.Iterator;

public class Mapa2 {

    private int ancho;
    private int alto;
    protected ArrayList<Casillero> casilleros = new ArrayList<>();

    public Mapa2(int ancho, int alto){
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
    public Casillero seleccionarCasillero(Casillero casillero){

        for (Iterator<Casillero> iterator = casilleros.iterator(); iterator.hasNext();) {
            Casillero casilleroActual = iterator.next();
            if( casilleroActual.esIgualA(casillero) )
                return casilleroActual;
        }

        return null;

    }*/ //El metodo esta repetido porque uno rompe el encapsulamiento pero necesita que se cree un objeto casillero
        // que nunca se va a usar solo para efectuar la comparacion y el otro rompe el encapsulamiento.

    public Casillero seleccionarCasillero(Posicion posicion){

        for (Iterator<Casillero> iterator = casilleros.iterator(); iterator.hasNext();) {
            Casillero casilleroActual = iterator.next();
            if( casilleroActual.tienePosicion(posicion) )
                return casilleroActual;
        }

        return null;
    }

    public void ocuparCasillero(Posicion posicion, Objeto objeto){
        verificarPosicionValida(posicion);
        Casillero casillero = seleccionarCasillero(posicion);

        try {
            casillero.colocarObjeto(objeto);
        } catch (CasilleroOcupadoException e) {
            throw e;
        }

    }

    public Objeto desocuparCasillero(Posicion posicion){
        verificarPosicionValida(posicion);
        Casillero casillero = seleccionarCasillero(posicion);

        try {
            Objeto objeto = casillero.removerObjeto();
            return objeto;
        } catch (CasilleroOcupadoException e) {
            throw e;
        }
    }


    public boolean posicionEnRango(Posicion posicion){
        return posicion.estaDentroDelMapa(this.ancho, this.alto);
    }

    public void verificarPosicionValida(Posicion posicion){
        if(!this.posicionEnRango(posicion))
            throw new PosicionFueraDelMapaException();
    }

    public void verificarPosicionDesocupada(Posicion posicion){
        Casillero casillero = this.seleccionarCasillero(posicion);
        if(casillero.estaOcupado())
            throw new PosicionOcupadaException();
    }

    /*

    public void moverUnidadMovil( Posicion origen, Posicion destino ){
        verificarPosicionValida(destino);
        verificarPosicionDesocupada(destino);
        Objeto unidad = this.desocuparCasillero(origen);
        unidad.mover(destino);
    }
*/


}
