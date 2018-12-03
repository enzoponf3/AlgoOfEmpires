package View.entidades;

import Controller.ConstruirCuartelHandler;
import Controller.ConstruirPlazaCentralHandler;
import Controller.Moverhandler;
import Controller.RepararHandler;
import Modelo.Posicion;
import Modelo.Unidades.Aldeano;
import View.Constantes;
import View.PiezaView;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

public class AldeanoView extends PiezaView {

    /*private ContextMenu menu;                 //Revisar porque no se usan, si no saquenlas

    private double mouseX;
    private double mouseY;*/

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
        ContextMenu menu = this.crearMenu(aldeanoModelo);

        this.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                /*mouseX = event.getScreenX();
                mouseY = event.getSceneY();*/           //esto tampoco se usa porque dsp hacen un event.getscreen en vez de usar estas varaibles
                menu.show(imagenAldeanoFrente, event.getScreenX(), event.getScreenY());
            }
        });
    }

    private ContextMenu crearMenu(Aldeano aldeanoModelo){
        ContextMenu menu = new ContextMenu();
        MenuItem construirPlazaCentral = new MenuItem("Construir Plaza Central");
        construirPlazaCentral.setOnAction(new ConstruirPlazaCentralHandler(aldeanoModelo, getThis()));

        MenuItem construirCuartel = new MenuItem("Construir Cuartel");
        construirCuartel.setOnAction(new ConstruirCuartelHandler(aldeanoModelo, getThis()));

        MenuItem reparar = new MenuItem("Reparar");
        reparar.setOnAction(new RepararHandler(aldeanoModelo,getThis()));

        MenuItem mover = new MenuItem("Mover");
        mover.setOnAction(new Moverhandler(aldeanoModelo, getThis()));

        menu.getItems().addAll(construirPlazaCentral, construirCuartel, reparar, mover);
        return menu;
    }

    private AldeanoView getThis(){
        return this;
    }
}
