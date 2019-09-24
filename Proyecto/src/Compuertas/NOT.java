package Compuertas;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class NOT extends Component {
    NOT(int ID, int x, int y) {
        super(ID, "NOT",  x, y);
        type = "Not";
        //formato:
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        setBorder(new LineBorder(Color.black, 1));

        new Input(Main.currentConnectorID, this, 0, getHeight() / 2);
        new Output(Main.currentConnectorID, this, getWidth(), getHeight() / 2);
    }
    public boolean operation(Mi_Lista<Boolean> args) {
        boolean input1 = args.get(0);
        boolean output = !input1;
        return output;
    }

}

