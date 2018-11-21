package Entrega2;

import Modelo.Exceptions.EdificioPropioException;
import Modelo.Exceptions.TurnoDelOponenteException;
import Modelo.Exceptions.UnidadPropiaException;
import Modelo.Jugador;
import Modelo.Posicion;
import Modelo.Unidades.*;
import Modelo.Edificios.*;
import org.junit.Assert;
import org.junit.Test;
import sun.net.www.protocol.http.HttpURLConnection;

import java.util.ArrayList;

public class Jugador1YJugador2ataqueTest {

    @Test
    public void crearDosJugadoresOponentesCorrectamente(){
        Jugador jugador1 = new Jugador(5, 14);
        Jugador jugador2 = new Jugador(41, 35);

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Assert.assertEquals(jugador2, jugador1.getOponente());
        Assert.assertEquals(jugador1, jugador2.getOponente());
    }

    //Atacar al oponente: jugador1 ataca a jugador2
    //Supuesto: No va a haber ninguna unidad creada fuera de los jugadores, por lo cual probar que es enemigo es
                //equivalente a probar que no pertenece a dicho jugador.

    //Arquero propio

    //Ataca a todas las unidades enemigas posibles en el turno propio

    @Test
    public void arqueroPropioAtacaAldeanoEnemigoEnTurnoPropio(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Posicion posicionAldeano = new Posicion(3, 3);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeano);

        jugador1.atacar(arquero, aldeanoEnemigo);

