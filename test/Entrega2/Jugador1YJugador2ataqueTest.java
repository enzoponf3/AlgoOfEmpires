package Entrega2;

import Modelo.Exceptions.*;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.*;
import Modelo.Edificios.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class Jugador1YJugador2ataqueTest {

    @Test
    public void crearDosJugadoresOponentesCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        Jugador jugador2 = new Jugador(mapa, 41, 35);

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
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        Posicion posicionAldeano = new Posicion(3, 3);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeano);

        jugador1.atacar(arquero, aldeanoEnemigo);

        Assert.assertEquals(35, aldeanoEnemigo.getVida() );
    }

    @Test
    public void arqueroPropioAtacaArqueroEnemigoEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        Posicion posicionArqueroEnemigo = new Posicion(3, 3);
        Arquero arqueroEnemigo = new Arquero(posicionArqueroEnemigo);

        jugador1.atacar(arquero, arqueroEnemigo);

        Assert.assertEquals(60, arqueroEnemigo.getVida() );
    }

    @Test
    public void arqueroPropioAtacaEspadachinEnemigoEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);

        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        Posicion posicionEspadachinEnemigo = new Posicion(3, 3);
        Espadachin espadachinEnemigo = new Espadachin(posicionEspadachinEnemigo);

        jugador1.atacar(arquero, espadachinEnemigo);

        Assert.assertEquals(85, espadachinEnemigo.getVida() );
    }

    @Test
    public void arqueroPropioAtacaArmaDeAsedioEnemigoEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        Posicion posicionArmaDeAsedioEnemiga = new Posicion(3, 3);
        ArmaDeAsedio armaDeAsedioEnemiga = new ArmaDeAsedio(posicionArmaDeAsedioEnemiga);

        jugador1.atacar(arquero, armaDeAsedioEnemiga);

        Assert.assertEquals(135, armaDeAsedioEnemiga.getVida() );
    }

    //Ataca edificios enemigos en turno propio

    @Test
    public void arqueroPropioCuartelEnemigoEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(19,19);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i=20; i<22 ;i++){
            for(int j=20 ; j<22 ; j++) {
                Posicion posicion = new Posicion(i, j);
                posiciones.add(posicion);
            }
        }
        Cuartel cuartelEnemigo = new Cuartel(posiciones);
        cuartelEnemigo.finalizarConstruccion();
        jugador2.agregarEdificio(cuartelEnemigo, mapa);

        jugador1.atacar(arquero, cuartelEnemigo);

        Assert.assertEquals(240, cuartelEnemigo.getVida() );
    }

    @Test
    public void arqueroPropioPlazaCentralEnemigoEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(19,19);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i=20; i<22 ;i++){
            for(int j=20 ; j<22 ; j++) {
                Posicion posicion = new Posicion(i, j);
                posiciones.add(posicion);
            }
        }
        PlazaCentral plazaCentralEnemiga = new PlazaCentral(posiciones);
        plazaCentralEnemiga.finalizarConstruccion();
        jugador2.agregarEdificio(plazaCentralEnemiga,mapa);

        jugador1.atacar(arquero, plazaCentralEnemiga);

        Assert.assertEquals(440, plazaCentralEnemiga.getVida() );
    }

    @Test
    public void arqueroPropioCastilloEnemigoEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(40,19);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero,mapa);

        Castillo castilloEnemigo = jugador2.getCastillo();

        jugador1.atacar(arquero, castilloEnemigo);

        Assert.assertEquals(990, castilloEnemigo.getVida() );
    }

    //Ataca a todas las unidades enemigas posibles en el turno del oponente

    @Test (expected = TurnoDelOponenteException.class)
    public void arqueroPropioAtacaAldeanoEnemigoEnTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.inactivar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.activar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        Posicion posicionAldeano = new Posicion(3, 3);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeano);

        jugador1.atacar(arquero, aldeanoEnemigo);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void arqueroPropioAtacaArqueroEnemigoEnTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.inactivar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.activar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        Posicion posicionArqueroEnemigo = new Posicion(3, 3);
        Arquero arqueroEnemigo = new Arquero(posicionArqueroEnemigo);

        jugador1.atacar(arquero, arqueroEnemigo);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void arqueroPropioAtacaEspadachinEnemigoEnTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.inactivar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.activar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        Posicion posicionEspadachinEnemigo = new Posicion(3, 3);
        Espadachin espadachinEnemigo = new Espadachin(posicionEspadachinEnemigo);

        jugador1.atacar(arquero, espadachinEnemigo);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void arqueroPropioAtacaArmaDeAsedioEnemigoEnTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.inactivar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.activar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        Posicion posicionArmaDeAsedioEnemiga = new Posicion(3, 3);
        ArmaDeAsedio armaDeAsedioEnemiga = new ArmaDeAsedio(posicionArmaDeAsedioEnemiga);

        jugador1.atacar(arquero, armaDeAsedioEnemiga);
    }

    //Ataca edificios enemigos en turno del oponente

    @Test (expected = TurnoDelOponenteException.class)
    public void arqueroPropioCuartelEnemigoEnTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.inactivar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.activar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(19,19);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i=20; i<22 ;i++){
            for(int j=20 ; j<22 ; j++) {
                Posicion posicion = new Posicion(i, j);
                posiciones.add(posicion);
            }
        }
        Cuartel cuartelEnemigo = new Cuartel(posiciones);
        cuartelEnemigo.finalizarConstruccion();
        jugador2.agregarEdificio(cuartelEnemigo, mapa);

        jugador1.atacar(arquero, cuartelEnemigo);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void arqueroPropioPlazaCentralEnemigoEnTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.inactivar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.activar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(19,19);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i=20; i<22 ;i++){
            for(int j=22 ; j<20 ; j++) {
                Posicion posicion = new Posicion(i, j);
                posiciones.add(posicion);
            }
        }
        PlazaCentral plazaCentralEnemiga = new PlazaCentral(posiciones);
        plazaCentralEnemiga.finalizarConstruccion();
        jugador2.agregarEdificio(plazaCentralEnemiga, mapa);

        jugador1.atacar(arquero, plazaCentralEnemiga);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void arqueroPropioCastilloEnemigoEnTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.inactivar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.activar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(40,40);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        Castillo castilloEnemigo = jugador2.getCastillo();

        jugador1.atacar(arquero, castilloEnemigo);
    }

    //Intenta atacar unidades aliadas

    @Test (expected = UnidadPropiaException.class)
    public void arqueroPropioAtacaAldeanoPropioEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        Posicion posicionAldeano = new Posicion(3, 3);
        Aldeano aldeano = new Aldeano(posicionAldeano);
        jugador1.agregarAldeano(aldeano, mapa);

        jugador1.atacar(arquero, aldeano);
    }

    @Test (expected = UnidadPropiaException.class)
    public void arqueroPropioAtacaArqueroPropioEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        Posicion posicionArquero2 = new Posicion(3, 3);
        Arquero arquero2 = new Arquero(posicionArquero2);
        jugador1.agregarAEjercito(arquero2, mapa);

        jugador1.atacar(arquero, arquero);
    }

    @Test (expected = UnidadPropiaException.class)
    public void arqueroPropioAtacaEspadachinPropioEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        Posicion posicionEspadachin = new Posicion(3, 3);
        Espadachin espadachin = new Espadachin(posicionEspadachin);
        jugador1.agregarAEjercito(espadachin, mapa);

        jugador1.atacar(arquero, espadachin);
    }

    @Test (expected = UnidadPropiaException.class)
    public void arqueroPropioAtacaArmaDeAsedioPropiaEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa,41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(1,1);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        Posicion posicionArmaDeAsedio = new Posicion(3, 3);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);
        jugador1.agregarAEjercito(armaDeAsedio, mapa);

        jugador1.atacar(arquero, armaDeAsedio);
    }

    //Ataca edificios enemigos en turno propio

    @Test (expected = EdificioPropioException.class)
    public void arqueroPropioCuartelPropioEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(19,19);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i=20; i<22 ;i++){
            for(int j=20 ; j<22 ; j++) {
                Posicion posicion = new Posicion(i, j);
                posiciones.add(posicion);
            }
        }
        Cuartel cuartel = new Cuartel(posiciones);
        cuartel.finalizarConstruccion();
        jugador1.agregarEdificio(cuartel, mapa);

        jugador1.atacar(arquero, cuartel);
    }

    @Test (expected = EdificioPropioException.class)
    public void arqueroPropioPlazaCentralPropioEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(19,19);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        for(int i=20; i<22 ;i++){
            for(int j=20 ; j<22 ; j++) {
                Posicion posicion = new Posicion(i, j);
                posiciones.add(posicion);
            }
        }
        PlazaCentral plazaCentral = new PlazaCentral(posiciones);
        plazaCentral.finalizarConstruccion();
        jugador1.agregarEdificio(plazaCentral, mapa);

        jugador1.atacar(arquero, plazaCentral);
    }

    @Test (expected = EdificioPropioException.class)
    public void arqueroPropioCastilloPropioEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArquero = new Posicion(2,2);
        Arquero arquero = new Arquero(posicionArquero);
        jugador1.agregarAEjercito(arquero, mapa);

        Castillo castillo = jugador1.getCastillo();

        jugador1.atacar(arquero, castillo);

        Assert.assertEquals(990, castillo.getVida() );
    }


    //Arma de asedio propia ataca

    //Ataca un edificio

    @Test
    public void armaDeAsedioMontadaPropiaAtacaEdificioEnemigoEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArmaDeAsedio = new Posicion(38,18);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);
        jugador1.agregarAEjercito(armaDeAsedio, mapa);

        Castillo castilloEnemigo = jugador2.getCastillo();

        jugador1.montarArmaDeAsedio(armaDeAsedio);
        armaDeAsedio.desocupar();
        jugador1.atacar(armaDeAsedio, castilloEnemigo);

        Assert.assertEquals(925, castilloEnemigo.getVida() );
    }

    @Test (expected = UnidadDesarmadaException.class)
    public void armaDeAsedioDesmontadaPropiaAtacaEdificioEnemigoEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArmaDeAsedio = new Posicion(38,38);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);
        jugador1.agregarAEjercito(armaDeAsedio, mapa);

        Castillo castilloEnemigo = jugador2.getCastillo();

        jugador1.atacar(armaDeAsedio, castilloEnemigo);
    }

    @Test (expected = EdificioPropioException.class)
    public void armaDeAsedioMontadaPropiaAtacaEdificioPropioEnTurnoPropio(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArmaDeAsedio = new Posicion(2,2);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);
        jugador1.agregarAEjercito(armaDeAsedio, mapa);

        Castillo castillo = jugador1.getCastillo();

        jugador1.atacar(armaDeAsedio, castillo);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void armaDeAsedioMontadaPropiaAtacaEdificioEnemigoEnTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.inactivar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.activar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArmaDeAsedio = new Posicion(38,38);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);
        jugador1.agregarAEjercito(armaDeAsedio, mapa);

        Castillo castilloEnemigo = jugador2.getCastillo();

        jugador1.montarArmaDeAsedio(armaDeAsedio);
        armaDeAsedio.desocupar();
        jugador1.atacar(armaDeAsedio, castilloEnemigo);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void armaDeAsedioMontadaPropiaAtacaEdificioPropioEnTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.inactivar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.activar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicionArmaDeAsedio = new Posicion(2, 2);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);
        jugador1.agregarAEjercito(armaDeAsedio, mapa);

        Castillo castilloEnemigo = jugador1.getCastillo();

        jugador1.montarArmaDeAsedio(armaDeAsedio);
        armaDeAsedio.desocupar();
        jugador1.atacar(armaDeAsedio, castilloEnemigo);
    }

    @Test
    public void castilloJugadorAtacaUnidadesEnemigas(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Aldeano aldeano = new Aldeano(new Posicion(2,2));
        Espadachin espadachin = new Espadachin(new Posicion(2,3));
        Arquero arquero = new Arquero(new Posicion(3,2));
        ArmaDeAsedio arma = new ArmaDeAsedio(new Posicion(3,3));
        jugador2.agregarAldeano(aldeano, mapa);
        jugador2.agregarAEjercito(espadachin, mapa);
        jugador2.agregarAEjercito(arquero, mapa);
        jugador2.agregarAEjercito(arma, mapa);

        ArrayList <Aldeano> aldeanosJug2 = jugador2.getAldeanos();
        ArrayList <IAtacante> ejercitoJug2 = jugador2.getEjercito();
        ArrayList <Edificio> edificiosJug2 = jugador2.getEdificios();
        jugador1.castilloAtacar(aldeanosJug2,edificiosJug2,ejercitoJug2);
        Assert.assertEquals(30,aldeano.getVida());
        Assert.assertEquals(80,espadachin.getVida());
        Assert.assertEquals(55,arquero.getVida());
        Assert.assertEquals(130,arma.getVida());
    }

    @Test
    public void castilloJugadorAtacaEdificiosEnemigos(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.inactivar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.activar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicion1 = new Posicion(39, 19);
        Posicion posicion2 = new Posicion(39, 18);
        Posicion posicion3 = new Posicion(38, 19);
        Posicion posicion4 = new Posicion(38, 18);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = new PlazaCentral(posiciones);
        plaza.finalizarConstruccion();

        Posicion posicion5 = new Posicion(39, 17);
        Posicion posicion6 = new Posicion(39, 16);
        Posicion posicion7 = new Posicion(38, 17);
        Posicion posicion8 = new Posicion(38, 16);
        ArrayList<Posicion> posiciones2 = new ArrayList<>();
        posiciones2.add(posicion5);
        posiciones2.add(posicion6);
        posiciones2.add(posicion7);
        posiciones2.add(posicion8);
        Cuartel cuartel = new Cuartel(posiciones2);
        cuartel.finalizarConstruccion();

        jugador1.agregarEdificio(cuartel,mapa);
        jugador1.agregarEdificio(plaza,mapa);

        ArrayList <Aldeano> aldeanosJug1 = jugador1.getAldeanos();
        ArrayList <IAtacante> ejercitoJug1 = jugador1.getEjercito();
        ArrayList <Edificio> edificiosJug1 = jugador1.getEdificios();
        jugador2.castilloAtacar(aldeanosJug1,edificiosJug1,ejercitoJug1);

        Assert.assertEquals(430,plaza.getVida());
        Assert.assertEquals(230,cuartel.getVida());
    }

    @Test
    public void castilloJugadorNoAtacaUnidadYEdificioFueraDerango(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);
        Aldeano aldeano = new Aldeano(new Posicion(20,20));

        Posicion posicion1 = new Posicion(40, 40);
        Posicion posicion2 = new Posicion(39, 40);
        Posicion posicion3 = new Posicion(39, 39);
        Posicion posicion4 = new Posicion(40, 39);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = new PlazaCentral(posiciones);
        plaza.finalizarConstruccion();

        jugador2.agregarAldeano(aldeano, mapa);
        jugador2.agregarEdificio(plaza, mapa);

        ArrayList <Aldeano> aldeanosJug2 = jugador2.getAldeanos();
        ArrayList <IAtacante> ejercitoJug2 = jugador2.getEjercito();
        ArrayList <Edificio> edificiosJug2 = jugador2.getEdificios();
        jugador1.castilloAtacar(aldeanosJug2,edificiosJug2,ejercitoJug2);

        Assert.assertEquals(50, aldeano.getVida());
        Assert.assertEquals(450, plaza.getVida());
    }

    @Test
    public void limpiarUnidadMuertaPorAtaque(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicion = new Posicion(20,20);
        Aldeano aldeano = new Aldeano(posicion);
        aldeano.reducirVida(49);

        Espadachin espadachin = new Espadachin(new Posicion(21,20));

        jugador1.agregarAEjercito(espadachin, mapa);
        jugador2.agregarAldeano(aldeano, mapa);

        jugador1.atacar(espadachin,aldeano);

        jugador2.limpiarEntidadesMuertas(mapa);

        Assert.assertEquals(jugador2.getAldeanos().size(),3);
    }

    @Test
    public void limpiarAtacanteMuertoPorAtaque(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicion = new Posicion(20,20);
        Espadachin espadachin = new Espadachin(posicion);
        espadachin.reducirVida(90);

        Arquero arquero = new Arquero(new Posicion(22,20));

        jugador1.agregarAEjercito(arquero, mapa);
        jugador2.agregarAEjercito(espadachin, mapa);

        jugador1.atacar(arquero,espadachin);

        jugador2.limpiarEntidadesMuertas(mapa);
        Assert.assertEquals(jugador2.getEjercito().size(),0);
    }



    @Test
    public void limpiarEdificioExplotadoPorAtaque(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador1 = new Jugador(mapa, 5, 14);
        jugador1.activar();
        Jugador jugador2 = new Jugador(mapa, 41, 35);
        jugador2.inactivar();

        jugador1.setOponente(jugador2);
        jugador2.setOponente(jugador1);

        Posicion posicion1 = new Posicion(40, 40);
        Posicion posicion2 = new Posicion(39, 40);
        Posicion posicion3 = new Posicion(39, 39);
        Posicion posicion4 = new Posicion(40, 39);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = new PlazaCentral(posiciones);
        plaza.finalizarConstruccion();
        plaza.reducirVida(440);                    //Reducimos vida para que el espadachin la destruya en 1 ataque

        Espadachin espadachin = new Espadachin(new Posicion(39,38));

        jugador1.agregarAEjercito(espadachin, mapa);
        jugador2.agregarEdificio(plaza, mapa);

        jugador1.atacar(espadachin,plaza);
        jugador2.limpiarEntidadesMuertas(mapa);

        Assert.assertEquals(jugador2.getEdificios().size(),1);
    }

}
