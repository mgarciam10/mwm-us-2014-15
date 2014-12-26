package ej3;

public class VueloMercancias extends Vuelo
{
    private int carga;
    private String tipoCarga;

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
    
    public VueloMercancias(){
        
    }
    public VueloMercancias(int numVuelo,int altitud,int velocidad, Aeropuerto origen, Aeropuerto destino, String tipoCarga, int carga){
        
    }
}
