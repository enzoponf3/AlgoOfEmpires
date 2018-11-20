package Entrega1;

import Modelo.Exceptions.UnidadDesarmadaException;
import Modelo.Exceptions.UnidadEstaMontadaException;
import Modelo.Exceptions.UnidadEstaOcupadoException;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import Modelo.Unidades.ArmaDeAsedio;
import Modelo.Unidades.Arquero;
import Modelo.Unidades.Espadachin;
import org.junit.Assert;
import org.junit.Test;

public class MovimientoTest {
    //Pruebas aldeano


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

    //Pruebas espadachin


    @Test
    public void moverEspadachinUnaUnidadArribaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(4,6);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));
    }

    @Test
    public void moverEspadachinUnaUnidadIzquierdaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(3,5);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));
    }



    @Test
    public void moverEspadachinUnaUnidadDerechaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(5,5);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadAbajoExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(4,4);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadAbajoIzquierdaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(3,4);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadAbajoDerechaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(5,4);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadArribaIzquierdaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(3,6);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));

    }

    @Test
    public void moverEspadachinUnaUnidadaArribaDerechaExitosamente(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(4,5);
        espadachin.setPosicion(posicion);
        Posicion destino = new Posicion(5,6);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino);
        Assert.assertTrue(espadachin.estaEnPosicion(destino));
    }

    @Test
    public void moverEspadachinEnDosTurnosDistintos(){
        Espadachin espadachin = new Espadachin();
        Posicion origen = new Posicion(1,1);
        espadachin.setPosicion(origen);
        Assert.assertTrue(espadachin.estaEnPosicion(origen));
        Posicion destino1 = new Posicion(1,2);
        espadachin.mover(destino1);
        Assert.assertTrue(espadachin.estaEnPosicion(destino1));
        Posicion destino2 = new Posicion(1,3);
        espadachin.desocupar();
        espadachin.mover(destino2);
        Assert.assertTrue(espadachin.estaEnPosicion(destino2));
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverEspadachinDosVecesConsecutivasFalla(){
        Espadachin espadachin = new Espadachin();
        Posicion posicion = new Posicion(1,1);
        espadachin.setPosicion(posicion);
        Posicion destino1 = new Posicion(0,1);
        Posicion destino2 = new Posicion(1,1);

        Assert.assertTrue(espadachin.estaEnPosicion(posicion));
        espadachin.mover(destino1);
        espadachin.mover(destino2);
    }

    //Pruebas arquero


    @Test
    public void moverArqueroUnaUnidadArribaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(4,6);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));
    }

    @Test
    public void moverArqueroUnaUnidadIzquierdaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(3,5);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));
    }



    @Test
    public void moverArqueroUnaUnidadDerechaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(5,5);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadAbajoExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(4,4);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadAbajoIzquierdaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(3,4);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadAbajoDerechaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(5,4);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadArribaIzquierdaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(3,6);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));

    }

    @Test
    public void moverArqueroUnaUnidadaArribaDerechaExitosamente(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(4,5);
        arquero.setPosicion(posicion);
        Posicion destino = new Posicion(5,6);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino);
        Assert.assertTrue(arquero.estaEnPosicion(destino));
    }

    @Test
    public void moverArqueroEnDosTurnosDistintos(){
        Arquero arquero = new Arquero();
        Posicion origen = new Posicion(1,1);
        arquero.setPosicion(origen);
        Assert.assertTrue(arquero.estaEnPosicion(origen));
        Posicion destino1 = new Posicion(1,2);
        arquero.mover(destino1);
        Assert.assertTrue(arquero.estaEnPosicion(destino1));
        Posicion destino2 = new Posicion(1,3);
        arquero.desocupar();
        arquero.mover(destino2);
        Assert.assertTrue(arquero.estaEnPosicion(destino2));
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void moverArqueroDosVecesConsecutivasLanzaUnidadEstaOcupadaException(){
        Arquero arquero = new Arquero();
        Posicion posicion = new Posicion(1,1);
        arquero.setPosicion(posicion);
        Posicion destino1 = new Posicion(0,1);
        Posicion destino2 = new Posicion(1,1);

        Assert.assertTrue(arquero.estaEnPosicion(posicion));
        arquero.mover(destino1);
        arquero.mover(destino2);
    }

    //Pruebas ArmaDeAsedio


    @Test
    public void moverArmaDeAsedioUnaUnidadArribaExitosamente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4, 5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(4, 6);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));
    }

    @Test
    public void moverArmaDeAsedioUnaUnidadIzquierdaExitosamente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4, 5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(3, 5);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));
    }

    @Test
    public void moverArmaDeAsedioUnaUnidadDerechaExitosamente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4, 5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(5, 5);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoExitosamente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4, 5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(4, 4);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoIzquierdaExitosamente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4, 5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(3, 4);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadAbajoDerechaExitosamente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4, 5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(5, 4);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadArribaIzquierdaExitosamente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4, 5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(3, 6);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));

    }

    @Test
    public void moverArmaDeAsedioUnaUnidadaArribaDerechaExitosamente() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(4, 5);
        armaAsedio.setPosicion(posicion);
        Posicion destino = new Posicion(5, 6);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino));
    }

    @Test
    public void moverArmaAsedioEnDosTurnosDistintos(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(1,1);
        armaAsedio.setPosicion(origen);
        Assert.assertTrue(armaAsedio.estaEnPosicion(origen));
        Posicion destino1 = new Posicion(1,2);
        armaAsedio.mover(destino1);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino1));
        Posicion destino2 = new Posicion(1,3);
        armaAsedio.desocupar();
        armaAsedio.mover(destino2);
        Assert.assertTrue(armaAsedio.estaEnPosicion(destino2));
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverArmaDeAsedioDosVecesConsecutivasLanzaUnidadEstaOcupadaException() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion posicion = new Posicion(1, 1);
        armaAsedio.setPosicion(posicion);
        Posicion destino1 = new Posicion(0, 1);
        Posicion destino2 = new Posicion(1, 1);

        Assert.assertTrue(armaAsedio.estaEnPosicion(posicion));
        armaAsedio.mover(destino1);
        armaAsedio.mover(destino2);
    }

    @Test(expected = UnidadEstaMontadaException.class)
    public void moverArmaDeAsedioMontadaFalla() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(1, 1);
        armaAsedio.setPosicion(origen);
        armaAsedio.montar();
        Posicion destino = new Posicion(1, 2);
        armaAsedio.desocupar();
        armaAsedio.mover(destino);
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void moverArmaDeAsedioMontadaEnMismoTurnoFalla() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(1, 1);
        armaAsedio.setPosicion(origen);
        armaAsedio.montar();
        Posicion destino = new Posicion(1, 2);
        armaAsedio.mover(destino);
    }
    @Test(expected = UnidadEstaOcupadoException.class)
    public void montarArmaDeAsedioMontadaEnMismoTurnoFalla() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(1, 1);
        armaAsedio.setPosicion(origen);
        armaAsedio.montar();
        armaAsedio.montar();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void armaDeAsedioDesmontarYMoverEnUnMismoTurnoFalla() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(1, 1);
        armaAsedio.setPosicion(origen);
        armaAsedio.montar();
        armaAsedio.desocupar();
        armaAsedio.desmontar();
        Posicion destino = new Posicion(1, 2);
        armaAsedio.mover(destino);
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void armaDeAsedioMontarYDesmontarEnMismoTurnoFalla() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(5, 5);
        armaAsedio.setPosicion(origen);
        armaAsedio.montar();
        armaAsedio.desmontar();
    }

    @Test(expected = UnidadEstaOcupadoException.class)
    public void armaDeAsedioDesmontarYMontarEnMismoTurnoFalla() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(5, 5);
        armaAsedio.setPosicion(origen);
        armaAsedio.montar();
        armaAsedio.desocupar();
        armaAsedio.desmontar();
        armaAsedio.montar();
    }

    @Test(expected = UnidadEstaMontadaException.class)
    public void armaDeAsedioMontarYaMontadoFalla() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(5, 5);
        armaAsedio.setPosicion(origen);
        armaAsedio.montar();
        armaAsedio.desocupar();
        armaAsedio.montar();
    }
    @Test(expected = UnidadDesarmadaException.class)
    public void armaDeAsedioDesmontarYaDesmontadoFalla() {
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(5, 5);
        armaAsedio.setPosicion(origen);
        armaAsedio.desmontar();
        armaAsedio.desocupar();
        armaAsedio.desmontar();
    }

    @Test (expected = UnidadEstaOcupadoException.class)
    public void armaAsedioDesmontarHabiendoMovidoFalla(){
        ArmaDeAsedio armaAsedio = new ArmaDeAsedio();
        Posicion origen = new Posicion(5, 5);
        armaAsedio.setPosicion(origen);
        Posicion destino = new Posicion(5,6);
        armaAsedio.mover(destino);
        armaAsedio.desmontar();
    }

}
