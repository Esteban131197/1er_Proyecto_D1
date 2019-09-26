package Logicaa;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class StartPoint extends Component {

    StartPoint(int ID, int x, int y) {
        super(ID, "Start", x, y);
        type = "Start";
        value = 0;
        this.setText(Integer.toString(value));
        //formato:
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        setBorder(new LineBorder(Color.black, 1));
        Output bye = new Output(Main.currentConnectorID, this, getWidth(), getHeight() /2);
        Input hi = new Input(Main.currentConnectorID, this, 0, getHeight() /2);
        hi.hasValue = true;
        hi.maxConnections = 0;

    }
    boolean isAvailable() {
        return false;
    }
    public boolean operation(Mi_Lista<Boolean> args) {

        return outputs.get(0).value;
    }
    public void toggle() {
        System.out.println("toggling");
        value +=1;
        value %= 2;
        if (value == 0) {
            outputs.get(0).value = false;
        }
        else {
            outputs.get(0).value = true;
        }

        this.setText(Integer.toString(value));

    }
}
