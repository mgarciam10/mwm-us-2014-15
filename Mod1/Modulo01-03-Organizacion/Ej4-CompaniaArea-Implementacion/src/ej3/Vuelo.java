package ej3;

public class Vuelo {
    private int numVuelo;
    private static int numVuelos = 0;
    private int altitud;
    private int velocidad;
    private Aeropuerto origen;
    private Aeropuerto destino;
    
    public void setNumVuelo(int numVuelo) {
        this.numVuelo = numVuelo;
    }

    public int getNumVuelo() {
        return numVuelo;
    }

    public void setAltitud(int altitud) {
        this.altitud = altitud;
    }

    public int getAltitud() {
        return altitud;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setOrigen(Aeropuerto origen) {
        this.origen = origen;
    }

    public Aeropuerto getOrigen() {
        return origen;
    }

    public void setDestino(Aeropuerto destino) {
        this.destino = destino;
    }

    public Aeropuerto getDestino() {
        return destino;
    }
    
    public String toString(){
        String vuelo = "Número: " + numVuelo;
        vuelo += "\nAltitud: " + altitud + " pies";
        vuelo += "\nVelocidad: " + velocidad + " nudos";
        vuelo += (origen != null) ? "\nAeropuerto origen: " + origen : "Sin Aeropuerto de origen definido";
        vuelo += (destino != null) ? "\nAeropuerto destino:" + destino: "Sin Aeropuerto de destino definido";
        return vuelo;
    }
   
    public Vuelo(){
        numVuelos++;
    }
    public Vuelo(int numVuelo,int altitud,int velocidad, Aeropuerto origen, Aeropuerto destino ){
        this.numVuelo = numVuelo;
        this.altitud = altitud;
        this.velocidad = velocidad;
        this.origen = origen;
        this.destino = destino;
        numVuelos++;
    }
    
    public static void numVuelos() {
    System.out.println("Se han creado " + numVuelos + " vuelos en total");
    }
}
