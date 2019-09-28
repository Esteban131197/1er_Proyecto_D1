package Logicaa;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JLabel;


/**
 * Esta clase es la clase padre para todos los componentes
 *Maneja tanto eventos como metodos que se heredan a las compuertas, el metodo de simulacion, entradas y salidas.
 * */
//En esta clase hago metodos y eventos necesarios para que mi interfaz use la lista
//Esta clase sera la que le herede a mis compuertas, mi simulacion y mi resultado de simulacion

public class Component extends JLabel implements MouseListener, MouseMotionListener {
    /**
     * Necesarios para que funcione la aplicacion
     * */

    int numberConnected = 0;
    int id;
    String type;
    /**
     * Este metodo sobreescribe solo el punto de inicio
     *
     * */

    public void toggle() {
    }

    public boolean operation(Mi_Lista<Boolean> args) { //overwritten by subclasses
        return false;
    }

    public Mi_Lista<Boolean> userOperation(Mi_Lista<Boolean> args) { //overwritten by subclasses
        return (new Mi_Lista<Boolean>());
    }

    int value = 0; //Valor por defecto de una entrada
    Mi_Lista<Input> inputs = new Mi_Lista<Input>(); //lista de inputs
    Mi_Lista<Input> toggles = new Mi_Lista<Input>(); // lista lo que contiene un input
    Mi_Lista<Output> outputs = new Mi_Lista<Output>();//lista de outputs

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
    /**
     * Este metodo muestra o desplega el componente
     * Esto se llama en drawPanel.repaint()
     * */
    @Override
    public void paintComponent(Graphics g) {//este metodo es para repain en mi panel
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        if (Main.showInputs) {
            for (Input in : inputs) {
                in.paintConnector(g2d);
            }
        } else {
            for (Input tog : toggles) {
                tog.paintConnector(g2d);
            }
        }
        if (Main.showOutputs) {
            for (Output out : outputs) {
                if (out.isAvailable()) {
                    out.paintConnector(g2d);
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
    /**
     * Este es el click de click and drag
     * */

    @Override
    public void mousePressed(MouseEvent e) { //Evento que me permite clickear para hacer el click-and-drag (ref.)

        System.out.println(Main.mode);
        if (Main.mode.equals("erase")) {

            Main.drawPanel.remove(this);
            Main.components.remove(this);

            for (Input input : this.inputs) {
                for (Connection connection : input.connections) {

                    Main.drawPanel.remove(connection);
                    Main.lines.remove(connection);

                    connection.output.connections.remove(connection);
                }
                input.connections.remove(input.connections);
            }

            for (Output output : this.outputs) {
                for (Connection connection : output.connections) {
                    Main.drawPanel.remove(connection);
                    Main.lines.remove(connection);

                    connection.input.connections.remove(connection);
                }
                output.connections.remove(output.connections);
            }

            Main.drawPanel.repaint();
            Main.mode = "";
        }
        // localizacion/posicion del click
        startDragX = e.getX();
        startDragY = e.getY();
    }
    /**
     * Este metodo es para cuando se libera el mouse de click and drag
     * */
    @Override
    public void mouseReleased(MouseEvent e) {
        if (inDrag) {
            inDrag = false;
        }
    }
    /**
     * Este metodo es para cuando se hace click en un punto de inicio de la entrada (tipo switch) esto pasa al valor inicial
     * */
    @Override
    public void mouseClicked(MouseEvent e) { //Con este evento doy manejo a mis listas con respecto a lo que clickeo

        for (Input in : inputs) {
            if (in.component.type.equals("Start") && in.contains(e.getPoint())) {
                System.out.println("testtoggle");
                in.component.toggle();
            }
        }
        if (Main.mode.equals("choosingInput")) {
            for (Input in : inputs) {
                if (in.isAvailable() && in.contains(e.getPoint())) {

                    Main.lines.add(new Connection(Main.currentConnectionID, Main.selectedOutput, in));
                    Main.drawPanel.repaint();
                    Main.mode = "";
                    Main.showOutputs = true;
                }
            }
        }

        if (Main.mode.equals("choosingOutput")) {
            for (Output out : outputs) {
                if (out.isAvailable() && out.contains(e.getPoint())) {

                    Main.selectedOutput = out;
                    Main.showOutputs = false;
                    Main.mode = "choosingInput";
                    Main.showInputs = true;
                    Main.drawPanel.repaint();
                }
            }
        }
    }
    /**
     * Este metodo es el encargado del drag para la plantilla
     *
     * */
        @Override
        //el "drag" del click-and-drag
        public void mouseDragged (MouseEvent e){
            int newX = getX() + (e.getX() - startDragX); //con esto muevo mis compuertas
            int newY = getY() + (e.getY() - startDragY);
            setLocation(newX, newY);
            inDrag = true;
            Main.drawPanel.repaint();
            Main.frame.repaint();
        }
        @Override
        public void mouseMoved (MouseEvent arg0){

        }
    }

