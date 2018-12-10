package Modelo.Edificios;

import Modelo.Constantes;
import Modelo.Exceptions.EdificioDestruidoException;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;

import java.util.ArrayList;

public class PlazaCentral extends Edificio {

    private IEstadoPlazaCentral estado;

    public PlazaCentral(ArrayList<Posicion> posiciones) {
        this.vidaMax = Constantes.VIDA_PLAZA_CENTRAL;
        // Inicializo con vida negativa en funcion del reducirVida
        this.vida = 0;
        this.costo = Constantes.COSTO_PLAZA_CENTRAL;
        this.velocidadReparacion = Constantes.VELOCIDAD_REPARACION_PLAZA_CENTRAL;
        this.estado = new EstadoPlazaCentralNoConstruida(Constantes.TURNOS_CONSTRUCCION_PLAZA_CENTRAL);

        this.posiciones = posiciones;
    }

    public int getCosto() {
        return this.costo;
    }

    public Aldeano crearAldeano(Mapa mapa) {
        return this.estado.crearAldeano(mapa, this);
    }

    @Override
    public void reducirVida(int cant) {
        if (this.vida < 0)
            throw new EdificioDestruidoException();
        this.vida -= cant;
        if (this.vida <= 0) {
            this.vida -= cant; // Aseguro vida sea negativa
            this.estado = new EstadoPlazaCentralDestruida();
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

    public void finalizarConstruccion() {
        this.vida = Constantes.VIDA_PLAZA_CENTRAL;
        this.estado = new EstadoPlazaCentralConstruida();
    }

    public void enReparacion() {
        this.estado = new EstadoPlazaCentralEnReparacion();
    }

    void construida() {
        this.estado = new EstadoPlazaCentralConstruida();
    }

    @Override
    public void volverAEstadoOriginal() {
        this.estado.volverAEstadoOriginal(this);
    }

    @Override
    public boolean construccionFinalizada() {
        return (this.estado.turnosRestantes()==0);
    }

    void noConstruida(int turnosRestantes) {
        this.estado = new EstadoPlazaCentralNoConstruida(turnosRestantes);
    }

    void enConstruccion(int turnosRestantes) {
        this.estado = new EstadoPlazaCentralEnConstruccion(turnosRestantes);
    }

    @Override
    public boolean estaDestruido() {
        return this.estado.estaDestruido();
    }
}
