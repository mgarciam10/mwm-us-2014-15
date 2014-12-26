package ej2fechayestruc;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class EstrucDatos_SinGenericidad {
    public static void main(String[] args) {
        // Ejercicio de Estructura de Datos, sin genericidad
        Stack s=new Stack();
        s.push(new Integer(1));
        s.push(new Integer(2));
        s.push(new Integer(3));
        s.push(new Integer(4));
        System.out.println("elemento extraido "+s.pop().toString());
        System.out.println("elemento extraido "+s.pop().toString());
        s.push(new Integer(5));
        s.push(new Integer(6));
        s.push(new Integer(7));
        Object o;
        LinkedList a=new LinkedList();
        Iterator it = s.iterator();
        while(it.hasNext()){
            o = it.next();
            a.add(o);
            System.out.println("elemento extraido hola "+o.toString());
        }
    }
}
