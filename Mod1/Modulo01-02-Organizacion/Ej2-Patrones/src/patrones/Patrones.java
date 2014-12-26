package patrones;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Enumeration;
import java.util.Vector;

public class Patrones {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws IOException {
        //1. Almacenamiento en un Vector las cadenas que se introduzcan desde el teclado.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Vector v = new Vector();
        String s;
        s = br.readLine();
        // Si introducimos una cadena vacia (enter)
        while (s.length() != 0) {
            v.addElement(s);
            s = br.readLine();
        }
        //2. Mostrar todas las cadenas que se han introducido.
        System.out.println("Todas las cadenas que se han le?do son:");
        Enumeration e = v.elements();
        while (e.hasMoreElements()) {
            s = (String) e.nextElement();
            System.out.println(s);
        }
        //3. Mostrasr s?lo las que tengan cinco o m?s caracteres.
        System.out.println("Cadenas con cinco o m?s caracteres");
        Enumeration e1 = v.elements();
        while (e1.hasMoreElements()) {
            s = (String) e1.nextElement();
            if (s.length() >= 5)
                System.out.println(s);
        }
        //4. Finalmente muestre s?lo aquellas cadenas que est?n en las posiciones pares.
        System.out.println("Cadenas en posiciones pares:");
        int i = 1;
        Enumeration e2 = v.elements();
        while (e2.hasMoreElements()) {
            s = (String) e2.nextElement();
            if (i % 2 == 0)
                System.out.println(s);
            i++;
        }
    }
}
