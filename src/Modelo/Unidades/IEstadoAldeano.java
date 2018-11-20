package Modelo.Unidades;
import Modelo.Edificios.*;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Posicion;

import java.util.ArrayList;

public interface IEstadoAldeano{

    int generaOro();

    Cuartel construirCuartel(Aldeano aldeano, ArrayList<Posicion> posiciones);

    PlazaCentral construirPlazaCentral(Aldeano aldeano, ArrayList<Posicion> posiciones);

    void repararEdificio(Edificio edificio, Aldeano aldeano);

    void continuarConstruccion(Edificio edificio, Aldeano aldeano);

    void mover(Posicion destino, Aldeano aldeano);

}