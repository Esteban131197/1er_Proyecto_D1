package Logicaa;

import java.util.Iterator;

/**
 * Esta es mi clase es una Lista, la cual es una lista Generica para manejra diferentes tipos de datos
 *
 * */

public class Mi_Lista <T> implements Iterable<T>{

    @Override
    public Iterator<T> iterator(){
        return new CustomIterator<T>(this);
    }

    public void add(T value) {
        Nodo<T> nodo = new Nodo<>(value);
        if (cabeza == null)
            cola = cabeza = nodo;
        else {
            cola.setNext(nodo);
            cola = nodo;
        }
    }

    public void remove(T connection) {
        throw new UnsupportedOperationException();
    }

    public void remove(Mi_Lista<T> connections) {
        throw new UnsupportedOperationException();
    }


    class CustomIterator<T> implements Iterator<T>{

        Nodo<T> current = null;

        public CustomIterator(Mi_Lista<T> lista){
            current = lista.cabeza;
        }

        @Override
        public boolean hasNext(){
            return current != null;
        }

        @Override
        public T next(){
            T data = current.component;
            current = current.siguiente;
            return data;
        }
    }

    private Nodo <T> cabeza = null;
    private Nodo <T> cola = null;
    private int longitud = 0;

    /**
     * Este metodo es para insertar un valor en un index "n" de la lista
     * @param n - index de la lista que se desea insertar
     * */

    public void add(int n, T component) { //insertar
        Nodo <T> nodo = new Nodo<>(component);
        if (cabeza == null){
            cabeza = nodo;
        }else{
            Nodo <T> puntero = cabeza;
            int contador = 0;
            while(contador < n && puntero.siguiente != null){
                puntero = puntero.siguiente;
                contador++;
            }
            nodo.siguiente = puntero.siguiente;
            puntero.siguiente = nodo;
        }
        longitud++;
    }

    /**
     * Este valor obtiene un valor en un index "n" de la lista.
     * @param n - Numero de posicion a obtener
     * @return null
     *
     * */

    public T get(int n){ //obtener
        if (cabeza == null){
            return null;
        }else{
            Nodo<T> puntero = cabeza;
            int contador = 0;
            while(contador < n && puntero.siguiente != null){
                puntero = puntero.siguiente;
                contador++;
            }
            if (contador!= n){
                return null;
            }else{
                return puntero.component;
            }
        }
    }

    /**
     * Este metodo  retorna el tamano de la lista
     * @return variable longitud de la clase lista
     *
     * */

    public int size(){ //tama;o
        return longitud;
    }

    public boolean estaVacio(){
        return cabeza == null;
    }

    /**
     * Este metodo elimina el nodo de una posicion "n"
     * @param n - Posicion del nodo a eliminar
     *
     * */

    public void remove(T component,  int n) { //eliminar
        if(cabeza != null){
            if(n==0) {
                Nodo primer = cabeza;
                cabeza = cabeza.siguiente;
                primer.siguiente = null;
                longitud--;

            }else if (n < longitud){
                Nodo puntero = cabeza;
                int contador = 0;
                while (contador < (n - 1)) {
                    puntero = puntero.siguiente;
                    contador++;
                }
                Nodo temp = puntero.siguiente;
                puntero.siguiente = temp.siguiente;
                temp.siguiente = null;
                longitud--;
            }
        }

    }
}
