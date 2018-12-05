package Controller;

import Modelo.IEntidad;
import Modelo.Unidades.ArmaDeAsedio;
import Modelo.Unidades.IAtacante;
import View.JugadorView;
import View.MapaView;
import View.PiezaView;
import View.contenedores.ActualizarView;
import View.entidades.ArmaDeAsedioView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class AtacarHandler implements EventHandler<ActionEvent> {
    private PiezaView atacanteView;
    private IEntidad atacante;

    public AtacarHandler(PiezaView pieza) {
        this.atacanteView = pieza;
    }

    @Override
    public void handle(ActionEvent event) {
        MapaView mapaView = MapaView.getInstancia();

        mapaView.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event){
                atacar(mapaView);
                mapaView.setOnMouseClicked(null);
            }
        });

    }

    private void atacar(MapaView mapaView) {
        IEntidad objetivo = mapaView.getEntidad();
        ActualizarView actualizarView = ActualizarView.getInstancia();
        JugadorView jugadorViewActual = actualizarView.getJugadorViewActual();
        jugadorViewActual.atacar(objetivo, (IAtacante) atacanteView.getEntidad());
    }
}
