package View.entidades;

import Controller.ConstruirHandler;
import Controller.Moverhandler;
import Modelo.Mapa;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import View.Constantes;
import View.JugadorView;
import View.MapaView;
import View.PiezaView;
import View.contenedores.ActualizarView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class AldeanoView extends PiezaView {

    private ContextMenu menu;

    private double mouseX;
    private double mouseY;

    public AldeanoView(Aldeano aldeanoModelo){

        super(aldeanoModelo);

        ajustarTamanio(Constantes.ALTURA_UNIDAD, Constantes.ANCHO_UNIDAD);

        Posicion unaPosicion = aldeanoModelo.getPosicion();
        setPosicion(unaPosicion);

        Image aldeanoFrente = new Image("AldeanoFrente.png");
        ImageView imagenAldeanoFrente = new ImageView(aldeanoFrente);

        Image aldeanoEspalda = new Image("AldeanoEspalda.png");
        ImageView imagenAldeanoEspalda = new ImageView(aldeanoEspalda);

        agregarImagen(imagenAldeanoFrente, imagenAldeanoEspalda);

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                mouseX = event.getScreenX();
                mouseY = event.getSceneY();

                ContextMenu menu = this.crearMenu();
                menu.show(imagenAldeanoFrente, event.getScreenX(), event.getScreenY());
            }

            private ContextMenu crearMenu(){

                ContextMenu menu = new ContextMenu();
                MenuItem construirPlazaCentral = new MenuItem("Construir Plaza Central");
                construirPlazaCentral.setOnAction(new ConstruirHandler(aldeanoModelo, getThis()));

                MenuItem construirCuartel = new MenuItem("Construir Cuartel");
                construirCuartel.setOnAction(new ConstruirHandler(aldeanoModelo, getThis()));

                MenuItem reparar = new MenuItem("Reparar");

                MenuItem mover = new MenuItem("Mover");
                mover.setOnAction(new Moverhandler(aldeanoModelo, getThis()));

                menu.getItems().addAll(construirPlazaCentral, construirCuartel, reparar, mover);
                return menu;
            }

        });


        inicializarEventos();

    }

    private AldeanoView getThis(){
        return this;
    }

    protected void inicializarEventos() {

        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mouseX = event.getSceneX();
                mouseY = event.getSceneY();

                MapaView mapaView = MapaView.getInstancia();
                Posicion destino = mapaView.getDestino();

                double destinoX = destino.getHorizontal();
                double destinoY = destino.getVertical();

                if( (mouseX - destinoX)==Constantes.TAMANIO_CASILLERO && (mouseY-destinoY)==Constantes.TAMANIO_CASILLERO )
                    relocate(destino.getHorizontal(), destino.getVertical());

            }
        });

        setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                relocate(event.getSceneX() - mouseX + getPosX(), event.getSceneY() - mouseY + getPosY());
            }
        });
    }



}
