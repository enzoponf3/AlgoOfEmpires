package View.entidades;

import Controller.CrearAldeanoHandler;
import Modelo.Edificios.PlazaCentral;
import Modelo.Posicion;
import Modelo.Constantes;
import View.MapaView;
import View.PiezaView;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.util.ArrayList;

public class PlazaCentralView extends PiezaView {

    private int turnos_faltantes;

    public PlazaCentralView(PlazaCentral plazaModelo){

        super(plazaModelo);

        ajustarTamanio(Constantes.ALTURA_EDIFICIO, Constantes.ANCHO_EDIFICIO);

        ArrayList<Posicion> posiciones = plazaModelo.getPosiciones();
        Posicion unaPosicion = posiciones.get(0);
        setPosicion(unaPosicion);

        Image plaza = new Image("View/img/EnConstruccion.png");
        ImageView imagenPlaza = new ImageView(plaza);

        agregarImagen(imagenPlaza, imagenPlaza);
    }


    @Override
    public ContextMenu crearMenu(){
        ContextMenu menu = new ContextMenu();

        MenuItem crearAldeano = new MenuItem("Crear aldeano");
        crearAldeano.setOnAction(new CrearAldeanoHandler(this));
        menu.getItems().addAll(crearAldeano);

        return menu;
    }

    public void construir(){
        this.turnos_faltantes -=1;
        System.out.println(turnos_faltantes);
        if(turnos_faltantes == 0){
            this.setImagenPlazaConstruida();
            System.out.println("Cambie imagen");
            MapaView.getInstancia().reproducirEfecto().terminarEdificio();
        }
    }

    public void setTurnosFaltantes(){
        this.turnos_faltantes = 3;
    }

    @Override
    public void colocarImgRestos(){
        ImageView imagenAldeanoFrente = new ImageView( new Image("View/img/destruido.png"));
        agregarImagen(imagenAldeanoFrente);
        MapaView.getInstancia().reproducirEfecto().destruirEdifio();
    }

}
