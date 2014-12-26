package carlos.utilidades;

import java.util.Stack;

public class QueueGenerica <T> extends Stack <T> {
    /**
     * Pila/Cola asociada a la clase
     */
    private Stack <T> s ;
    /**
     * Constructor. Crea la cola vacía
     */
    public QueueGenerica () {
        s = new Stack <T> ();
    };
    /**
     *Añade el objeto al final de la cola
     * @param x T a introducir en la cola
     */
    public boolean add (T x){
        s.push(x);
        return true;
    }
    /**
     * Saca de la cola y devuelve el elemento que está en el frente de la cola.
     * @return o T almacenado en la cola
     */
    public Object remove(){
        T o= (T) s.pop();
        return o;
    }
    /**
     *Devuelve el elemento que está en el frente de la cola, pero no lo saca de la cola. 
     * @return o T almacenado en la cola
     */
    public Object get(){
        T o= (T) s.peek();
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
