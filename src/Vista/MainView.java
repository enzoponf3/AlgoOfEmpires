package Vista;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainView extends Application {

    public VBox unaCaja;

    public static final int TAMANIO_CASILLERO = 50;
    public static final int WIDTH = 10;
    public static final int HEIGHT = 15;

    private Group casilleros;
    private Group piezas;

    private Parent crearContenido(){
        //Un grupo de casilleros
        casilleros = new Group();
        piezas = new Group();

        //El cuadro general
        Pane root = new Pane();
        root.setPrefSize(900, 900);

        //Quiero un VBox que separe un pane de un menu
        unaCaja  = new VBox();

        Pane mapa = new Pane();
        mapa.setPrefSize(WIDTH*TAMANIO_CASILLERO,HEIGHT*TAMANIO_CASILLERO);

        MenuBar barra = new MenuBar();
        Menu acciones = new Menu("Acciones");
        MenuItem unItem = new MenuItem("AlgunaAccion");

        acciones.getItems().add(unItem);
        barra.getMenus().add(acciones);

        //creo los casilleros para poner en el Pane
        for(int x=0; x<HEIGHT ;x++){
            for(int y=0; y<WIDTH; y++){
                CasilleroView unCasillero = new CasilleroView(x,y);
                casilleros.getChildren().add(unCasillero);
            }
        }

        PiezaView unaPieza = new PiezaView(8, 8);
        CastilloView unCastillo = new CastilloView(2,2);

        piezas.getChildren().add(unaPieza);

        mapa.getChildren().addAll(casilleros, unCastillo);

        unaCaja.getChildren().addAll(barra, mapa);

        root.getChildren().addAll(unaCaja, piezas);

        return root;
    }

    public void agregarPieza(PiezaView pieza){
        this.piezas.getChildren().add(pieza);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(crearContenido());
        primaryStage.setTitle("AlgoEmpires");
        primaryStage.setMaximized(true);

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
