package Vista;

import Modelo.Edificios.PlazaCentral;
import Modelo.Posicion;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class PlazaCentralView extends StackPane {

    private PlazaCentral modelo;

    private ImageView imagenPlaza;
    private static final int ALTURA_PLAZA_CENTRAL = 2;
    private static final int ANCHO_PLAZA_CENTRAL = 2;
    private int x;
    private int y;

    ContextMenu menu;

    public PlazaCentralView(PlazaCentral unModelo){
        modelo = unModelo;

        setWidth(ANCHO_PLAZA_CENTRAL* Main2View.TAMANIO_CASILLERO);
        setHeight(ALTURA_PLAZA_CENTRAL* Main2View.TAMANIO_CASILLERO);

        ArrayList<Posicion> posiciones = unModelo.getPosiciones();
        Posicion unaPosicion = posiciones.get(0);
        x = unaPosicion.getHorizontal();
        y = unaPosicion.getVertical();


        Image plaza = new Image("University2.png");
        imagenPlaza = new ImageView(plaza);
        imagenPlaza.setFitHeight(ALTURA_PLAZA_CENTRAL* Main2View.TAMANIO_CASILLERO);
        imagenPlaza.setFitWidth(ANCHO_PLAZA_CENTRAL* Main2View.TAMANIO_CASILLERO);


        relocate(x* Main2View.TAMANIO_CASILLERO,y* Main2View.TAMANIO_CASILLERO);

        //this.setOnMouseClicked(new ControladorCastillo(this));

        getChildren().addAll(imagenPlaza);


        menu = new ContextMenu();
        MenuItem crearAldeano = new MenuItem("Crear Aldeano");
        menu.getItems().add(crearAldeano);
    }

}
