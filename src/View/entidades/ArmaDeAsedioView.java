package View.entidades;

import Controller.ConstruirHandler;
import Controller.DesmontarHandler;
import Controller.MontarHandler;
import Controller.MoverHandler;
import Controller.AtacarHandler;
import Modelo.Posicion;
import Modelo.Unidades.ArmaDeAsedio;
import View.Constantes;
import View.PiezaView;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.PickResult;

public class ArmaDeAsedioView extends PiezaView {

    public ArmaDeAsedioView (ArmaDeAsedio arma){
        super(arma);

        ajustarTamanio(Constantes.ALTURA_UNIDAD, Constantes.ANCHO_UNIDAD);

        Posicion unaPosicion = arma.getPosicion();
        setPosicion(unaPosicion);


        ImageView imagenArmaFrente = new ImageView(new Image("View/img/Trebuchetmove039.png"));
        ImageView imagenArmaEspalda = new ImageView(new Image("View/img/Trebuchetmove012.png"));

        agregarImagen(imagenArmaFrente, imagenArmaEspalda);

            this.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                ContextMenu menu = this.crearMenu();
                menu.show(imagenArmaFrente, event.getScreenX(), event.getScreenY());
            }

            private ContextMenu crearMenu(){

                ContextMenu menu = new ContextMenu();
                MenuItem montar = new MenuItem("Montar");
                montar.setOnAction(new MontarHandler(arma));

                MenuItem desmontar = new MenuItem("Desmontar");
                desmontar.setOnAction(new DesmontarHandler(arma));

                MenuItem atacar = new MenuItem("Atacar");
                atacar.setOnAction(new AtacarHandler(arma,getThis()));

                MenuItem mover = new MenuItem("Mover");
                mover.setOnAction(new MoverHandler(arma, getThis()));

                menu.getItems().addAll(montar, desmontar, atacar, mover);
                return menu;
            }

        });
    }

    private ArmaDeAsedioView getThis(){
        return this;
    }

}
