import org.junit.Test;
import org.junit.Assert;


public class AldeanoTest {
    //Pruebas base
    @Test
    public void crearAldeanoEnPosicionIndicada(){
        Aldeano aldeano = new Aldeano(5,7);
        Assert.assertEquals(true,aldeano.estaEnPos(5,7));
    }

    //public void crearAldeanoEnPosicionInexistente(){}
    //public void crearAldeanoYVerificarQueGeneraOro(){}

    @Test
    public void crearAldeanoYVerificarVidaCorrespondiente(){
        Aldeano aldeano = new Aldeano(13,21);
        Assert.assertEquals(50,aldeano.getVida());
    }

    @Test
    public void crearAldeanoYVerificarCostoCorrespondiente(){
        Aldeano aldeano = new Aldeano(13,21);
        Assert.assertEquals(25,aldeano.getCosto());
    }

    //Pruebas Mov normales

    @Test
    public void moverAldeanoUnaUnidadArribaExitosamente(){
        Aldeano aldeano = new Aldeano(4,5);
        Assert.assertEquals(true,aldeano.estaEnPos(4,5));
        aldeano.moverHaciaArriba();
        Assert.assertEquals(true,aldeano.estaEnPos(4,6));
    }

    @Test
    public void moverAldeanoUnaUnidadIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano(2,4); //idem
        Assert.assertEquals(true,aldeano.estaEnPos(2,4));
        aldeano.moverHaciaIzquierda();
        Assert.assertEquals(true,aldeano.estaEnPos(1,4));
    }

    @Test
    public void moverAldeanoUnaUnidadDerechaExitosamente(){
        Aldeano aldeano = new Aldeano(23,15); //idem
        Assert.assertEquals(true,aldeano.estaEnPos(23,15));
        aldeano.moverHaciaDerecha();
        Assert.assertEquals(true,aldeano.estaEnPos(24,15));
    }

    @Test
    public void moverAldeanoUnaUnidadAbajoExitosamente(){
        Aldeano aldeano = new Aldeano(10,10); //idem
        Assert.assertEquals(true,aldeano.estaEnPos(10,10));
        aldeano.moverHaciaAbajo();
        Assert.assertEquals(true,aldeano.estaEnPos(10,9));
    }

    @Test
    public void moverAldeanoUnaUnidadAbajoIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano(15,15); //idem
        Assert.assertEquals(true,aldeano.estaEnPos(15,15));
        aldeano.moverHaciaAbajoIzquierda();
        Assert.assertEquals(true,aldeano.estaEnPos(14,14));
    }

    @Test
    public void moverAldeanoUnaUnidadAbajoDerechaExitosamente(){
        Aldeano aldeano = new Aldeano(10,8); //idem
        Assert.assertEquals(true,aldeano.estaEnPos(10,8));
        aldeano.moverHaciaAbajoDerecha();
        Assert.assertEquals(true,aldeano.estaEnPos(11,7));
    }

    @Test
    public void moverAldeanoUnaUnidadArribaIzquierdaExitosamente(){
        Aldeano aldeano = new Aldeano(19,42); //idem
        Assert.assertEquals(true,aldeano.estaEnPos(19,42));
        aldeano.moverHaciaArribaIzquierda();
        Assert.assertEquals(true,aldeano.estaEnPos(18,43));
    }

    @Test
    public void moverAldeanoUnaUnidadaArribaDerechaExitosamente(){
        Aldeano aldeano = new Aldeano(33,33); //idem
        Assert.assertEquals(true,aldeano.estaEnPos(33,33));
        aldeano.moverHaciaArribaDerecha();
        Assert.assertEquals(true,aldeano.estaEnPos(34,34));
    }
