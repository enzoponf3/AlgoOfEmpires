package View;

import Controller.CasilleroHandler;
import Modelo.Casillero;
import Modelo.Constantes;
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

    private Casillero casilleroModelo;
    private PiezaView pieza;
    private ImageView laImagen;
    private Rectangle borde;

    private Rectangle bordeConstruir;

    public PiezaView getPieza(){
        return this.pieza;
    }

    public Posicion getPosicion(){
        return this.casilleroModelo.getPosicion();
    }

    public void setPieza(PiezaView pieza){
        this.pieza = pieza;
    }

    public CasilleroView(int x, int y, Casillero casilleroModelo){

        this.casilleroModelo = casilleroModelo;

        setWidth(Constantes.TAMANIO_CASILLERO);
        setHeight(Constantes.TAMANIO_CASILLERO);

        relocate(x* Constantes.TAMANIO_CASILLERO,y* Constantes.TAMANIO_CASILLERO);

        Image newPic = new Image("View/img/aoeGrass.jpeg");
        laImagen = new ImageView(newPic);
        laImagen.setFitHeight(Constantes.TAMANIO_CASILLERO);
        laImagen.setFitWidth(Constantes.TAMANIO_CASILLERO);

        this.borde = new Rectangle();
        borde.setFill(Color.TRANSPARENT);
        borde.setHeight(Constantes.TAMANIO_CASILLERO);
        borde.setWidth(Constantes.TAMANIO_CASILLERO);
        borde.setStroke(Color.BLUE);
        borde.setStrokeWidth(3);
        borde.setVisible(false);

        this.setOnMousePressed(new CasilleroHandler(this));

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                borde.setVisible(true);
            }
        });
        //Prueba
        bordeConstruir = new Rectangle();
        bordeConstruir.setFill(Color.TRANSPARENT);
        bordeConstruir.setHeight(Constantes.TAMANIO_CASILLERO);
        bordeConstruir.setWidth(Constantes.TAMANIO_CASILLERO);
        bordeConstruir.setStroke(Color.DARKGREEN);
        bordeConstruir.setStrokeWidth(3);

        bordeConstruir.setVisible(false);
        getChildren().add(bordeConstruir);

        getChildren().addAll(laImagen, borde);
    }

    public void quitarEfecto(){
        this.borde.setVisible(false);
    }


}
