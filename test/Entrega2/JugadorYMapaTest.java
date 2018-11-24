package Entrega2;

import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import javafx.geometry.Pos;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.ListIterator;

public class JugadorYMapaTest {

    @Test
    public void posicionarCorrectamenteAldeanosIniciales() {
        Mapa mapa = new Mapa(7,5);
        Jugador jugador = new Jugador(mapa,0,4);
        Posicion posicionPosible1 = new Posicion(6,0);
        Posicion posicionPosible2 = new Posicion(6,1);
        Posicion posicionPosible3 = new Posicion(6,2);
        Posicion posicionPosible4 = new Posicion(5,2);
        Posicion posicionPosible5 = new Posicion(4,2);
        ArrayList<Posicion> posicionesPosibles = new ArrayList<>();
        posicionesPosibles.add(posicionPosible1);
        posicionesPosibles.add(posicionPosible2);
        posicionesPosibles.add(posicionPosible3);
        posicionesPosibles.add(posicionPosible4);
        posicionesPosibles.add(posicionPosible5);
        ArrayList<Aldeano> aldeanos = jugador.getAldeanos();
        int aldeanosBienPosicionados = 0;
        ListIterator<Posicion> iter = posicionesPosibles.listIterator();
        for (Aldeano aldeano : aldeanos) {
            Posicion posicionAldeano = aldeano.getPosicion();
            while (iter.hasNext()) {
                Posicion posicionPosible = iter.next();
                if (posicionAldeano.igualA(posicionPosible)) {
                    aldeanosBienPosicionados += 1;
                    posicionesPosibles.remove(posicionPosible);
                    break;
                }
            }
            iter = posicionesPosibles.listIterator();
        }
        Assert.assertEquals(aldeanosBienPosicionados,3);
    }
}
