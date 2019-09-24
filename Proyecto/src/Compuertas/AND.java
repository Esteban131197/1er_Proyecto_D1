package Compuertas;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class AND extends Component {
    AND(int ID, int x, int y) {
        super(ID, "AND",  x, y);
        type = "And";
        //formato:
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        setBorder(new LineBorder(Color.black, 1));

        new Input(Main.currentConnectorID, this, 0, 6);
        new Input(Main.currentConnectorID, this, 0, getHeight() - 6);
        new Output(Main.currentConnectorID, this, getWidth(), getHeight() / 2);
    }

    public boolean operation(Mi_Lista<Boolean> args) {
        boolean input1 = args.get(0);
        boolean input2 = args.get(1);
        boolean output = (input1&&input2);
        return output;
    }


}

