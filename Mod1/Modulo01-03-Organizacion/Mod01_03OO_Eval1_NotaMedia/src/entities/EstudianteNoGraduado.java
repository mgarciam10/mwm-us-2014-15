package entities;

/**
 *
 * @description Entity Class for Estudiante No Graduado
 * @version 0.1
 * @author Carlos Rodriguez Lopez
 * @contact carlosrodriguezlopez82@gmail.com
 */
public class EstudianteNoGraduado extends Estudiante{
    
    
    public String notaCurso(){
        String notaCurso="", calificacion="";
        super.notaCurso=(super.notaMedia() >= 70) ? "Apto": "No Apto";
        notaCurso = "************************************";
        notaCurso += "\nEstudiante No Graduado \n";
        notaCurso  += super.notaCurso();
        notaCurso  += "\nCalificacion: " + super.notaCurso;
        notaCurso  += "\n************************************";
        return notaCurso ;
    }
    
    public EstudianteNoGraduado (String nombre) {
        super(nombre);
    }
}
