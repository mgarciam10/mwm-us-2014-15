package main;

import entities.*;
import entities.exception.*;
import entities.exception.ExcepcionDemasiadoViejo;
import entities.exception.ExcepcionFormatoEdadIlegal;
import utils.ESInteractiva;
/**
 *
 * @description Test class for running the program
 * @version 0.1
 * @author Carlos Rodriguez Lopez
 * @contact carlosrodriguezlopez82@gmail.com
 */
public class main {
    public static void main(String[] args) {
        int edad;
        for (int i = 0; i < 4; i++) {
            edad = Integer.parseInt(ESInteractiva.preguntaYLee("Introduce tu edad: "));
            try {
                MontanaRusa.montarMontanaRusa(edad);
                ESInteractiva.escribe("¡Wow! ¡Esto es espectacular!");
            } catch (ExcepcionDemasiadoJoven e) {
                ESInteractiva.escribe(e.getMessage());
                ESInteractiva.escribe((MontanaRusa.getEdadMinima() - e.edad) + " años más y podrás probarlo.");
            } catch (ExcepcionDemasiadoViejo e) {
                ESInteractiva.escribe(e.getMessage());
                ESInteractiva.escribe((e.edad - MontanaRusa.getEdadMaxima()) + " años atrás esto era un juego de niños.");
            } catch (ExcepcionFormatoEdadIlegal e) {
                ESInteractiva.escribe(e.getMessage());
            } finally {
                ESInteractiva.escribe("Siguiente...");
            }
        }
    }
}
