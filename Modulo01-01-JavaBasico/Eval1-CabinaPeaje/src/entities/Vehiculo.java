package entities;
/**
 *
 * @description Entity Class for a Vehicle
 * @version 0.1
 * @author Carlos Rodriguez Lopez
 * @contact carlosrodriguezlopez82@gmail.com
 */
public class Vehiculo {
    private String tipo;
    private int ejes, pesoTotal;
    /**
     *
     * @description Constructor by default
     * @param coche
     */
    public Vehiculo(String coche) {
        this.tipo=coche;
    }
    /**
     *
     * @description Parametrized Constructor
     * @param camion 
     * @param nejes
     * @param peso
     */
    public Vehiculo(String camion, int nejes, int peso) {
        this.tipo=camion;
        this.ejes=nejes;
        this.pesoTotal=peso;
    }
    /**
     *
     * @description Getter method for tipo
     * @return tipo
     */
    public String getTipo() {
        return this.tipo;
    }
    /**
     *
     * @description Getter method for ejes
     * @return ejes
     */
    public int getEjes() {
        return this.ejes;
    }
    /**
     *
     * @description Getter method for ejes
     * @return pesoTotal (untis: Kg)
     */
    public int getPesoTotal() {
        return this.pesoTotal;
    }
 
}
