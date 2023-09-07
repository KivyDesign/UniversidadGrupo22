/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadGrupo22.entidades;

/**
 *
 * @author german
 */
public class Inscripcion {
   private int idInscripto;
    private int idAlumno;
    private String alumno;
    private int idMateria;
    private String materia;private int nota;

    public Inscripcion(int idInscripto, int idAlumno, String alumno, int idMateria, String materia, int nota) {
        this.idInscripto = idInscripto;
        this.idAlumno = idAlumno;
        this.alumno = alumno;
        this.idMateria = idMateria;
        this.materia = materia;
        this.nota = nota;
    }
    
    

    public Inscripcion(int idInscripto, int idAlumno, int idMateria, int nota) {
        this.idInscripto = idInscripto;
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.nota = nota;
        
    }

    public Inscripcion(int idAlumno, int idMateria, int nota) {
        this.idAlumno = idAlumno;
        this.idMateria = idMateria;
        this.nota = nota;
    }

    public Inscripcion(String alumno) {
        this.alumno = alumno;
    }

 
    
    

    public Inscripcion() {
    }

    public int getIdInscripto() {
        return idInscripto;
    }

    public void setIdInscripto(int idInscripto) {
        this.idInscripto = idInscripto;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    }

    public int getIdMateria() {
        return idMateria;
    }

    public void setIdMateria(int idMateria) {
        this.idMateria = idMateria;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "Inscripcion{" + "idInscripto=" + idInscripto + ", alumno=" + alumno + ", materia=" + materia + ", nota=" + nota + '}';
    }

      public String listarNotasMayores() {
        return alumno;
    }

    
}
 

