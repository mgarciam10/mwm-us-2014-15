import java.io.PrintStream;
import java.util.Scanner;

/**
 * Clase ESInteractiva. Tiene un m?todo para imprimir una cadena por
 * pantalla y otro para mostrar un mensaje y a continuaci?n leer una
 * cadena de texto por teclado.
 */
public class ESInteractiva {
    private Scanner ent;
    private PrintStream sal;

    /**
     * Constructor sin par?metros que inicializa el flujo de entrada
     * al teclado y el flujo de salida a la pantalla.
     */
    public ESInteractiva() {
        ent = new Scanner(System.in);
        sal = System.out;
    }

    /**
     * Constructor con dos par?metros para inicializar el flujo de
     * entrada y el flujo de salida.
     * @param sc flujo de entrada
     * @param ps flujo de salida
     */
    public ESInteractiva(Scanner sc, PrintStream ps) {
        ent = sc;
        sal = ps;
    }

    /**
     * M?todo para escribir una cadena en el flujo de salida.
     * @param s cadena de salida
     */
    public void escribe(String s) {
        sal.println(s);
        sal.flush();
    }

    /**
     * m?todo que le pide datos al usuario y despu?s los lee
     * @param s cadena que se desea escribir en el flujo de salida
     * como pregunta
     * @return cadena con el valor leido del flujo de entrada
     * @throws Exception cuando hay problemas al leer los datos
     */
    public String preguntaYLee(String s) throws Exception {
        escribe(s);
        String linea = ent.nextLine();
        return linea;
    }
}
