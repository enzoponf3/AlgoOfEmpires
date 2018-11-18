import Modelo.Edificios.Cuartel;
import Modelo.Edificios.PlazaCentral;
import Modelo.Exceptions.EdificioConVidaAlMaximoException;
import Modelo.Exceptions.UndidadNoPuedeRepararException;
import Modelo.Exceptions.UnidadEstaOcupadoException;
import Modelo.Exceptions.UnidadNoPuedeConstruirException;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import org.junit.Assert;
import org.junit.Test;

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
    public void AldeanoConstruyeCuartelYSeVerificaQueExiste(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel = aldeano.construirCuartel();
        Assert.assertNotNull(cuartel);
    }

    @Test
    public void AldeanoConstruyeCuartelYSeVerificaQueTieneVidaCorrespondiente(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        Assert.assertEquals(250, cuartel.getVida());
    }

    @Test
    public void AldeanoConstruyePlazaCentralYSeVerificaQueExiste(){
        Aldeano aldeano = new Aldeano();
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        Assert.assertNotNull(plaza);
    }

    @Test
    public void AldeanoConstruyePlazaCentralYSeVerificaQueTieneVidaCorrespondiente(){
        Aldeano aldeano = new Aldeano();
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        Assert.assertEquals(450, plaza.getVida());
    }

    @Test(expected = UnidadNoPuedeConstruirException.class)
    public void AldeanoConstruyeCuartelYSeVerificaQueAldeanoEstaOcupado(){
        Aldeano aldeano = new Aldeano();
        aldeano.construirPlazaCentral();
        aldeano.construirPlazaCentral();
    }


    @Test
    public void AldeanoConstruyeCuartelYSeVerificaQueoNoGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Assert.assertEquals(20,aldeano.generaOro());
        aldeano.construirCuartel();
        Assert.assertEquals(0,aldeano.generaOro());
    }

    @Test
    public void AldeanoConstruyePlazaCentralYSeVerificaQueNoGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Assert.assertEquals(20,aldeano.generaOro());
        aldeano.construirPlazaCentral();
        Assert.assertEquals(0,aldeano.generaOro());
    }


    @Test (expected = UnidadNoPuedeConstruirException.class)
    public void aldeanoConstruirPlazaCentralDosVecesEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        aldeano.construirPlazaCentral();
        aldeano.construirPlazaCentral();
    }

    @Test (expected = UnidadNoPuedeConstruirException.class)
    public void aldeanoConstruirCuartellDosVecesEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        aldeano.construirCuartel();
        aldeano.construirCuartel();
    }

    @Test (expected = UnidadNoPuedeConstruirException.class)
    public void aldeanoContinuarConstruccionPlazaCentralEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.continuarConstruccionPlazaCentral(plaza);
    }

    @Test (expected = UnidadNoPuedeConstruirException.class)
    public void aldeanoContinuarConstruccionCuartelEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.continuarConstruccionCuartel(cuartel);
    }

    //Pruebas de reparacion

    @Test (expected = EdificioConVidaAlMaximoException.class)
    public void AldeanoReparaCuartelConVidaCompletaException(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        aldeano.repararEdificio(cuartel);
    }

    @Test (expected = EdificioConVidaAlMaximoException.class)
    public void AldeanoReparaPlazaCentralConVidaCompletaException(){
        Aldeano aldeano = new Aldeano();
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        aldeano.repararEdificio(plaza);
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void AldeanoReparaCuartelYSeVerificaSuEstado(){
        Aldeano aldeano = new Aldeano();
        Posicion origen = new Posicion(2,2);
        aldeano.setPosicion(origen);
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.reducirVida(60);
        aldeano.repararEdificio(cuartel);
        Posicion destino = new Posicion(2,3);
        aldeano.mover(destino);
    }

    @Test
    public void AldeanoReparaCuartelYSeVerificaAumentoVida(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        Assert.assertEquals(250,cuartel.getVida());
        cuartel.reducirVida(50);
        Assert.assertEquals(200,cuartel.getVida());
        aldeano.repararEdificio(cuartel);
        Assert.assertEquals(250,cuartel.getVida());
    }

    @Test
    public void AldeanoReparaCuartelNoGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.reducirVida(50);
        Assert.assertEquals(200,cuartel.getVida());
        aldeano.repararEdificio(cuartel);
        Assert.assertEquals(0,aldeano.generaOro());
    }

    @Test
    public void AldeanoReparaPlazaCentralNoGeneraOro(){
        Aldeano aldeano = new Aldeano();
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Assert.assertEquals(0,aldeano.generaOro());
    }

    @Test
    public void AldeanoFinalizaReparacionCuartelYGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
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
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
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
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Posicion destino = new Posicion(4,3);
        aldeano.mover(destino);
    }

    @Test
    public void AldeanoReparaPlazaCentralYSeVerificaAumentoVida(){
        Aldeano aldeano = new Aldeano();
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        Assert.assertEquals(450,plaza.getVida());
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Assert.assertEquals(plaza.getVida(),425);
    }

    @Test (expected = UndidadNoPuedeRepararException.class)
    public void aldeanoRepararPlazaCentralDosVecesEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocupar();
        plaza.reducirVida(100);
        aldeano.repararEdificio(plaza);
        aldeano.repararEdificio(plaza);
    }

    @Test (expected = UndidadNoPuedeRepararException.class)
    public void aldeanoRepararCuartellDosVecesEnMismoTurnoFalla(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocupar();
        cuartel.reducirVida(100);
        aldeano.repararEdificio(cuartel);
        aldeano.repararEdificio(cuartel);
    }

}
