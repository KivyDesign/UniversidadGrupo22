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
        Alumno alu = ad.buscarAlumno(8);

        // Busco la materia por su ID 3
        Materia mat = md.buscarMateria(3);

        // Preparo la inscripcion con los datos del alumno, materia y le asigno
        // la nota 9
        Inscripcion ins = new Inscripcion(alu, mat, 9);

        // Guardo la inscipcion con el metodo guardarInscripcion de InscripcionData
        id.guardarInscripcion(ins);
    }

}
