package varios;

public class CaracterDelMedio {
    public CaracterDelMedio() {
        super();
    }

    public static void main(String[] args) {
        CaracterDelMedio caracterDelMedio = new CaracterDelMedio();
        String palabra = "esternocleidomastoideo";
        int mitad = palabra.length() / 2;
        String medio;
        medio = palabra.substring(mitad, mitad + 1);
        System.out.println(medio);
    }
}
