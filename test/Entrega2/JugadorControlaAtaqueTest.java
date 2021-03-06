package Entrega2;

import Modelo.Edificios.Cuartel;
import Modelo.Exceptions.EntidadFueraDeRangoException;
import Modelo.Exceptions.TurnoDelOponenteException;
import Modelo.Exceptions.UnidadDesarmadaException;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import Modelo.Unidades.ArmaDeAsedio;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class JugadorControlaAtaqueTest {

    //Control de ataque

    @Test
    public void ArqueroDelJugadorAtacaAAldeanoEnemigoAUnaUnidadDeDistanciaCorrectamenteDuranteSuTurno(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionArquero = new Posicion(3,2);
        Arquero arquero = new Arquero(posicionArquero);

        Posicion posicionAldeano = new Posicion(3,3);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeano);

        jugador.agregarAEjercito(arquero, mapa);
        jugador.atacar(arquero, aldeanoEnemigo);

        Assert.assertEquals(35 , aldeanoEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArqueroDelJugadorAtacaAAldeanoEnemigoAUnaUnidadDeDistanciaDuranteTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion posicionArquero = new Posicion(3,2);
        Arquero arquero = new Arquero(posicionArquero);

        Posicion posicionAldeano = new Posicion(3,3);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeano);

        jugador.agregarAEjercito(arquero, mapa);
        jugador.atacar(arquero, aldeanoEnemigo);

        Assert.assertEquals(35 , aldeanoEnemigo.getVida() );
    }


    @Test
    public void ArqueroDelJugadorAtacaAAldeanoEnemigoADosUnidadesDeDistanciaCorrectamenteDuranteSuTurno(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionArquero = new Posicion(3,2);
        Arquero arquero = new Arquero(posicionArquero);

        Posicion posicionAldeano = new Posicion(5,2);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeano);

        jugador.agregarAEjercito(arquero, mapa);
        jugador.atacar(arquero, aldeanoEnemigo);

        Assert.assertEquals(35 , aldeanoEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArqueroDelJugadorAtacaAAldeanoEnemigoADosUnidadesDeDistanciaDuranteTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion posicionArquero = new Posicion(3,2);
        Arquero arquero = new Arquero(posicionArquero);

        Posicion posicionAldeano = new Posicion(5,2);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeano);

        jugador.agregarAEjercito(arquero, mapa);
        jugador.atacar(arquero, aldeanoEnemigo);

        Assert.assertEquals(35 , aldeanoEnemigo.getVida() );
    }

    @Test
    public void ArqueroDelJugadorAtacaAAldeanoEnemigoATresUnidadesDeDistanciaCorrectamenteDuranteSuTurno(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionArquero = new Posicion(3,2);
        Arquero arquero = new Arquero(posicionArquero);

        Posicion posicionAldeano = new Posicion(6,2);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeano);

        jugador.agregarAEjercito(arquero, mapa);
        jugador.atacar(arquero, aldeanoEnemigo);

        Assert.assertEquals(35 , aldeanoEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArqueroDelJugadorAtacaAAldeanoEnemigoATresUnidadesDeDistanciaDuranteTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion posicionArquero = new Posicion(3,2);
        Arquero arquero = new Arquero(posicionArquero);

        Posicion posicionAldeano = new Posicion(6,2);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeano);

        jugador.agregarAEjercito(arquero, mapa);
        jugador.atacar(arquero, aldeanoEnemigo);

        Assert.assertEquals(35 , aldeanoEnemigo.getVida() );
    }

    @Test (expected = EntidadFueraDeRangoException.class)
    public void ArqueroDelJugadorNoPuedeAtacarAAldeanoEnemigoAMasDeTresUnidadesDeDistanciaDuranteSuTurno(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionArquero = new Posicion(3,2);
        Arquero arquero = new Arquero(posicionArquero);

        Posicion posicionAldeano = new Posicion(7,2);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeano);

        jugador.agregarAEjercito(arquero, mapa);
        jugador.atacar(arquero, aldeanoEnemigo);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArqueroDelJugadorNoPuedeAtacarAAldeanoEnemigoAMasDeTresUnidadesDeDistanciaDuranteTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion posicionArquero = new Posicion(3,2);
        Arquero arquero = new Arquero(posicionArquero);

        Posicion posicionAldeano = new Posicion(7,2);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeano);

        jugador.agregarAEjercito(arquero, mapa);
        jugador.atacar(arquero, aldeanoEnemigo);
    }


    @Test
    public void EspadachinDelJugadorAtacaAAldeanoEnemigoAUnaUnidadDeDistanciaCorrectamenteDuranteSuTurno(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionEspadachin = new Posicion(3,2);
        Espadachin espadachin = new Espadachin(posicionEspadachin);

        Posicion posicionAldeano = new Posicion(3,3);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeano);

        jugador.agregarAEjercito(espadachin, mapa);
        jugador.atacar(espadachin, aldeanoEnemigo);

        Assert.assertEquals(25 , aldeanoEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void EspadachinDelJugadorAtacaAAldeanoEnemigoAUnaUnidadDeDistanciaDuranteTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion posicionEspadachin = new Posicion(3,2);
        Espadachin espadachin = new Espadachin(posicionEspadachin);

        Posicion posicionAldeano = new Posicion(3,3);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeano);

        jugador.agregarAEjercito(espadachin, mapa);
        jugador.atacar(espadachin, aldeanoEnemigo);

        Assert.assertEquals(25 , aldeanoEnemigo.getVida() );
    }


    @Test (expected = EntidadFueraDeRangoException.class)
    public void EspadachinDelJugadorNoPuedeAtacarAAldeanoEnemigoAMasDeUnaUnidadDeDistanciaDuranteSuTurno(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionEspadachin = new Posicion(3,2);
        Espadachin espadachin = new Espadachin(posicionEspadachin);

        Posicion posicionAldeano = new Posicion(7,2);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeano);

        jugador.agregarAEjercito(espadachin, mapa);
        jugador.atacar(espadachin, aldeanoEnemigo);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void EspadachinDelJugadorNoPuedeAtacarAAldeanoEnemigoAMasDeUnaUnidadDeDistanciaDuranteTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion posicionEspadachin = new Posicion(3,2);
        Espadachin espadachin = new Espadachin(posicionEspadachin);

        Posicion posicionAldeano = new Posicion(7,2);
        Aldeano aldeanoEnemigo = new Aldeano(posicionAldeano);

        jugador.agregarAEjercito(espadachin, mapa);
        jugador.atacar(espadachin, aldeanoEnemigo);
    }


    @Test
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoAUnaUnidadDeDistanciaCorrectamenteDuranteSuTurno(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionArmaDeAsedio = new Posicion(3,2);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(2,3);
        Posicion posicion2 = new Posicion(2,4);
        Posicion posicion3 = new Posicion(3,3);
        Posicion posicion4 = new Posicion(3,4);
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel edificioEnemigo = new Cuartel(posiciones);
        edificioEnemigo.finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio, mapa);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoAUnaUnidadDeDistanciaDuranteTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion posicionArmaDeAsedio = new Posicion(3,2);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(2,3);
        Posicion posicion2 = new Posicion(2,4);
        Posicion posicion3 = new Posicion(3,3);
        Posicion posicion4 = new Posicion(3,4);
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel edificioEnemigo = new Cuartel(posiciones);
        edificioEnemigo.finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio, mapa);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }

    @Test
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoADosUnidadesDeDistanciaCorrectamenteDuranteSuTurno(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionArmaDeAsedio = new Posicion(10,10);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(12,13);
        Posicion posicion2 = new Posicion(12,12);
        Posicion posicion3 = new Posicion(13,13);
        Posicion posicion4 = new Posicion(13,12);
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel edificioEnemigo = new Cuartel(posiciones);
        edificioEnemigo.finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio, mapa);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoADosUnidadesDeDistanciaDuranteTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion posicionArmaDeAsedio = new Posicion(10,10);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(12,13);
        Posicion posicion2 = new Posicion(12,12);
        Posicion posicion3 = new Posicion(13,13);
        Posicion posicion4 = new Posicion(13,12);
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel edificioEnemigo = new Cuartel(posiciones);
        edificioEnemigo.finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio, mapa);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }


    @Test
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoATresUnidadesDeDistanciaCorrectamenteDuranteSuTurno(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionArmaDeAsedio = new Posicion(10,10);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(13,13);
        Posicion posicion2 = new Posicion(13,14);
        Posicion posicion3 = new Posicion(14,13);
        Posicion posicion4 = new Posicion(14,14);
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel edificioEnemigo = new Cuartel(posiciones);
        edificioEnemigo.finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio, mapa);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoATresUnidadesDeDistanciaDuranteTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion posicionArmaDeAsedio = new Posicion(10,10);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(13,13);
        Posicion posicion2 = new Posicion(13,14);
        Posicion posicion3 = new Posicion(14,13);
        Posicion posicion4 = new Posicion(14,14);
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel edificioEnemigo = new Cuartel(posiciones);
        edificioEnemigo.finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio, mapa);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }


    @Test
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoACuatroUnidadesDeDistanciaCorrectamenteDuranteSuTurno(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionArmaDeAsedio = new Posicion(10,10);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(14,14);
        Posicion posicion2 = new Posicion(14,15);
        Posicion posicion3 = new Posicion(15,15);
        Posicion posicion4 = new Posicion(15,14);
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel edificioEnemigo = new Cuartel(posiciones);
        edificioEnemigo.finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio, mapa);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoACuatroUnidadesDeDistanciaduranteTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion posicionArmaDeAsedio = new Posicion(10,10);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(14,14);
        Posicion posicion2 = new Posicion(14,15);
        Posicion posicion3 = new Posicion(15,14);
        Posicion posicion4 = new Posicion(15,15);
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel edificioEnemigo = new Cuartel(posiciones);
        edificioEnemigo.finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio, mapa);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }


    @Test
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoACincoUnidadesDeDistanciaCorrectamenteDuranteSuTurno(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionArmaDeAsedio = new Posicion(10,10);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(11,11);
        Posicion posicion2 = new Posicion(10,11);
        Posicion posicion3 = new Posicion(10,10);
        Posicion posicion4 = new Posicion(11,10);
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel edificioEnemigo = new Cuartel(posiciones);
        edificioEnemigo.finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio, mapa);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoACincoUnidadesDeDistanciaDuranteTurnoDelOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.inactivar();

        Posicion posicionArmaDeAsedio = new Posicion(10,10);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(15,10);
        Posicion posicion2 = new Posicion(15,11);
        Posicion posicion3 = new Posicion(16,10);
        Posicion posicion4 = new Posicion(16,11);
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel edificioEnemigo = new Cuartel(posiciones);
        edificioEnemigo.finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio, mapa);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }

    @Test (expected = EntidadFueraDeRangoException.class)
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoAMasDeCincoUnidadesDeDistanciaNoPuedeAtacarDuranteSuTurno(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionArmaDeAsedio = new Posicion(9,3);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(2,3);
        Posicion posicion2 = new Posicion(2,4);
        Posicion posicion3 = new Posicion(3,3);
        Posicion posicion4 = new Posicion(3,4);
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel edificioEnemigo = new Cuartel(posiciones);
        edificioEnemigo.finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio, mapa);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);
    }


    @Test (expected = UnidadDesarmadaException.class)
    public void ArmaDeAsedioDelJugadorDesarmadaNoPuedeAtacarDuranteSuTurno(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionArmaDeAsedio = new Posicion(5,1);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(2,3);
        Posicion posicion2 = new Posicion(2,4);
        Posicion posicion3 = new Posicion(3,3);
        Posicion posicion4 = new Posicion(3,4);
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel edificioEnemigo = new Cuartel(posiciones);
        edificioEnemigo.finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio, mapa);
        jugador.atacar(armaDeAsedio, edificioEnemigo);
    }

    @Test (expected = UnidadDesarmadaException.class)
    public void montarArmaDeAsediodesmontarArmaDeAsedioYVerificarQueNoPuedeAtacarDuranteSuTurno(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        jugador.activar();

        Posicion posicionArmaDeAsedio = new Posicion(10,10);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicionArmaDeAsedio);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(12,13);
        Posicion posicion2 = new Posicion(12,12);
        Posicion posicion3 = new Posicion(13,13);
        Posicion posicion4 = new Posicion(13,12);
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel edificioEnemigo = new Cuartel(posiciones);
        edificioEnemigo.finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio, mapa);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.desmontarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);
    }


}
