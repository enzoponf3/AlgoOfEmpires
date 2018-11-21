package Entrega2;

import Modelo.Edificios.Cuartel;
import Modelo.Exceptions.EntidadFueraDeRangoException;
import Modelo.Exceptions.TurnoDelOponenteException;
import Modelo.Exceptions.UnidadDesarmadaException;
import Modelo.Jugador;
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
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        Arquero arquero = new Arquero();
        Posicion posicionArquero = new Posicion(3,2);
        arquero.setPosicion(posicionArquero);

        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(3,3);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(arquero);
        jugador.atacar(arquero, aldeanoEnemigo);

        Assert.assertEquals(35 , aldeanoEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArqueroDelJugadorAtacaAAldeanoEnemigoAUnaUnidadDeDistanciaDuranteTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        Arquero arquero = new Arquero();
        Posicion posicionArquero = new Posicion(3,2);
        arquero.setPosicion(posicionArquero);

        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(3,3);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(arquero);
        jugador.atacar(arquero, aldeanoEnemigo);

        Assert.assertEquals(35 , aldeanoEnemigo.getVida() );
    }


    @Test
    public void ArqueroDelJugadorAtacaAAldeanoEnemigoADosUnidadesDeDistanciaCorrectamenteDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        Arquero arquero = new Arquero();
        Posicion posicionArquero = new Posicion(3,2);
        arquero.setPosicion(posicionArquero);
        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(5,2);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(arquero);
        jugador.atacar(arquero, aldeanoEnemigo);

        Assert.assertEquals(35 , aldeanoEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArqueroDelJugadorAtacaAAldeanoEnemigoADosUnidadesDeDistanciaDuranteTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        Arquero arquero = new Arquero();
        Posicion posicionArquero = new Posicion(3,2);
        arquero.setPosicion(posicionArquero);
        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(5,2);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(arquero);
        jugador.atacar(arquero, aldeanoEnemigo);

        Assert.assertEquals(35 , aldeanoEnemigo.getVida() );
    }

    @Test
    public void ArqueroDelJugadorAtacaAAldeanoEnemigoATresUnidadesDeDistanciaCorrectamenteDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        Arquero arquero = new Arquero();
        Posicion posicionArquero = new Posicion(3,2);
        arquero.setPosicion(posicionArquero);
        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(6,2);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(arquero);
        jugador.atacar(arquero, aldeanoEnemigo);

        Assert.assertEquals(35 , aldeanoEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArqueroDelJugadorAtacaAAldeanoEnemigoATresUnidadesDeDistanciaDuranteTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        Arquero arquero = new Arquero();
        Posicion posicionArquero = new Posicion(3,2);
        arquero.setPosicion(posicionArquero);
        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(6,2);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(arquero);
        jugador.atacar(arquero, aldeanoEnemigo);

        Assert.assertEquals(35 , aldeanoEnemigo.getVida() );
    }

    @Test (expected = EntidadFueraDeRangoException.class)
    public void ArqueroDelJugadorNoPuedeAtacarAAldeanoEnemigoAMasDeTresUnidadesDeDistanciaDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        Arquero arquero = new Arquero();
        Posicion posicionArquero = new Posicion(3,2);
        arquero.setPosicion(posicionArquero);
        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(7,2);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(arquero);
        jugador.atacar(arquero, aldeanoEnemigo);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArqueroDelJugadorNoPuedeAtacarAAldeanoEnemigoAMasDeTresUnidadesDeDistanciaDuranteTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        Arquero arquero = new Arquero();
        Posicion posicionArquero = new Posicion(3,2);
        arquero.setPosicion(posicionArquero);
        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(7,2);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(arquero);
        jugador.atacar(arquero, aldeanoEnemigo);
    }


    @Test
    public void EspadachinDelJugadorAtacaAAldeanoEnemigoAUnaUnidadDeDistanciaCorrectamenteDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        Espadachin espadachin = new Espadachin();
        Posicion posicionEspadachin = new Posicion(3,2);
        espadachin.setPosicion(posicionEspadachin);
        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(3,3);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(espadachin);
        jugador.atacar(espadachin, aldeanoEnemigo);

        Assert.assertEquals(25 , aldeanoEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void EspadachinDelJugadorAtacaAAldeanoEnemigoAUnaUnidadDeDistanciaDuranteTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        Espadachin espadachin = new Espadachin();
        Posicion posicionEspadachin = new Posicion(3,2);
        espadachin.setPosicion(posicionEspadachin);
        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(3,3);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(espadachin);
        jugador.atacar(espadachin, aldeanoEnemigo);

        Assert.assertEquals(25 , aldeanoEnemigo.getVida() );
    }


    @Test (expected = EntidadFueraDeRangoException.class)
    public void EspadachinDelJugadorNoPuedeAtacarAAldeanoEnemigoAMasDeUnaUnidadDeDistanciaDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        Espadachin espadachin = new Espadachin();
        Posicion posicionEspadachin = new Posicion(3,2);
        espadachin.setPosicion(posicionEspadachin);
        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(7,2);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(espadachin);
        jugador.atacar(espadachin, aldeanoEnemigo);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void EspadachinDelJugadorNoPuedeAtacarAAldeanoEnemigoAMasDeUnaUnidadDeDistanciaDuranteTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        Espadachin espadachin = new Espadachin();
        Posicion posicionEspadachin = new Posicion(3,2);
        espadachin.setPosicion(posicionEspadachin);
        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(7,2);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(espadachin);
        jugador.atacar(espadachin, aldeanoEnemigo);
    }


    @Test
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoAUnaUnidadDeDistanciaCorrectamenteDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicionArmaDeAsedio = new Posicion(3,2);
        armaDeAsedio.setPosicion(posicionArmaDeAsedio);

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

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoAUnaUnidadDeDistanciaDuranteTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicionArmaDeAsedio = new Posicion(3,2);
        armaDeAsedio.setPosicion(posicionArmaDeAsedio);

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

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }

    @Test
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoADosUnidadesDeDistanciaCorrectamenteDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicionArmaDeAsedio = new Posicion(5,3);
        armaDeAsedio.setPosicion(posicionArmaDeAsedio);

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

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoADosUnidadesDeDistanciaDuranteTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicionArmaDeAsedio = new Posicion(5,3);
        armaDeAsedio.setPosicion(posicionArmaDeAsedio);

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

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }


    @Test
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoATresUnidadesDeDistanciaCorrectamenteDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicionArmaDeAsedio = new Posicion(6,3);
        armaDeAsedio.setPosicion(posicionArmaDeAsedio);

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

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoATresUnidadesDeDistanciaDuranteTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicionArmaDeAsedio = new Posicion(6,3);
        armaDeAsedio.setPosicion(posicionArmaDeAsedio);

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

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }


    @Test
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoACuatroUnidadesDeDistanciaCorrectamenteDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicionArmaDeAsedio = new Posicion(7,3);
        armaDeAsedio.setPosicion(posicionArmaDeAsedio);

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

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoACuatroUnidadesDeDistanciaduranteTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicionArmaDeAsedio = new Posicion(7,3);
        armaDeAsedio.setPosicion(posicionArmaDeAsedio);

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

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }


    @Test
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoACincoUnidadesDeDistanciaCorrectamenteDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicionArmaDeAsedio = new Posicion(8,3);
        armaDeAsedio.setPosicion(posicionArmaDeAsedio);

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

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoACincoUnidadesDeDistanciaDuranteTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicionArmaDeAsedio = new Posicion(8,3);
        armaDeAsedio.setPosicion(posicionArmaDeAsedio);

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

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }

    @Test (expected = EntidadFueraDeRangoException.class)
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoAMasDeCincoUnidadesDeDistanciaNoPuedeAtacarDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicionArmaDeAsedio = new Posicion(9,3);
        armaDeAsedio.setPosicion(posicionArmaDeAsedio);

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

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);
    }


    @Test (expected = UnidadDesarmadaException.class)
    public void ArmaDeAsedioDelJugadorDesarmadaNoPuedeAtacarDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicionArmaDeAsedio = new Posicion(5,3);
        armaDeAsedio.setPosicion(posicionArmaDeAsedio);

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

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.atacar(armaDeAsedio, edificioEnemigo);
    }

    @Test (expected = UnidadDesarmadaException.class)
    public void montarArmaDeAsediodesmontarArmaDeAsedioYVerificarQueNoPuedeAtacarDuranteSuTurno(){
        Jugador jugador = new Jugador(5, 14);
        jugador.activar();

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicionArmaDeAsedio = new Posicion(5,3);
        armaDeAsedio.setPosicion(posicionArmaDeAsedio);

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

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.desmontarArmaDeAsedio(armaDeAsedio);

        armaDeAsedio.desocupar();

        jugador.atacar(armaDeAsedio, edificioEnemigo);
    }

    //Recibir ataque

    @Test
    public void aldeanoPropioRecibeAtaqueDeArqueroEnemigoEnTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        Arquero arqueroEnemigo = new Arquero();
        Posicion posicionArquero = new Posicion(3,2);
        arqueroEnemigo.setPosicion(posicionArquero);

        Aldeano aldeano = new Aldeano();
        Posicion posicionAldeano = new Posicion(3,3);
        aldeano.setPosicion(posicionAldeano);

        jugador.agregarAldeano(aldeano);
        arqueroEnemigo.atacar(aldeano);

        Assert.assertEquals(35 , aldeano.getVida() );

    }

    @Test
    public void aldeanoPropioRecibeAtaqueDeEspadachinEnemigoEnTurnoDelOponente(){
        Jugador jugador = new Jugador(5, 14);
        jugador.inactivar();

        Espadachin espadachinEnemigo = new Espadachin();
        Posicion posicionEspadachin = new Posicion(3,2);
        espadachinEnemigo.setPosicion(posicionEspadachin);

        Aldeano aldeano = new Aldeano();
        Posicion posicionAldeano = new Posicion(3,3);
        aldeano.setPosicion(posicionAldeano);

        jugador.agregarAldeano(aldeano);
        espadachinEnemigo.atacar(aldeano);

        Assert.assertEquals(25 , aldeano.getVida() );

    }
    //No se si estas pruebas tienen mucho sentido, tendria que ser directamente la de integracion con el otro jugador


}
