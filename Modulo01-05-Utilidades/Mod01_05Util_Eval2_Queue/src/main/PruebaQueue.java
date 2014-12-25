package main;

import java.util.Iterator;
import carlos.utilidades.*;

public class PruebaQueue {
    public static void main(String[] args) {
        System.out.println(" ===> Prueba de Estructura de Datos sin genericidad");
        Queue q = new Queue();
        q.add(new Integer(1));
        q.add(new Integer(2));
        q.add(new Integer(3));
        q.add(new Integer(4));
        System.out.println("Remove() == > "+q.remove().toString());
        System.out.println("Get() == > "+q.get().toString());
        q.add(new Integer(5));
        q.add(new Integer(6));
        q.add("A");
        q.add("B");
        Iterator it = q.getS().iterator();
        Object o;
        int indice=0;
        while(it.hasNext()){
            o = it.next();
            indice++;
            System.out.println("Indice: "+indice+" - Elemento:  "+o.toString());
        }
        System.out.println(" ===> Prueba de Estructura de Datos con genericidad");
        QueueGenerica <String> qt = new QueueGenerica <String> ();
        qt.add("A");
        qt.add("B");
        qt.add("C");
        qt.add("D");
        System.out.println("Remove() == > "+qt.remove().toString());
        System.out.println("Get() == > "+qt.get().toString());
        qt.add("E");
        qt.add("F");
        qt.add("G");
        Iterator <String> it_qt = qt.getS().iterator();
        Object o_qt;
        int indice_qt=0;
        while(it_qt.hasNext()){
            o_qt = it_qt.next();
            indice_qt++;
            System.out.println("Indice: "+indice_qt+" - Elemento:  "+o_qt.toString());
        }      
    }
}
