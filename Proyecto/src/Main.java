import javafx.stage.Screen;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Main {

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
            Image img = ImageIO.read(getClass().getResource("./and.gif"));
            andbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton nandbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./nand.gif"));
            nandbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton orbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./or.gif"));
            orbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton norbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./nor.gif"));
            norbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton notbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./not.gif"));
            notbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton xorbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./xor.gif"));
            xorbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton xnorbutton = new JButton();
        try {
            Image img = ImageIO.read(getClass().getResource("./xnor.gif"));
            xnorbutton.setIcon(new ImageIcon(img));
        } catch (Exception ex) {
            System.out.println(ex);
        }

        JButton coneccionesButton = new JButton("Hilos");
        JButton startButton = new JButton("Entrada");
        JButton endButton = new JButton("Salida");
        JButton simularButton = new JButton("Simular");
        JButton eraseButton = new JButton("Borrar");
