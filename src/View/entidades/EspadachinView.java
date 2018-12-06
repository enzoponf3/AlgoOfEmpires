package View.entidades;

import Controller.AtacarHandler;
import Controller.MoverHandler;
import Modelo.Constantes;
import Modelo.Posicion;
import Modelo.Unidades.Espadachin;
import View.PiezaView;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class EspadachinView extends PiezaView {

    public EspadachinView(Espadachin espadachinModelo){

        super(espadachinModelo);

        ajustarTamanio(Constantes.ALTURA_UNIDAD, Constantes.ANCHO_UNIDAD);

        Posicion unaPosicion = espadachinModelo.getPosicion();
        setPosicion(unaPosicion);

        Image espadachinFrente = new Image("View/img/Longswordwalk027.png");
        ImageView imagenEspadachinFrente = new ImageView(espadachinFrente);

        Image espadachinEspalda = new Image("View/img/Longswordwalk001.png");
        ImageView imagenEspadachinEspalda = new ImageView(espadachinEspalda);

        agregarImagen(imagenEspadachinFrente, imagenEspadachinEspalda);
    }

    private EspadachinView getThis(){
        return this;
    }

    @Override
    public ContextMenu crearMenu() {
        ContextMenu menu = new ContextMenu();

        MenuItem mover = new MenuItem("Mover");
        mover.setOnAction(new MoverHandler(this.entidadModelo, getThis()));

        MenuItem atacar = new MenuItem("Atacar");
        atacar.setOnAction(new AtacarHandler(this));

        menu.getItems().addAll(atacar, mover);

        return menu;
    }

    @Override
    public void colocarImgRestos(){
        ImageView imagenAldeanoFrente = new ImageView( new Image("View/img/Longsworddie020.png"));
        agregarImagen(imagenAldeanoFrente);
    }
}
