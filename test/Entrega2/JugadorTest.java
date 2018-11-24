package Entrega2;

import Modelo.Exceptions.*;
import Modelo.Jugador.Jugador;
import Modelo.Posicion;
import Modelo.Unidades.*;
import Modelo.Edificios.*;
import org.junit.Assert;
import org.junit.Test;
import java.util.ArrayList;

public class JugadorTest {

    @Test
    public void obtenerPosicionesInicialesCastilloJugador1Correctamente(){
        Jugador jugador = new Jugador(5, 14);

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
        Jugador jugador = new Jugador(5, 14);
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
        Jugador jugador = new Jugador(5, 14);
        Castillo castillo = jugador.getCastillo();
        Assert.assertEquals(castillo.getVida(), 1000);
    }

    @Test
    public void verificarQueIniciaConUnaPlazaCentral(){
        Jugador jugador = new Jugador(5, 14);
        Assert.assertEquals( 1, jugador.getEdificios().size() );
    }

    @Test
    public void verificarQueIniciaConUnaPlazaCentralCorrectamenteCreada(){
        Jugador jugador = new Jugador(5, 14);
        ArrayList<Edificio> edificios = jugador.getEdificios();
        Edificio plaza = edificios.get(0);
        Assert.assertEquals(plaza.getVida(), 450);
    }

    @Test
    public void verificarQueIniciaConTresAldeanos(){
        Jugador jugador = new Jugador(5, 14);
        ArrayList<Aldeano> aldeanos = jugador.getAldeanos();
        Assert.assertEquals(3, aldeanos.size());
    }

    @Test
    public void verificarQueIniciaConTresAldeanosCorrectamenteCreados(){
        Jugador jugador = new Jugador(5, 14);
        ArrayList<Aldeano> aldeanos = jugador.getAldeanos();
        for (Aldeano aldeano : aldeanos)
            Assert.assertEquals(aldeano.getVida(),50);
    }

    @Test
    public void verificarQueIniciaConCienDeOro(){
        Jugador jugador = new Jugador(5, 14);
        Assert.assertEquals(100, jugador.getCantidadOro());
    }

    @Test
    public void verificarTodasLasCondicionesEnSimultaneo(){
        Jugador jugador = new Jugador(5, 14);
        Assert.assertNotNull( jugador.getCastillo() );
        Assert.assertEquals( 1, jugador.getEdificios().size() );
        ArrayList<Aldeano> aldeanos = jugador.getAldeanos();
        Assert.assertEquals(3, aldeanos.size());
        Assert.assertEquals(100, jugador.getCantidadOro());
    }

    @Test
    public void verificarQueIniciaConEjercitoVacio(){
        Jugador jugador = new Jugador(5, 14);
        Assert.assertTrue( jugador.getEjercito().isEmpty() );
    }


    //Agrego unidades al ejercito

