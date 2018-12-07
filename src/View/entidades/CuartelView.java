package View.entidades;

import Controller.CrearArqueroHandler;
import Controller.CrearEspadachinHandler;
import Modelo.Edificios.Cuartel;
import Modelo.Posicion;
import Modelo.Constantes;
import View.MapaView;
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

        Image cuartelNoConstruido = new Image("View/img/EnConstruccion.png");
        ImageView imagenNoConstruido = new ImageView(cuartelNoConstruido);

        agregarImagen(imagenNoConstruido);

        this.turnos_faltantes = Constantes.TURNOS_CONSTRUCCION_CUARTEL;

    }


    @Override
    public ContextMenu crearMenu(){
        ContextMenu menu = new ContextMenu();

        MenuItem crearEspadachin = new MenuItem("Crear Espadachin");
        crearEspadachin.setOnAction(new CrearEspadachinHandler(this));

        MenuItem crearArquero = new MenuItem("Crear Arquero");
        crearArquero.setOnAction(new CrearArqueroHandler(this));

        menu.getItems().addAll(crearArquero, crearEspadachin);

        return menu;
    }

    public void construir(){
        this.turnos_faltantes -=1;
        System.out.println(turnos_faltantes);
        if(turnos_faltantes == 0){
            this.setImagenCuartelConstruido();
            System.out.println("Cambie imagen");
            MapaView.getInstancia().reproducirEfecto().terminarEdificio();
        }
    }

    @Override
    public void colocarImgRestos(){
        ImageView imagenAldeanoFrente = new ImageView( new Image("View/img/destruido.png"));
        agregarImagen(imagenAldeanoFrente);
        MapaView.getInstancia().reproducirEfecto().destruirEdifio();
    }

}
