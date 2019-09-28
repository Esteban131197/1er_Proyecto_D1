package Logicaa;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

/**
 * Clase EndPoint
 * Esta clase almacena el resultado al evaluar las entradas en su respectiva compuerta
 * */

public class EndPoint extends Component {
    EndPoint(int ID, int x, int y) {
        super(ID, "End", x, y);
        type = "End";

        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        setBorder(new LineBorder(Color.black, 1));

        new Input(Main.currentConnectorID, this, 0, getHeight() / 2);

    }

}

