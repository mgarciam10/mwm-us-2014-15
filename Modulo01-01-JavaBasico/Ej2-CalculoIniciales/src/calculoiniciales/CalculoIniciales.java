package calculoiniciales;

public class CalculoIniciales {
    public static void main(String[] args) {
        CalculoIniciales calculoIniciales = new CalculoIniciales();
        String nombre = "Carlos";
        String apellido1 = "Rodriguez";
        String apellido2 = "Lopez";
        String nombreCompleto= nombre+" "+apellido1+" "+apellido2;
        String iniciales = nombre.substring(0,1) + apellido1.substring(0,1) + apellido2.substring(0,1);
        Integer longCadena= nombreCompleto.length();
        System.out.println("iniciales: "+ iniciales + "\n Longitud Cadena:" + longCadena);
    }
}
