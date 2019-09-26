package Logicaa;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;


public class Connection extends JComponent {

    Output output;
    Input input;
    int id;

    public Connection(int ID, Output theOutput, Input theInput) {

        setDoubleBuffered(true); //Esto puede ser presindible, se deja para evitar errores
        id = ID;
        Main.currentConnectionID++;

        this.output = theOutput;
        this.input = theInput;
        if (output.isAvailable()) output.connections.add(this); //Solo lineas entre inputs y outputs!!!
        if (input.isAvailable()) input.connections.add(this);
    }

    public void paintConnection(Graphics2D g2d) { //Dibujo de las lineas

        Line2D.Double line = new Line2D.Double(output.getX(), output.getY(), input.getX(), input.getY());
        g2d.draw(line);
        output.inputsReceivingThis.add(input);
        if (Main.mode.equals("choosingInput")) {
            input.component.numberConnected +=1;

        }
    }
}
