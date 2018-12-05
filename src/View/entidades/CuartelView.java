package View.entidades;

import Modelo.Edificios.Cuartel;
import Modelo.Posicion;
import Modelo.Constantes;
import View.PiezaView;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class CuartelView extends PiezaView {

    private ContextMenu menu;

    private int turnos_faltantes;

    public CuartelView(Cuartel cuartelModelo){
        super(cuartelModelo);

        ajustarTamanio(Constantes.ALTURA_EDIFICIO, Constantes.ANCHO_EDIFICIO);

        ArrayList<Posicion> posiciones = cuartelModelo.getPosiciones();
        Posicion unaPosicion = posiciones.get(0);
        setPosicion(unaPosicion);

        Image cuartelNoConstruido = new Image("View/img/rubble2.png");
        ImageView imagenNoConstruido = new ImageView(cuartelNoConstruido);

        agregarImagen(imagenNoConstruido);

        this.turnos_faltantes = 3;

    }


    @Override
    public ContextMenu crearMenu(){
        ContextMenu menu = new ContextMenu();

        MenuItem crearEspadachin = new MenuItem("Crear Espadachin");

        MenuItem crearArquero = new MenuItem("Crear Arquero");

        menu.getItems().addAll(crearArquero, crearEspadachin);

        return menu;
    }

    public void construir(){
        this.turnos_faltantes -=1;
        System.out.println(turnos_faltantes);
        if(turnos_faltantes == 0){
            Image cuartelConstruido = new Image("View/img/Cuartel.png");
            ImageView imagenCuartel = new ImageView(cuartelConstruido);
            setImagenConstruido(imagenCuartel);
            System.out.println("Cambie imagen");
        }
    }

}
