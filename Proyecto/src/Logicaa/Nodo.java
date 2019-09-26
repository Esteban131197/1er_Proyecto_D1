package Logicaa;

public class Nodo<T> {
    public T component;
    public Nodo<T> siguiente = null;

    public Nodo(T component){
        this.component = component;
    }

    public void setNext(Nodo<T> next)
    {
        this.siguiente = next;
    }

    public T getComponent() {
        return component;
    }
}

