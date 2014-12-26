package varios;

import java.util.Scanner;

public class EntradaTeclado_Scanner {

    public static void main(String[] args) throws Exception {
        Scanner tcld = new Scanner(System.in);
        System.out.print("Introduzca su nombre: ");
        String nombre = tcld.nextLine();
        System.out.print("Introduzca su edad: ");
        int edad = tcld.nextInt();
        System.out.println("Su nombre es " + nombre);
        System.out.println("Su edad es " + edad);
    }
}
