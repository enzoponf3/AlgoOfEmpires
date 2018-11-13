import org.junit.Test;
import org.junit.Assert;


//Cada vez que se hace un aldeano.desocuparse() Indica que pasa de turno

public class AldeanoTest {
    //Pruebas base
    @Test
    public void crearAldeanoEnPosicionIndicada(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(5,7);
        Assert.assertEquals(true,aldeano.estaEnPos(5,7));
    }

    @Test
    public void crearAldeanoYVerificarQueGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Assert.assertEquals(20,aldeano.generaOro());
    }

    @Test
    public void crearAldeanoYVerificarVidaCorrespondiente(){
        Aldeano aldeano = new Aldeano();
        Assert.assertEquals(50,aldeano.getVida());
    }

    @Test
    public void crearAldeanoYVerificarCostoCorrespondiente(){
        Aldeano aldeano = new Aldeano();
        Assert.assertEquals(25,aldeano.getCosto());
    }

    //Pruebas Mov normales

    @Test
    public void moverAldeanoUnaUnidadArribaExitosamente(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(4,5);
        Assert.assertEquals(true,aldeano.estaEnPos(4,5));
        aldeano.moverHaciaArriba();
        Assert.assertEquals(true,aldeano.estaEnPos(4,6));
    }

    @Test
    public void moverAldeanoUnaUnidadIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano(); //idem
        aldeano.setPosicion(2,4);
        Assert.assertEquals(true,aldeano.estaEnPos(2,4));
        aldeano.moverHaciaIzquierda();
        Assert.assertEquals(true,aldeano.estaEnPos(1,4));
    }

    @Test
    public void moverAldeanoUnaUnidadDerechaExitosamente(){
        Aldeano aldeano = new Aldeano(); //idem
        aldeano.setPosicion(23,15);
        Assert.assertEquals(true,aldeano.estaEnPos(23,15));
        aldeano.moverHaciaDerecha();
        Assert.assertEquals(true,aldeano.estaEnPos(24,15));
    }

    @Test
    public void moverAldeanoUnaUnidadAbajoExitosamente(){
        Aldeano aldeano = new Aldeano(); //idem
        aldeano.setPosicion(10,10);
        Assert.assertEquals(true,aldeano.estaEnPos(10,10));
        aldeano.moverHaciaAbajo();
        Assert.assertEquals(true,aldeano.estaEnPos(10,9));
    }

    @Test
    public void moverAldeanoUnaUnidadAbajoIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano(); //idem
        aldeano.setPosicion(15,15);
        Assert.assertEquals(true,aldeano.estaEnPos(15,15));
        aldeano.moverHaciaAbajoIzquierda();
        Assert.assertEquals(true,aldeano.estaEnPos(14,14));
    }

    @Test
    public void moverAldeanoUnaUnidadAbajoDerechaExitosamente(){
        Aldeano aldeano = new Aldeano(); //idem
        aldeano.setPosicion(10,8);
        Assert.assertEquals(true,aldeano.estaEnPos(10,8));
        aldeano.moverHaciaAbajoDerecha();
        Assert.assertEquals(true,aldeano.estaEnPos(11,7));
    }

    @Test
    public void moverAldeanoUnaUnidadArribaIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano(); //idem
        aldeano.setPosicion(19,42);
        Assert.assertEquals(true,aldeano.estaEnPos(19,42));
        aldeano.moverHaciaArribaIzquierda();
        Assert.assertEquals(true,aldeano.estaEnPos(18,43));
    }

    @Test
    public void moverAldeanoUnaUnidadaArribaDerechaExitosamente(){
        Aldeano aldeano = new Aldeano(); //idem
        aldeano.setPosicion(33,33);
        Assert.assertEquals(true,aldeano.estaEnPos(33,33));
        aldeano.moverHaciaArribaDerecha();
        Assert.assertEquals(true,aldeano.estaEnPos(34,34));
    }

    //Mover mas de 1 vez falla en cada posicion

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoADerechaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(1,1);
        Assert.assertEquals(true,aldeano.estaEnPos(1,1));
        aldeano.moverHaciaIzquierda();
        aldeano.moverHaciaDerecha();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoAIzquierdaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(3,3);
        Assert.assertEquals(true,aldeano.estaEnPos(3,3));
        aldeano.moverHaciaArriba();
        aldeano.moverHaciaIzquierda();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoArribaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(28,30);
        Assert.assertEquals(true,aldeano.estaEnPos(28,30));
        aldeano.moverHaciaDerecha();
        aldeano.moverHaciaArriba();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoArribaIzquierdaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(11,19);
        Assert.assertEquals(true,aldeano.estaEnPos(11,19));
        aldeano.moverHaciaArribaDerecha();
        aldeano.moverHaciaArribaIzquierda();
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoArribaDerechaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(3,3);
        Assert.assertEquals(true,aldeano.estaEnPos(3,3));
        aldeano.moverHaciaAbajoIzquierda();
        aldeano.moverHaciaArribaDerecha();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoAbajoLuegoDeHaberMovidoExcepcion(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(17,48);
        Assert.assertEquals(true,aldeano.estaEnPos(17,48));
        aldeano.moverHaciaArribaDerecha();
        aldeano.moverHaciaAbajo();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoAbajoIzquierdaLuegoDeHaberMovidoExcepcion(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(34,41);
        Assert.assertEquals(true,aldeano.estaEnPos(34,41));
        aldeano.moverHaciaAbajo();
        aldeano.moverHaciaAbajoIzquierda();
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverAldeanoAbajoDerechaLuegoDeHaberMovidoException(){
        Aldeano aldeano = new Aldeano();
        aldeano.setPosicion(10,3);
        Assert.assertEquals(true,aldeano.estaEnPos(10,3));
        aldeano.moverHaciaIzquierda();
        aldeano.moverHaciaAbajoDerecha();
    }

    //Pruebas construccion

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
        aldeano.desocuparse();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocuparse();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocuparse();
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
        aldeano.desocuparse();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocuparse();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocuparse();
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

    //Pruebas de reparacion

    @Test (expected = EdificioConVidaAlMaximoException.class)
    public void AldeanoReparaCuartelConVidaCompletaException(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.desocuparse();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocuparse();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocuparse();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocuparse();
        aldeano.repararEdificio(cuartel);
    }

    @Test (expected = EdificioConVidaAlMaximoException.class)
    public void AldeanoReparaPlazaCentralConVidaCompletaException(){
        Aldeano aldeano = new Aldeano();
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.desocuparse();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocuparse();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocuparse();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocuparse();
        aldeano.repararEdificio(plaza);
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void AldeanoReparaCuartelYSeVerificaSuEstado(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.desocuparse();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocuparse();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocuparse();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocuparse();
        cuartel.reducirVida(60);
        aldeano.repararEdificio(cuartel);
        aldeano.moverHaciaAbajo();
    }

    @Test
    public void AldeanoReparaCuartelYSeVerificaAumentoVida(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.desocuparse();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocuparse();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocuparse();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocuparse();
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
        aldeano.desocuparse();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocuparse();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocuparse();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocuparse();
        cuartel.reducirVida(50);
        Assert.assertEquals(200,cuartel.getVida());
        aldeano.repararEdificio(cuartel);
        Assert.assertEquals(0,aldeano.generaOro());
    }

    @Test
    public void AldeanoReparaPlazaCentralNoGeneraOro(){
        Aldeano aldeano = new Aldeano();
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.desocuparse();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocuparse();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocuparse();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocuparse();
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Assert.assertEquals(0,aldeano.generaOro());
    }

    @Test
    public void AldeanoFinalizaReparacionCuartelYGeneraOro(){
        Aldeano aldeano = new Aldeano();
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.desocuparse();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocuparse();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocuparse();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.desocuparse();
        Assert.assertEquals(250,cuartel.getVida());
        cuartel.reducirVida(50);
        Assert.assertEquals(200,cuartel.getVida());
        aldeano.repararEdificio(cuartel);
        Assert.assertEquals(250,cuartel.getVida());
    }

    @Test
    public void AldeanoFinalizaReparacionPlazaCentralYGeneraOro(){
        Aldeano aldeano = new Aldeano();
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.desocuparse();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocuparse();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocuparse();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocuparse();
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Assert.assertEquals(0,aldeano.generaOro());
        aldeano.desocuparse();
        Assert.assertEquals(20,aldeano.generaOro());
    }


    @Test (expected = UnidadEstaOcupadoException.class)
    public void AldeanoReparaPlazaCentralYSeVerificaSuEstado(){
        Aldeano aldeano = new Aldeano();
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.desocuparse();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocuparse();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocuparse();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocuparse();
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        aldeano.moverHaciaAbajo();
    }

    @Test
    public void AldeanoReparaPlazaCentralYSeVerificaAumentoVida(){
        Aldeano aldeano = new Aldeano();
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.desocuparse();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocuparse();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocuparse();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.desocuparse();
        Assert.assertEquals(450,plaza.getVida());
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Assert.assertEquals(plaza.getVida(),425);
    }

}
