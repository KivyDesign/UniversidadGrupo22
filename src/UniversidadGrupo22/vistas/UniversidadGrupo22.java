package UniversidadGrupo22.vistas;

import UniversidadGrupo22.accesoADatos.AlumnoData;
import UniversidadGrupo22.accesoADatos.Conexion;
import UniversidadGrupo22.accesoADatos.InscripcionData;
import UniversidadGrupo22.accesoADatos.MateriaData;
import UniversidadGrupo22.entidades.Alumno;
import UniversidadGrupo22.entidades.Inscripcion;
import UniversidadGrupo22.entidades.Materia;
import java.sql.Connection;

public class UniversidadGrupo22 {

    public static void main(String[] args) {
        // Realizo la coneccion a la DB, si fue exitosa lo informo como
        // conectado para no tener ese molesto dialogo de conexion ;)
        Connection con = Conexion.getConexion();
        // Si la conexion fue exitosa lo informo
        if (con != null) {
            System.out.println("Sistema de Gestión para la Universidad de La Punta - Estado: Conectado");
        } else {
            System.out.println("Sistema de Gestión para la Universidad de La Punta - Estado: Error");
        }
        
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
        // 
        // ERROR de tipos de datos. Clave Foranea - Resolver
        // La instruccion en MySQL funciona bien manualmente
        // INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (9, 8, 3)
        Inscripcion ins = new Inscripcion(9, alu, mat);

        // Guardo la inscipcion con el metodo guardarInscripcion de InscripcionData
        id.guardarInscripcion(ins);
    }

}