    @Test
    public void agregarUnArqueroAlEjercitoCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        Arquero arquero = new Arquero();
        jugador.agregarAEjercito(arquero);
        Assert.assertFalse( jugador.getEjercito().isEmpty() );
    }

    @Test
    public void agregarUnEspadachinAlEjercitoCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        Espadachin espadachin = new Espadachin();

        jugador.agregarAEjercito(espadachin);
        Assert.assertFalse( jugador.getEjercito().isEmpty() );
    }

    @Test
    public void agregarUnArmaDeAsedioAlEjercitoCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();

        jugador.agregarAEjercito(armaDeAsedio);
        Assert.assertFalse( jugador.getEjercito().isEmpty() );
    }

    @Test
    public void agregarUnoDeCadaUnoAlEjercitoCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        Arquero arquero = new Arquero();
        Espadachin espadachin = new Espadachin();
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();

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
        Jugador jugador = new Jugador(5, 14);
        Aldeano aldeano = new Aldeano();

        jugador.agregarAldeano(aldeano);
        Assert.assertFalse( jugador.getAldeanos().isEmpty() );
        Assert.assertEquals(4, jugador.getAldeanos().size() );
    }

    @Test
    public void agregarAldeanosSobreElLimiteYVerificarPoblacion(){
        Jugador jugador = new Jugador(5, 14);

        for(int i=0; i<47; i++){
            Aldeano aldeano = new Aldeano();
            jugador.agregarAldeano(aldeano);
        }

        Assert.assertEquals(50, jugador.getAldeanos().size() );
    }

    @Test (expected = LimiteDePoblacionException.class)
    public void agregarAldeanosPasandoElLimiteDePoblacion(){
        Jugador jugador = new Jugador(5, 14);

        for(int i=0; i<48; i++){
            Aldeano aldeano = new Aldeano();
            jugador.agregarAldeano(aldeano);
        }

    }

    @Test
    public void agregarArqueroSobreElLimiteYVerificarPoblacion(){
        Jugador jugador = new Jugador(5, 14);

        for(int i=0; i<47; i++){
            Arquero arquero = new Arquero();
            jugador.agregarAEjercito(arquero);
        }

        Assert.assertEquals(47, jugador.getEjercito().size() );
    }


    @Test (expected = LimiteDePoblacionException.class)
    public void agregarArquerosPasandoElLimiteDePoblacion(){
        Jugador jugador = new Jugador(5, 14);

        for(int i=0; i<48; i++){
            Arquero arquero = new Arquero();
            jugador.agregarAEjercito(arquero);
        }

    }

    @Test
    public void agregarEspadachinSobreElLimiteYVerificarPoblacion(){
        Jugador jugador = new Jugador(5, 14);

        for(int i=0; i<47; i++){
            Espadachin espadachin = new Espadachin();
            jugador.agregarAEjercito(espadachin);
        }

        Assert.assertEquals(47, jugador.getEjercito().size() );
    }

    @Test (expected = LimiteDePoblacionException.class)
    public void agregarEspadachinesPasandoElLimiteDePoblacion(){
        Jugador jugador = new Jugador(5, 14);

        for(int i=0; i<48; i++){
            Espadachin espadachin = new Espadachin();
            jugador.agregarAEjercito(espadachin);
        }

    }

    @Test
    public void agregarArmaDeAsedioSobreElLimiteYVerificarPoblacion(){
        Jugador jugador = new Jugador(5, 14);

        for(int i=0; i<47; i++){
            ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
            jugador.agregarAEjercito(armaDeAsedio);
        }

        Assert.assertEquals(47, jugador.getEjercito().size() );
    }

    @Test (expected = LimiteDePoblacionException.class)
    public void agregarArmaDeAsedioPasandoElLimiteDePoblacion(){
        Jugador jugador = new Jugador(5, 14);

        for(int i=0; i<48; i++){
            ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
            jugador.agregarAEjercito(armaDeAsedio);
        }

    }

    //Agregar edificios

    @Test
    public void agregarUnaPlazacentralCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
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
        Jugador jugador = new Jugador(5, 14);
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
        Jugador jugador = new Jugador(5, 14);
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
        Jugador jugador = new Jugador(5, 14);
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(2,5);
        aldeano.setPosicion(posicion);

        jugador.agregarAldeano(aldeano);
        Aldeano aldeanoAComparar = jugador.devolverAldeanoEnPosicion(posicion);

        Assert.assertEquals( aldeano, aldeanoAComparar );
    }

    @Test
    public void devolverAldeanoInicialCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        Posicion posicionAldeano = new Posicion(1,1);

        Aldeano aldeanoInicial = jugador.devolverAldeanoEnPosicion(posicionAldeano);

        Assert.assertEquals( aldeanoInicial, jugador.getAldeanos().get(1) );
    }

    @Test (expected = AldeanoNoExisteException.class)
    public void devolverAldeanoQueNoEsDelJugador(){
        Jugador jugador = new Jugador(5, 14);
        Posicion posicionAldeano = new Posicion(1,6);

        jugador.devolverAldeanoEnPosicion(posicionAldeano);
    }

    @Test
    public void devolverArqueroEnPosicionCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(2,5);
        arquero.setPosicion(posicion);

        jugador.agregarAEjercito(arquero);
        Arquero arqueroAComparar = (Arquero) jugador.devolverAtacanteEnPosicion(posicion);

        Assert.assertEquals( arquero, arqueroAComparar );
    }

    @Test (expected = AtacanteNoExisteException.class)
    public void devolverArqueroQueNoEsDelJugadorEnPosicion(){
        Jugador jugador = new Jugador(5, 14);
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(2,5);
        arquero.setPosicion(posicion);

        jugador.devolverAtacanteEnPosicion(posicion);
    }

    @Test
    public void devolverEspadachinEnPosicionCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(2,5);
        espadachin.setPosicion(posicion);

        jugador.agregarAEjercito(espadachin);
        Espadachin espadachinAComprar = (Espadachin) jugador.devolverAtacanteEnPosicion(posicion);

        Assert.assertEquals( espadachin, espadachinAComprar);
    }

    @Test (expected = AtacanteNoExisteException.class)
    public void devolverEspadachinQueNoEsDelJugadorEnPosicion(){
        Jugador jugador = new Jugador(5, 14);
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(2,5);
        espadachin.setPosicion(posicion);

        jugador.devolverAtacanteEnPosicion(posicion);
    }

    @Test
    public void devolverArmaDeAsedioEnPosicionCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(2,5);
        armaDeAsedio.setPosicion(posicion);

        jugador.agregarAEjercito(armaDeAsedio);
        ArmaDeAsedio armaDeAsedioAComparar = (ArmaDeAsedio) jugador.devolverAtacanteEnPosicion(posicion);

        Assert.assertEquals( armaDeAsedio, armaDeAsedioAComparar);
    }

    @Test (expected = AtacanteNoExisteException.class)
    public void devolverArmaDeAsedioQueNoEsDelJugadorEnPosicion(){
        Jugador jugador = new Jugador(5, 14);
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(2,5);
        armaDeAsedio.setPosicion(posicion);

        jugador.devolverAtacanteEnPosicion(posicion);
    }

    //Unidad movible

    @Test
    public void devolverAldeanoInicialComoUnidadMovibleCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
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


    //Remover aldeanos

    @Test
    public void removerUnAldeano(){
        Jugador jugador = new Jugador(5, 14);
        Aldeano aldeanoARemover = new Aldeano();
        Posicion posicion = new Posicion(3,5);
        aldeanoARemover.setPosicion(posicion);

        jugador.agregarAldeano(aldeanoARemover);
        Aldeano aldeano = jugador.removerAldeano(aldeanoARemover);

        Assert.assertEquals(3, jugador.getAldeanos().size() );
        Assert.assertEquals(aldeano, aldeanoARemover);
    }

    @Test (expected = AldeanoNoExisteException.class)
    public void removerUnAldeanoQueNoEsDelJugador(){
        Jugador jugador = new Jugador(5, 14);
        Aldeano aldeanoARemover = new Aldeano();
        Posicion posicion = new Posicion(3,5);
        aldeanoARemover.setPosicion(posicion);

        Aldeano aldeano = jugador.removerAldeano(aldeanoARemover);

        Assert.assertEquals(3, jugador.getAldeanos().size() );
    }

    @Test
    public void removerUnAldeanoDisminuyeLaPoblacionEnUno(){
        Jugador jugador = new Jugador(5, 14);
        Aldeano aldeanoARemover = new Aldeano();

        jugador.agregarAldeano(aldeanoARemover);
        Assert.assertEquals(4, jugador.getAldeanos().size() );
        Aldeano aldeano = jugador.removerAldeano(aldeanoARemover);

        Assert.assertEquals(3, jugador.getAldeanos().size() );
        Assert.assertEquals(aldeano, aldeanoARemover);
    }

    //Remover atacantes

    @Test
    public void removerUnEspadachinCorrectamenteDisminuyePoblacion(){
        Jugador jugador = new Jugador(5, 14);
        Espadachin espadachinARemover = new Espadachin();

        jugador.agregarAEjercito(espadachinARemover);
        Espadachin espadachin = (Espadachin) jugador.removerDeEjercito(espadachinARemover);

        Assert.assertEquals(0, jugador.getEjercito().size() );
        Assert.assertEquals(espadachin, espadachinARemover);
    }

    @Test (expected = AtacanteNoExisteException.class)
    public void removerUnEspadachinQueNoEsDelJugador(){
        Jugador jugador = new Jugador(5, 14);
        Espadachin espadachinARemover = new Espadachin();

        Espadachin espadachin = (Espadachin) jugador.removerDeEjercito(espadachinARemover);

        Assert.assertEquals(0, jugador.getEjercito().size() );
    }

    @Test
    public void removerUnArqueroCorrectamenteDisminuyePoblacion(){
        Jugador jugador = new Jugador(5, 14);
        Arquero arqueroARemover = new Arquero();

        jugador.agregarAEjercito(arqueroARemover);
        Arquero arquero = (Arquero) jugador.removerDeEjercito(arqueroARemover);

        Assert.assertEquals(0, jugador.getEjercito().size() );
        Assert.assertEquals(arquero, arqueroARemover);
    }

    @Test (expected = AtacanteNoExisteException.class)
    public void removerUnArqueroQueNoEsDelJugador(){
        Jugador jugador = new Jugador(5, 14);
        Arquero arqueroARemover = new Arquero();

        Arquero arquero = (Arquero) jugador.removerDeEjercito(arqueroARemover);

        Assert.assertEquals(0, jugador.getEjercito().size() );
        Assert.assertEquals(arquero, arqueroARemover);
    }

    @Test
    public void removerUnArmaDeAsedioCorrectamenteDisminuyePoblacion(){
        Jugador jugador = new Jugador(5, 14);
        ArmaDeAsedio armaDeAsedioARemover = new ArmaDeAsedio();

        jugador.agregarAEjercito(armaDeAsedioARemover);
        ArmaDeAsedio armaDeAsedio = (ArmaDeAsedio) jugador.removerDeEjercito(armaDeAsedioARemover);

        Assert.assertEquals(0, jugador.getEjercito().size() );
        Assert.assertEquals(armaDeAsedio, armaDeAsedioARemover);
    }

    @Test (expected = AtacanteNoExisteException.class)
    public void removerUnArmaDeAsedioQueNoEsDelJugador(){
        Jugador jugador = new Jugador(5, 14);
        ArmaDeAsedio armaDeAsedioARemover = new ArmaDeAsedio();

        ArmaDeAsedio armaDeAsedio = (ArmaDeAsedio) jugador.removerDeEjercito(armaDeAsedioARemover);

        Assert.assertEquals(0, jugador.getEjercito().size() );
        Assert.assertEquals(armaDeAsedio, armaDeAsedioARemover);
    }

    //Remover edificios

    @Test
    public void removerUnaPlazaCentralQueFueAgregadaCorrectamente(){
        Jugador jugador = new Jugador(5, 14);
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
        Jugador jugador = new Jugador(5, 14);
        Posicion posicion1 = new Posicion(14, 5);

        PlazaCentral plazaCentral = (PlazaCentral) jugador.devolverEdificioEnPosicion(posicion1);
        PlazaCentral plazaCentral1 = (PlazaCentral) jugador.removerEdificio(posicion1);

        Assert.assertEquals(0, jugador.getEdificios().size() );
        Assert.assertEquals(plazaCentral1, plazaCentral);
    }


    @Test (expected = EdificioNoExisteException.class)
    public void removerUnaPlazaCentralQueNoEsDelJugador(){
        Jugador jugador = new Jugador(5, 14);
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
        Jugador jugador = new Jugador(5, 14);

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
        Jugador jugador = new Jugador(5, 14);

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
        Jugador jugador = new Jugador(5,14);
        jugador.inactivar();
        ArmaDeAsedio arma = new ArmaDeAsedio(new Posicion(1,1));
        arma.montar();
        arma.desocupar();
        jugador.agregarAEjercito(arma);
        jugador.desmontarArmaDeAsedio(arma);
    }

    @Test (expected = TurnoDelOponenteException.class)
     public void crearCuartelEnTurnoDelOponente() {
        Jugador jugador = new Jugador(5, 14);
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
        Jugador jugador = new Jugador(5, 14);
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
        Jugador jugador = new Jugador(5, 14);
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
        Jugador jugador = new Jugador(5, 14);
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
        Jugador jugador = new Jugador(5,14);
        jugador.inactivar();
        Assert.assertEquals(100,jugador.getCantidadOro());
        jugador.recolectarOro();
        Assert.assertEquals(100, jugador.getCantidadOro());
    }
}
