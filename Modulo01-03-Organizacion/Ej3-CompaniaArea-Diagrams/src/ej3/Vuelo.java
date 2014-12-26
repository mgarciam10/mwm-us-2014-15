package ej3;

public class Vuelo {
    private int numVuelo;
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
        return "cadena";
    }
   
    public Vuelo(){
        
    }
    public Vuelo(int numVuelo,int altitud,int velocidad, Aeropuerto origen, Aeropuerto destino ){
        
    }
}
