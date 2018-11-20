import Modelo.Edificios.Castillo;
import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.*;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class AldeanoTest {

    //Pruebas base
    @Test
    public void crearAldeanoEnPosicionIndicada() {
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(5,7);
        aldeano.setPosicion(posicion);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
    }

    @Test
    public void crearAldeanoYVerificarQueGeneraOro() {
        Aldeano aldeano = new Aldeano();
        Assert.assertEquals(20, aldeano.generaOro());
    }

    @Test
    public void crearAldeanoYVerificarVidaCorrespondiente() {
        Aldeano aldeano = new Aldeano();
        Assert.assertEquals(50, aldeano.getVida());
    }

    @Test
    public void crearAldeanoYVerificarCostoCorrespondiente() {
        Aldeano aldeano = new Aldeano();
        Assert.assertEquals(25, aldeano.getCosto());
    }
    
    //Pruebas Mov normales
    
    @Test
    public void moverAldeanoUnaUnidadArribaExitosamente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        Posicion destino = new Posicion(4,6);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertTrue(aldeano.estaEnPosicion(destino));
    }

    @Test
    public void moverAldeanoUnaUnidadIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        Posicion destino = new Posicion(3,5);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertTrue(aldeano.estaEnPosicion(destino));
    }
    
    @Test
    public void moverAldeanoUnaUnidadDerechaExitosamente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        Posicion destino = new Posicion(5,5);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertTrue(aldeano.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoExitosamente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        Posicion destino = new Posicion(4,4);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertTrue(aldeano.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        Posicion destino = new Posicion(3,4);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertTrue(aldeano.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadAbajoDerechaExitosamente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        Posicion destino = new Posicion(5,4);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertTrue(aldeano.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadArribaIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        Posicion destino = new Posicion(3,6);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertTrue(aldeano.estaEnPosicion(destino));

    }

    @Test
    public void moverAldeanoUnaUnidadaArribaDerechaExitosamente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        Posicion destino = new Posicion(5,6);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino);
        Assert.assertTrue(aldeano.estaEnPosicion(destino));
    }
    @Test
    public void moverEnDosTurnosDistintos(){
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(1,1);
        aldeano.setPosicion(origen);
        Assert.assertTrue(aldeano.estaEnPosicion(origen));
        Posicion destino1 = new Posicion(1,2);
        aldeano.mover(destino1);
        Assert.assertTrue(aldeano.estaEnPosicion(destino1));
        Posicion destino2 = new Posicion(1,3);
        aldeano.desocupar();
        aldeano.mover(destino2);
        Assert.assertTrue(aldeano.estaEnPosicion(destino2));
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoDosVecesConsecutivasLanzaUnidadEstaOcupadaException(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(1,1);
        aldeano.setPosicion(posicion);
        Posicion destino1 = new Posicion(0,1);
        Posicion destino2 = new Posicion(1,1);

        Assert.assertTrue(aldeano.estaEnPosicion(posicion));
        aldeano.mover(destino1);
        aldeano.mover(destino2);
    }

    @Test
    public void moverAldeanoContinuaGenerandoOro(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(1,1);
        aldeano.setPosicion(posicion);
        Assert.assertEquals(20, aldeano.generaOro());
        Posicion posicion2 = new Posicion(1,2);
        aldeano.mover(posicion2);
        Assert.assertEquals(20, aldeano.generaOro());
    }

    //Pruebas construccion

    @Test
    public void AldeanoConstruyeCuartelYSeVerificaQueExiste(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        Cuartel cuartel = aldeano.construirCuartel(posicions);
        Assert.assertNotNull(cuartel);
    }

    @Test
    public void AldeanoConstruyeCuartelYSeVerificaQueTieneVidaCorrespondiente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        Cuartel cuartel = aldeano.construirCuartel(posicions);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        cuartel.volverAEstadoOriginal();
        Assert.assertEquals(250, cuartel.getVida());
    }

    @Test
    public void AldeanoConstruyePlazaCentralYSeVerificaQueExiste(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        PlazaCentral plaza = aldeano.construirPlazaCentral(posicions);
        Assert.assertNotNull(plaza);
    }

    @Test
    public void AldeanoConstruyePlazaCentralYSeVerificaQueTieneVidaCorrespondiente(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        PlazaCentral plaza = aldeano.construirPlazaCentral(posicions);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        plaza.volverAEstadoOriginal();
        Assert.assertEquals(450, plaza.getVida());
    }

    @Test(expected = UnidadNoPuedeConstruirException.class)
    public void AldeanoConstruyeCuartelYSeVerificaQueAldeanoEstaOcupado(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        aldeano.construirCuartel(posicions);
        aldeano.construirPlazaCentral(posicions);
    }


    @Test
    public void AldeanoConstruyeCuartelYSeVerificaQueoNoGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Assert.assertEquals(20,aldeano.generaOro());
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        aldeano.construirCuartel(posicions);
        Assert.assertEquals(0,aldeano.generaOro());
    }

    @Test
    public void AldeanoConstruyePlazaCentralYSeVerificaQueNoGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Assert.assertEquals(20,aldeano.generaOro());
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        aldeano.construirPlazaCentral(posicions);
        Assert.assertEquals(0,aldeano.generaOro());
    }


    @Test (expected = UnidadNoPuedeConstruirException.class)
    public void aldeanoConstruirPlazaCentralDosVecesEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        aldeano.construirPlazaCentral(posicions);
        aldeano.construirPlazaCentral(posicions);
    }

    @Test (expected = UnidadNoPuedeConstruirException.class)
    public void aldeanoConstruirCuartellDosVecesEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        aldeano.construirCuartel(posicions);
        aldeano.construirCuartel(posicions);
    }

    @Test (expected = UnidadNoPuedeConstruirException.class)
    public void aldeanoContinuarConstruccionPlazaCentralEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        PlazaCentral plaza = aldeano.construirPlazaCentral(posicions);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.continuarConstruccionPlazaCentral(plaza);
    }

    @Test (expected = UnidadNoPuedeConstruirException.class)
    public void aldeanoContinuarConstruccionCuartelEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(2,2);
        Posicion posicion4 = new Posicion(2,3);
        Posicion posicionAlde = new Posicion(1,1);
        ArrayList<Posicion> posicions =new ArrayList<>();
        posicions.add(posicion1);
        posicions.add(posicion2);
        posicions.add(posicion3);
        posicions.add(posicion4);
        aldeano.setPosicion(posicionAlde);
        Cuartel cuartel = aldeano.construirCuartel(posicions);
        aldeano.continuarConstruccionCuartel(cuartel);
    }

    //Pruebas de reparacion

    @Test (expected = EdificioConVidaAlMaximoException.class)
    public void AldeanoReparaCuartelConVidaCompletaException(){
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(2,3);
        aldeano.setPosicion(origen);
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel cuartel = aldeano.construirCuartel(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.repararEdificio(cuartel);
    }

    @Test (expected = EdificioConVidaAlMaximoException.class)
    public void AldeanoReparaPlazaCentralConVidaCompletaException(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(1,6);
        aldeano.setPosicion(posicion);
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = aldeano.construirPlazaCentral(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.repararEdificio(plaza);
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void AldeanoReparaCuartelYSeVerificaSuEstado(){
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(2,6);
        aldeano.setPosicion(origen);
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel cuartel = aldeano.construirCuartel(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        cuartel.reducirVida(60);
        aldeano.repararEdificio(cuartel);
        Posicion destino = new Posicion(2,3);
        aldeano.mover(destino);
    }

    @Test
    public void AldeanoReparaCuartelYSeVerificaAumentoVida(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(2,6);
        aldeano.setPosicion(posicion);
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel cuartel = aldeano.construirCuartel(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        Assert.assertEquals(250,cuartel.getVida());
        cuartel.reducirVida(50);
        Assert.assertEquals(200,cuartel.getVida());
        aldeano.repararEdificio(cuartel);
        Assert.assertEquals(250,cuartel.getVida());
    }

    @Test
    public void AldeanoReparaCuartelNoGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(3,6);
        aldeano.setPosicion(origen);
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel cuartel = aldeano.construirCuartel(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        cuartel.reducirVida(50);
        Assert.assertEquals(200,cuartel.getVida());
        aldeano.repararEdificio(cuartel);
        Assert.assertEquals(0,aldeano.generaOro());
    }

    @Test
    public void AldeanoReparaPlazaCentralNoGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(3,6);
        aldeano.setPosicion(posicion);
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = aldeano.construirPlazaCentral(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Assert.assertEquals(0,aldeano.generaOro());
    }

    @Test
    public void AldeanoFinalizaReparacionCuartelYGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(1,6);
        aldeano.setPosicion(origen);
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel cuartel = aldeano.construirCuartel(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        Assert.assertEquals(250,cuartel.getVida());
        cuartel.reducirVida(50);
        Assert.assertEquals(200,cuartel.getVida());
        aldeano.repararEdificio(cuartel);
        aldeano.desocupar();
        Assert.assertEquals(20, aldeano.generaOro());
    }

    @Test
    public void AldeanoFinalizaReparacionPlazaCentralYGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(4,5);
        aldeano.setPosicion(posicion);
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = aldeano.construirPlazaCentral(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Assert.assertEquals(0,aldeano.generaOro());
        aldeano.desocupar();
        Assert.assertEquals(20,aldeano.generaOro());
    }


    @Test (expected = UnidadEstaOcupadoException.class)
    public void AldeanoReparaPlazaCentralYSeVerificaSuEstado(){
        Aldeano aldeano = new Aldeano();
        Posicion inicial = new Posicion(3,3);
        aldeano.setPosicion(inicial);
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = aldeano.construirPlazaCentral(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Posicion destino = new Posicion(4,3);
        aldeano.mover(destino);
    }

    @Test
    public void AldeanoReparaPlazaCentralYSeVerificaAumentoVida(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(1,6);
        aldeano.setPosicion(posicion);
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = aldeano.construirPlazaCentral(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        Assert.assertEquals(450,plaza.getVida());
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Assert.assertEquals(plaza.getVida(),425);
    }

    @Test (expected = UnidadNoPuedeRepararException.class)
    public void aldeanoRepararPlazaCentralDosVecesEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(2,3);
        aldeano.setPosicion(posicion);
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = aldeano.construirPlazaCentral(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        plaza.reducirVida(100);
        aldeano.repararEdificio(plaza);
        aldeano.repararEdificio(plaza);
    }

    @Test (expected = UnidadNoPuedeRepararException.class)
    public void aldeanoRepararCuartellDosVecesEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(1,6);
        aldeano.setPosicion(posicion);
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel cuartel = aldeano.construirCuartel(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        cuartel.reducirVida(100);
        aldeano.repararEdificio(cuartel);
        aldeano.repararEdificio(cuartel);
    }

    @Test (expected = EntidadFueraDeRangoException.class)
    public void aldeanoRepararCuartelFueraDeRango(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(1,99);
        aldeano.setPosicion(posicion);
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        Cuartel cuartel = aldeano.construirCuartel(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.volverAEstadoOriginal();
        cuartel.reducirVida(100);
        aldeano.repararEdificio(cuartel);
    }

    @Test (expected = EntidadFueraDeRangoException.class)
    public void aldeanoRepararPlazaCentralFueraDeRango(){
        Aldeano aldeano = new Aldeano();
        Posicion posicion = new Posicion(1,99);
        aldeano.setPosicion(posicion);
        Posicion posicion1 = new Posicion(2, 5);
        Posicion posicion2 = new Posicion(2, 4);
        Posicion posicion3 = new Posicion(3, 5);
        Posicion posicion4 = new Posicion(3, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
        posiciones.add(posicion1);
        posiciones.add(posicion2);
        posiciones.add(posicion3);
        posiciones.add(posicion4);
        PlazaCentral plaza = aldeano.construirPlazaCentral(posiciones);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.volverAEstadoOriginal();
        plaza.reducirVida(100);
        aldeano.repararEdificio(plaza);
    }

    @Test
    public void aldeanoRepararCastilloExitosamente(){
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(4,5);
        aldeano.setPosicion(origen);
        Castillo castillo = new Castillo();
        Posicion posicion1 = new Posicion(1, 1);
        Posicion posicion2 = new Posicion(1, 2);
        Posicion posicion3 = new Posicion(1, 3);
        Posicion posicion4 = new Posicion(1, 4);
        Posicion posicion5 = new Posicion(2, 1);
        Posicion posicion6 = new Posicion(2, 2);
        Posicion posicion7 = new Posicion(2, 3);
        Posicion posicion8 = new Posicion(2, 4);
        Posicion posicion9 = new Posicion(3, 1);
        Posicion posicion10 = new Posicion(3, 2);
        Posicion posicion11 = new Posicion(3, 3);
        Posicion posicion12 = new Posicion(3, 4);
        Posicion posicion13 = new Posicion(4, 1);
        Posicion posicion14 = new Posicion(4, 2);
        Posicion posicion15 = new Posicion(4, 3);
        Posicion posicion16 = new Posicion(4, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
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
        castillo.setPosiciones(posiciones);
        castillo.reducirVida(50);
        aldeano.repararEdificio(castillo);
        Assert.assertEquals(965,castillo.getVida());
    }

    @Test (expected = UnidadNoPuedeRepararException.class)
    public void aldeanoOcupadoRepararCastilloFalla(){
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(4,6);
        aldeano.setPosicion(origen);
        Castillo castillo = new Castillo();
        Posicion posicion1 = new Posicion(1, 1);
        Posicion posicion2 = new Posicion(1, 2);
        Posicion posicion3 = new Posicion(1, 3);
        Posicion posicion4 = new Posicion(1, 4);
        Posicion posicion5 = new Posicion(2, 1);
        Posicion posicion6 = new Posicion(2, 2);
        Posicion posicion7 = new Posicion(2, 3);
        Posicion posicion8 = new Posicion(2, 4);
        Posicion posicion9 = new Posicion(3, 1);
        Posicion posicion10 = new Posicion(3, 2);
        Posicion posicion11 = new Posicion(3, 3);
        Posicion posicion12 = new Posicion(3, 4);
        Posicion posicion13 = new Posicion(4, 1);
        Posicion posicion14 = new Posicion(4, 2);
        Posicion posicion15 = new Posicion(4, 3);
        Posicion posicion16 = new Posicion(4, 4);
        ArrayList<Posicion> posiciones = new ArrayList<>();
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
        castillo.setPosiciones(posiciones);
        castillo.reducirVida(50);
        Posicion destino = new Posicion(4,5);
        aldeano.mover(destino);
        aldeano.repararEdificio(castillo);
    }


}
