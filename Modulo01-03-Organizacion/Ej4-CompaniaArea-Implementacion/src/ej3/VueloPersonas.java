package ej3;

public class VueloPersonas extends Vuelo
{
    private int numPasajeros;
    private static int numVuelos = 0;

    public void setNumPasajeros(int numPasajeros) {
        this.numPasajeros = numPasajeros;
    }

    public int getNumPasajeros() {
        return numPasajeros;
    }
    
    public VueloPersonas(){
        numVuelos++;
    }
    public VueloPersonas(int numVuelo,int altitud,int velocidad, Aeropuerto origen, Aeropuerto destino, int numPasajeros){
        super(numVuelo, altitud, velocidad, origen,destino);
        this.numPasajeros = numPasajeros;
        numVuelos++;
    }
    
    public String toString() {
    String vuelo = "************************************";
    vuelo += "\nVuelo de pasajeros \n";
    vuelo += super.toString();
    vuelo += "\nNúmero de pasajeros: " + this.numPasajeros;
    vuelo += "\n************************************";
    return vuelo;
    }
    
    public static void numVuelos() {
    System.out.println("Se han creado " + numVuelos + " vuelos de pasajeros");
    }
}
