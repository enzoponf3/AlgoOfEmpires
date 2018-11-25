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

import static javafx.scene.input.KeyCode.M;

public class JugadorTest {

    @Test
    public void obtenerPosicionesInicialesCastilloJugador1Correctamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(5,5);
        Posicion posicion2 = new Posicion(5,6);
        Posicion posicion3 = new Posicion(5,7);
        Posicion posicion4 = new Posicion(5,8);
        Posicion posicion5 = new Posicion(6,5);
        Posicion posicion6 = new Posicion(6,6);
        Posicion posicion7 = new Posicion(6,7);
        Posicion posicion8 = new Posicion(6,8);
        Posicion posicion9 = new Posicion(7,5);
        Posicion posicion10 = new Posicion(7,6);
        Posicion posicion11 = new Posicion(7,7);
        Posicion posicion12 = new Posicion(7,8);
        Posicion posicion13 = new Posicion(8,5);
        Posicion posicion14 = new Posicion(8,6);
        Posicion posicion15 = new Posicion(8,7);
        Posicion posicion16 = new Posicion(8,8);

        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        posiciones.add(posicion5);
        posiciones.add(posicion6);
        posiciones.add(posicion7);
        posiciones.add(posicion8);
        posiciones.add(posicion9);
        posiciones.add(posicion10);
        posiciones.add(posicion11);
        posiciones.add(posicion12);
        posiciones.add(posicion13);
        posiciones.add(posicion14);
        posiciones.add(posicion15);
        posiciones.add(posicion16);

        ArrayList<Posicion> posicionesaAComparar = jugador.obtenerPosicionesInicialesCastillo(5);

