package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.RadioButton;

public class BotonRadio extends RadioButton {

    public BotonRadio(String text) {
        setText(text);
    }

    @Override public void fire() {
        if (!isDisabled()) {
//            setSelected(!isSelected());
            fireEvent(new ActionEvent());
        }
    }
}
