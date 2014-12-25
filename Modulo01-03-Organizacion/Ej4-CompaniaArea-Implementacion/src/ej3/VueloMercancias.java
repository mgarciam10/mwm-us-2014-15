package ej3;

public class VueloMercancias extends Vuelo
{
    private int carga;
    private String tipoCarga;
    private static int numVuelos = 0;

    public void setTipoCarga(String tipoCarga) {
        this.tipoCarga = tipoCarga;
    }

    public String getTipoCarga() {
        return tipoCarga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }

    public int getCarga() {
        return carga;
    }

    public VueloMercancias() {
        numVuelos++;
    }

    public VueloMercancias(int numVuelo, int altitud, int velocidad, Aeropuerto origen, Aeropuerto destino,
                           String tipoCarga, int carga) {
        super(numVuelo, altitud, velocidad, origen, destino);
        this.tipoCarga = tipoCarga;
        this.carga = carga;
        numVuelos++;
    }

    public String toString() {
        String vuelo = "************************************";
        vuelo += "\nVuelo de mercancías \n";
        vuelo += super.toString();
        vuelo += "\nTipo de carga: " + tipoCarga;
        vuelo += "\nPeso de la carga: " + carga + " toneladas";
        vuelo += "\n************************************";
        return vuelo;
    }

    public static void numVuelos() {
        System.out.println("Se han creado " + numVuelos + " vuelos de mercancías");
    }
}
