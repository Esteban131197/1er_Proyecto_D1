package Logicaa;

/**
 *
 * Esta clase funciona como ventana principal de la aplicacion.
 * En ella se:
 * Define lo relacionado con interfaz de usuario
 * Establece botones en la paleta como imagenes
 *
 * */

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.*;
import javax.swing.*;


public class Main {

    /**
     *Los siguientes "fields" son usados para dar un # de ID a los objetos
     *
     * */
    //la razon por la que se usa variables statics, es para tener un valor fijo en la memoria, y asi hacer el llamado
    //de ese solo valor de manera inmutable, no que se creen nuevos espacio de memoria en cada instancia.

    static Mi_Lista <Component>components = new Mi_Lista();
    static Mi_Lista <Connection> lines = new Mi_Lista();
    static int currentComponentID = 0;
    static int currentConnectorID = 0;
    static int currentConnectionID = 0;
    static String mode = "";
    static boolean showInputs = true, showOutputs = true;
    static Output selectedOutput = null;

    //Ventana:
    static JFrame frame = new JFrame("Circuit Designer");
    static Screen drawPanel = new Screen();

    Main() {
        //formato de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        drawPanel.setLayout(null);
        frame.add(drawPanel);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel buttonspanel = new JPanel();
        splitPane.setTopComponent(buttonspanel);
        frame.add(splitPane, BorderLayout.PAGE_END);

        //Imagenes y botones

        JButton andbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("img./and.gif"));
            andbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton nandbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("img./nand.gif"));
            nandbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton orbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("img./or.gif"));
            orbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton norbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("img./nor.gif"));
            norbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton notbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("img./not.gif"));
            notbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton xorbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("img./xor.gif"));
            xorbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton xnorbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("img./xnor.gif"));
            xnorbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton coneccionesButton = new JButton("Hilos");
        JButton startButton = new JButton("Entrada");
        JButton endButton = new JButton("Salida");
        JButton simularButton = new JButton("Simular");
        JButton eraseButton = new JButton("Borrar");

        //Mostrar botones e imagenes

        buttonspanel.add(andbutton);
        buttonspanel.add(nandbutton);
        buttonspanel.add(orbutton);
        buttonspanel.add(norbutton);
        buttonspanel.add(notbutton);
        buttonspanel.add(xorbutton);
        buttonspanel.add(xnorbutton);
        buttonspanel.add(coneccionesButton);
        buttonspanel.add(startButton);
        buttonspanel.add(endButton);
        buttonspanel.add(simularButton);
        buttonspanel.add(eraseButton);

        andbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                makeAnd();
            }
        });

        nandbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                makeNand();
            }
        });

        orbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                makeOr();
            }
        });

        norbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                makeNor();
            }
        });

        notbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                makeNot();
            }
        });

        xorbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                makeXor();
            }
        });

        xnorbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                makeXnor();
            }
        });

        coneccionesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
                makeConnection();
            }
        });

        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                makeStart();
            }
        });

        endButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                makeEnd();
            }
        });
        simularButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                simulate();
            }
        });

        eraseButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                makeErase();
            }
        });


        frame.setVisible(true);
    }


    void makeAnd() {
        mode = "addingAnd";
    }

    void makeNand() {
        mode = "addingNand";
    }

    void makeOr() {
        mode = "addingOr";
    }

    void makeNor() {
        mode = "addingNor";
    }

    void makeNot() {
        mode = "addingNot";
    }

    void makeXor() {
        mode = "addingXor";
    }

    void makeXnor() {
        mode = "addingXnor";
    }

    void makeConnection() {
        mode = "choosingOutput";
        showInputs = false;
        showOutputs = true;
        drawPanel.repaint(); //repaint = refrescar la interfaz
    }

    void makeStart() {
        mode = "addingStart";
    }

    void makeEnd() {
        mode = "addingEnd";
    }

    void makeErase() {
        mode = "erase";
    }



    int simulate() {
        int toBeReturned = -1;

        int keepGoing = 0;

        while (keepGoing < 200) {
            keepGoing++;
            int endsReached = 0;

            for (Component gate : components) {
                boolean act = true;
                Mi_Lista<Boolean> inputValues = new Mi_Lista<>();
                for (Input input : gate.inputs) {
                    if (!(input.hasValue)) {
                        act = false;
                    }
                    else {
                        inputValues.add(input.value);
                    }
                }
                if (act) {
                    if (gate.type.equals("User")) {
                        int nextOne=0;
                        for (Output out : gate.outputs) {
                            System.out.println("nextone is " + nextOne + "input value: " + inputValues + " value is " + (gate.userOperation(inputValues)));
                            out.value = gate.userOperation(inputValues).get(nextOne);
                            nextOne ++;
                        }
                    }
                    else {
                        for (Output out : gate.outputs){
                            out.value = gate.operation(inputValues);
                        }
                    }
                    for (Output out : gate.outputs) {
                        for (Input input : out.inputsReceivingThis) {


                            input.value = out.value;
                            input.hasValue = true;
                        }
                    }
                    if (gate.type.equals("End")) {
                        boolean reached = false;
                        String result;
                        if (gate.inputs.get(0).value == false) {
                            result = Integer.toString(0);
                            reached = true;
                        }
                        else if (gate.inputs.get(0).value == true) {
                            result = Integer.toString(1);
                            reached = true;
                        }
                        else {
                            result = "";
                        }

                        if (reached) {
                            gate.setText(result);
                            endsReached +=1;
                        }

                        Mi_Lista<Component> endPoints = new Mi_Lista<>();
                        for (Component component : components) {
                            if (component.type.equals("End")) {
                                endPoints.add(component);
                            }
                        }
                        if (endsReached >= endPoints.size()) {
                            toBeReturned = 0;
                        }
                    }
                }
                else {
                }
            }
        }
        return toBeReturned;
    }


    /**
     * Este metodo inicia la aplicacion.
     * @param args - argumentos a ejecutar de la pantalla principal
     *
     * */
    public static void main(String[] args) {

        new Main();
    }
}