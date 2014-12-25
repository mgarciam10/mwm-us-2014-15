package main;

import entities.MiMatriz;

import utils.ESInteractiva;

/**
 * @description Main class responsible of testing the program
 * @version 0.1
 * @author Carlos Rodriguez Lopez
 * @contact carlosrodriguezlopez82@gmail.com
 */
public class TestMiMatriz {
    public static void main(String[] args) {
        TestMiMatriz testVector = new TestMiMatriz();
        MiMatriz miMatriz1, miMatriz2, miMatriz3, miMatriz4;
        int [ ][ ] matrizTrans;
        int nfila, ncolum, nfilasXColum, pasos=0;

        ESInteractiva.escribe("********************************************************************");
        ESInteractiva.escribe("Modulo 1: Fundamentos de la programación con Java y Bases de datos");
        ESInteractiva.escribe("Parte 2: Organizacion");
        ESInteractiva.escribe("Ejercicio de Evaluacion 2: Mi Matriz");
        ESInteractiva.escribe("Nota: Para su funcionamiento requiere que active la opcion de 'Allow Program Input', desde las propiedades del proyecto.");
        ESInteractiva.escribe("********************************************************************");
        nfila = Integer.parseInt(ESInteractiva.preguntaYLee("> Paso "+Integer.toString(++pasos)+" : Matriz 1: Introduzca el numero de filas: "));
        ncolum = Integer.parseInt(ESInteractiva.preguntaYLee("> Paso "+Integer.toString(++pasos)+ ": Matriz 1: Introduzca el numero de columnas: "));
        miMatriz1 = new MiMatriz(nfila,ncolum);
        ESInteractiva.escribe("> Paso "+Integer.toString(++pasos)+": Matriz 1: Representacion por filas:" + miMatriz1.toStringFilas());
        ESInteractiva.escribe("> Paso "+Integer.toString(++pasos)+": Matriz 1: Representacion por columnas:" + miMatriz1.toStringCol());
        matrizTrans= miMatriz1.transpuesta();
        miMatriz3= new MiMatriz(matrizTrans);
        ESInteractiva.escribe("> Paso "+Integer.toString(++pasos)+": Matriz 1 Transpuesta: Matriz3 por Metodo 'int [ ][ ] transpuesta()': Representacion por filas:" + miMatriz3.toStringFilas());
        ESInteractiva.escribe("> Paso "+Integer.toString(++pasos)+": Matriz 1 Transpuesta: Matriz3 por Metodo 'int [ ][ ] transpuesta()': Representacion por columnas:" + miMatriz3.toStringCol());
        nfilasXColum = Integer.parseInt(ESInteractiva.preguntaYLee("> Paso "+Integer.toString(++pasos)+" : Matriz 2: Introduzca el numero de filas y columnas: "));
        miMatriz2 = new MiMatriz(nfilasXColum);
        ESInteractiva.escribe("> Paso "+Integer.toString(++pasos)+": Matriz 2: Representacion por filas:" + miMatriz2.toStringFilas());
        ESInteractiva.escribe("> Paso "+Integer.toString(++pasos)+": Matriz 2: Representacion por columnas:" + miMatriz2.toStringCol());
        miMatriz4=miMatriz1.transpuesta(miMatriz2);
        ESInteractiva.escribe("> Paso "+Integer.toString(++pasos)+": Matriz 2 Transpuesta: Matriz4 por Metodo 'MiMatriz transpuesta(MiMatriz matrizATRansponer)': Representacion por filas:" + miMatriz4.toStringFilas());
        ESInteractiva.escribe("> Paso "+Integer.toString(++pasos)+": Matriz 2 Transpuesta: Matriz4 por Metodo 'MiMatriz transpuesta(MiMatriz matrizATRansponer)': Representacion por columnas:" + miMatriz4.toStringCol());
    }
}
