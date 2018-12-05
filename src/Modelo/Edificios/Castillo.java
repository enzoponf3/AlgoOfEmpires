package Modelo.Edificios;

import Modelo.Exceptions.EdificioDestruidoException;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import Modelo.Unidades.ArmaDeAsedio;
import Modelo.Unidades.IAtacante;
import Modelo.Unidades.Unidad;
import Modelo.Constantes;
import java.util.ArrayList;

public class Castillo extends Edificio {




    private int danio;
    private IEstadoCastillo estado;

    public Castillo(ArrayList<Posicion> posiciones) {
        this.vidaMax = Constantes.VIDA_CASTILLO;
        this.vida = Constantes.VIDA_CASTILLO;
        this.velocidadReparacion = Constantes.VELOCIDAD_REPARACION_CASTILLO;
        this.danio = Constantes.DANIO_CASTILLO;
        this.estado = new EstadoCastilloConstruido();

        this.posiciones = posiciones;
    }

    @Override
    public void reducirVida(int cant) {
        if (this.vida <= 0)
            throw new EdificioDestruidoException();
        this.vida -= cant;
        if (this.vida <= 0)
            this.estado = new EstadoCastilloDestruido();
    }

    public ArmaDeAsedio crearArmaDeAsedio(Mapa mapa) {
        return this.estado.crearArmaDeAsedio(mapa, this);
    }

    @Override
    public void reparar() {
        this.estado.reparar(this);
    }

    public void enReparacion() {
        this.estado = new EstadoCastilloEnReparacion();
    }

    @Override
    public void volverAEstadoOriginal() {
        this.estado.volverAEstadoOriginal(this);
    }

    void construido() {
        this.estado = new EstadoCastilloConstruido();
    }

    private boolean estaEnRango(Edificio edificio) {
        ArrayList<Posicion> posicionesOtroEdificio = edificio.getPosiciones();
        for (Posicion posicion : this.posiciones) {
            for (Posicion posicionOtroEdificio : posicionesOtroEdificio) {
                if (posicion.estaEnRango(posicionOtroEdificio, Constantes.DISTANCIA_MAXIMA_ATAQUE_CASTILLO))
                    return true;
            }
        }
        return false;
    }

    private boolean estaEnRango(Unidad unidad) {
        Posicion posicionUnidad = unidad.getPosicion();
        for (Posicion posicion : this.posiciones) {
            if (posicion.estaEnRango(posicionUnidad, Constantes.DISTANCIA_MAXIMA_ATAQUE_CASTILLO))
                    return true;
        }
        return false;
    }

    public void atacarEdificios(ArrayList<Edificio> edificios) {
        for (Edificio edificio : edificios) {
            if (this.estaEnRango(edificio))
               edificio.reducirVida(this.danio);
        }
    }

    public void atacarUnidades(ArrayList<Aldeano> aldeanos, ArrayList<IAtacante> atacantes) {
        for (Aldeano aldeano : aldeanos) {
            if (this.estaEnRango(aldeano))
                aldeano.reducirVida(this.danio);
        }
        for(IAtacante atacante : atacantes){
            if(this.estaEnRango((Unidad) atacante))
                atacante.reducirVida(this.danio);
        }
    }

    public void autodestruir() {
        this.vida = 0;
    }
}
