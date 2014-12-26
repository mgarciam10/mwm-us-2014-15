package carlos.utilidades;

import java.util.Stack;

public class Queue extends Stack {
    /**
     * Pila/Cola asociada a la clase
     */
    private Stack s;
    /**
     * Constructor. Crea la cola vacía
     */
    public Queue(){
        s = new Stack ();
    };
    /**
     *Añade el objeto al final de la cola
     * @param x Objetc a introducir en la cola
     */
    public boolean add(Object x){
        s.push(x);
        return true;
    }
    /**
     * Saca de la cola y devuelve el elemento que está en el frente de la cola.
     * @return o Object almacenado en la cola
     */
    public Object remove(){
        Object o=s.pop();
        return o;
    }
    /**
     *Devuelve el elemento que está en el frente de la cola, pero no lo saca de la cola. 
     * @return o Object almacenado en la cola
     */
    public Object get(){
        Object o=s.peek();
        return o;
    }
    /**
     * Devuelve la pila
     * @return s Pila
     */
    public Stack getS() {
        return s;
    }
}
