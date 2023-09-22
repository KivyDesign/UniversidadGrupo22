package UniversidadGrupo22.vistas;

import UniversidadGrupo22.accesoADatos.AlumnoData;
import UniversidadGrupo22.accesoADatos.Conexion;
import UniversidadGrupo22.accesoADatos.InscripcionData;
import UniversidadGrupo22.accesoADatos.MateriaData;
import UniversidadGrupo22.entidades.Alumno;
import UniversidadGrupo22.entidades.Inscripcion;
import UniversidadGrupo22.entidades.Materia;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Month;

public class UniversidadGrupo22 {

    public static void main(String[] args) {
        // Realizo la coneccion a la DB
        Connection con = Conexion.getConexion();

        // Si la conexion fue exitosa lo informo como conectado con un (sout)
        // para no tener ese molesto dialogo de conexion
        if (con != null) {
            System.out.println("Sistema de Gestión para la Universidad de La Punta - Estado: Conectado");
        } else {
            System.out.println("Sistema de Gestión para la Universidad de La Punta - Estado: Error");
        }

        // Pruebas para Form Alumno
        //
        // Creo los atributos aluData, matData e insData para acceder mas
        // comodamente a los metodos de los paquetes entidades AlumnoData,
        // MateriaData e InscripcionData
//        AlumnoData aluData = new AlumnoData();
//        MateriaData matData = new MateriaData();
//        InscripcionData insData = new InscripcionData();
//
//        Alumno juan = new Alumno(36, 12322312, "Luna", "Juan Pedro", LocalDate.of(1980, 4, 25), true);
//        AlumnoData alu = new AlumnoData();
//        alu.guardarAlumno(juan);
//        alu.modificarAlumno(juan);
//        alu.eliminarAlumno(36);
//        Alumno alumnoEncontrado = alu.buscarAlumnoPorDni(333);
//        if (alumnoEncontrado != null) {
//            System.out.println("DNI: " + alumnoEncontrado.getDni());
//            System.out.println("Apellido: " + alumnoEncontrado.getApellido());
//        }
//        
//        AlumnoData alu = new AlumnoData();
//        for (Alumno alumno : alu.listarAlumnos()) {
//            System.out.println("DNI: " + alumno.getDni());
//            System.out.println("Apellido: " + alumno.getApellido());
//            System.out.println("Nombre: " + alumno.getNombre());
//            System.out.println("Fecha de Nacimiento: " + alumno.getFechaNacimiento());
//        }
        // =====================================================================
        // Pruebas para Form Inscripcion
        // =====================================================================
        //
        // Creo los atributos aluData, matData e insData para acceder mas
        // comodamente a los metodos de los paquetes entidades AlumnoData,
        // MateriaData e InscripcionData
        AlumnoData aluData = new AlumnoData();
        MateriaData matData = new MateriaData();
        InscripcionData insData = new InscripcionData();

        // Busco el alumno por su ID
        Alumno alu = aluData.buscarAlumno(2);

        // Busco la materia por su ID
        Materia mat = matData.buscarMateria(3);

        // ---------------------------------------------------------------------
        // Para el metodo guardarInscripcion()
        // ---------------------------------------------------------------------
        // Preparo la actualizacion con los datos de la nota 9, el alumno y la
        // materia
        // NOTA: Recordar el ORDEN de los parametros que son MUY IMPORTANTES
        // 
        // Resolver: Carga datos duplicados si se ejecuta mas de una vez
        // La instruccion en MySQL funciona bien manualmente
        // INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (9, 2, 3)
        // Resolver: Parece ser mala idea por que carga duplicados los datos
        // Resolveeremos desde codigo verificando si ya existe primero
//        Inscripcion ins = new Inscripcion(9, alu, mat);
        // Guardo la inscipcion con el metodo guardarInscripcion
        // de InscripcionData
//        insData.guardarInscripcion(ins);
        // ---------------------------------------------------------------------
        // Para el metodo actualizarNota()
        // ---------------------------------------------------------------------
        // Preparo la actualizacion con los datos de la nota 7, el alumno y la
        // materia
        // NOTA: Recordar el ORDEN de los parametros que son MUY IMPORTANTES
        // 
        // Resolver: Sobrescribe los mismos datos si se ejecuta mas de una vez
        // La instruccion en MySQL funciona bien manualmente
        // UPDATE inscripcion (nota, idAlumno, idMateria) VALUES (7, 2, 7)
        // Resolveremos desde codigo verificando si ya existe primero
//        Inscripcion ins = new Inscripcion(7, alu, mat);
        // Primero convertir los tipos alu y mat a enteros
//        int aluEnt = alu.getIdAlumno();
//        int matEnt = mat.getIdMateria();
        // Actualizo la inscipcion con el metodo actualizarNota de InscripcionData
//        insData.actualizarNota(7, aluEnt, matEnt);
        // ---------------------------------------------------------------------
        // Para el metodo borrarInscripcion()
        // ---------------------------------------------------------------------
        // Preparo el borrado con los datos del alumno y la
        // materia
        // NOTA: Recordar el ORDEN de los parametros que son MUY IMPORTANTES
        // La instruccion en MySQL funciona bien manualmente
        // DELETE FROM inscripcion (idAlumno, idMateria) VALUES (2, 7)
        // Primero convertir los tipos alu y mat a enteros
//        int aluEnt = alu.getIdAlumno();
//        int matEnt = mat.getIdMateria();
        // Borro fisicamente la inscipcion con el metodo
        // borrarInscripcionMateriaAlumno de InscripcionData
//        insData.borrarInscripcionMateriaAlumno(aluEnt, matEnt);
        // ---------------------------------------------------------------------
        // Para el metodo obtenerInscripciones()
        // ---------------------------------------------------------------------
        // La instruccion en MySQL funciona bien manualmente
        // SELECT * FROM inscripcion
        // Realizo la consulta con el metodo obtenerInscripciones()
        // El resultado es del tipo Inscripcion
//        for (Inscripcion inscripcion : insData.obtenerInscripciones()) {
//            System.out.println("ID: " + inscripcion.getIdInscripcion());
//            System.out.println("Apellido: " + inscripcion.getAlumno().getApellido());
//            System.out.println("Materia: " + inscripcion.getMateria().getNombre());
//        }
        // ---------------------------------------------------------------------
        // Para el metodo obtenerAlumnosXMateria()
        // ---------------------------------------------------------------------
        // La instruccion en MySQL funciona bien manualmente
//        "SELECT a.idAlumno, dni, nombre, apellido, fechaNacimiento, estado"
//                + "FROM inscripcion i, alumno a"
//                + "WHERE i.idAlumno = a.idAlumno"
//                + "AND idMateria = ?"
//                + "AND a.estado = 1";
        // Recorre todas las materias y las muestra, menos en las que el
        // alumno este inscripto
//        for (Materia materia : insData.obtenerMateriasNOCursadas(22)) {
//            System.out.println("Nombre: " + materia.getNombre());
//        }
//--------------------------------------------------------------------------------
        //probar metodo inscripcion data    obtenerMateriasInscriptas(Alumno alumno)
        //-----------------------------------------------------------------------------
//        for (Materia materia : insData.obtenerMateriasInscriptas(aluData.buscarAlumno(2))) {
//            System.out.println("materia " + materia.getNombre());
//        }
//probar metodo obtenerMateriasCursadas(int idAlumno)
//        for (Materia materia : insData.obtenerMateriasCursadas(aluData.buscarAlumno(2).getIdAlumno())) {
//            System.out.println("materia " + materia.getNombre());
        //      }
        //---------------------------------------------------------------------------
        //probar metodo obtenerMateriaNoInscriptas(Alumno alumno)
        //---------------------------------------------------------------------------
        for (Materia materia : insData.obtenerMateriaNoInscriptas(aluData.buscarAlumno(2))) {
            System.out.println("materia " + materia.getNombre());
        }
    }

}
