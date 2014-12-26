package entities;

/**
 *
 * @description Entity Class for Estudiante Graduado
 * @version 0.1
 * @author Carlos Rodriguez Lopez
 * @contact carlosrodriguezlopez82@gmail.com
 */
public class EstudianteGraduado extends Estudiante {
    
    
    public String notaCurso(){
        
        String notaCurso="", calificacion="";
        super.notaCurso=(super.notaMedia() >= 80) ? "Apto": "No Apto"; 
        notaCurso = "************************************";
        notaCurso += "\nEstudiante Graduado \n";
        notaCurso  += super.notaCurso();
        notaCurso  += "\nCalificacion: " + super.notaCurso;
        notaCurso  += "\n************************************";
        return notaCurso ;
    }
    
    public EstudianteGraduado (String nombre) {
        super(nombre);
    }
   
}
