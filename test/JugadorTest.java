import Modelo.Exceptions.LimiteDePoblacionException;
import Modelo.Jugador;
import Modelo.Unidades.*;
import Modelo.Edificios.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class JugadorTest {

    //Inicializacion

    @Test
    public void verificarQueIniciaConUnCastillo(){
        Jugador jugador = new Jugador();

        Assert.assertNotNull( jugador.getCastillo() );
    }

    @Test
    public void verificarQueIniciaConUnaPlazaCentral(){
        Jugador jugador = new Jugador();

        Assert.assertEquals( 1, jugador.getEdificios().size() );
    }

    @Test
    public void verificarQueIniciaConTresAldeanos(){
        Jugador jugador = new Jugador();

        ArrayList<Aldeano> aldeanos = jugador.getAldeanos();
        Assert.assertEquals(3, aldeanos.size());
    }

    @Test
    public void verificarQueIniciaConCienDeOro(){
        Jugador jugador = new Jugador();

        Assert.assertEquals(100, jugador.getCantidadOro());
    }

    @Test
    public void verificarTodasLasCondicionesEnSimultaneo(){
        Jugador jugador = new Jugador();

        Assert.assertNotNull( jugador.getCastillo() );
        Assert.assertEquals( 1, jugador.getEdificios().size() );
        ArrayList<Aldeano> aldeanos = jugador.getAldeanos();
        Assert.assertEquals(3, aldeanos.size());
        Assert.assertEquals(100, jugador.getCantidadOro());
    }

    @Test
    public void verificarQueIniciaConEjercitoVacio(){
        Jugador jugador = new Jugador();

        Assert.assertTrue( jugador.getEjercito().isEmpty() );
    }


    //Agrego unidades al ejercito
    @Test
    public void agregarUnArqueroAlEjercitoCorrectamente(){
        Jugador jugador = new Jugador();
        Arquero arquero = new Arquero();

        jugador.agregarAEjercito(arquero);
        Assert.assertFalse( jugador.getEjercito().isEmpty() );
    }

    @Test
    public void agregarUnEspadachinAlEjercitoCorrectamente(){
        Jugador jugador = new Jugador();
        Espadachin espadachin = new Espadachin();

        jugador.agregarAEjercito(espadachin);
        Assert.assertFalse( jugador.getEjercito().isEmpty() );
    }

    @Test
    public void agregarUnArmaDeAsedioAlEjercitoCorrectamente(){
        Jugador jugador = new Jugador();
        ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();

        jugador.agregarAEjercito(armaDeAsedio);
        Assert.assertFalse( jugador.getEjercito().isEmpty() );
    }

    @Test
    public void agregarUnoDeCadaUnoAlEjercitoCorrectamente(){
        Jugador jugador = new Jugador();
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
        Jugador jugador = new Jugador();
        Aldeano aldeano = new Aldeano();

        jugador.agregarAldeano(aldeano);
        Assert.assertFalse( jugador.getAldeanos().isEmpty() );
        Assert.assertEquals(4, jugador.getAldeanos().size() );
    }

    @Test
    public void agregarAldeanosSobreElLimiteYVerificarPoblacion(){
        Jugador jugador = new Jugador();

        for(int i=0; i<47; i++){
            Aldeano aldeano = new Aldeano();
            jugador.agregarAldeano(aldeano);
        }

        Assert.assertEquals(50, jugador.getAldeanos().size() );
    }

    @Test (expected = LimiteDePoblacionException.class)
    public void agregarAldeanosPasandoElLimiteDePoblacion(){
        Jugador jugador = new Jugador();

        for(int i=0; i<48; i++){
            Aldeano aldeano = new Aldeano();
            jugador.agregarAldeano(aldeano);
        }

    }

    @Test
    public void agregarArqueroSobreElLimiteYVerificarPoblacion(){
        Jugador jugador = new Jugador();

        for(int i=0; i<47; i++){
            Arquero arquero = new Arquero();
            jugador.agregarAEjercito(arquero);
        }

        Assert.assertEquals(47, jugador.getEjercito().size() );
    }


    @Test (expected = LimiteDePoblacionException.class)
    public void agregarArquerosPasandoElLimiteDePoblacion(){
        Jugador jugador = new Jugador();

        for(int i=0; i<48; i++){
            Arquero arquero = new Arquero();
            jugador.agregarAEjercito(arquero);
        }

    }

    @Test
    public void agregarEspadachinSobreElLimiteYVerificarPoblacion(){
        Jugador jugador = new Jugador();

        for(int i=0; i<47; i++){
            Espadachin espadachin = new Espadachin();
            jugador.agregarAEjercito(espadachin);
        }

        Assert.assertEquals(47, jugador.getEjercito().size() );
    }

    @Test (expected = LimiteDePoblacionException.class)
    public void agregarEspadachinesPasandoElLimiteDePoblacion(){
        Jugador jugador = new Jugador();

        for(int i=0; i<48; i++){
            Espadachin espadachin = new Espadachin();
            jugador.agregarAEjercito(espadachin);
        }

    }

    @Test
    public void agregarArmaDeAsedioSobreElLimiteYVerificarPoblacion(){
        Jugador jugador = new Jugador();

        for(int i=0; i<47; i++){
            ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
            jugador.agregarAEjercito(armaDeAsedio);
        }

        Assert.assertEquals(47, jugador.getEjercito().size() );
    }

    @Test (expected = LimiteDePoblacionException.class)
    public void agregarArmaDeAsedioPasandoElLimiteDePoblacion(){
        Jugador jugador = new Jugador();

        for(int i=0; i<48; i++){
            ArmaDeAsedio armaDeAsedio = new ArmaDeAsedio();
            jugador.agregarAEjercito(armaDeAsedio);
        }

    }

    //Agregar edificios

    @Test
    public void agregarUnaPlazacentralCorrectamente(){
        Jugador jugador = new Jugador();
        PlazaCentral plazaCentral = new PlazaCentral();

        jugador.agregarEdificio(plazaCentral);

        Assert.assertEquals(2, jugador.getEdificios().size() );
    }

    @Test
    public void agregarUnCuartelCorrectamente(){
        Jugador jugador = new Jugador();
        Cuartel cuartel = new Cuartel();

        jugador.agregarEdificio(cuartel);

        Assert.assertEquals(2, jugador.getEdificios().size() );
    }

    @Test
    public void agregarUnaPlazaYUnCuartelCorrectamente(){
        Jugador jugador = new Jugador();
        PlazaCentral plazaCentral = new PlazaCentral();
        Cuartel cuartel = new Cuartel();

        jugador.agregarEdificio(plazaCentral);
        jugador.agregarEdificio(cuartel);

        Assert.assertEquals(3, jugador.getEdificios().size() );
    }

    //No pruebo agregar castillos dado que directamente no se pueden construir, y para agregarlos tienen que ser
    //construidos primero.

    //Remover aldeanos
/*
    @Test
    public void removerUnAldeano(){
        Jugador jugador = new Jugador();

        jugador.removerAldeano();

        Assert.assertEquals(2, jugador.getAldeanos().size() );
    }
*/
}
