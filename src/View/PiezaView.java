package View;

import Modelo.IEntidad;
import Modelo.Posicion;
import Modelo.Unidades.Unidad;
import View.Constantes;
import View.entidades.AldeanoView;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;

import static View.Constantes.ALTURA_CASTILLO;


public class PiezaView extends StackPane {

    private ImageView imagenPieza;
    private IEntidad entidadModelo;
    private double alto;
    private double ancho;

    private int x;
    private int y;

    public PiezaView(IEntidad entidadModelo){

        this.entidadModelo = entidadModelo;

/*
        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if(event.getButton() == MouseButton.PRIMARY ) {
                    seleccionarPieza();
                }
                if(event.getButton() == MouseButton.SECONDARY ) {
                    atacarPieza();
                }
            }
        });

        */
    }

    public void setPosicion(Posicion unaPosicion){
        this.x = unaPosicion.getHorizontal();
        this.y = unaPosicion.getVertical();

        relocate(x*Constantes.TAMANIO_CASILLERO,y*Constantes.TAMANIO_CASILLERO);
    }

    public void ajustarTamanio(double alto, double ancho){
        this.alto = alto;
        setWidth(this.ancho*Constantes.TAMANIO_CASILLERO);

        this.ancho = ancho;
        setHeight(this.alto*Constantes.TAMANIO_CASILLERO);
    }

    public void agregarImagen(ImageView imagenPiezaADerecha, ImageView imagenPiezaAIzquierda){

        if( x < Screen.getPrimary().getVisualBounds().getWidth() /2 ){
            imagenPieza = imagenPiezaADerecha;
            imagenPieza.setFitHeight(this.alto*Constantes.TAMANIO_CASILLERO);
            imagenPieza.setFitWidth(this.ancho*Constantes.TAMANIO_CASILLERO);
        }else{
            imagenPieza = imagenPiezaAIzquierda;
            imagenPieza.setFitHeight(this.alto*Constantes.TAMANIO_CASILLERO);
            imagenPieza.setFitWidth(this.ancho*Constantes.TAMANIO_CASILLERO);
        }

        getChildren().addAll(imagenPieza);
    }





}
