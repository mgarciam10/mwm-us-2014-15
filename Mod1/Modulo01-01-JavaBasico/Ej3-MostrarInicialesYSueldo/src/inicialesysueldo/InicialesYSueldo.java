package inicialesysueldo;

import java.util.Scanner;

public class InicialesYSueldo {
    public static void main(String[] args) {
        InicialesYSueldo inicialesYSueldo = new InicialesYSueldo();
        Scanner tcld = new Scanner(System.in);
        System.out.print("Introduzca su nombre: ");
        String nombre = tcld.nextLine().trim();
        System.out.print("Introduzca su primer apellido: ");
        String apellido = tcld.nextLine().trim();
        String iniciales = (nombre.substring(0,1) + apellido.substring(0,1)).toUpperCase();
        System.out.print("Introduzca su salario anual: ");
        int salariomensual = (tcld.nextInt())/12;
        System.out.println("Iniciales " + iniciales);
        System.out.println("Su salirio mensual bruto es " + salariomensual);
    }
}
