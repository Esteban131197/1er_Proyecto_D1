package Logicaa;

import java.awt.Component;
import java.awt.event.MouseEvent;

/**
 *
 * Esta clase es un factory de la clase componente
 */

public class Factory {

    /**
     * Metodo static que selecciona e instancia cada clase, segun el componente.
     * @return instancia de la clase componente.
     * */

    public static Component ComponentFactory(TypeComponent type, MouseEvent e) {
        if (type == TypeComponent.AND) {
            return new AND(Main.ID_componente, e.getX(), e.getY());
        }
        if (type == TypeComponent.OR) {
            return new OR(Main.ID_componente, e.getX(), e.getY());
        }
        if (type == TypeComponent.NAND) {
            return new NAND(Main.ID_componente, e.getX(), e.getY());
        }
        if (type == TypeComponent.NOR) {
            return new NOR(Main.ID_componente, e.getX(), e.getY());
        }
        if (type == TypeComponent.NOT) {
            return new NOT(Main.ID_componente, e.getX(), e.getY());
        }
        if (type == TypeComponent.XNOR) {
            return new XNOR(Main.ID_componente, e.getX(), e.getY());
        } else {
            return new XOR(Main.ID_componente, e.getX(), e.getY());
        }
    }
}
