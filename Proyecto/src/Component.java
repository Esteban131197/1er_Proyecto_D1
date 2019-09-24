//En esta clase hago metodos y eventos necesarios para que mi interfaz use la lista
//Esta clase sera la que le herede a mis compuertas, mi simulacion y mi resultado de simulacion

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
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
    public void paintComponent(Graphics g) {
        //este metodo es para repain en mi panel

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

    //esto para mi click and drag
    int startDragX, startDragY;
    boolean inDrag = false;

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) { //Evento que me permite clickear para hacer el click-and-drag (ref.)

        System.out.println(Main.mode);
        if (Main.mode.equals("erase")) {

            Main.drawPanel.remove(this);
            Main.components.remove(this);

            for (int x=0; x<this.outputs.size();x++) {
                for (Connection connection : inputs.connections) {
                    //for(int y=0; y<inputs.connection.size();y++)
                    Main.drawPanel.remove(connection);
                    Main.lines.remove(connection);

                    connection.output.connections.remove(connection);

                }
                inputs.get(x).connections.remove(inputs.get(x).connections);
            }
            for (int x=0; x<outputs.size(); x++) {
                for (Connection connection : outputs.connections) {
                    Main.drawPanel.remove(connection);
                    Main.lines.remove(connection);

                    connection.input.connections.remove(connection);
                }
                outputs.get(x).connections.remove(outputs.get(x).connections);
            }

            Main.drawPanel.repaint();
            Main.mode = "";

        }
        // localizacion/posicion del click
        startDragX = e.getX();
        startDragY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) { //when you release the mouse from a click and drag
        if (inDrag) {
            inDrag = false;
        }
    }

}
