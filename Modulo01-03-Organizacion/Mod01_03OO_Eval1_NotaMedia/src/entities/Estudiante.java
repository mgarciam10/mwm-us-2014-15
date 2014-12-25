package entities;
/**
 *
 * @description Entity SuperClass for Estudiante
 * @version 0.1
 * @author Carlos Rodriguez Lopez
 * @contact carlosrodriguezlopez82@gmail.com
 */
public class Estudiante {
    private String nombre;
    private int nota1;
    private int nota2;
    protected String notaCurso;
    
    
    public double notaMedia(){
        return (nota1+nota2)/2;
    }
    public String notaCurso(){
        String notaCurso = "Alumno: " + this.nombre;
        notaCurso += "\n Nota Examen 1: " + this.nota1 + " puntos";
        notaCurso += "\n Nota Examen 2: " + this.nota2 + " puntos";
        notaCurso += "\n Nota Examen 2: " + Double.toString(this.notaMedia()) + " puntos";
        return notaCurso;
    }
    
    public Estudiante(String nombre){
        this.nombre=nombre;
    }
    
    public void setNota1(int nota1) {
        this.nota1 = nota1;
    }

    public void setNota2(int nota2) {
        this.nota2 = nota2;
    }
}
