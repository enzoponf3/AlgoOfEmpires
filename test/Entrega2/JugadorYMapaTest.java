package Entrega2;

import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.AldeanoNoExisteException;
import Modelo.Exceptions.AtacanteNoExisteException;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import Modelo.Unidades.ArmaDeAsedio;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;
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
    //Devolver una entidad

    @Test
    public void devolverAldeanoEnPosicionCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion = new Posicion(2,5);
        Aldeano aldeano = new Aldeano(posicion);

        jugador.agregarAldeano(aldeano, mapa);
        Aldeano aldeanoAComparar = (Aldeano) mapa.obtenerEntidad(posicion);

        Assert.assertEquals( aldeano, aldeanoAComparar );
    }

    @Test
    public void devolverArqueroEnPosicionCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion = new Posicion(2,5);
        Arquero arquero = new Arquero(posicion);

        jugador.agregarAEjercito(arquero, mapa);
        Arquero arqueroAComparar = (Arquero) mapa.obtenerEntidad(posicion);

        Assert.assertEquals( arquero, arqueroAComparar );
    }

    @Test
    public void devolverEspadachinEnPosicionCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion = new Posicion(2,5);
        Espadachin espadachin = new Espadachin(posicion);
        jugador.agregarAEjercito(espadachin, mapa);
        Espadachin espadachinAComprar = (Espadachin) mapa.obtenerEntidad(posicion);

        Assert.assertEquals( espadachin, espadachinAComprar);
    }

    @Test
    public void devolverArmaDeAsedioEnPosicionCorrectamente() {
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion = new Posicion(2, 5);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion);

        jugador.agregarAEjercito(armaDeAsedio, mapa);
        ArmaDeAsedio armaDeAsedioAComparar = (ArmaDeAsedio) mapa.obtenerEntidad(posicion);

        Assert.assertEquals(armaDeAsedio, armaDeAsedioAComparar);
    }

    //Edificios

    @Test
    public void devolverPlazaCentralEnPosicionCorrectamente(){
        Mapa mapa = new Mapa(50,50);
        Jugador jugador = new Jugador(mapa,5,14);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(2,3);
        Posicion posicion2 = new Posicion(2,4);
        Posicion posicion3 = new Posicion(3,3);
        Posicion posicion4 = new Posicion(3,4);
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plazaCentral = new PlazaCentral(posiciones);
        jugador.agregarEdificio(plazaCentral,mapa);
        PlazaCentral plaza = (PlazaCentral) mapa.obtenerEntidad(posicion1);
        Assert.assertEquals(plazaCentral, plaza);
    }

}
