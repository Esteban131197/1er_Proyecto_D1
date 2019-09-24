package Compuertas;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class NOR extends Component { // Nor Gate class
    NOR(int ID, int x, int y) {
        super(ID, "NOR",  x, y); //adding to the component constructor, not replacing it
        type = "Nor";
        //formatting:
        setVerticalAlignment(SwingConstants.CENTER);
        setHorizontalAlignment(SwingConstants.CENTER);
        setBounds(x, y, 70, 30);
        setBorder(new LineBorder(Color.black, 1));
        //Below: creates two inputs, one output
        new Input(Main.currentConnectorID, this, 0, 6);
        new Input(Main.currentConnectorID, this, 0, getHeight() - 6);
        new Output(Main.currentConnectorID, this, getWidth(), getHeight() / 2);
    }

    public boolean operation(Mi_Lista<Boolean> args) { // "ors" the two inputs
        boolean input1 = args.get(0);
        boolean input2 = args.get(1);//need to relate these with the physical inputs
        return !(input1||input2);
    }
}