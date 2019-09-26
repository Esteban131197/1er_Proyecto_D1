package Logicaa;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class Screen extends JPanel { //the "canvas" for everything
    {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //Se implementa patron de diseño FACTORY
                if (Main.mode.equals("addingAnd")) {
                    Component c = (Component) new Factory().ComponentFactory(TypeComponent.AND, e);
                } else if (Main.mode.equals("addingOr")) {
                    Component c = (Component) new Factory().ComponentFactory(TypeComponent.OR, e);
                } else if (Main.mode.equals("addingNot")) {
                    Component c= (Component) new Factory().ComponentFactory(TypeComponent.NOT,e);
                } else if (Main.mode.equals("addingNand")) {
                    Component c= (Component) new Factory().ComponentFactory(TypeComponent.NAND,e);
                } else if (Main.mode.equals("addingNor")) {
                    Component c= (Component) new Factory().ComponentFactory(TypeComponent.NOR,e);
                } else if (Main.mode.equals("addingXor")) {
                    Component c= (Component) new Factory().ComponentFactory(TypeComponent.XOR,e);;
                } else if (Main.mode.equals("addingXnor")) {
                    Component c= (Component) new Factory().ComponentFactory(TypeComponent.XNOR,e);

                } else if (Main.mode.equals("addingStart")) {
                    Component c = new StartPoint(Main.currentComponentID, e.getX(), e.getY());

                } else if (Main.mode.equals("addingEnd")) {
                    Component c = new EndPoint(Main.currentComponentID, e.getX(), e.getY());
                }
                Main.mode = "";

                Main.drawPanel.repaint();
            }
        });
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        System.out.println(Main.lines.size());
        for (Connection line : Main.lines) {
            line.paintConnection(g2d);
        }
    }
}
