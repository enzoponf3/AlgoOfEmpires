package View.entidades;

import Modelo.Edificios.PlazaCentral;
import Modelo.Posicion;
import View.MapaView;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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

        setWidth(ANCHO_PLAZA_CENTRAL* MapaView.TAMANIO_CASILLERO);
        setHeight(ALTURA_PLAZA_CENTRAL* MapaView.TAMANIO_CASILLERO);

        ArrayList<Posicion> posiciones = unModelo.getPosiciones();
        Posicion unaPosicion = posiciones.get(0);
        x = unaPosicion.getHorizontal();
        y = unaPosicion.getVertical();


        Image plaza = new Image("University2.png");
        imagenPlaza = new ImageView(plaza);
        imagenPlaza.setFitHeight(ALTURA_PLAZA_CENTRAL* MapaView.TAMANIO_CASILLERO);
        imagenPlaza.setFitWidth(ANCHO_PLAZA_CENTRAL* MapaView.TAMANIO_CASILLERO);


        relocate(x* MapaView.TAMANIO_CASILLERO,y* MapaView.TAMANIO_CASILLERO);

        //this.setOnMouseClicked(new ControladorCastillo(this));

        getChildren().addAll(imagenPlaza);


        menu = new ContextMenu();
        MenuItem crearAldeano = new MenuItem("Crear Aldeano");
        menu.getItems().add(crearAldeano);


        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                devolverMenu();
            }
        });

    }


    public ContextMenu devolverMenu(){
        return menu;
    }

}
