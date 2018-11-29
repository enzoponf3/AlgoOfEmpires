package View.contenedores;


import Controller.CerrarJuegoButtonHandler;
import Controller.PasarTurnoButtonHandler;
import Controller.RendirseButtonHandler;
import Modelo.Juego;
import View.Boton;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class DisplayBotoneraOpciones extends VBox {

    private final Stage stage;
    private final Juego juego;

    public DisplayBotoneraOpciones(Stage stage, Juego juego,ActualizarView actualizarIcono){
        this.stage = stage;
        this.juego = juego;

        Boton pasarTurno = new Boton("Pasar turno",new PasarTurnoButtonHandler(this.juego,actualizarIcono));
        pasarTurno.getStyleClass().add("ready-button");
        Boton salir = new Boton("Salir",new CerrarJuegoButtonHandler(this.stage));
        salir.getStyleClass().add("ready-button");
        Boton rendirse = new Boton("Rendirse", new RendirseButtonHandler(this.stage));
        rendirse.getStyleClass().add("ready-button");
        this.getStylesheets().add(getClass().getResource("/View/estilos/buttonsStylesheet.css").toString());


        Rectangle2D limitesPantalla = Screen.getPrimary().getVisualBounds();
        this.setPrefSize(limitesPantalla.getWidth()/6,limitesPantalla.getHeight()/5);
        setStyle("-fx-background-color: #ad6c11");
        this.setSpacing(13);
        this.setAlignment(Pos.BASELINE_CENTER);
        this.getChildren().addAll(pasarTurno,rendirse,salir);
    }
}
