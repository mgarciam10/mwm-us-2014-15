package utils;

import java.io.PrintStream;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @description Class responsible to define the In/Out information flow with the User
 * @version 0.2
 * @author Carlos Rodriguez Lopez
 * @contact carlosrodriguezlopez82@gmail.com
 */
public class ESInteractiva {
    private static Scanner ent = new Scanner(System.in);
    private static PrintStream sal = System.out;
    private final static String ERROR =
        "Debe introducir un numero entero positivo. Por favor, vuelva a introducir el valor: ";

    /**
     * Method responsible to show information on the screen
     * @param s String out
     */
    public static void escribe(String s) {
        sal.println(s);
        sal.flush();
    }

    /**
     * Method responsible to ask for a piece of information to the User and Collect the input
     * @param s String question to ask for a specific parameter
     * @return String witn the input introduced by the user
     */
    public static String preguntaYLee(String s) {
        escribe(s);
        String input;
        boolean inputvalidation = true;
        input = ent.nextLine();
        //do {
            inputvalidation = Validator.isPositiveInteger(input);
            if (!inputvalidation) {
                inputvalidation = false;
                escribe(ERROR);
            } else {
                inputvalidation = true;
            }
        //} while (!inputvalidation);*/
        return input;
    }
}
