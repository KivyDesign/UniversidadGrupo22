package UniversidadGrupo22.vistas;

import UniversidadGrupo22.accesoADatos.AlumnoData;
import UniversidadGrupo22.accesoADatos.InscripcionData;
import UniversidadGrupo22.accesoADatos.MateriaData;
import UniversidadGrupo22.entidades.Alumno;
import UniversidadGrupo22.entidades.Inscripcion;
import UniversidadGrupo22.entidades.Materia;

public class UniversidadGrupo22 {

    public static void main(String[] args) {
        // Pruebas para Form Inscripcion
        AlumnoData ad = new AlumnoData();
        MateriaData md = new MateriaData();
        InscripcionData id = new InscripcionData();

        // Busco el alumno por su ID 8
        Alumno alu = ad.buscarAlumnoPorID(8);

        // Busco la materia por su ID 3
        Materia mat = md.buscarMateriaPorID(3);

//        int aluID = alu.getIdAlumno();
//        int matID = mat.getIdMateria();
        
        // Preparo la inscripcion con los datos del alumno, materia y le asigno
        // la nota 9
        // 
        // ERROR de tipos de datos. Clave Foranea - Resolver
        // La instruccion en MySQL funciona bien manualmente
        // INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (9, 8, 3)
        Inscripcion ins = new Inscripcion(9, alu, mat);

        // Guardo la inscipcion con el metodo guardarInscripcion de InscripcionData
        id.guardarInscripcion(ins);
    }

}
