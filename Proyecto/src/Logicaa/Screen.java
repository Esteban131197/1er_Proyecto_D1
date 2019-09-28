package Logicaa;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

/**
 * Esta clase funciona como un canvas para realizar acciones sobre ella
 **/

public class Screen extends JPanel {
    {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Se implementa patron de diseño FACTORY
                if (Main.modo.equals("addingAnd")) {
                    Component c = (Component) new Factory().ComponentFactory(TypeComponent.AND, e);
                } else if (Main.modo.equals("addingOr")) {
                    Component c = (Component) new Factory().ComponentFactory(TypeComponent.OR, e);
                } else if (Main.modo.equals("addingNot")) {
                    Component c= (Component) new Factory().ComponentFactory(TypeComponent.NOT,e);
                } else if (Main.modo.equals("addingNand")) {
                    Component c= (Component) new Factory().ComponentFactory(TypeComponent.NAND,e);
                } else if (Main.modo.equals("addingNor")) {
                    Component c= (Component) new Factory().ComponentFactory(TypeComponent.NOR,e);
                } else if (Main.modo.equals("addingXor")) {
                    Component c= (Component) new Factory().ComponentFactory(TypeComponent.XOR,e);;
                } else if (Main.modo.equals("addingXnor")) {
                    Component c= (Component) new Factory().ComponentFactory(TypeComponent.XNOR,e);

                } else if (Main.modo.equals("addingStart")) {
                    Component c = new StartPoint(Main.ID_componente, e.getX(), e.getY());

                } else if (Main.modo.equals("addingEnd")) {
                    Component c = new EndPoint(Main.ID_componente, e.getX(), e.getY());
                }
                Main.modo = "";

                Main.drawPanel.repaint();
            }
        });
    }

    /**
     * Este metodo permite llamar al drawPanel.repaint
     * */

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);//Pinta el drawPanel y asocia componentes

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        System.out.println(Main.lineas.size());
        for (Connection line : Main.lineas) {
            line.paintConnection(g2d);
        }
    }
}
