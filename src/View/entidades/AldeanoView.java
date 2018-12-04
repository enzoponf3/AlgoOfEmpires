package View.entidades;

import Controller.ConstruirCuartelHandler;
import Controller.ConstruirPlazaCentralHandler;
import Controller.MoverHandler;
import Controller.RepararHandler;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import Modelo.Constantes;
import View.PiezaView;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AldeanoView extends PiezaView {

    public AldeanoView(Aldeano aldeanoModelo){

        super(aldeanoModelo);
        ajustarTamanio(Constantes.ALTURA_UNIDAD, Constantes.ANCHO_UNIDAD);

        Posicion unaPosicion = aldeanoModelo.getPosicion();
        setPosicion(unaPosicion);


        Image aldeanoFrente = new Image("View/img/AldeanoFrente.png");
        ImageView imagenAldeanoFrente = new ImageView(aldeanoFrente);

        Image aldeanoEspalda = new Image("View/img/AldeanoEspalda.png");
        ImageView imagenAldeanoEspalda = new ImageView(aldeanoEspalda);

        agregarImagen(imagenAldeanoFrente, imagenAldeanoEspalda);

    }

    @Override
    public ContextMenu crearMenu(){
        ContextMenu menu = new ContextMenu();
        MenuItem construirPlazaCentral = new MenuItem("Construir Plaza Central");
        construirPlazaCentral.setOnAction(new ConstruirPlazaCentralHandler((Aldeano) this.entidadModelo, getThis()));

        MenuItem construirCuartel = new MenuItem("Construir Cuartel");
        construirCuartel.setOnAction(new ConstruirCuartelHandler((Aldeano) this.entidadModelo, getThis()));

        MenuItem reparar = new MenuItem("Reparar");
        reparar.setOnAction(new RepararHandler((Aldeano) this.entidadModelo,getThis()));

        MenuItem mover = new MenuItem("Mover");
        mover.setOnAction(new MoverHandler(this.entidadModelo, getThis()));

        menu.getItems().addAll(construirPlazaCentral, construirCuartel, reparar, mover);
        return menu;
    }

    private AldeanoView getThis(){
        return this;
    }
}
