package ej2fechayestruc;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Fechas {
    public static void main(String[] args) {
        String days[] = {"","Dom","Lun","Mar","Mie","Jue","Vie","Sab"};
        int dia=4, mes=Calendar.MAY,anyoactual;
        Calendar c1=GregorianCalendar.getInstance();
        Date today = new Date();
        GregorianCalendar cal= new GregorianCalendar();
        
        cal.setTime(today);
        anyoactual=cal.get(Calendar.YEAR);
        System.out.println("Cumpleaños los siguientes años");
        for(int i=anyoactual,n=i+11;i!=n;i++){
            c1.set(i,mes,dia);
            System.out.println("Año: "+i+" Día:"+days[c1.get(Calendar.DAY_OF_WEEK)]);
        }
    }
}
