package View.contenedores;

import View.Boton;
import View.JugadorView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;


public class PantallaGanador extends Pane {

    public  PantallaGanador (JugadorView jugador){

        this.setPrefSize(1080,680);

        ImageView fondo = new ImageView(new Image("View/img/fondoGanador.png",1100,770,false,false));

        ImageView fondoAni = new ImageView(new Image("View/img/fondoCelebrate.gif",900,600,true,true));
        fondoAni.setOpacity(0.15);
        fondoAni.relocate(-50,-150);
        fondoAni.setRotate(fondoAni.getRotate() + 180);
        ImageView fondoAni2 = new ImageView(new Image("View/img/fuegoArt.gif",500,300,true,true));
        fondoAni2.setOpacity(0.4);
        fondoAni2.relocate(700, -50);

        Text ganador = new Text("GANASTE!!!");
        ganador.setFill(Color.web("#FCBA1E"));
        ganador.relocate(50,50);
        ganador.setFont(Font.font("Castellar", FontWeight.NORMAL, FontPosture.REGULAR,60));

        ImageView figura = new ImageView(jugador.getFigura().getImage());
        figura.resize(600,400);
        figura.setFitWidth(550);
        figura.setFitHeight(450);
        figura.setPreserveRatio(true);
        figura.relocate(100,100);

        Text nombre = new Text(jugador.getNombre());
        nombre.setFont(Font.font("Calisto MT", FontWeight.NORMAL, FontPosture.REGULAR,60));
        nombre.relocate(100,580);
        nombre.setFill(Color.web("#FCBA1E"));

       /* Boton volver = new Boton("Volver a jugar", new PlayAgainButtonHandler ());

        Boton Salir = new Boton("SALIR", new ExitButtonHandler());
*/
        this.getChildren().addAll(fondo,fondoAni, fondoAni2,ganador,figura,nombre);



    }
}
