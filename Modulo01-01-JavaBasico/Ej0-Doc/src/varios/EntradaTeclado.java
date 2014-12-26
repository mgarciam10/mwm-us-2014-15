package varios;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EntradaTeclado {
    public EntradaTeclado() {
        super();
    }

    public static void main(String[] args) throws Exception {
        EntradaTeclado entradaTeclado = new EntradaTeclado();
        BufferedReader tcld = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Introduzca su nombre: ");
        String nombre = tcld.readLine();
        System.out.print("Introduzca su edad: ");
        int edad = Integer.parseInt(tcld.readLine());
        System.out.println("Su nombre es " + nombre);
        System.out.println("Su edad es " + edad);
    }
}
