package Modelo.Edificios;

import Modelo.Constantes;
import Modelo.Exceptions.EdificioDestruidoException;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Cuartel extends Edificio {

    private IEstadoCuartel estado;

    public Cuartel(ArrayList<Posicion> posiciones) {
        this.vidaMax = Constantes.VIDA_CUARTEL;
        this.vida = 0;
        this.costo = Constantes.COSTO_CUARTEL;
        this.velocidadReparacion = Constantes.VELOCIDAD_REPARACION_CUARTEL;
        this.estado = new EstadoCuartelEnConstruccion(Constantes.TURNOS_CONSTRUCCION_CUARTEL);

        this.posiciones = posiciones;
    }

    public int getCosto() {
        return this.costo;
    }

    public Espadachin crearEspadachin(Mapa mapa) {
        return this.estado.crearEspadachin(mapa, this);
    }

    public Arquero crearArquero(Mapa mapa) {
        return this.estado.crearArquero(mapa, this);
    }

    @Override
    public void reducirVida(int cant) {
        if (this.vida < 0)
            throw new EdificioDestruidoException();
        this.vida -= cant;
        if (this.vida <= 0) {
            this.vida -= cant; // Aseguro vida sea negativa
            this.estado = new EstadoCuartelDestruido();
        }
    }

    @Override
    public void reparar() {
        this.estado.reparar(this);
    }

    @Override
    public void construir() {
        this.estado.construir(this);
    }

    void enConstruccion(int turnosRestantes) {
        this.estado = new EstadoCuartelEnConstruccion(turnosRestantes);
    }

    void noConstruido(int turnosRestantes) {
        this.estado = new EstadoCuartelNoConstruido(turnosRestantes);
    }

    public void finalizarConstruccion() {
        this.vida = Constantes.VIDA_CUARTEL;
        this.estado = new EstadoCuartelConstruido();
    }

    void construido() {
        this.estado = new EstadoCuartelConstruido();
    }

    public void enReparacion() {
        this.estado = new EstadoCuartelEnReparacion();
    }

    @Override
    public void volverAEstadoOriginal() {
        this.estado.volverAEstadoOriginal(this);
    }


    @Override
    public boolean estaDestruido() {
        return this.estado.estaDestruido();
    }

}
