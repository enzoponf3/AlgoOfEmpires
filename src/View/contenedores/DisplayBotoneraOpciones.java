package View.contenedores;


import Controller.CerrarJuegoButtonHandler;
import Controller.PasarTurnoButtonHandler;
import Controller.RendirseButtonHandler;
import Modelo.Juego;
import View.Boton;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class DisplayBotoneraOpciones extends VBox {

    private final Stage stage;
    private final Juego juego;

    public DisplayBotoneraOpciones(Stage stage, Juego juego,ActualizarView actualizarUI){
        this.stage = stage;
        this.juego = juego;
        Rectangle2D limitesPantalla = Screen.getPrimary().getVisualBounds();
        this.setPrefSize(limitesPantalla.getWidth()/6,limitesPantalla.getHeight()/5);
        HBox hbox = new HBox();

        Boton pasarTurno = new Boton("Pasar turno",new PasarTurnoButtonHandler(this.juego,actualizarUI));
        pasarTurno.getStyleClass().add("menu-button");
        Boton salir = new Boton("Salir",new CerrarJuegoButtonHandler(this.stage));
        salir.getStyleClass().add("menu-button");
        Boton rendirse = new Boton("Rendirse", new RendirseButtonHandler(actualizarUI,this.stage,this.juego));      //Esto deberia recibir un pasarTurnoHandler ?
        rendirse.getStyleClass().add("menu-button");
        this.getStylesheets().add(getClass().getResource("/View/estilos/buttonsStylesheet.css").toString());

        this.setStyle("-fx-background-image: url(\"View/img/fondoDisplay.png\");\n -fx-background-size: cover");

        this.setSpacing(10);
        salir.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(pasarTurno,rendirse);
        hbox.setAlignment(Pos.BASELINE_CENTER);
        hbox.setSpacing(13);
        this.setAlignment(Pos.BASELINE_CENTER);
        this.setPadding(new Insets(13,0,0,0));
        this.getChildren().addAll(hbox,salir);
    }
}
