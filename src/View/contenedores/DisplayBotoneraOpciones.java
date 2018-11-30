package View.contenedores;


import Controller.CerrarJuegoButtonHandler;
import Controller.PasarTurnoButtonHandler;
import Controller.RendirseButtonHandler;
import Modelo.Juego;
import View.Boton;
import javafx.geometry.Insets;
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
        Rectangle2D limitesPantalla = Screen.getPrimary().getVisualBounds();
        this.setPrefSize(limitesPantalla.getWidth()/6,limitesPantalla.getHeight()/5);

        Boton pasarTurno = new Boton("Pasar turno",new PasarTurnoButtonHandler(this.juego,actualizarIcono));
        pasarTurno.getStyleClass().add("ready-button");
        Boton salir = new Boton("Salir",new CerrarJuegoButtonHandler(this.stage));
        salir.getStyleClass().add("ready-button");
        Boton rendirse = new Boton("Rendirse", new RendirseButtonHandler(this.stage));
        rendirse.getStyleClass().add("ready-button");
        this.getStylesheets().add(getClass().getResource("/View/estilos/buttonsStylesheet.css").toString());

        // hay que acoomodar los botones
        this.setStyle("-fx-background-image: url(\"View/img/fondoDisplay.png\");");           //Ver si se deforma en la de enzo
        this.setSpacing(10);
        pasarTurno.setAlignment(Pos.TOP_CENTER);
        rendirse.setAlignment(Pos.CENTER);
        salir.setAlignment(Pos.BOTTOM_CENTER);

        this.setAlignment(Pos.BASELINE_CENTER);
        this.setPadding(new Insets(13,0,0,0));
        this.getChildren().addAll(pasarTurno,rendirse,salir);
    }
}
