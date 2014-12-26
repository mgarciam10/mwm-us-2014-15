package foryrandom;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

public class ForAndRandom {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        int randNum=0;
        Integer in1, in2, in3;
        Vector v1, v2, v3, v4;
        Random r1, r2;
        
        //1. Almacenamiento en un Vector las cadenas que se introduzcan desde el teclado.
        v1 = new Vector();
        for (int i = 1; i <= 10; ++i) {
            // Se inlcuye los encapsuladores
            in1=new Integer(i);
            v1.addElement(in1);
        }

        //2. Cree ahora el vector con 10 n?meros enteros consecutivos entre 1201 y 1210. Compare ambos algoritmos.
        v2 = new Vector();
        int base1=1210;
        for (int i = 1; i <= 10; ++i) {
            in2=new Integer(base1+i);
            v2.addElement(in2);
        }
 
        //3. Cree otro vector con 10 n?meros aleatorios entre 10 y 20
        v3 = new Vector();
        r1 = new Random();
        int i1=0;
        while (i1<=10){
            randNum = r1.nextInt(20);
            if (randNum >= 10) {
                v3.addElement(new Integer(randNum));
                i1++;
            }
        }
        //4. Otra forma seria:
        int n=0, i2=0, base2=10;
        v4 = new Vector();
        r2 = new Random();
        while (i2 != 10) {
            n=base2+r2.nextInt(11);
            in3=new Integer(n);
            v4.addElement(in3);
            i2++;
        }
    }
}
