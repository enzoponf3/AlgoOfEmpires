package Vista;

import Modelo.Edificios.Castillo;
import Modelo.Posicion;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

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

        setWidth(ANCHO_CASTILLO* Main2View.TAMANIO_CASILLERO);
        setHeight(ALTURA_CASTILLO* Main2View.TAMANIO_CASILLERO);

        ArrayList<Posicion> posiciones = unModelo.getPosiciones();
        Posicion unaPosicion = posiciones.get(0);
        x = unaPosicion.getHorizontal();
        y = unaPosicion.getVertical();


        if( x < Main2View.ANCHO/2 ){
            Image castilloADerecha = new Image("Castle3.png");
            imagenCastillo = new ImageView(castilloADerecha);
            imagenCastillo.setFitHeight(ALTURA_CASTILLO* Main2View.TAMANIO_CASILLERO);
            imagenCastillo.setFitWidth(ANCHO_CASTILLO* Main2View.TAMANIO_CASILLERO);
        }else{
            Image newPic = new Image("castle.png");
            imagenCastillo = new ImageView(newPic);
            imagenCastillo.setFitHeight(ALTURA_CASTILLO* Main2View.TAMANIO_CASILLERO);
            imagenCastillo.setFitWidth(ANCHO_CASTILLO* Main2View.TAMANIO_CASILLERO);
        }

        relocate(x* Main2View.TAMANIO_CASILLERO,y* Main2View.TAMANIO_CASILLERO);

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
