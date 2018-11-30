package View.entidades;

import Modelo.Edificios.Castillo;
import Modelo.Posicion;
import Controller.ControladorCastillo;
import View.MapaView;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

import java.util.ArrayList;

public class CastilloView extends StackPane {

    private Castillo modelo;

    private ImageView imagenCastillo;
    private static final int ALTURA_CASTILLO = 4;
    private static final int ANCHO_CASTILLO = 4;
    private int x;
    private int y;

    ContextMenu menu;

    public CastilloView(Castillo unModelo){
        modelo = unModelo;

        setWidth(ANCHO_CASTILLO* MapaView.TAMANIO_CASILLERO);
        setHeight(ALTURA_CASTILLO* MapaView.TAMANIO_CASILLERO);

        ArrayList<Posicion> posiciones = unModelo.getPosiciones();
        Posicion unaPosicion = posiciones.get(0);
        x = unaPosicion.getHorizontal();
        y = unaPosicion.getVertical();


        if( x < Screen.getPrimary().getVisualBounds().getWidth() /2 ){
            Image castilloADerecha = new Image("castilloVerticalInvertido.png");
            imagenCastillo = new ImageView(castilloADerecha);
            imagenCastillo.setFitHeight(ALTURA_CASTILLO* MapaView.TAMANIO_CASILLERO);
            imagenCastillo.setFitWidth(ANCHO_CASTILLO* MapaView.TAMANIO_CASILLERO);
        }else{
            Image newPic = new Image("castle.png");
            imagenCastillo = new ImageView(newPic);
            imagenCastillo.setFitHeight(ALTURA_CASTILLO* MapaView.TAMANIO_CASILLERO);
            imagenCastillo.setFitWidth(ANCHO_CASTILLO* MapaView.TAMANIO_CASILLERO);
        }

        relocate(x* MapaView.TAMANIO_CASILLERO,y* MapaView.TAMANIO_CASILLERO);

        this.setOnMouseClicked(new ControladorCastillo(this));

        getChildren().addAll(imagenCastillo);

        menu = new ContextMenu();
        MenuItem crearArmaDeAsedio = new MenuItem("Crear ArmaDeAsedio");
        menu.getItems().add(crearArmaDeAsedio);

    }

    public ContextMenu devolverMenu(){
        return menu;
    }


}
