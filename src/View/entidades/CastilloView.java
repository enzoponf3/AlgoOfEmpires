package View.entidades;

import Modelo.Edificios.Castillo;
import Modelo.Posicion;
import Controller.ControladorCastillo;
import View.Constantes;
import View.MapaView;
import View.PiezaView;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

import java.util.ArrayList;

public class CastilloView extends PiezaView {

    ContextMenu menu;

    public CastilloView(Castillo castilloModelo){

        super(castilloModelo);

        ArrayList<Posicion> posiciones = castilloModelo.getPosiciones();
        Posicion unaPosicion = posiciones.get(0);
        setPosicion(unaPosicion);

        ajustarTamanio(Constantes.ALTURA_CASTILLO, Constantes.ANCHO_CASTILLO);

        Image castilloADerecha = new Image("castilloVerticalInvertido.png");
        ImageView imagenCastilloADerecha = new ImageView(castilloADerecha);

        Image castilloAizquierda = new Image("castle.png");
        ImageView imagenCastilloAIzquierda = new ImageView(castilloAizquierda);

        agregarImagen(imagenCastilloADerecha, imagenCastilloAIzquierda);

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ContextMenu menu = this.crearMenu();
                menu.show(imagenCastilloADerecha, event.getScreenX(), event.getScreenY());
            }

            private ContextMenu crearMenu(){
                ContextMenu menu = new ContextMenu();
                MenuItem crearArmaDeAsedio = new MenuItem("Crear arma de asedio");

                menu.getItems().addAll(crearArmaDeAsedio);
                return menu;
            }

        });


    }


}
