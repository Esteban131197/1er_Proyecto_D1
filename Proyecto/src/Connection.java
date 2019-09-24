import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;

public class Connection extends JComponent {

    Output output;
    Input input;
    int id;

    public Connection(int ID, Output theOutput, Input theInput) {
        setDoubleBuffered(true); //graphics stuff - may or may not be necessary, but it does no harm
        id = ID;
        Main.currentConnectionID++;

        this.output = theOutput;
        this.input = theInput;
        if (output.isAvailable()) output.connections.add(this); //only make line if the outputs/inputs aren't already taken
        if (input.isAvailable()) input.connections.add(this); //^^
    }