        int i=0;
        for( Posicion posicion : posicionesaAComparar){
            Assert.assertTrue( posicion.igualA( posiciones.get(i) ) );
            i++;
        }
    }

    @Test
    public void obtenerPosicionesInicialesPlazaCentralCorrectamente(){
        Mapa mapa = new Mapa(50, 50);

        Jugador jugador = new Jugador(mapa, 5, 14);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        Posicion posicion1 = new Posicion(14,5);
        Posicion posicion2 = new Posicion(14,6);
        Posicion posicion3 = new Posicion(15,5);
        Posicion posicion4 = new Posicion(15,6);

        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);

        ArrayList<Posicion> posicionesaAComparar = jugador.obtenerPosicionesInicialesPlazaCentral(14, 5);

        int i=0;
        for( Posicion posicion : posicionesaAComparar){
            Assert.assertTrue( posicion.igualA( posiciones.get(i) ) );
            i++;
        }
    }

    //Inicializacion

    @Test
    public void verificarQueIniciaConUnCastillo(){
        Mapa mapa = new Mapa(50, 50);

        Jugador jugador = new Jugador(mapa, 5, 14);
        Castillo castillo = jugador.getCastillo();
        Assert.assertEquals(castillo.getVida(), 1000);
    }

    @Test
    public void verificarQueIniciaConUnaPlazaCentral(){
        Mapa mapa = new Mapa(50, 50);

        Jugador jugador = new Jugador(mapa, 5, 14);
        Assert.assertEquals( 1, jugador.getEdificios().size() );
    }

    @Test
    public void verificarQueIniciaConUnaPlazaCentralCorrectamenteCreada(){
        Mapa mapa = new Mapa(50, 50);

        Jugador jugador = new Jugador(mapa, 5, 14);
        ArrayList<Edificio> edificios = jugador.getEdificios();
        Edificio plaza = edificios.get(0);
        Assert.assertEquals(plaza.getVida(), 450);
    }

    @Test
    public void verificarQueIniciaConTresAldeanos(){
        Mapa mapa = new Mapa(50, 50);

        Jugador jugador = new Jugador(mapa, 5, 14);
        ArrayList<Aldeano> aldeanos = jugador.getAldeanos();
        Assert.assertEquals(3, aldeanos.size());
    }

    @Test
    public void verificarQueIniciaConTresAldeanosCorrectamenteCreados(){
        Mapa mapa = new Mapa(50, 50);

        Jugador jugador = new Jugador(mapa, 5, 14);
        ArrayList<Aldeano> aldeanos = jugador.getAldeanos();
        for (Aldeano aldeano : aldeanos)
            Assert.assertEquals(aldeano.getVida(),50);
    }

    @Test
    public void verificarQueIniciaConCienDeOro(){
        Mapa mapa = new Mapa(50, 50);

        Jugador jugador = new Jugador(mapa, 5, 14);
        Assert.assertEquals(100, jugador.getCantidadOro());
    }

    @Test
    public void verificarTodasLasCondicionesEnSimultaneo(){
        Mapa mapa = new Mapa(50, 50);

        Jugador jugador = new Jugador(mapa, 5, 14);
        Assert.assertNotNull( jugador.getCastillo() );
        Assert.assertEquals( 1, jugador.getEdificios().size() );
        ArrayList<Aldeano> aldeanos = jugador.getAldeanos();
        Assert.assertEquals(3, aldeanos.size());
        Assert.assertEquals(100, jugador.getCantidadOro());
    }

    @Test
    public void verificarQueIniciaConEjercitoVacio(){
        Mapa mapa = new Mapa(50, 50);

        Jugador jugador = new Jugador(mapa, 5, 14);
        Assert.assertTrue( jugador.getEjercito().isEmpty() );
    }


    //Agrego unidades al ejercito

    @Test
    public void agregarUnArqueroAlEjercitoCorrectamente(){
        Mapa mapa = new Mapa(50, 50);

        Jugador jugador = new Jugador(mapa, 5, 14);
        Arquero arquero = new Arquero();
        jugador.agregarAEjercito(arquero);
        Assert.assertFalse( jugador.getEjercito().isEmpty() );
    }

    @Test
    public void agregarUnEspadachinAlEjercitoCorrectamente(){
        Mapa mapa = new Mapa(50, 50);

        Jugador jugador = new Jugador(mapa, 5, 14);
        Posicion origen = new Posicion(4,4);
        Espadachin espadachin = new Espadachin(origen);

        jugador.agregarAEjercito(espadachin);
        Assert.assertFalse( jugador.getEjercito().isEmpty() );
    }

    @Test
    public void agregarUnArmaDeAsedioAlEjercitoCorrectamente(){
        Mapa mapa = new Mapa(50, 50);

        Jugador jugador = new Jugador(mapa, 5, 14);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();

        jugador.agregarAEjercito(armaDeAsedio);
        Assert.assertFalse( jugador.getEjercito().isEmpty() );
    }

    @Test
    public void agregarUnoDeCadaUnoAlEjercitoCorrectamente(){
        Mapa mapa = new Mapa(50, 50);

        Jugador jugador = new Jugador(mapa, 5, 14);
        Posicion pos1 = new Posicion(5,5);
        Posicion pos2 = new Posicion(5,6);
        Posicion pos3 = new Posicion(5,7);
        Arquero arquero = new Arquero(pos1);
        Espadachin espadachin = new Espadachin(pos2);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(pos3);

        jugador.agregarAEjercito(espadachin);
        jugador.agregarAEjercito(arquero);
        jugador.agregarAEjercito(armaDeAsedio);

        Assert.assertEquals(3, jugador.getEjercito().size() );
    }

    //No pruebo que no se puede agregar otra cosa porque directamente Java no eja por el tipado estatico, por eso el
    //uso de la interfaz IAtacante.

    //Control poblacion

    @Test
    public void agregarAldeanoCorrectamente(){
        Mapa mapa = new Mapa(50, 50);

        Jugador jugador = new Jugador(mapa, 5, 14);
        Posicion posicion = new Posicion(2,2);
        Aldeano aldeano = new Aldeano(posicion);

        jugador.agregarAldeano(aldeano);
        Assert.assertFalse( jugador.getAldeanos().isEmpty() );
        Assert.assertEquals(4, jugador.getAldeanos().size() );
    }

    @Test
    public void agregarAldeanosSobreElLimiteYVerificarPoblacion(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        for(int i=0; i<47; i++){
            Posicion posicion = new Posicion(i,i);
            Aldeano aldeano = new Aldeano(posicion);
            jugador.agregarAldeano(aldeano);
        }

        Assert.assertEquals(50, jugador.getAldeanos().size() );
    }

    @Test (expected = LimiteDePoblacionException.class)
    public void agregarAldeanosPasandoElLimiteDePoblacion(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        for(int i=0; i<48; i++){
            Posicion posicion = new Posicion(i,i);
            Aldeano aldeano = new Aldeano(posicion);
            jugador.agregarAldeano(aldeano);
        }

    }

    @Test
    public void agregarArqueroSobreElLimiteYVerificarPoblacion(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        for(int i=0; i<47; i++){
            Arquero arquero = new Arquero();
            jugador.agregarAEjercito(arquero);
        }

        Assert.assertEquals(47, jugador.getEjercito().size() );
    }


    @Test (expected = LimiteDePoblacionException.class)
    public void agregarArquerosPasandoElLimiteDePoblacion(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        for(int i=0; i<48; i++){
            Arquero arquero = new Arquero();
            jugador.agregarAEjercito(arquero);
        }

    }

    @Test
    public void agregarEspadachinSobreElLimiteYVerificarPoblacion(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        int posNueva = 0;
        for(int i=0; i<47; i++){
            posNueva++;
            Posicion posicion = new Posicion(9, posNueva);
            Espadachin espadachin = new Espadachin(posicion);
            jugador.agregarAEjercito(espadachin);
        }

        Assert.assertEquals(47, jugador.getEjercito().size() );
    }

    @Test (expected = LimiteDePoblacionException.class)
    public void agregarEspadachinesPasandoElLimiteDePoblacion(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        int posNueva = 0;
        for(int i=0; i<48; i++){
            posNueva++;
            Posicion posicion = new Posicion(9,posNueva);
            Espadachin espadachin = new Espadachin(posicion);
            jugador.agregarAEjercito(espadachin);
        }

    }

    @Test
    public void agregarArmaDeAsedioSobreElLimiteYVerificarPoblacion(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        int posNueva = 0;
        for(int i=0; i<47; i++){
            posNueva++;
            Posicion posicion = new Posicion(9,posNueva);
            ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio(posicion);
            jugador.agregarAEjercito(armaDeAsedio);
        }

        Assert.assertEquals(47, jugador.getEjercito().size() );
    }

    @Test (expected = LimiteDePoblacionException.class)
    public void agregarArmaDeAsedioPasandoElLimiteDePoblacion(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        for(int i=0; i<48; i++){
            ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
            jugador.agregarAEjercito(armaDeAsedio);
        }

    }

    //Agregar edificios

    @Test
    public void agregarUnaPlazacentralCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        PlazaCentral plazaCentral = new PlazaCentral(posicions);

        jugador.agregarEdificio(plazaCentral);

        Assert.assertEquals(2, jugador.getEdificios().size() );
    }

    @Test
    public void agregarUnCuartelCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        Cuartel cuartel = new Cuartel(posicions);

        jugador.agregarEdificio(cuartel);

        Assert.assertEquals(2, jugador.getEdificios().size() );
    }

    @Test
    public void agregarUnaPlazaYUnCuartelCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        PlazaCentral plazaCentral = new PlazaCentral(posicions);
        Posicion posicion5 = new Posicion(1,2);
        Posicion posicion6 = new Posicion(1,3);
        Posicion posicion7 = new Posicion(2,2);
        Posicion posicion8 = new Posicion(2,3);
        ArrayList<Posicion> posicions2 =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        Cuartel cuartel = new Cuartel(posicions2);

        jugador.agregarEdificio(plazaCentral);
        jugador.agregarEdificio(cuartel);

        Assert.assertEquals(3, jugador.getEdificios().size() );
    }

    //No pruebo agregar castillos dado que directamente no se pueden construir, y para agregarlos tienen que ser
    //construidos primero.


    //Devolver una entidad

    @Test
    public void devolverAldeanoEnPosicionCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion = new Posicion(2,5);
        Aldeano aldeano = new Aldeano(posicion);

        jugador.agregarAldeano(aldeano);
        Aldeano aldeanoAComparar = jugador.devolverAldeanoEnPosicion(posicion);

        Assert.assertEquals( aldeano, aldeanoAComparar );
    }


    @Test (expected = AldeanoNoExisteException.class)
    public void devolverAldeanoQueNoEsDelJugador(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicionAldeano = new Posicion(1,6);

        jugador.devolverAldeanoEnPosicion(posicionAldeano);
    }

    @Test
    public void devolverArqueroEnPosicionCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(2,5);
        arquero.setPosicion(posicion);

        jugador.agregarAEjercito(arquero);
        Arquero arqueroAComparar = (Arquero) jugador.devolverAtacanteEnPosicion(posicion);

        Assert.assertEquals( arquero, arqueroAComparar );
    }

    @Test (expected = AtacanteNoExisteException.class)
    public void devolverArqueroQueNoEsDelJugadorEnPosicion(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(2,5);
        arquero.setPosicion(posicion);

        jugador.devolverAtacanteEnPosicion(posicion);
    }

    @Test
    public void devolverEspadachinEnPosicionCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion = new Posicion(2,5);
        Espadachin espadachin = new Espadachin(posicion);
        jugador.agregarAEjercito(espadachin);
        Espadachin espadachinAComprar = (Espadachin) jugador.devolverAtacanteEnPosicion(posicion);

        Assert.assertEquals( espadachin, espadachinAComprar);
    }

    @Test (expected = AtacanteNoExisteException.class)
    public void devolverEspadachinQueNoEsDelJugadorEnPosicion(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);
        Posicion posicion = new Posicion(2,5);
        Espadachin espadachin = new Espadachin(posicion);

        jugador.devolverAtacanteEnPosicion(posicion);
    }

    @Test
    public void devolverArmaDeAsedioEnPosicionCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(2,5);
        armaDeAsedio.setPosicion(posicion);

        jugador.agregarAEjercito(armaDeAsedio);
        ArmaDeAsedio armaDeAsedioAComparar = (ArmaDeAsedio) jugador.devolverAtacanteEnPosicion(posicion);

        Assert.assertEquals( armaDeAsedio, armaDeAsedioAComparar);
    }

    @Test (expected = AtacanteNoExisteException.class)
    public void devolverArmaDeAsedioQueNoEsDelJugadorEnPosicion(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(2,5);
        armaDeAsedio.setPosicion(posicion);

        jugador.devolverAtacanteEnPosicion(posicion);
    }

    //Unidad movible
