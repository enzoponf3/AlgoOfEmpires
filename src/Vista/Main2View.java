package Vista;

import Modelo.Edificios.Castillo;
import Modelo.Edificios.PlazaCentral;
import Modelo.Jugador.Jugador;
import Modelo.Mapa;
import Modelo.Posicion;
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

public class Main2View extends Application {

    public VBox unaCaja;

    public static final int TAMANIO_CASILLERO = 30;
    public static final int ANCHO = 20;
    public static final int ALTO = 20;

    private Group casilleros;
    private Group piezas;

    private Parent crearContenido(){
        //Un grupo de casilleros
        casilleros = new Group();
        piezas = new Group();

        //El cuadro general
        Pane root = new Pane();
        root.setPrefSize(ANCHO*TAMANIO_CASILLERO,(ALTO+1)*TAMANIO_CASILLERO);

        //Quiero un VBox que separe un pane de un menu
        unaCaja  = new VBox();

        //MAPA-----------
        Mapa mapaModelo = new Mapa(ANCHO, ALTO);
        MapaView mapaView = new MapaView(mapaModelo);

        //BOTONERA------------
        MenuBar barra = new MenuBar();
        Menu acciones = new Menu("Acciones");
        MenuItem unItem = new MenuItem("AlgunaAccion");
        acciones.getItems().add(unItem);
        barra.getMenus().add(acciones);

        //CONTENIDO------------------
        Jugador jugador1 = new Jugador(mapaModelo, 0, 6);
        Jugador jugador2 = new Jugador(mapaModelo, 16, 13);


        colocarPiezasIniciales(jugador1, jugador2);

        //-------------------
        mapaView.getChildren().add(piezas);

        unaCaja.getChildren().addAll(mapaView, barra);

        root.getChildren().addAll(unaCaja);

        return root;
    }

    public void colocarPiezasIniciales(Jugador jugador1, Jugador jugador2){
        //Piezas jug 1
        CastilloView castilloView1 = new CastilloView(jugador1.getCastillo());
        PlazaCentralView plazaView1 = new PlazaCentralView((PlazaCentral) jugador1.getEdificios().get(0));
        for(int i=0; i<3; i++) {
            AldeanoView aldeano = new AldeanoView(jugador1.getAldeanos().get(i));
            this.piezas.getChildren().add(aldeano);
        }

        //Piezas jug 2
        CastilloView castilloView2 = new CastilloView(jugador2.getCastillo());
        PlazaCentralView plazaView2 = new PlazaCentralView((PlazaCentral) jugador2.getEdificios().get(0));
        for(int i=0; i<3; i++) {
            AldeanoView aldeano = new AldeanoView(jugador2.getAldeanos().get(i));
            this.piezas.getChildren().add(aldeano);
        }

        this.piezas.getChildren().addAll(castilloView1, plazaView1, castilloView2, plazaView2);
    }

    public void agregarPieza(PiezaView pieza){
        this.piezas.getChildren().add(pieza);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(crearContenido());
        primaryStage.setTitle("AlgoEmpires");
        //primaryStage.setMaximized(true);

        primaryStage.setScene(scene);
        primaryStage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }
}
