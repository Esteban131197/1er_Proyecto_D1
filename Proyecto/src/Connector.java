import java.awt.*;

abstract class Connector { //clase de manera "general" para mis outputs e inputs

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

