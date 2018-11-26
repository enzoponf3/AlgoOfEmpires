package Modelo.Unidades;
import Modelo.Edificios.*;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Posicion;

import java.util.ArrayList;

public interface IEstadoAldeano{

    int generaOro();

    Cuartel construirCuartel(ArrayList<Posicion> posiciones);

    PlazaCentral construirPlazaCentral(ArrayList<Posicion> posiciones);

    void repararEdificio(Edificio edificio);

    void continuarConstruccion(Edificio edificio);

    void mover(Posicion destino);

}
