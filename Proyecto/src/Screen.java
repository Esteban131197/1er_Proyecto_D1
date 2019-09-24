import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Screen extends JPanel { //the "canvas" for everything
    Screen() {

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) { //Diferentes acciones que se dan con un click
                //Se implementa patron de diseño FACTORY
                if (Main.mode.equals("addingAnd")) { //adds and gate at click point
                    Component c = new Factory().ComponentFactory(TypeComponent.AND, e);
                } else if (Main.mode.equals("addingOr")) {// adds or gate at click point
                    Component c = new Factory().ComponentFactory(TypeComponent.OR, e);
                } else if (Main.mode.equals("addingNot")) {//adds not gate at click point
                    Component c= new Factory().ComponentFactory(TypeComponent.NOT,e);
                } else if (Main.mode.equals("addingNand")) {//adds not gate at click point
                    Component c= new Factory().ComponentFactory(TypeComponent.NAND,e);
                } else if (Main.mode.equals("addingNor")) {//adds not gate at click point
                    Component c= new Factory().ComponentFactory(TypeComponent.NOR,e);
                } else if (Main.mode.equals("addingXor")) {//adds not gate at click point
                    Component c= new Factory().ComponentFactory(TypeComponent.XOR,e);;
                } else if (Main.mode.equals("addingXnor")) {//adds not gate at click point
                    Component c= new Factory().ComponentFactory(TypeComponent.XNOR,e);

                } else if (Main.mode.equals("addingStart")) {//adds start gate at click point
                    Component c = new StartPoint(Main.currentComponentID, e.getX(), e.getY());

                } else if (Main.mode.equals("addingEnd")) { //adds end gate at click point
                    Component c = new EndPoint(Main.currentComponentID, e.getX(), e.getY());
                }
                Main.mode = "";

                Main.drawPanel.repaint();
            }
        });
    }