package mysarrays;

import java.util.Arrays;
import java.util.Random;

public class MisArrays {

    public static void main(String[] args) {
        Random r = new Random();
        int[] v = new int[10];
        for (int i = 0, n = v.length; i != n; i++) {
            v[i] = r.nextInt(11) * 2;
        }
        
        muestra(v,"Vector Original");
        Arrays.sort(v);
        muestra(v,"Vector Ordenado");
        int pos = Arrays.binarySearch(v, 11);
        System.out.println("El 11 debería estar en posición "+Math.abs(pos-1));
        pos = Arrays.binarySearch(v, 12);
        if(pos>=0)
        //Devuelve posición comenzando en 0
        System.out.println("El 12 está en posición "+pos);
        else
        System.out.println("El 12 debería estar en "+Math.abs(pos-1));
    }
    private static void muestra(int[] v, String texto) {
        System.out.println(texto + " ===>");
        for (int i = 0, n = v.length; i != n; i++)
            System.out.println(v[i]);
    }
}
