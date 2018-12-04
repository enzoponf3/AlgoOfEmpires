package View.entidades;

import Modelo.Edificios.Cuartel;
import Modelo.Posicion;
import Modelo.Constantes;
import View.PiezaView;
import javafx.scene.control.ContextMenu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class CuartelView extends PiezaView {

    private ContextMenu menu;

    public CuartelView(Cuartel cuartelModelo){
        super(cuartelModelo);

        ajustarTamanio(Constantes.ALTURA_EDIFICIO, Constantes.ANCHO_EDIFICIO);

        ArrayList<Posicion> posiciones = cuartelModelo.getPosiciones();
        Posicion unaPosicion = posiciones.get(0);
        setPosicion(unaPosicion);

        Image plaza = new Image("View/img/University2.png");
        ImageView imagenPlaza = new ImageView(plaza);

        agregarImagen(imagenPlaza, imagenPlaza);

    }

}
