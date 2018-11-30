package View;

import Controller.CasilleroHandler;
import Modelo.Posicion;
import javafx.event.EventHandler;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class CasilleroView extends StackPane {

    private PiezaView pieza;
    private ImageView laImagen;

    private int i;
    private int j;

    public PiezaView getPieza(){
        return this.pieza;
    }

    public Posicion getPosicion(){
        Posicion posicion = new Posicion(this.i, this.j );
        return posicion;
    }

    public void setPieza(PiezaView pieza){
        this.pieza = pieza;
    }

    public CasilleroView(int x, int y){
        setWidth(Constantes.TAMANIO_CASILLERO);
        setHeight(Constantes.TAMANIO_CASILLERO);

        this.i = (int) ( x*Constantes.TAMANIO_CASILLERO);
        this.j = (int) (y*Constantes.TAMANIO_CASILLERO);

        relocate(x* Constantes.TAMANIO_CASILLERO,y* Constantes.TAMANIO_CASILLERO);

        Image newPic = new Image("aoeGrass.jpeg");
        laImagen = new ImageView(newPic);
        laImagen.setFitHeight(Constantes.TAMANIO_CASILLERO);
        laImagen.setFitWidth(Constantes.TAMANIO_CASILLERO);

        Rectangle borde = new Rectangle();
        borde.setStroke(Color.rgb(0, 0, 0, 0.2));
        borde.setVisible(true);

        this.setOnMousePressed(new CasilleroHandler(this));

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                setEffect(new Glow(0.5));
            }
        });

        getChildren().addAll(laImagen, borde);
    }


}
