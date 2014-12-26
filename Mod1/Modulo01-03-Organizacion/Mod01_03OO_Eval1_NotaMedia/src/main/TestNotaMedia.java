package main;

import entities.*;
import utils.ESInteractiva;

/**
 * @description Main class responsible of testing the program
 * @version 0.1
 * @author Carlos Rodriguez Lopez
 * @contact carlosrodriguezlopez82@gmail.com
 */
public class TestNotaMedia implements Prueba{
    public static void main(String[] args) {
        TestNotaMedia notaMedia = new TestNotaMedia ();
        EstudianteGraduado eg = new EstudianteGraduado("Ramiro");
        EstudianteNoGraduado eng = new EstudianteNoGraduado("Pepe");
        notaMedia.calcularNotaAlumno(eg, 100, 50);
        notaMedia.calcularNotaAlumno(eng, 100, 50);
        
        }
        
    @Override
    public void calcularNotaAlumno(Estudiante est, int nota1, int nota2) {
        est.setNota1(nota1);
        est.setNota2(nota2);
        ESInteractiva.escribe(est.notaCurso());
    }
}