/*
    @Test
    public void devolverAldeanoInicialComoUnidadMovibleCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicionAldeano = new Posicion(1,1);

        Aldeano aldeanoInicial = jugador.devolverAldeanoEnPosicion(posicionAldeano);
        IUnidadMovible aldeano = jugador.devolverUnidadMovible(posicionAldeano);

        Assert.assertEquals(aldeanoInicial, aldeano);
    }

    @Test
    public void devolverAldeanoAgregadoComoUnidadMovibleCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        Posicion posicionAldeano = new Posicion(1,5);
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(posicionAldeano);

        jugador.agregarAldeano(aldeano);
        IUnidadMovible aldeanoAgregado = jugador.devolverUnidadMovible(posicionAldeano);

        Assert.assertEquals(aldeano, aldeanoAgregado);
    }

    @Test (expected = UnidadMovibleNoExisteException.class)
    public void devolverAldeanoQueNoEsDelJugadorComoUnidadMovible(){
        Jugador jugador = new Jugador(5, 14);
        Posicion posicionAldeano = new Posicion(1,5);
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(posicionAldeano);

        jugador.devolverUnidadMovible(posicionAldeano);
    }

    @Test
    public void devolverArqueroComoUnidadMovibleCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        Posicion posicion = new Posicion(2,5);
        Arquero arquero = new Arquero();
        arquero.setPosicion(posicion);

        jugador.agregarAEjercito(arquero);
        IUnidadMovible arqueroAgregado = jugador.devolverUnidadMovible(posicion);

        Assert.assertEquals(arqueroAgregado, arquero);
    }

    @Test (expected = UnidadMovibleNoExisteException.class)
    public void devolverArqueroQueNoEsDelJugadorComoUnidadMovible(){
        Jugador jugador = new Jugador(5, 14);
        Posicion posicion = new Posicion(2,5);
        Arquero arquero = new Arquero();
        arquero.setPosicion(posicion);

        jugador.devolverUnidadMovible(posicion);
    }

    @Test
    public void devolverArmaDeAsedioComoUnidadMovibleCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        Posicion posicion = new Posicion(2,5);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        armaDeAsedio.setPosicion(posicion);

        jugador.agregarAEjercito(armaDeAsedio);
        IUnidadMovible armaAgregada = jugador.devolverUnidadMovible(posicion);

        Assert.assertEquals(armaDeAsedio, armaAgregada);
    }

    @Test (expected = UnidadMovibleNoExisteException.class)
    public void devolverArmaDeAsedioQueNoEsDelJugadorComoUnidadMovible(){
        Jugador jugador = new Jugador(5, 14);
        Posicion posicion = new Posicion(2,5);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        armaDeAsedio.setPosicion(posicion);

        IUnidadMovible armaAgregada = jugador.devolverUnidadMovible(posicion);
    }

    @Test
    public void devolverEspadachinComoUnidadMovibleCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        Posicion posicion = new Posicion(2,5);
        Espadachin espadachin = new Espadachin();
        espadachin.setPosicion(posicion);

        jugador.agregarAEjercito(espadachin);
        IUnidadMovible espadachinAgregado = jugador.devolverUnidadMovible(posicion);

        Assert.assertEquals(espadachin, espadachinAgregado);
    }

    @Test (expected = UnidadMovibleNoExisteException.class)
    public void devolverEspadachinQueNoEsDelJugadorComoUnidadMovible(){
        Jugador jugador = new Jugador(5, 14);
        Posicion posicion = new Posicion(2,5);
        Espadachin espadachin = new Espadachin();
        espadachin.setPosicion(posicion);

        IUnidadMovible espadachinAgregado = jugador.devolverUnidadMovible(posicion);
    }

    //Edificios

    @Test
    public void devolverPlazaCentralEnPosicionCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
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
        jugador.agregarEdificio(plazaCentral);
        PlazaCentral plaza = (PlazaCentral) jugador.devolverEdificioEnPosicion(posicion1);
        Assert.assertEquals(plazaCentral, plaza);
    }

    @Test
    public void devolverLaPlazaCentralConLaQueSeInicializaElJuegoCorrectamente(){
        Jugador jugador = new Jugador(5, 14);

        Posicion posicion3 = new Posicion(14,5);

        PlazaCentral plaza = (PlazaCentral) jugador.devolverEdificioEnPosicion(posicion3);
        Assert.assertEquals(1, jugador.getEdificios().size() );
    }

    @Test (expected = EdificioNoExisteException.class)
    public void devolverPlazaCentralQueNoEsDelJugadorEnPosicion(){
        Jugador jugador = new Jugador(5, 14);
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

        PlazaCentral plaza = (PlazaCentral) jugador.devolverEdificioEnPosicion(posicion1);
    }

*/
    //Remover aldeanos

    @Test
    public void removerUnAldeano(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion = new Posicion(3,5);
        Aldeano aldeanoARemover = new Aldeano(posicion);

        jugador.agregarAldeano(aldeanoARemover);
        Aldeano aldeano = jugador.removerAldeano(aldeanoARemover);

        Assert.assertEquals(3, jugador.getAldeanos().size() );
        Assert.assertEquals(aldeano, aldeanoARemover);
    }

    @Test (expected = AldeanoNoExisteException.class)
    public void removerUnAldeanoQueNoEsDelJugador(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion = new Posicion(3,5);
        Aldeano aldeanoARemover = new Aldeano(posicion);

        Aldeano aldeano = jugador.removerAldeano(aldeanoARemover);

        Assert.assertEquals(3, jugador.getAldeanos().size() );
    }

    @Test
    public void removerUnAldeanoDisminuyeLaPoblacionEnUno(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion = new Posicion(2,5);
        Aldeano aldeanoARemover = new Aldeano(posicion);

        jugador.agregarAldeano(aldeanoARemover);
        Assert.assertEquals(4, jugador.getAldeanos().size() );
        Aldeano aldeano = jugador.removerAldeano(aldeanoARemover);

        Assert.assertEquals(3, jugador.getAldeanos().size() );
        Assert.assertEquals(aldeano, aldeanoARemover);
    }

    //Remover atacantes

    @Test
    public void removerUnEspadachinCorrectamenteDisminuyePoblacion(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion = new Posicion(10,10);
        Espadachin espadachinARemover = new Espadachin(posicion);

        jugador.agregarAEjercito(espadachinARemover);
        Espadachin espadachin = (Espadachin) jugador.removerDeEjercito(espadachinARemover);

        Assert.assertEquals(0, jugador.getEjercito().size() );
        Assert.assertEquals(espadachin, espadachinARemover);
    }

    @Test (expected = AtacanteNoExisteException.class)
    public void removerUnEspadachinQueNoEsDelJugador(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion = new Posicion(10,10);
        Espadachin espadachinARemover = new Espadachin(posicion);

        Espadachin espadachin = (Espadachin) jugador.removerDeEjercito(espadachinARemover);

        Assert.assertEquals(0, jugador.getEjercito().size() );
    }

    @Test
    public void removerUnArqueroCorrectamenteDisminuyePoblacion(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Arquero arqueroARemover = new Arquero();

        jugador.agregarAEjercito(arqueroARemover);
        Arquero arquero = (Arquero) jugador.removerDeEjercito(arqueroARemover);

        Assert.assertEquals(0, jugador.getEjercito().size() );
        Assert.assertEquals(arquero, arqueroARemover);
    }

    @Test (expected = AtacanteNoExisteException.class)
    public void removerUnArqueroQueNoEsDelJugador(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Arquero arqueroARemover = new Arquero();

        Arquero arquero = (Arquero) jugador.removerDeEjercito(arqueroARemover);

        Assert.assertEquals(0, jugador.getEjercito().size() );
        Assert.assertEquals(arquero, arqueroARemover);
    }

    @Test
    public void removerUnArmaDeAsedioCorrectamenteDisminuyePoblacion(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        ArmaDeAsedio armaDeAsedioARemover = new ArmaDeAsedio();

        jugador.agregarAEjercito(armaDeAsedioARemover);
        ArmaDeAsedio armaDeAsedio = (ArmaDeAsedio) jugador.removerDeEjercito(armaDeAsedioARemover);

        Assert.assertEquals(0, jugador.getEjercito().size() );
        Assert.assertEquals(armaDeAsedio, armaDeAsedioARemover);
    }

    @Test (expected = AtacanteNoExisteException.class)
    public void removerUnArmaDeAsedioQueNoEsDelJugador(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        ArmaDeAsedio armaDeAsedioARemover = new ArmaDeAsedio();

        ArmaDeAsedio armaDeAsedio = (ArmaDeAsedio) jugador.removerDeEjercito(armaDeAsedioARemover);

        Assert.assertEquals(0, jugador.getEjercito().size() );
        Assert.assertEquals(armaDeAsedio, armaDeAsedioARemover);
    }

    //Remover edificios

    @Test
    public void removerUnaPlazaCentralQueFueAgregadaCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);
        PlazaCentral plazaCentral = new PlazaCentral(posicionesPlazaCentral);

        jugador.agregarEdificio(plazaCentral);
        PlazaCentral plazaCentral1 = (PlazaCentral) jugador.removerEdificio(posicion1PlazaCentral);

        Assert.assertEquals(1, jugador.getEdificios().size() );
        Assert.assertEquals(plazaCentral1, plazaCentral);
    }

    @Test
    public void removerLaPlazaCentralConLaQueSeInicializaElJuegoCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion1 = new Posicion(14, 5);

        PlazaCentral plazaCentral = (PlazaCentral) jugador.devolverEdificioEnPosicion(posicion1);
        PlazaCentral plazaCentral1 = (PlazaCentral) jugador.removerEdificio(posicion1);

        Assert.assertEquals(0, jugador.getEdificios().size() );
        Assert.assertEquals(plazaCentral1, plazaCentral);
    }


    @Test (expected = EdificioNoExisteException.class)
    public void removerUnaPlazaCentralQueNoEsDelJugador(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion1PlazaCentral = new Posicion(3,2);
        Posicion posicion2PlazaCentral = new Posicion(3,1);
        Posicion posicion3PlazaCentral = new Posicion(4,2);
        Posicion posicion4PlazaCentral = new Posicion(4,1);
        ArrayList<Posicion> posicionesPlazaCentral = new ArrayList<>();
        posicionesPlazaCentral.add(posicion1PlazaCentral);
        posicionesPlazaCentral.add(posicion2PlazaCentral);
        posicionesPlazaCentral.add(posicion3PlazaCentral);
        posicionesPlazaCentral.add(posicion4PlazaCentral);
        new PlazaCentral(posicionesPlazaCentral);

        jugador.removerEdificio(posicion1PlazaCentral);
    }

    @Test
    public void removerUnaCuartelQueFueAgregadaCorrectamente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);
        Cuartel cuartel = new Cuartel(posicionesCuartel);

        jugador.agregarEdificio(cuartel);
        Cuartel cuartel1 = (Cuartel) jugador.removerEdificio(posicion1Cuartel);

        Assert.assertEquals(1, jugador.getEdificios().size() );
        Assert.assertEquals(cuartel1, cuartel);
    }

    @Test (expected = EdificioNoExisteException.class)
    public void removerUnCuartelQueNoEsDelJugador(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        Posicion posicion1Cuartel = new Posicion(3,2);
        Posicion posicion2Cuartel = new Posicion(3,1);
        Posicion posicion3Cuartel = new Posicion(4,2);
        Posicion posicion4Cuartel = new Posicion(4,1);
        ArrayList<Posicion> posicionesCuartel = new ArrayList<>();
        posicionesCuartel.add(posicion1Cuartel);
        posicionesCuartel.add(posicion2Cuartel);
        posicionesCuartel.add(posicion3Cuartel);
        posicionesCuartel.add(posicion4Cuartel);
        Cuartel cuartel = new Cuartel(posicionesCuartel);

        jugador.removerEdificio(posicion1Cuartel);
    }

    //No es necesario remover el castillo porque una vez que este se destruye dicho jugador pierde la partida.

    // Realizar acciones fuera de turno

    @Test (expected = TurnoDelOponenteException.class)
    public void desmontarArmaDeAsedioEnTunoOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        jugador.inactivar();
        ArmaDeAsedio arma = new ArmaDeAsedio(new Posicion(1,1));
        arma.montar();
        arma.desocupar();
        jugador.agregarAEjercito(arma);
        jugador.desmontarArmaDeAsedio(arma);
    }

    @Test (expected = TurnoDelOponenteException.class)
     public void crearCuartelEnTurnoDelOponente() {
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        jugador.inactivar();
        Aldeano aldeano = new Aldeano(new Posicion(1,1));
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        jugador.construirCuartel(aldeano, posiciones);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void continuarConstruccionCuartelTurnoOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        jugador.activar();
        Aldeano aldeano = new Aldeano(new Posicion(1,1));
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel cuartel = new Cuartel(posiciones);
        jugador.inactivar();
        jugador.continuarConstruccionCuartel(aldeano, cuartel);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void continuarConstruccionPlazaCentralTurnoOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        jugador.activar();
        Aldeano aldeano = new Aldeano(new Posicion(1,1));
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = new PlazaCentral(posiciones);
        jugador.inactivar();
        jugador.continuarConstruccionPlazaCentral(aldeano, plaza);
    }

    @Test (expected = TurnoDelOponenteException.class)
    public void repararPlazaCentralTurnoOponente() {
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        jugador.activar();
        Aldeano aldeano = new Aldeano(new Posicion(1, 1));
        Posicion posicion1 = new Posicion(1, 2);
        Posicion posicion2 = new Posicion(1, 3);
        Posicion posicion3 = new Posicion(2, 2);
        Posicion posicion4 = new Posicion(2, 3);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = new PlazaCentral(posiciones);
        plaza.finalizarConstruccion();
        jugador.inactivar();
        plaza.reducirVida(45);
        jugador.reparar(aldeano, plaza);
    }

    @Test
    public void recolectarOroEnTurnoOponente(){
        Mapa mapa = new Mapa(50, 50);
        Jugador jugador = new Jugador(mapa, 5, 14);

        jugador.inactivar();
        Assert.assertEquals(100,jugador.getCantidadOro());
        jugador.recolectarOro();
        Assert.assertEquals(100, jugador.getCantidadOro());
    }
}
