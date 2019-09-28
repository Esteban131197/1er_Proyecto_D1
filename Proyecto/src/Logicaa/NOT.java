package Logicaa;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Esta clase representa la compuerta o componente NOT
 * */

public class NOT extends Component {
    public NOT(int ID, int x, int y) {
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

    /**
     * Este metodo establece la logica de la compuerta para obtener un salida
     * de acuerdo a su respectiva logica
     * */

    public boolean operation(Mi_Lista<Boolean> args) {
        boolean input1 = args.get(0);
        boolean output = !input1;
        return output;
    }

}

