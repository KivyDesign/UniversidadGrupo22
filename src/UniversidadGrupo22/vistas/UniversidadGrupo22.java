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
        //
        // Creo los atributos aluData, matData e insData para acceder mas
        // comodamente a los metodos de los paquetes entidades AlumnoData,
        // MateriaData e InscripcionData
        AlumnoData aluData = new AlumnoData();
        MateriaData matData = new MateriaData();
        InscripcionData insData = new InscripcionData();

        // Busco el alumno por su ID 8
        Alumno alu = aluData.buscarAlumno(8);

        // Busco la materia por su ID 3
        Materia mat = matData.buscarMateria(3);

        // Preparo la inscripcion con los datos del alumno, materia y le asigno
        // la nota 9
        // 
        // ERROR de tipos de datos. Clave Foranea - Resolver
        // La instruccion en MySQL funciona bien manualmente
        // INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (9, 8, 3)
        // Posible solución:
        //     1 - Desactivar las claves foraneas
        //     2 - Insertar los datos
        //     3 - Reactivar las claves foraneas.
        //     4 - Parece ser mala idea por que carga duplicados los datos
        // Otro error que se presenta: mat devuelve -1, llamar un Profe
        // ¡¡¡AIUDA!!!
        Inscripcion ins = new Inscripcion(9, alu, mat);

        // Guardo la inscipcion con el metodo guardarInscripcion de InscripcionData
        insData.guardarInscripcion(ins);
    }

}
