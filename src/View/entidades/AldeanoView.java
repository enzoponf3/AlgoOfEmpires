package View.entidades;

import Controller.ControladorConstruir;
import Controller.MovimientoHandler;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import Controller.ControladorAldeano;
import View.Constantes;
import View.MapaView;
import View.PiezaView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class AldeanoView extends PiezaView {

    private ContextMenu menu;

    public AldeanoView(Aldeano aldeanoModelo){

        super(aldeanoModelo);

        ajustarTamanio(Constantes.ALTURA_UNIDAD, Constantes.ANCHO_UNIDAD);

        Posicion unaPosicion = aldeanoModelo.getPosicion();
        setPosicion(unaPosicion);

        Image aldeanoFrente = new Image("AldeanoFrente.png");
        ImageView imagenAldeanoFrente = new ImageView(aldeanoFrente);

        Image aldeanoEspalda = new Image("AldeanoEspalda.png");
        ImageView imagenAldeanoEspalda = new ImageView(aldeanoEspalda);

        agregarImagen(imagenAldeanoFrente, imagenAldeanoEspalda);

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ContextMenu menu = this.crearMenu();
                menu.show(imagenAldeanoFrente, event.getScreenX(), event.getScreenY());
            }

            private ContextMenu crearMenu(){
                ContextMenu menu = new ContextMenu();
                MenuItem construirPlazaCentral = new MenuItem("Construir Plaza Central");
                construirPlazaCentral.setOnAction(new ControladorConstruir(aldeanoModelo));

                MenuItem construirCuartel = new MenuItem("Construir Cuartel");
                MenuItem reparar = new MenuItem("Reparar");

                menu.getItems().addAll(construirPlazaCentral, construirCuartel, reparar);
                return menu;
            }

        });


        setOnDragDropped(new MovimientoHandler(this, aldeanoModelo));

    }

}
