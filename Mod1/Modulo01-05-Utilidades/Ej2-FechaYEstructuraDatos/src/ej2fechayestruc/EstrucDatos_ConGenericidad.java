package ej2fechayestruc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Iterator;
import java.util.Vector;

public class EstrucDatos_ConGenericidad {
    public static void main(String[] args) throws IOException {
        //Ejercicio de genericidad
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Vector<String> v = new Vector<String>();
        String st;
        st = br.readLine();
        while (!st.equals("")) {
            v.addElement(st);
            st = br.readLine();
        }
        System.out.println("Todas las cadenas que se han leido son:");
        Iterator<String> ite = v.iterator();
        while (ite.hasNext()) {
            st = ite.next();
            System.out.println(st);
        }
    }
}
