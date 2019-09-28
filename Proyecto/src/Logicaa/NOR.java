package Logicaa;

import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * Esta clase representa la compuerta o componente NOR
 * */

public class NOR extends Component {
    public NOR(int ID, int x, int y) {
        super(ID, "NOR",  x, y);
        type = "Nor";
        //formato:
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        setBorder(new LineBorder(Color.black, 1));

        new Input(Main.currentConnectorID, this, 0, 6);
        new Input(Main.currentConnectorID, this, 0, getHeight() - 6);
        new Output(Main.currentConnectorID, this, getWidth(), getHeight() / 2);
    }

    /**
     * Este metodo establece la logica de la compuerta para obtener un salida
     * de acuerdo a su respectiva logica
     * */

    public boolean operation(Mi_Lista<Boolean> args) {
        boolean input1 = args.get(0);
        boolean input2 = args.get(1);
        return !(input1||input2);
    }
}