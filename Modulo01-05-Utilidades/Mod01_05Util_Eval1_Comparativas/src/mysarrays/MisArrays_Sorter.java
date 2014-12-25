package mysarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class MisArrays_Sorter {

    public static void main(String[] args) {

        //Constante que almacena el numero de intentos
        final int G0_NUM = 10;
        //Constante que almacena la base exponencial
        final int BASE = 10;
        //Constante que almacena el crecimiento exponencial (N). MAX=8
        final int EXP_NUM = 6;
        int sizeArray;
        double t1, t2, tProcess = 0, tProcessAvera;
        Double fTProcess;
        Vector tiemposUnitarios;
        Enumeration e;

        for (int i = 1; i <= EXP_NUM; i++) {
            tiemposUnitarios = new Vector();
            sizeArray = (int) Math.pow(BASE, i);
            for (int j = 1; j <= G0_NUM; j++) {
                t1 = System.nanoTime();
                Integer[] v = MisArrays_Sorter.getArrayInt(sizeArray);
                //MisArrays_Sorter.quickSearch(v);
                MisArrays_Sorter.secuencialSearch(v);
                t2 = System.nanoTime();
                fTProcess = new Double((t2 - t1) * 1E-9);
                //For debugging
                //System.out.println("Proceso :" + Integer.toString(j) + " - Tiempo de Proceso  :" + Double.toString(fTProcess));
                tiemposUnitarios.addElement(fTProcess);
            }
            e = tiemposUnitarios.elements();
            while (e.hasMoreElements()) {
                tProcess += (Double) e.nextElement();
            }
            tProcessAvera = tProcess / G0_NUM;
            System.out.println("Array de Tamano de :" + Integer.toString(sizeArray) + " - Tiempo medio: " +
                               Double.toString(tProcessAvera));
        }
    }

    private static Integer[] getArrayInt(int size) {
        Random r = new Random();
        Integer[] v = new Integer[size];
        int i = 0, ran = 0, elemInser = 0;
        while (i < v.length) {
            ran = r.nextInt(size + 1);
            v[i] = ran;
            i++;
            // For debugging
            // System.out.println("elemento insertado n: "+i+" - valor:"+ran);
        }
        return v;
    }

    private static void secuencialSearch(Integer[] v) {
        int indexActualPos =0, indexInserc = 0, index = 0, menor = 0, valor = 0;
        /* Para la manipulacion de los arrays se hace nesario transformarlos a lista
         * Porque el Array es estatico una vez creado no se puede modificar su tamaño*/ 
        ArrayList <Integer> list = new ArrayList(Arrays.asList(v));
        while (indexInserc < list.size()) {
            index = indexInserc;
            //Porque el valor mayor del array coincide con el tamaño maximo
            menor = list.size();
            while (index <  list.size()) {
                valor = list.get(index);
                if (valor < menor) {
                    menor = valor;
                    indexActualPos = index;
                }
                index++;
            }
            list.remove(indexActualPos);
            list.add(indexInserc,menor);
            indexInserc++;
        }
        list.toArray(v); // convert list back to array 
    }

    private static void quickSearch(Integer[] v) {
        Arrays.sort(v);
    }

}

