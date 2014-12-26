package main;
import entities.*;
import java.util.*;
import utils.*;
/**
 *
 * @description Main class responsible of testing the program
 * @version 0.1
 * @author Carlos Rodriguez Lopez
 * @contact carlosrodriguezlopez82@gmail.com
 */
public class TestMiVector {
    public static void main(String[] args) {
        TestMiVector testVector = new TestMiVector();
        MiVector vector1, vector2, vector3;
        Integer vectorSize;

        ESInteractiva.escribe("Ejercicio2: Mi Vector");
        ESInteractiva.escribe("Nota: Para su funcionamiento requiere que active la opcion de Allow Program Input, desde las propiedades del proyecto.");
        ESInteractiva.escribe("> Paso 1: Generando 2 vectores mediante constructor por defecto...");
        vector1 = new MiVector();
        vector2 = new MiVector();
        ESInteractiva.escribe("Vector 1: " + vector1.toString());
        ESInteractiva.escribe("Vector 2: " + vector2.toString());
        vectorSize = Integer.parseInt(ESInteractiva.preguntaYLee("> Paso 2: Introduzca el tamano del vector 3: "));
        vector3 = new MiVector(vectorSize);
        ESInteractiva.escribe("Vector 3: " + vector3.toString());
        ESInteractiva.escribe("> Paso 3: El valor maximo del Vector 1 es:" + Integer.toString(vector1.valorMayor()));
        ESInteractiva.escribe("> Paso 4: El valor maximo del Vector 1, corresponde con la posicion:" + Integer.toString(vector1.posicionMayor()));
        ESInteractiva.escribe("> Paso 5: El valor minimo del Vector 2 es:" + Integer.toString(vector2.valorMenor()));
        ESInteractiva.escribe("> Paso 6: El valor medio del Vector 3 es:" + Double.toString(vector3.media()));
        ESInteractiva.escribe("> Paso 7: La mediana del Vector 3 es:" + Double.toString(vector3.mediana()));
        ESInteractiva.escribe("> Paso 8: Vector 1 y 2 son iguales?:" + vector1.equals(vector2));
    }
}
