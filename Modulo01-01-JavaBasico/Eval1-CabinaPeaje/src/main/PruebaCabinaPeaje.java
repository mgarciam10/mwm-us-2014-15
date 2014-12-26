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
public class PruebaCabinaPeaje {
    public static void main(String[] args) throws Exception {
        
        CabinaPeaje cabina;
        Vehiculo camion1, coche, camion2;
        Integer ejes, peso;
        final String INPUT_AXIS = "Numero de ejes: ";
        final String INPUT_WEIGHT = "Peso total:";
        
        cabina = new CabinaPeaje();
        ESInteractiva.escribe("Ejercicio1: Cabinas de Peaje");
        ESInteractiva.escribe("Nota: Para su funcionamiento requiere que active la opcion de Allow Program Input, desde las propiedades del proyecto.");
        ESInteractiva.escribe("Introduzca los datos del camion 1");
        ejes = Integer.parseInt(ESInteractiva.preguntaYLee(INPUT_AXIS));
        peso = Integer.parseInt(ESInteractiva.preguntaYLee(INPUT_WEIGHT));
        camion1 = new Vehiculo("camion", ejes, peso);
        coche = new Vehiculo("coche");
        ESInteractiva.escribe("Introduzca los datos del camion 2");
        ejes = Integer.parseInt(ESInteractiva.preguntaYLee(INPUT_AXIS));
        peso = Integer.parseInt(ESInteractiva.preguntaYLee(INPUT_WEIGHT));
        camion2 = new Vehiculo("camion", ejes, peso);
        cabina.calculaPeaje(camion1);
        cabina.muestraDatos();
        cabina.calculaPeaje(coche);
        cabina.recaudar();
        cabina.calculaPeaje(camion2);
        cabina.muestraDatos();
    }
}
