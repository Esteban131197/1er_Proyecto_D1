import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Screen extends JPanel { //canvas
    Screen() {

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //Diferentes acciones que se dan con un click
                //Se implementa patron de diseño FACTORY
                if (Main.mode.equals("addingAnd")) {
                    Component c = new Factory().ComponentFactory(TypeComponent.AND, e);
                } else if (Main.mode.equals("addingOr")) {
                    Component c = new Factory().ComponentFactory(TypeComponent.OR, e);
                } else if (Main.mode.equals("addingNot")) {
                    Component c= new Factory().ComponentFactory(TypeComponent.NOT,e);
                } else if (Main.mode.equals("addingNand")) {
                    Component c= new Factory().ComponentFactory(TypeComponent.NAND,e);
                } else if (Main.mode.equals("addingNor")) {
                    Component c= new Factory().ComponentFactory(TypeComponent.NOR,e);
                } else if (Main.mode.equals("addingXor")) {
                    Component c= new Factory().ComponentFactory(TypeComponent.XOR,e);;
                } else if (Main.mode.equals("addingXnor")) {
                    Component c= new Factory().ComponentFactory(TypeComponent.XNOR,e);

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
        for (int x = 0; x<Main.lines.size(); x++) { //paints all the lines in the world
            Main.lines.get(x).paintConnection(g2d);
        }
    }


}
