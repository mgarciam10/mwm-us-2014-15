package ej3;

public class Vuelos {

    @SuppressWarnings("oracle.jdeveloper.java.semantic-warning")
    public static void main(String[] args) {
        Aeropuerto aSevilla = new Aeropuerto("San Pablo", "Sevilla");
        Aeropuerto aMadrid = new Aeropuerto("Barajas", "Madrid");
        VueloPersonas vp = new VueloPersonas();
        VueloMercancias vm = new VueloMercancias(2, 5000, 1000,  aSevilla, aMadrid, "Ayuda humanitaria", 547);
        vp.setNumVuelo(1);
        vp.setAltitud(10000);
        vp.setVelocidad(2500);
        vp.setNumPasajeros(342);
        imprime(vp);
        vp.numVuelos();
        imprime(vm);
        vm.numVuelos();
        Vuelo.numVuelos();
        }
        // Este método muestra el funcionamiento del polimorfismo
        public static void imprime(Vuelo vuelo){
            System.out.println(vuelo);
        }
}

