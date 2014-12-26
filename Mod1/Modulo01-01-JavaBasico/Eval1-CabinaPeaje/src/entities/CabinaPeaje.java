package entities;
import utils.*;
/**
 *
 * @description Entity Class for the Toll Station
 * @version 0.1
 * @author Carlos Rodriguez Lopez
 * @contact carlosrodriguezlopez82@gmail.com
 */
public class CabinaPeaje {
    private final double  CAR_TAX_FIXED = 6.5;
    private final int  LORRY_TAX_PER_AXIS= 5;
    private final int  LORRY_TAX_PER_1_TN= 10;
    private double totalDesdeRecogida;
    private int vehiculosDesdeRecogida=0;
    private Vehiculo vehiculo;
    private float taxes;
    /**
     *
     * @description Method that shows on the screen, total amount of money collected until this moment
     */
    public void muestraDatos() {
        String stringToDisplay;
        stringToDisplay="Total desde la ultima recogida - Peaje: "+this.totalDesdeRecogida + " Numero de Vehiculos: "+this.vehiculosDesdeRecogida;
        ESInteractiva.escribe(stringToDisplay);
    }
    /**
     *
     * @description Method that shows on the screen, total amount of money collected once the work shift is finished
     */
    public void recaudar() {
        String stringToDisplay;
        stringToDisplay="********* Procedimiento de Recaudacion ******** \n " +
            " Total desde la ultima recogida - Peaje: "+this.totalDesdeRecogida + " Numero de Vehiculos: "+this.vehiculosDesdeRecogida;
        ESInteractiva.escribe(stringToDisplay);
        vehiculosDesdeRecogida=0;
        totalDesdeRecogida=0;
    }
    /**
     *
     * @description Method responsible for toll rate calculation based on the type of vehicle
     * @param vehiculo Vehicule to evaluate
     */
    public void calculaPeaje(Vehiculo vehiculo) {
        this.vehiculo=vehiculo;
        double taxes;
        String stringToDisplay;
        
        if (this.vehiculo.getTipo()=="camion"){
            this.taxes = (this.vehiculo.getEjes()*LORRY_TAX_PER_AXIS+(this.vehiculo.getPesoTotal()/1000)*LORRY_TAX_PER_1_TN);
            stringToDisplay="Camion - Ejes: "+this.vehiculo.getEjes()+" - Peso Total: "+this.vehiculo.getPesoTotal()+ " Peaje: "+this.taxes;
        }
        else {
            this.taxes = (float) CAR_TAX_FIXED;
            stringToDisplay="Coche - Peaje: "+this.taxes;
        }
        ESInteractiva.escribe(stringToDisplay); 
        this.vehiculosDesdeRecogida++;
        this.totalDesdeRecogida+=this.taxes;
    }
}
