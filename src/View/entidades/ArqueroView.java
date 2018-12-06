package View.entidades;

import Controller.AtacarHandler;
import Controller.MoverHandler;
import Modelo.Constantes;
import Modelo.Posicion;
import Modelo.Unidades.Arquero;
import View.PiezaView;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ArqueroView extends PiezaView {

    public ArqueroView(Arquero arqueroModelo){

        super(arqueroModelo);

        ajustarTamanio(Constantes.ALTURA_UNIDAD, Constantes.ANCHO_UNIDAD);

        Posicion unaPosicion = arqueroModelo.getPosicion();
        setPosicion(unaPosicion);

        Image arqueroFrente = new Image("View/img/Archerwalk027.png");
        ImageView imagenArqueroFrente = new ImageView(arqueroFrente);

        Image arqueroEspalda = new Image("View/img/Archerwalk001.png");
        ImageView imagenArqueroEspalda = new ImageView(arqueroEspalda);

        agregarImagen(imagenArqueroFrente, imagenArqueroEspalda);

    }

    private ArqueroView getThis(){
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
        ImageView imagenAldeanoFrente = new ImageView( new Image("View/img/Archerdie017.png"));
        agregarImagen(imagenAldeanoFrente);
    }
}