        Assert.assertEquals(35, aldeanoEnemigo.getVida() );
    }

    @Test
    public void arqueroPropioAtacaArqueroEnemigoEnTurnoPropio(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Posicion posicionArqueroEnemigo = new Posicion(3, 3);
        Arquero arqueroEnemigo = new Arquero(posicionArqueroEnemigo);

        jugador1.atacar(arquero, arqueroEnemigo);

        Assert.assertEquals(60, arqueroEnemigo.getVida() );
    }

    @Test
    public void arqueroPropioAtacaEspadachinEnemigoEnTurnoPropio(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Posicion posicionEspadachinEnemigo = new Posicion(3, 3);
        Espadachin espadachinEnemigo = new Espadachin(posicionEspadachinEnemigo);

        jugador1.atacar(arquero, espadachinEnemigo);

        Assert.assertEquals(85, espadachinEnemigo.getVida() );
    }

    @Test
    public void arqueroPropioAtacaArmaDeAsedioEnemigoEnTurnoPropio(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Posicion posicionArmaDeAsedioEnemiga = new Posicion(3, 3);
        ArmaDeAsedio armaDeAsedioEnemiga = new ArmaDeAsedio(posicionArmaDeAsedioEnemiga);

        jugador1.atacar(arquero, armaDeAsedioEnemiga);

        Assert.assertEquals(135, armaDeAsedioEnemiga.getVida() );
    }

    //Ataca edificios enemigos en turno propio

    @Test
    public void arqueroPropioCuartelEnemigoEnTurnoPropio(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(2,2);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i=5; i<7 ;i++){
            for(int j=5 ; j<7 ; j++) {
                Posicion posicion = new Posicion(i, j);
                posiciones.add(posicion);
            }
        }
        Cuartel cuartelEnemigo = new Cuartel(posiciones);
        cuartelEnemigo.finalizarConstruccion();
        jugador2.agregarEdificio(cuartelEnemigo);

        jugador1.atacar(arquero, cuartelEnemigo);

        Assert.assertEquals(240, cuartelEnemigo.getVida() );
    }

    @Test
    public void arqueroPropioPlazaCentralEnemigoEnTurnoPropio(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(2,2);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i=5; i<7 ;i++){
            for(int j=5 ; j<7 ; j++) {
                Posicion posicion = new Posicion(i, j);
                posiciones.add(posicion);
            }
        }
        PlazaCentral plazaCentralEnemiga = new PlazaCentral(posiciones);
        plazaCentralEnemiga.finalizarConstruccion();
        jugador2.agregarEdificio(plazaCentralEnemiga);

        jugador1.atacar(arquero, plazaCentralEnemiga);

        Assert.assertEquals(440, plazaCentralEnemiga.getVida() );
    }

    @Test
    public void arqueroPropioCastilloEnemigoEnTurnoPropio(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(40,40);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Castillo castilloEnemigo = jugador2.getCastillo();

        jugador1.atacar(arquero, castilloEnemigo);

        Assert.assertEquals(990, castilloEnemigo.getVida() );
    }

    //Ataca a todas las unidades enemigas posibles en el turno del oponente

    @Test (expected = TurnoDelOponenteException.class)
    public void arqueroPropioAtacaAldeanoEnemigoEnTurnoDelOponente(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.inactivar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.activar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Posicion posicionAldeano = new Posicion(3, 3);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeano);

        jugador1.atacar(arquero, aldeanoEnemigo);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void arqueroPropioAtacaArqueroEnemigoEnTurnoDelOponente(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.inactivar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.activar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Posicion posicionArqueroEnemigo = new Posicion(3, 3);
        Arquero arqueroEnemigo = new Arquero(posicionArqueroEnemigo);

        jugador1.atacar(arquero, arqueroEnemigo);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void arqueroPropioAtacaEspadachinEnemigoEnTurnoDelOponente(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.inactivar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.activar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Posicion posicionEspadachinEnemigo = new Posicion(3, 3);
        Espadachin espadachinEnemigo = new Espadachin(posicionEspadachinEnemigo);

        jugador1.atacar(arquero, espadachinEnemigo);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void arqueroPropioAtacaArmaDeAsedioEnemigoEnTurnoDelOponente(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.inactivar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.activar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Posicion posicionArmaDeAsedioEnemiga = new Posicion(3, 3);
        ArmaDeAsedio armaDeAsedioEnemiga = new ArmaDeAsedio(posicionArmaDeAsedioEnemiga);

        jugador1.atacar(arquero, armaDeAsedioEnemiga);
    }

    //Ataca edificios enemigos en turno del oponente

    @Test (expected = TurnoDelOponenteException.class)
    public void arqueroPropioCuartelEnemigoEnTurnoDelOponente(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.inactivar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.activar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(2,2);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i=5; i<7 ;i++){
            for(int j=5 ; j<7 ; j++) {
                Posicion posicion = new Posicion(i, j);
                posiciones.add(posicion);
            }
        }
        Cuartel cuartelEnemigo = new Cuartel(posiciones);
        cuartelEnemigo.finalizarConstruccion();
        jugador2.agregarEdificio(cuartelEnemigo);

        jugador1.atacar(arquero, cuartelEnemigo);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void arqueroPropioPlazaCentralEnemigoEnTurnoDelOponente(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.inactivar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.activar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(2,2);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i=5; i<7 ;i++){
            for(int j=5 ; j<7 ; j++) {
                Posicion posicion = new Posicion(i, j);
                posiciones.add(posicion);
            }
        }
        PlazaCentral plazaCentralEnemiga = new PlazaCentral(posiciones);
        plazaCentralEnemiga.finalizarConstruccion();
        jugador2.agregarEdificio(plazaCentralEnemiga);

        jugador1.atacar(arquero, plazaCentralEnemiga);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void arqueroPropioCastilloEnemigoEnTurnoDelOponente(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.inactivar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.activar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(40,40);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Castillo castilloEnemigo = jugador2.getCastillo();

        jugador1.atacar(arquero, castilloEnemigo);
    }

    //Intenta atacar unidades aliadas

    @Test (expected = UnidadPropiaException.class)
    public void arqueroPropioAtacaAldeanoPropioEnTurnoPropio(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Posicion posicionAldeano = new Posicion(3, 3);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador1.agregarAldeano(aldeano);

        jugador1.atacar(arquero, aldeano);
    }

    @Test (expected = UnidadPropiaException.class)
    public void arqueroPropioAtacaArqueroPropioEnTurnoPropio(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Posicion posicionArquero2 = new Posicion(3, 3);
        Arquero arquero2 = new Arquero(posicionArquero2);
        jugador1.agregarAEjercito(arquero2);

        jugador1.atacar(arquero, arquero);
    }

    @Test (expected = UnidadPropiaException.class)
    public void arqueroPropioAtacaEspadachinPropioEnTurnoPropio(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Posicion posicionEspadachin = new Posicion(3, 3);
        Espadachin espadachin = new Espadachin(posicionEspadachin);
        jugador1.agregarAEjercito(espadachin);

        jugador1.atacar(arquero, espadachin);
    }

    @Test (expected = UnidadPropiaException.class)
    public void arqueroPropioAtacaArmaDeAsedioPropiaEnTurnoPropio(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Posicion posicionArmaDeAsedio = new Posicion(3, 3);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);
        jugador1.agregarAEjercito(armaDeAsedio);

        jugador1.atacar(arquero, armaDeAsedio);
    }

    //Ataca edificios enemigos en turno propio

    @Test (expected = EdificioPropioException.class)
    public void arqueroPropioCuartelPropioEnTurnoPropio(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(2,2);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i=5; i<7 ;i++){
            for(int j=5 ; j<7 ; j++) {
                Posicion posicion = new Posicion(i, j);
                posiciones.add(posicion);
            }
        }
        Cuartel cuartel = new Cuartel(posiciones);
        cuartel.finalizarConstruccion();
        jugador1.agregarEdificio(cuartel);

        jugador1.atacar(arquero, cuartel);
    }

    @Test (expected = EdificioPropioException.class)
    public void arqueroPropioPlazaCentralPropioEnTurnoPropio(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(2,2);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i=5; i<7 ;i++){
            for(int j=5 ; j<7 ; j++) {
                Posicion posicion = new Posicion(i, j);
                posiciones.add(posicion);
            }
        }
        PlazaCentral plazaCentral = new PlazaCentral(posiciones);
        plazaCentral.finalizarConstruccion();
        jugador1.agregarEdificio(plazaCentral);

        jugador1.atacar(arquero, plazaCentral);
    }

    @Test (expected = EdificioPropioException.class)
    public void arqueroPropioCastilloPropioEnTurnoPropio(){
        Jugador jugador1 = new Jugador(5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(2,2);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero);

        Castillo castillo = jugador1.getCastillo();

        jugador1.atacar(arquero, castillo);

        Assert.assertEquals(990, castillo.getVida() );
    }



}