/*
    //Pruebas mov unidad inexistente , hacer las comentadas cuando se sepa tamanio map

    @Test(expected = PosicionFueraDelMapaException.class)
    public void moverAldeanoUnaUnidadArribaInexistente(){
        Mapa map = new Mapa(50,25);
        Aldeano aldeano = new Aldeano(CotaInf,CotaInf);
        Assert.assertEquals(true,aldeano.estaEnPos(CotaInf,CotaInf));
        aldeano.moverHaciaArriba();
        map.comprobarPosicion(CotaInf,CotaInf);
    }

    @Test(expected = PosicionFueraDelMapaException.class)
    public void moverAldeanoUnaUnidadAbajoInexistente(){
        Aldeano aldeano = new Aldeano(2,24);
        Assert.assertEquals(true,aldeano.estaEnPos(2,24));
        aldeano.moverHaciaArribaDerecha();
    }

    @Test(expected = PosicionFueraDelMapaException.class)
    public void moverAldeanoUnaUnidadDerechaInexistente(){
        Aldeano aldeano = new Aldeano(CotaSupAncho,CotaInf);
        Assert.assertEquals(true,aldeano.estaEnPos(CotaSupAncho,CotaInf));
        aldeano.moverHaciaArribaDerecha();
    }

    @Test(expected = PosicionFueraDelMapaException.class)
    public void moverAldeanoUnaUnidadAbajoDerechaInexistente(){
        Aldeano aldeano = new Aldeano(CotaSupAncho,CotaSupAlto);
            Assert.assertEquals(true,aldeano.estaEnPos(CotaSupAncho,CotaSupAlto));
            aldeano.moverHaciaArribaDerecha();
    }

    @Test(expected = PosicionFueraDelMapaException.class)
    public void moverAldeanoUnaUnidadAbajoIzquierdaInexistente(){
        Aldeano aldeano = new Aldeano(CotaInf,CotaSupAlto);
        Assert.assertEquals(true,aldeano.estaEnPos(CotaInf,CotaSupAlto));
        aldeano.moverHaciaArribaDerecha();
    }

    @Test(expected = PosicionFueraDelMapaException.class)
    public void moverAldeanoUnaUnidadIzquierdaInexistente(){
        Aldeano aldeano = new Aldeano(5,CotaInf);
        Assert.assertEquals(true,aldeano.estaEnPos(5,CotaInf));
        aldeano.moverHaciaIzquierda();
    }

    @Test(expected = PosicionFueraDelMapaException.class)
    public void moverAldeanoUnaUnidadArribaIzquierdaInexistente(){
        Aldeano aldeano = new Aldeano(CotaInf,2);
        Assert.assertEquals(true,aldeano.estaEnPos(CotaInf,2));
        aldeano.moverHaciaArribaIzquierda();
    }

    @Test(expected = PosicionFueraDelMapaException.class)
    public void moverAldeanoUnaUnidadArribaDerechaInexistente(){
        Aldeano aldeano = new Aldeano(24,CotaInf);
        Assert.assertEquals(true,aldeano.estaEnPos(24,CotaInf));
        aldeano.moverHaciaArribaDerecha();

    }
*/
    //Mover mas de 1 vez falla en cada posicion
    /*
    @Test (expected = AldeanoOcupadoException.class)
    public void moverAldeanoADerechaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano(1,1);
        Assert.assertEquals(true,aldeano.estaEnPos(1,1));
        aldeano.moverHaciaIzquierda();
        aldeano.moverHaciaDerecha();
    }

    @Test(expected = AldeanoOcupadoException.class)
    public void moverAldeanoAIzquierdaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano(3,3);
        Assert.assertEquals(true,aldeano.estaEnPos(3,3));
        aldeano.moverHaciaArriba();
        aldeano.moverHaciaIzquierda();
    }

    @Test(expected = AldeanoOcupadoException.class)
    public void moverAldeanoArribaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano(28,30);
        Assert.assertEquals(true,aldeano.estaEnPos(28,30));
        aldeano.moverHaciaDerecha();
        aldeano.moverHaciaArriba();
    }

    @Test(expected = AldeanoOcupadoException.class)
    public void moverAldeanoArribaIzquierdaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano(11,19);
        Assert.assertEquals(true,aldeano.estaEnPos(11,19));
        aldeano.moverHaciaArribaDerecha();
        aldeano.moverHaciaArribaIzquierda();
    }

    @Test (expected = AldeanoOcupadoException.class)
    public void moverAldeanoArribaDerechaLuegoDeHaberMovidoLanzaExcepcion(){
        Aldeano aldeano = new Aldeano(3,3);
        Assert.assertEquals(true,aldeano.estaEnPos(3,3));
        aldeano.moverHaciaAbajoIzquierda();
        aldeano.moverHaciaArribaDerecha();
    }

    @Test(expected = AldeanoOcupadoException.class)
    public void moverAldeanoAbajoLuegoDeHaberMovidoExcepcion(){
        Aldeano aldeano = new Aldeano(17,48);
        Assert.assertEquals(true,aldeano.estaEnPos(17,48));
        aldeano.moverHaciaArribaDerecha();
        aldeano.moverHaciaAbajo();
    }

    @Test(expected = AldeanoOcupadoException.class)
    public void moverAldeanoAbajoIzquierdaLuegoDeHaberMovidoExcepcion(){
        Aldeano aldeano = new Aldeano(34,41);
        Assert.assertEquals(true,aldeano.estaEnPos(34,41));
        aldeano.moverHaciaAbajo();
        aldeano.moverHaciaAbajoIzquierda();
    }

    @Test (expected = AldeanoOcupadoException.class)
    public void moverAldeanoAbajoDerechaLuegoDeHaberMovidoException(){
        Aldeano aldeano = new Aldeano(10,3);
        Assert.assertEquals(true,aldeano.estaEnPos(10,3));
        aldeano.moverHaciaIzquierda();
        aldeano.moverHaciaAbajoDerecha();
    }
    */

    //Pruebas construccion

   @Test
    public void AldeanoConstruyeCuartelYSeVerificaQueExiste(){
        Aldeano aldeano = new Aldeano(2,3);
        Cuartel cuartel = aldeano.construirCuartel();
        Assert.assertNotNull(cuartel);
    }

    @Test
    public void AldeanoConstruyeCuartelYSeVerificaQueTieneVidaCorrespondiente(){
        Aldeano aldeano = new Aldeano(2,3);
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.continuarConstruccionCuartel(cuartel);
        Assert.assertEquals(250, cuartel.getVida());
    }

    @Test
    public void AldeanoConstruyePlazaCentralYSeVerificaQueExiste(){
        Aldeano aldeano = new Aldeano(10,9);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        Assert.assertNotNull(plaza);
    }

    @Test
    public void AldeanoConstruyePlazaCentralYSeVerificaQueTieneVidaCorrespondiente(){
        Aldeano aldeano = new Aldeano(10,9);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.continuarConstruccionPlazaCentral(plaza);
        Assert.assertEquals(450, plaza.getVida());
    }

    @Test(expected = AldeanoOcupadoException.class)
    public void AldeanoConstruyeCuartelYSeVerificaQueAldeanoEstaOcupado(){
        Aldeano aldeano = new Aldeano(10,9);
        aldeano.construirPlazaCentral();
        aldeano.construirPlazaCentral();
    }


    @Test
    public void AldeanoConstruyeCuartelYSeVerificaQueoNoGeneraOro(){
        Aldeano aldeano = new Aldeano(35,30);
        Assert.assertTrue(aldeano.generaOro());
        Cuartel cuartel = aldeano.construirCuartel();
        Assert.assertFalse(aldeano.generaOro());
        aldeano.continuarConstruccionCuartel(cuartel);
        Assert.assertFalse(aldeano.generaOro());
    }

    @Test
    public void AldeanoConstruyePlazaCentralYSeVerificaQueNoGeneraOro(){
        Aldeano aldeano = new Aldeano(45,11);
        Assert.assertTrue(aldeano.generaOro());
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        Assert.assertFalse(aldeano.generaOro());
        aldeano.continuarConstruccionPlazaCentral(plaza);
        Assert.assertFalse(aldeano.generaOro());
    }

    //Pruebas de reparacion

    @Test (expected = EdificioConVidaAlMaximoException.class)
    public void AldeanoReparaCuartelConVidaCompletaException(){
        Aldeano aldeano = new Aldeano(2,2);
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.repararEdificio(cuartel);
    }

    @Test (expected = EdificioConVidaAlMaximoException.class)
    public void AldeanoReparaPlazaCentralConVidaCompletaException(){
        Aldeano aldeano = new Aldeano(2,10);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.repararEdificio(plaza);
    }

    @Test
    public void AldeanoReparaCuartelYSeVerificaSuEstado(){
        Aldeano aldeano = new Aldeano(3,2);
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.continuarConstruccionCuartel(cuartel);
        cuartel.reducirVida(60);
        aldeano.repararEdificio(cuartel);
        Assert.assertEquals("Ocupado",aldeano.getEstado());
    }

    @Test
    public void AldeanoReparaCuartelYSeVerificaAumentoVida(){
        Aldeano aldeano = new Aldeano(4,5);
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.continuarConstruccionCuartel(cuartel);
        Assert.assertEquals(250,cuartel.getVida());
        cuartel.reducirVida(50);
        Assert.assertEquals(200,cuartel.getVida());
        aldeano.repararEdificio(cuartel);
        Assert.assertEquals(250,cuartel.getVida());
    }

    @Test
    public void AldeanoReparaCuartelNoGeneraOro(){
        Aldeano aldeano = new Aldeano(6,10);
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.continuarConstruccionCuartel(cuartel);
        cuartel.reducirVida(50);
        Assert.assertEquals(200,cuartel.getVida());
        aldeano.repararEdificio(cuartel);
        Assert.assertFalse(aldeano.generaOro());
    }

    @Test
    public void AldeanoReparaPlazaCentralNoGeneraOro(){
        Aldeano aldeano = new Aldeano(6,10);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.continuarConstruccionPlazaCentral(plaza);
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Assert.assertFalse(aldeano.generaOro());
    }

    @Test
    public void AldeanoFinalizaReparacionCuartelYGeneraOro(){
        Aldeano aldeano = new Aldeano(6,10);
        Cuartel cuartel = aldeano.construirCuartel();
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.continuarConstruccionCuartel(cuartel);
        aldeano.continuarConstruccionCuartel(cuartel);
        Assert.assertEquals(250,cuartel.getVida());
        cuartel.reducirVida(50);
        Assert.assertEquals(200,cuartel.getVida());
        aldeano.repararEdificio(cuartel);
        Assert.assertEquals(250,cuartel.getVida());
    }

    @Test
    public void AldeanoFinalizaReparacionPlazaCentralYGeneraOro(){
        Aldeano aldeano = new Aldeano(10,2);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.continuarConstruccionPlazaCentral(plaza);
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Assert.assertFalse(aldeano.generaOro());
        aldeano.desocuparse();                  //Este desocuparse es general cuando pasa el turno entero del jugador
        Assert.assertTrue(aldeano.generaOro());
    }


    @Test
    public void AldeanoReparaPlazaCentralYSeVerificaSuEstado(){
        Aldeano aldeano = new Aldeano(5,12);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.continuarConstruccionPlazaCentral(plaza);
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Assert.assertEquals("Ocupado",aldeano.getEstado());
    }

    @Test
    public void AldeanoReparaPlazaCentralYSeVerificaAumentoVida(){
        Aldeano aldeano = new Aldeano(16,16);
        PlazaCentral plaza = aldeano.construirPlazaCentral();
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.continuarConstruccionPlazaCentral(plaza);
        aldeano.continuarConstruccionPlazaCentral(plaza);
        Assert.assertEquals(450,plaza.getVida());
        plaza.reducirVida(50);
        Assert.assertEquals(400,plaza.getVida());
        aldeano.repararEdificio(plaza);
        Assert.assertEquals(plaza.getVida(),425);
    }

    //Pruebas atacar
    @Test
    public void CrearAldeanoYReducirVida(){
        Aldeano pedro = new Aldeano(0,0);
        pedro.reducirVida(15);
        Assert.assertEquals(35, pedro.getVida());
    }
    @Test (expected = ElAldeanoNoPuedeAtacarException.class)
    public void AldeanoAtacarLanzaEcepcion(){
        Aldeano juan = new Aldeano(0,0);
        Aldeano pepito = new Aldeano(1,0);
        juan.atacar(pepito);
    }
}
