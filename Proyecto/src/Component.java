//En esta clase hago metodos y eventos necesarios para que mi interfaz use la lista
//Esta clase sera la que le herede a mis compuertas, mi simulacion y mi resultado de simulacion

import javax.swing.*;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

abstract class Component extends JLabel implements MouseListener, MouseMotionListener {

    int numberConnected = 0;
    int id;
    String type;



}
