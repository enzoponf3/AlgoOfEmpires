package View.entidades;

import Controller.DesmontarHandler;
import Controller.MontarHandler;
import Controller.MoverHandler;
import Controller.AtacarHandler;
import Modelo.Posicion;
import Modelo.Unidades.ArmaDeAsedio;
import Modelo.Constantes;
import View.PiezaView;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ArmaDeAsedioView extends PiezaView {

    public ArmaDeAsedioView (ArmaDeAsedio arma){
        super(arma);

        ajustarTamanio(Constantes.ALTURA_UNIDAD, Constantes.ANCHO_UNIDAD);

        Posicion unaPosicion = arma.getPosicion();
        setPosicion(unaPosicion);

        ImageView imagenArmaFrente = new ImageView(new Image("View/img/Trebuchetmove039.png"));
        ImageView imagenArmaEspalda = new ImageView(new Image("View/img/Trebuchetmove012.png"));

        agregarImagen(imagenArmaFrente, imagenArmaEspalda);

    }

    private ArmaDeAsedioView getThis(){
        return this;
    }

    @Override
    public ContextMenu crearMenu(){
        ContextMenu menu = new ContextMenu();

        MenuItem montar = new MenuItem("Montar");
        montar.setOnAction(new MontarHandler(this));

        MenuItem atacar = new MenuItem("Atacar");
        atacar.setOnAction(new AtacarHandler(this));       //No hace falta el view no ?o si, si se destruye o muere ?

        MenuItem desmontar = new MenuItem("Desmontar");
        desmontar.setOnAction(new DesmontarHandler(entidadModelo,this));

        MenuItem mover = new MenuItem("Mover");
        mover.setOnAction(new MoverHandler(entidadModelo, getThis()));

        menu.getItems().addAll(montar, atacar, desmontar, mover);

        return menu;
    }

    @Override
    public void colocarImgRestos(){
        ImageView imagenAldeanoFrente = new ImageView( new Image("View/img/Trebuchetdie022.png"));
        agregarImagen(imagenAldeanoFrente);
    }

}
