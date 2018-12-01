package Modelo.Unidades;

import Modelo.Edificios.Edificio;
import Modelo.Posicion;

import java.util.ArrayList;

public interface IAtacante extends IUnidadMovible{

    void atacar(Unidad unidad);

    void atacar(Edificio edificio);

    void reducirVida(int danio);

    int getVida();

    boolean estaMuerto();

    boolean enRangoDeAtaque(Posicion posAtacado);

    boolean enRangoDeAtaque(ArrayList<Posicion> posiciones);

    int getDanioUnidad();

    int getDanioEdificio();

    void ocupar();

    Posicion getPosicion();

    void desocupar();
}
