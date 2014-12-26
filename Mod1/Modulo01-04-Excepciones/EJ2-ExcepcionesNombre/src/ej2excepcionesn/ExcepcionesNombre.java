package ej2excepcionesn;

import java.util.Scanner;

public class ExcepcionesNombre {
    public static void main(String[] args) {
        ExcepcionesNombre excepcionesNombre = new ExcepcionesNombre();
        String nombre;
        try {
            nombre = leer();
            System.out.println("El nombre introducido es " + nombre);
        } catch (Exception e) {
            System.out.println("Error de longitud: " + e.getMessage());
            main(args);
        }
    }

    public static String leer() throws ExcepcionNombreCorto, ExcepcionNombreLargo {
        String nombre = null;
        Scanner tcld = new Scanner(System.in);
        System.out.print("Introduzca un nombre: ");
        nombre = tcld.nextLine();
        if (nombre.length() < 8)
            throw new ExcepcionNombreCorto();
        else if (nombre.length() > 14)
            throw new ExcepcionNombreLargo();
        return nombre;
    }
}
