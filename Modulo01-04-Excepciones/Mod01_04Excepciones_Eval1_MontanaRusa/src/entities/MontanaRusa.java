package entities;
import entities.exception.*;

import utils.ESInteractiva;

/**
 *
 * @description Entity for Montana Rusa
 * @version 0.1
 * @author Carlos Rodriguez Lopez
 * @contact carlosrodriguezlopez82@gmail.com
 */
public class MontanaRusa {
    static final int MIN_EDAD_VALIDA = 0;
    static final int EDAD_MINIMA = 5;
    static final int EDAD_MAXIMA = 65;

    public static void montarMontanaRusa(int edad) throws ExcepcionFormatoEdadIlegal, ExcepcionDemasiadoJoven, ExcepcionDemasiadoViejo{
        if (edad < MIN_EDAD_VALIDA)
            throw new ExcepcionFormatoEdadIlegal();
        else if (edad > MIN_EDAD_VALIDA && edad < EDAD_MINIMA)
            throw new ExcepcionDemasiadoJoven(edad);
        else if (edad > EDAD_MAXIMA )
            throw new ExcepcionDemasiadoViejo(edad);
        else {
            ESInteractiva.escribe("Montando en montaña rusa...");
        }

    }
    
    public static int getEdadMinimaValida(){
        return MIN_EDAD_VALIDA;
    }
    
    public static int getEdadMinima(){
        return EDAD_MINIMA;
    }
    
    public static int getEdadMaxima(){
        return EDAD_MAXIMA;
    }
    
}
