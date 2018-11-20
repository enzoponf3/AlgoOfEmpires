package Entrega2;

import Modelo.Edificios.Cuartel;
import Modelo.Edificios.Edificio;
import Modelo.Exceptions.EntidadFueraDeRangoException;
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
    public void ArqueroDelJugadorAtacaAAldeanoEnemigoAUnaUnidadDeDistanciaCorrectamente(){
        Jugador jugador = new Jugador();
        Arquero arquero = new Arquero();
        Posicion posicionArquero = new Posicion(3,2);
        arquero.setPosicion(posicionArquero);
        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(3,3);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(arquero);
        jugador.atacar(posicionArquero, aldeanoEnemigo);

        Assert.assertEquals(35 , aldeanoEnemigo.getVida() );
    }

    @Test
    public void ArqueroDelJugadorAtacaAAldeanoEnemigoADosUnidadesDeDistanciaCorrectamente(){
        Jugador jugador = new Jugador();
        Arquero arquero = new Arquero();
        Posicion posicionArquero = new Posicion(3,2);
        arquero.setPosicion(posicionArquero);
        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(5,2);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(arquero);
        jugador.atacar(posicionArquero, aldeanoEnemigo);

        Assert.assertEquals(35 , aldeanoEnemigo.getVida() );
    }

    @Test
    public void ArqueroDelJugadorAtacaAAldeanoEnemigoATresUnidadesDeDistanciaCorrectamente(){
        Jugador jugador = new Jugador();
        Arquero arquero = new Arquero();
        Posicion posicionArquero = new Posicion(3,2);
        arquero.setPosicion(posicionArquero);
        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(6,2);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(arquero);
        jugador.atacar(posicionArquero, aldeanoEnemigo);

        Assert.assertEquals(35 , aldeanoEnemigo.getVida() );
    }

    @Test (expected = EntidadFueraDeRangoException.class)
    public void ArqueroDelJugadorNoPuedeAtacarAAldeanoEnemigoAMasDeTresUnidadesDeDistancia(){
        Jugador jugador = new Jugador();
        Arquero arquero = new Arquero();
        Posicion posicionArquero = new Posicion(3,2);
        arquero.setPosicion(posicionArquero);
        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(7,2);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(arquero);
        jugador.atacar(posicionArquero, aldeanoEnemigo);
    }


    @Test
    public void EspadachinDelJugadorAtacaAAldeanoEnemigoAUnaUnidadDeDistanciaCorrectamente(){
        Jugador jugador = new Jugador();
        Espadachin espadachin = new Espadachin();
        Posicion posicionEspadachin = new Posicion(3,2);
        espadachin.setPosicion(posicionEspadachin);
        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(3,3);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(espadachin);
        jugador.atacar(posicionEspadachin, aldeanoEnemigo);

        Assert.assertEquals(25 , aldeanoEnemigo.getVida() );
    }


    @Test (expected = EntidadFueraDeRangoException.class)
    public void EspadachinDelJugadorNoPuedeAtacarAAldeanoEnemigoAMasDeUnaUnidadDeDistancia(){
        Jugador jugador = new Jugador();
        Espadachin espadachin = new Espadachin();
        Posicion posicionEspadachin = new Posicion(3,2);
        espadachin.setPosicion(posicionEspadachin);
        Aldeano aldeanoEnemigo = new Aldeano();
        Posicion posicionAldeano = new Posicion(7,2);
        aldeanoEnemigo.setPosicion(posicionAldeano);

        jugador.agregarAEjercito(espadachin);
        jugador.atacar(posicionEspadachin, aldeanoEnemigo);
    }



    @Test
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoAUnaUnidadDeDistanciaCorrectamente(){
        Jugador jugador = new Jugador();
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
        Edificio edificioEnemigo = new Cuartel(posiciones);
        ((Cuartel) edificioEnemigo).finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(posicionArmaDeAsedio);
        ArmaDeAsedio armaDeAsedio2 = (ArmaDeAsedio) jugador.devolverAtacanteEnPosicion(posicionArmaDeAsedio);
        armaDeAsedio2.desocupar();
        jugador.atacar(posicionArmaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }

    @Test
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoADosUnidadesDeDistanciaCorrectamente(){
        Jugador jugador = new Jugador();
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
        Edificio edificioEnemigo = new Cuartel(posiciones);
        ((Cuartel) edificioEnemigo).finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(posicionArmaDeAsedio);
        ArmaDeAsedio armaDeAsedio2 = (ArmaDeAsedio) jugador.devolverAtacanteEnPosicion(posicionArmaDeAsedio);
        armaDeAsedio2.desocupar();
        jugador.atacar(posicionArmaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }


    @Test
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoATresUnidadesDeDistanciaCorrectamente(){
        Jugador jugador = new Jugador();
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
        Edificio edificioEnemigo = new Cuartel(posiciones);
        ((Cuartel) edificioEnemigo).finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(posicionArmaDeAsedio);
        ArmaDeAsedio armaDeAsedio2 = (ArmaDeAsedio) jugador.devolverAtacanteEnPosicion(posicionArmaDeAsedio);
        armaDeAsedio2.desocupar();
        jugador.atacar(posicionArmaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }


    @Test
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoACuatroUnidadesDeDistanciaCorrectamente(){
        Jugador jugador = new Jugador();
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
        Edificio edificioEnemigo = new Cuartel(posiciones);
        ((Cuartel) edificioEnemigo).finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(posicionArmaDeAsedio);
        ArmaDeAsedio armaDeAsedio2 = (ArmaDeAsedio) jugador.devolverAtacanteEnPosicion(posicionArmaDeAsedio);
        armaDeAsedio2.desocupar();
        jugador.atacar(posicionArmaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }


    @Test
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoACincoUnidadesDeDistanciaCorrectamente(){
        Jugador jugador = new Jugador();
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
        Edificio edificioEnemigo = new Cuartel(posiciones);
        ((Cuartel) edificioEnemigo).finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(posicionArmaDeAsedio);
        ArmaDeAsedio armaDeAsedio2 = (ArmaDeAsedio) jugador.devolverAtacanteEnPosicion(posicionArmaDeAsedio);
        armaDeAsedio2.desocupar();
        jugador.atacar(posicionArmaDeAsedio, edificioEnemigo);

        Assert.assertEquals(175 , edificioEnemigo.getVida() );
    }


    @Test (expected = EntidadFueraDeRangoException.class)
    public void ArmaDeAsedioDelJugadorAtacaAEdificioEnemigoAMasDeCincoUnidadesDeDistanciaNoPuedeAtacar(){
        Jugador jugador = new Jugador();
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
        Edificio edificioEnemigo = new Cuartel(posiciones);
        ((Cuartel) edificioEnemigo).finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(posicionArmaDeAsedio);
        ArmaDeAsedio armaDeAsedio2 = (ArmaDeAsedio) jugador.devolverAtacanteEnPosicion(posicionArmaDeAsedio);
        armaDeAsedio2.desocupar();
        jugador.atacar(posicionArmaDeAsedio, edificioEnemigo);
    }


    @Test (expected = UnidadDesarmadaException.class)
    public void ArmaDeAsedioDelJugadorDesarmadaNoPuedeAtacar(){
        Jugador jugador = new Jugador();
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
        Edificio edificioEnemigo = new Cuartel(posiciones);
        ((Cuartel) edificioEnemigo).finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.atacar(posicionArmaDeAsedio, edificioEnemigo);
    }

    @Test (expected = UnidadDesarmadaException.class)
    public void montarArmaDeAsediodesmontarArmaDeAsedioYVerificarQueNoPuedeAtacar(){
        Jugador jugador = new Jugador();
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
        Edificio edificioEnemigo = new Cuartel(posiciones);
        ((Cuartel) edificioEnemigo).finalizarConstruccion();

        jugador.agregarAEjercito(armaDeAsedio);
        jugador.montarArmaDeAsedio(posicionArmaDeAsedio);
        armaDeAsedio.desocupar();
        jugador.desmontarArmaDeAsedio(posicionArmaDeAsedio);
        armaDeAsedio.desocupar();
        jugador.atacar(posicionArmaDeAsedio, edificioEnemigo);
    }

}
