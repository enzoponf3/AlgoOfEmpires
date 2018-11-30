package View.entidades;

import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import Controller.ControladorAldeano;
import View.MapaView;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;

public class AldeanoView extends StackPane {

    private Aldeano modelo;

    private ContextMenu menu;

    private ImageView imagenAldeano;
    private static final double ALTURA_UNIDAD = 1;
    private static final double ANCHO_UNIDAD = 0.5;
    private int x;
    private int y;

    public AldeanoView(Aldeano unModelo){

        this.modelo = unModelo;

        setWidth(ANCHO_UNIDAD* MapaView.TAMANIO_CASILLERO);
        setHeight(ALTURA_UNIDAD* MapaView.TAMANIO_CASILLERO);

        Posicion unaPosicion = unModelo.getPosicion();
        x = unaPosicion.getHorizontal();
        y = unaPosicion.getVertical();

        Image aldeano = new Image("Villagerwalk001.png");
        imagenAldeano = new ImageView(aldeano);
        imagenAldeano.setFitHeight(ALTURA_UNIDAD* MapaView.TAMANIO_CASILLERO);
        imagenAldeano.setFitWidth(ANCHO_UNIDAD* MapaView.TAMANIO_CASILLERO);

        relocate(x* MapaView.TAMANIO_CASILLERO,y* MapaView.TAMANIO_CASILLERO);



        getChildren().addAll(imagenAldeano);


        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                devolverMenu();
            }
        });

        this.setOnMouseClicked(new ControladorAldeano(this, modelo));



    }

    public ContextMenu devolverMenu(){
        return this.menu;
    }

    public void agregarMenu(ContextMenu menu){
        this.menu = menu;
    }

}
