package varios;

import holamundo.ConversorMonetario;

public class LlamaConversorMonetario {
    public LlamaConversorMonetario() {
        super();
    }

    public static void main(String[] args) {
        LlamaConversorMonetario llamaConversorMonetario = new LlamaConversorMonetario();
        ConversorMonetario conversor, conversorDolares, conversorYenes;
        conversor = new ConversorMonetario();
        double euros = conversor.aEuro(150.0); // convierte 150 pesetas a euros
        double pesetas = conversor.deEuro(17.0); // convierte 17 euros a pesetas
        System.out.println("euros:" + euros);
        System.out.println("pesetas:" + pesetas);
        conversorDolares = new ConversorMonetario(1.35);
        euros = conversorDolares.aEuro(150.0);
        System.out.println("150$ equivalen a " + euros + "?");
        conversorYenes = new ConversorMonetario(140.73);
        double yenes = conversorYenes.deEuro(25.0);
        System.out.println("25? equivalen a " + yenes + "?");
    }
}
