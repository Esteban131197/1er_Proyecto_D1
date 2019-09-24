//En esta clase hago metodos y eventos necesarios para que mi interfaz use la lista
//Esta clase sera la que le herede a mis compuertas, mi simulacion y mi resultado de simulacion

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

abstract class Component extends JLabel implements MouseListener, MouseMotionListener {

    int numberConnected = 0;
    int id;
    String type;

    public void toggle() { //Is overwritten only in the StartPoint class - go there if you dare...
    }
    public boolean operation(Mi_Lista<Boolean> args) { //overwritten by subclasses
        return false;
    }

    public Mi_Lista<Boolean> userOperation(Mi_Lista<Boolean> args) { //overwritten by subclasses
        return (new Mi_Lista());
    }

    int value = 0; //Valor por defecto de una entrada
    Mi_Lista<Input> inputs = new Mi_Lista<>(); //lista de inputs
    Mi_Lista<Input> toggles = new Mi_Lista<>(); // list lo que contiene un input
    Mi_Lista<Output> outputs = new Mi_Lista<>();//lista de outputs

    public Component(int ID, String text, int x, int y) {

        super(text);
        id = ID;
        Main.currentComponentID++;

        Main.components.add(this);
        addMouseListener(this);
        addMouseMotionListener(this);
        Main.drawPanel.add(this);
    }

    public void addOutput(Output o) {
        outputs.add(o);
    }
    public void addInput(Input i) {
        inputs.add(i);
    }
    public void addtoToggles(Input i) {
        toggles.add(i);
    }

    @Override
    public void paintComponent(Graphics g) { //displays component depending on the your Main.modes and stuff
        //this gets called on drawPanel.repaint()

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        if (Main.showInputs) { //inputs only shown when appropriate
            for (int x=0; x<inputs.size(); x++) {
                inputs.get(x).paintConnector(g2d);
            }
        }

        else {
            for (int x=0; x<toggles.size();x++) {
                toggles.get(x).paintConnector(g2d);
            }
        }
        if (Main.showOutputs) {
            for (int x=0; x<outputs.size(); x++) { //outputs only shown when appropriate
                if (outputs.get(x).isAvailable()) {
                    outputs.get(x).paintConnector(g2d);
                }

            }
        }
    }
}
