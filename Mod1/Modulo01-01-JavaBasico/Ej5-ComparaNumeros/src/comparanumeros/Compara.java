package comparanumeros;

import util.ESInteractiva;

public class Compara {

    public static void main(String[] args) throws Exception {
        Compara class1 = new Compara();
        ESInteractiva esi;
        Integer num1, num2;
        final String SONIGUALES = "Los numeros son iguales";
        final String MAYOR = " es mayor que ";
        esi = new ESInteractiva();
        num1= Integer.parseInt(esi.preguntaYLee("Introduce el primer numero"));
        num2= Integer.parseInt(esi.preguntaYLee("Introduce el segundo numero"));
        if (num1==num2){
            esi.escribe(SONIGUALES);
        }
        else if (num1 > num2){
            esi.escribe(num1+MAYOR+num2);     
        }
        else{
            esi.escribe(num2+MAYOR+num1);                               
            }
    }
}
