import javafx.stage.Screen;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {

    static int currentComponentID = 0;
    static int currentConnectorID = 0;
    static int currentConnectionID = 0;
    static String mode = "";
    static boolean showInputs = true, showOutputs = true;
    static Output selectedOutput = null;

    //Ventana:
    private JFrame frame = new JFrame("");
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


    }
}