package View.entidades;

import Modelo.Edificios.PlazaCentral;
import Modelo.Posicion;
import View.Constantes;
import View.PiezaView;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class PlazaCentralView extends PiezaView {

    ContextMenu menu;

    public PlazaCentralView(PlazaCentral plazaModelo){

        super(plazaModelo);

        ajustarTamanio(Constantes.ALTURA_EDIFICIO, Constantes.ANCHO_EDIFICIO);

        ArrayList<Posicion> posiciones = plazaModelo.getPosiciones();
        Posicion unaPosicion = posiciones.get(0);
        setPosicion(unaPosicion);

        Image plaza = new Image("View/img/University2.png");
        ImageView imagenPlaza = new ImageView(plaza);

        agregarImagen(imagenPlaza, imagenPlaza);
        ContextMenu menu = this.crearMenu();

        this.setOnMouseClicked(new  EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                menu.show(imagenPlaza, event.getScreenX(), event.getScreenY());
            }
        });
    }

    private ContextMenu crearMenu(){
        ContextMenu menu = new ContextMenu();
        MenuItem crearAldeano = new MenuItem("Crear aldeano");
        menu.getItems().addAll(crearAldeano);
        return menu;
    }
}
