import javafx.stage.Screen;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {

    //la razon por la que se usa variables statics, es para tener un valor fijo en la memoria, y asi hacer el llamado
    //de ese solo valor de manera inmutable, no que se creen nuevos espacio de memoria en cada instancia.

    static int currentComponentID = 0;
    static int currentConnectorID = 0;
    static int currentConnectionID = 0;
    static String mode = "";
    static boolean showInputs = true, showOutputs = true;
    static Output selectedOutput = null;

    //Ventana:
    static JFrame frame = new JFrame("");
    static Screen drawPanel = new Screen();

    Main() {
        //formato de la ventana
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
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

        //GUI FORMATTING STUFF ENDS.  button event handling below.  To see what the buttons actually do,
        //Go to the function inside "actionPerformed"
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

    //self-explanatory functions below
    void makeAnd() {
        mode = "And";
    }

    void makeNand() {
        mode = "Nand";
    }

    void makeOr() {
        mode = "Or";
    }

    void makeNor() {
        mode = "Nor";
    }

    void makeNot() {
        mode = "Not";
    }

    void makeXor() {
        mode = "Xor";
    }

    void makeXnor() {
        mode = "Xnor";
    }

    void makeConnection() {
        mode = "choosingOutput";
        showInputs = false;
        showOutputs = true;
        drawPanel.repaint(); //repaint = refrescar la interfaz
    }

    void makeStart() {
        mode = "ENTRADA";
    }

    void makeEnd() {
        mode = "SALIDA";
    }

    void makeErase() {
        mode = "erase";
    }
}