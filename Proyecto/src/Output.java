import java.awt.*;
import Compuertas.*;

public class Output extends Connector {

    Mi_Lista<Input> inputsReceivingThis = new Mi_Lista<>();

    Output(int ID, Component owner, int x, int y) {
        super(ID, owner, x, y);
        isOutput = true;
        owner.addOutput(this);
        maxConnections = 100; // maxima cant de outputs
        Polygon p = new Polygon();
        p.addPoint(x - w, y - h / 2);
        p.addPoint(x, y - h/2);
        p.addPoint(x, y + h/2);
        p.addPoint(x - w, y + h / 2);

        shape = p;
        color = Color.red;
    }
}

