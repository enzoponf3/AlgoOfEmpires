package Vista;

import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

import java.util.ArrayList;

public class AldeanoView extends StackPane {

    private Aldeano modelo;

    private ContextMenu menu;

    private ImageView imagenAldeano;
    private static final double ALTURA_UNIDAD = 1;
    private static final double ANCHO_UNIDAD = 0.5;
    private int x;
    private int y;

    public AldeanoView(Aldeano unModelo){
        this.modelo = unModelo;

        setWidth(ANCHO_UNIDAD* Main2View.TAMANIO_CASILLERO);
        setHeight(ALTURA_UNIDAD* Main2View.TAMANIO_CASILLERO);

        Posicion unaPosicion = unModelo.getPosicion();
        x = unaPosicion.getHorizontal();
        y = unaPosicion.getVertical();

        Image aldeano = new Image("Villagerwalk001.png");
        imagenAldeano = new ImageView(aldeano);
        imagenAldeano.setFitHeight(ALTURA_UNIDAD* Main2View.TAMANIO_CASILLERO);
        imagenAldeano.setFitWidth(ANCHO_UNIDAD* Main2View.TAMANIO_CASILLERO);

        relocate(x* Main2View.TAMANIO_CASILLERO,y* Main2View.TAMANIO_CASILLERO);



        getChildren().addAll(imagenAldeano);


        this.menu = new ContextMenu();
        MenuItem construir = new MenuItem("Construir");
        this.menu.getItems().add(construir);
    }

}
