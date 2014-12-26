package mysarrays;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Random;
import java.util.Vector;

public class MisArrays_Builder {

    public static void main(String[] args) {
        
        //Constante que almacena el numero de intentos
        final int G0_NUM=10;
        //Constante que almacena la base exponencial
        final int BASE=10;
        //Constante que almacena el crecimiento exponencial (N). MAX=8
        final int EXP_NUM=8;
        int sizeArray;
        double t1, t2, tProcess=0, tProcessAvera;
        Double fTProcess;
        Vector tiemposUnitarios;
        Enumeration e;
        
        for (int i=1; i<= EXP_NUM; i++){
            tiemposUnitarios=new Vector();
            sizeArray = (int) Math.pow(BASE, i);
            for (int j=1; j<= G0_NUM; j++){
                //t1=System.currentTimeMillis();
                t1=System.nanoTime();
                MisArrays_Builder.getArrayExclusiveINt (sizeArray);
                //t2=System.currentTimeMillis();
                t2=System.nanoTime();
                //fTProcess= new Double((t2-t1)/1000 );
                fTProcess= new Double((t2-t1)*1E-9);
                //For debugging
                //System.out.println("Proceso :" + Integer.toString(j) + " - Tiempo de Proceso  :" + Double.toString(fTProcess));
                tiemposUnitarios.addElement(fTProcess);
            }
            e = tiemposUnitarios.elements();
            while (e.hasMoreElements()) {
                tProcess += (Double) e.nextElement();
            }
            tProcessAvera=tProcess/G0_NUM;
            System.out.println("Array de Tamano de :" + Integer.toString(sizeArray) + " - Tiempo medio: "  +Double.toString(tProcessAvera));
        }
    }
    
    private static int[] getArrayExclusiveINt (int size) {
        Random r = new Random();
        int[] v = new int[size];
        int i = 0, ran=0,elemInser=0;
        while (i < v.length) {
            ran = r.nextInt(size+1);
            if (!binarySearch(v,ran)) {
            //if (!secuencialSearch(v,ran,elemInser)) {
                v[i] =ran;
                i++;
                // For debugging
                // System.out.println("elemento insertado n: "+i+" - valor:"+ran);
            }
        }
        return v;
    }
    
    private static boolean secuencialSearch(int[] v, int value2Find, int elemInsert) {
        boolean find = false;
        for (int i = 0; i <= elemInsert && !find; i++){
            if (value2Find == v[i]){
                find = true;
            }
        }
        return find;
    }
    
    private static boolean binarySearch(int[] v, int value2Find) {
        boolean find = false;
        Arrays.sort(v);
        int pos = Arrays.binarySearch(v, value2Find);
        if (pos>=0){
            find = true;
        }
        return find;
    }
}
