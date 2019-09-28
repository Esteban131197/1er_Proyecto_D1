package Logicaa;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;

/**
 * La clase Connector es una clase general para las entradas y salidas
 * Las entradas y salidas son los cuadrados rojos y azules en las compuertas
 * */

public class Connector { //clase de manera "general" para mis outputs e inputs

    boolean value; //Valores de inputs y outputs, no de las compuertas
    boolean hasValue = false;
    boolean isInput;
    boolean isOutput;
    int id;
    Component component;
    Mi_Lista<Connection> connections = new Mi_Lista<>();
    int maxConnections;
    int x, y; //coordenadas
    int w = 10, h = 10; //dimensiones
    Shape shape;
    Color color;

    Connector(int ID, Component c, int x, int y) {

        id = ID;
        Main.currentConnectorID++;

        this.component = c;
        this.x = x;
        this.y = y;
    }

    boolean isAvailable() { //Para comprobar si puedo trabajar con un output o input
        if (component.type.equals("Start") && this.isInput) {
            return false;
        }
        else {
            return (connections.size() < maxConnections);
        }
    }

    void addConnection(Connection con) {
        if (isAvailable()) connections.add(con);
    }
    public int getX() {
        return component.getX() + x;
    }

    public int getY() {
        return component.getY() + y;
    }
    public boolean contains(Point p) { //Me muestra donde puerdo hacer conneciones entre input y output
        return shape.contains(p);
    }
    public void paintConnector(Graphics2D g2d) { //dibujar el conector
        if (isAvailable()) {
            g2d.setColor(color);
        }
        else if (component.type.equals("Start")) { //entradas de diferente color
            g2d.setColor(Color.pink);

        }
        else {
            g2d.setColor(Color.lightGray);
        }
        g2d.fill(shape);
    }
}
