//En esta clase hago metodos y eventos necesarios para que mi interfaz use la lista
//Esta clase sera la que le herede a mis compuertas, mi simulacion y mi resultado de simulacion

import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

abstract class Component extends JLabel implements MouseListener, MouseMotionListener {

    int numberConnected = 0;
    int id;
    String type;

    public void toggle() { //Is overwritten only in the StartPoint class - go there if you dare...
    }
    public boolean operation(Mi_Lista<Boolean> args) { //overwritten by subclasses
        return false;
    }

    public Mi_Lista<Boolean> userOperation(Mi_Lista<Boolean> args) { //overwritten by subclasses
        return (new Mi_Lista());
    }

    int value = 0; //Valor por defecto de una entrada
    Mi_Lista<Input> inputs = new Mi_Lista<>(); //lista de inputs
    Mi_Lista<Input> toggles = new Mi_Lista<>(); // list lo que contiene un input
    Mi_Lista<Output> outputs = new Mi_Lista<>();//lista de outputs



}
