package View.entidades;

import Controller.CrearArmaHandler;
import Modelo.Edificios.Castillo;
import Modelo.Posicion;
import Modelo.Constantes;
import View.PiezaView;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class CastilloView extends PiezaView {

    ContextMenu menu;

    public CastilloView(Castillo castilloModelo){

        super(castilloModelo);

        ArrayList<Posicion> posiciones = castilloModelo.getPosiciones();
        Posicion unaPosicion = posiciones.get(0);
        setPosicion(unaPosicion);

        ajustarTamanio(Constantes.ALTURA_CASTILLO, Constantes.ANCHO_CASTILLO);

        Image castilloADerecha = new Image("View/img/castilloVerticalInvertido.png");
        ImageView imagenCastilloADerecha = new ImageView(castilloADerecha);

        Image castilloAizquierda = new Image("View/img/castle.png");
        ImageView imagenCastilloAIzquierda = new ImageView(castilloAizquierda);

        agregarImagen(imagenCastilloADerecha, imagenCastilloAIzquierda);

        ContextMenu menu = this.crearMenu();
    }


    public  CastilloView getThis(){
        return this;
    }


    @Override
    public ContextMenu crearMenu(){
        ContextMenu menu = new ContextMenu();

        MenuItem crearArmaDeAsedio = new MenuItem("Crear Arma de asedio");
        crearArmaDeAsedio.setOnAction( new CrearArmaHandler(getThis()));

        menu.getItems().addAll(crearArmaDeAsedio);

        return menu;
    }

    @Override
    public void colocarImgRestos() {
    }
}
