public class Mi_Lista {

    public Mi_Lista<Object> connections;
    private Nodo cabeza = null;
    private int longitud = 0;


    private class Nodo{
        public Component component;
        public Nodo siguiente = null;

        public Nodo(Component component){
            this.component = component;

        }
    }

    public void add(B o) {

        //insertar
        Component component = null;
        Nodo nodo = new Nodo(component);
        if (cabeza == null){
            cabeza = nodo;
        }else{
            Nodo puntero = cabeza;
            int contador = 0;
            int n = 0;
            while(contador < n && puntero.siguiente != null){
                puntero = puntero.siguiente;
                contador++;
            }
            nodo.siguiente = puntero.siguiente;
            puntero.siguiente = nodo;
        }
        longitud++;
    }

    public B get(int n){ //obtener
        if (cabeza == null){
            return null;
        }else{
            Nodo puntero = cabeza;
            int contador = 0;
            while(contador < n && puntero.siguiente != null){
                puntero = puntero.siguiente;
                contador++;
            }
            if (contador!= n){
                return null;
            }else{
                return (B) puntero.component;
            }

        }
    }

}
