package View.contenedores;
import View.Boton;
import Controller.BackButtonHandler;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class pantallaAyuda extends Pane{

    Stage stage;
    public pantallaAyuda(Stage stage){
        this.stage = stage;
        this.setPrefSize(720,480);

        Text tituloText = new Text("Instrucciones\n");
        tituloText.setFill(Color.web("#d1a96b"));
        tituloText.relocate(170,35);
        tituloText.setFont(Font.font("Castellar", FontWeight.NORMAL, FontPosture.REGULAR,40));
        Text textHelp = new Text(" • Cada jugador comienza con una plaza central, un castillo,3 aldeanos y 100 de oro.\n" +
                " • Los aldeanos pueden construir cuarteles y plazas centrales.\n • Los cuarteles pueden crear" +
                " espadachines y arqueros con su respectivo costo, asi\n        como las plazas" +
                "centrales pueden crear aldeanos.\n");
        textHelp.relocate(0,80);
        Text objetivoText = new Text(" • Objetivo principal: Destruir el castillo enemigo.");
        objetivoText.relocate(0,200);
        objetivoText.setFill(Color.web("#b71c1c"));
        objetivoText.setStroke(Color.web("#d32828"));
        objetivoText.setStrokeWidth(0.2);
        textHelp.setFont(Font.font("Century Schoolbook", FontWeight.NORMAL, FontPosture.REGULAR,18));
        objetivoText.setFont(Font.font("Century Schoolbook",FontWeight.SEMI_BOLD,FontPosture.REGULAR,20));

        Boton volver = new Boton("Volver", new BackButtonHandler(stage));
        volver.relocate(330,250);
        Image fondo = new Image("View/img/fondoAyuda.png", 1500, 500, true, false);
        ImageView im = new ImageView(fondo);
        im.relocate(-70,0);
        im.setOpacity(0.70);
        this.getStylesheets().add(getClass().getResource("/View/estilos/buttonsStylesheet.css").toString());

        this.getChildren().addAll(im,tituloText,textHelp,objetivoText,volver);

    }
}
