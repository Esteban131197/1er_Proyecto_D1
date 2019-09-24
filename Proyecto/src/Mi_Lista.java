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

}
