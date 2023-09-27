package UniversidadGrupo22.accesoADatos;

import UniversidadGrupo22.entidades.Alumno;
import UniversidadGrupo22.entidades.Inscripcion;
import UniversidadGrupo22.entidades.Materia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class InscripcionData {

    // Creo el atributo (con) de tipo Connection y  lo inicializo a null para
    // poder verificar si se pudo o no conectar a la DB
    private Connection con = null;

    // Creo los atributos aluData y matData para acceder mas comodamente a
    // los metodos de los paquetes entidades AlumnoData y MateriaData
    private AlumnoData aluData = new AlumnoData();
    private MateriaData matData = new MateriaData();

    // Aqui inicializo Connection en el constructor
    public InscripcionData() {
        // Creo el objeto (con) que hereda de la Clase Conexion.java y es el que
        // realiza toda la magia de la conexión
        this.con = Conexion.getConexion();
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // void guardarInscripcion(Inscripcion insc)
    // /////////////////////////////////////////////////////////////////////////
    public void guardarInscripcion(Inscripcion ins) {
        // Preparo la consulta SQL para ser enviada cuando la necesite a la DB
        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (?, ?, ?)";

        // Englobo todo el codigo por si ocurren errores en la conexion
        try {
            // Obtengo la clave del ID generada de la posicion 0 del DB
            // Esto es necesario por que aún no existe el ID que se crea en la DB
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Cargo idAlumno, idMateria y nota de las posiciones 1, 2 y 3 respectivamente
            // El objeto ins es el que trae los aributos de tipo Nota, Alumno y Materia
            // A los atributos los seteo al tipo de dato que corresponde para cada caso
            // el ORDEN de los artibutos es MUY IMPORTANTE, deben coincidir con
            // el orden en la tabla cuando se los pasemos con VALUES (?, ?, ?)
            // al ejecutar la consulta SQL
            ps.setDouble(1, ins.getNota());
            ps.setInt(2, ins.getAlumno().getIdAlumno());
            ps.setInt(3, ins.getMateria().getIdMateria());

            // Ejecuto el INSERT y almaceno la consulta en la DB
            ps.executeUpdate();

            // Obtengo la lista de claves con el ID de la clave primaria que SQL
            // genero, y actualizo el rs
            ResultSet rs = ps.getGeneratedKeys();

            // Verifico que exista el ID que insertamos para saber si se genero
            // al menos una clave
            if (rs.next()) {
                // Actualizo el ID de la inscripcion desde la única columna
                // que tiene el rs
                ins.setIdInscripcion(rs.getInt(1));
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción: " + ex.getMessage());
        }
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // void actualizarNota(int idAlumno, int idMateria, double nota)
    // /////////////////////////////////////////////////////////////////////////
    public void actualizarNota(double nota, int idAlumno, int idMateria) {
        // Preparo la consulta SQL para ser enviada cuando la necesite a la DB
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";

        // Por las dudas coloco todo dentro de un try, no vaya ha ser que explote TODO
        try {
            // Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);

            // Cargo nota, idAlumno y idMateria de las posiciones 1, 2 y 3 respectivamente
            // El objeto ins es el que trae los aributos de tipo Nota, Alumno y Materia
            // A los atributos los seteo al tipo de dato que corresponde para cada caso
            // el ORDEN de los artibutos es MUY IMPORTANTE, deben coincidir con
            // el orden en la tabla cuando se los pasemos con VALUES (?, ?, ?)
            // al ejecutar la consulta SQL
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);

            // Ejecuto el UPDATE y almaceno la consulta en la DB
            int rs = ps.executeUpdate();

            // Como la consulta es un executeUpdate que devuelve un entero,
            // entonces solo hay que verificar si es mayor a 0, de otra forma
            // algo no esta funcionando bien
            if (rs > 0) {
                // Hay que ver si le hacemos una barra de status para informar
                // de estos casos al operador y no detenerlo a cada rato con
                // mensajitos de dialogo emergentes que son bastante molestos
//                JOptionPane.showMessageDialog(null, "Nota Actualizada");
            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido encontrar el alumno para actulizar la nota");
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion: " + ex.getMessage());
        }
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria)
    // /////////////////////////////////////////////////////////////////////////
    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        // Este metodo recibe los IDs de alumno y materia, debera encontrarlos
        // en la tabla para borrar la inscripcion correcta

        // Preparo la consulta a la DB
        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";

        // Por las dudas coloco todo dentro de un try, no vaya ha ser que explote TODO
        try {
            // Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);

            // Para obtener el ID del alumno y el ID de la materia
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            // Ejecuto la consulta
            int rs = ps.executeUpdate();

            // Como la consulta es un executeUpdate que devuelve un entero,
            // entonces solo hay que verificar si es mayor a 0, de otra forma
            // algo no esta funcionando bien
            if (rs > 0) {
                // Hay que ver si le hacemos una barra de status para informar
                // de estos casos al operador y no detenerlo a cada rato con
                // mensajitos de dialogo emergentes que son bastante molestos
            } else {
                JOptionPane.showMessageDialog(null, "La inscripción no se pudo encontrar");
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion: " + ex.getMessage());
        }
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // List<Inscripcion> obtenerMateriasCursadas(int id)
    // /////////////////////////////////////////////////////////////////////////
    public ArrayList<Materia> obtenerMateriasInscriptas(Alumno alumno) {
        // Creo una lista listaDeMateriasInscripto para almacenar los resultados
        // en memoria temporalmente para trabajar
        ArrayList<Materia> listaDeMateriasInscripto = new ArrayList<Materia>();

        // Declaro mat para utilizarlo para crear una nueva materia
        Materia mat;

        // Preparo la consulta a la DB
        String sql = "SELECT m.idMateria from materia m, inscripcion i where i.idMateria=m.idMateria and i.idAlumno=?;";

        // Por las dudas coloco todo dentro de un try, no vaya ha ser que explote TODO
        try {
            // Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);

            // Para obtener el ID del alumno
            ps.setInt(1, alumno.getIdAlumno());

            // Ejecuto la consulta
            ResultSet rs = ps.executeQuery();

            // Recorro el rs
            while (rs.next()) {
                listaDeMateriasInscripto.add(matData.buscarMateria(rs.getInt("idMateria")));
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia: " + ex.getMessage());
        }

        // Si todo salio bien, entonces retorno la lista con las materias que
        // posea la tabla materia en la DB universidadulp
        return listaDeMateriasInscripto;
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // List<Inscripcion> obtenerMateriasNOCursadas(int id)
    // /////////////////////////////////////////////////////////////////////////
    public ArrayList<Materia> obtenerMateriaNoInscriptas(Alumno alumno) {
        // Creo una lista listaDeMateriasInscripto para almacenar los resultados
        // en memoria temporalmente para trabajar
        ArrayList<Materia> listaDeMateriasNoInscripto = new ArrayList<Materia>();

        // Declaro mat para utilizarlo para crear una nueva materia
        Materia mat;

        // Preparo la consulta a la DB
        String sql = "SELECT idMateria FROM materia WHERE estado = 1 AND idMateria NOT IN (SELECT idmateria FROM inscripcion WHERE idAlumno = ?);";

        // Por las dudas coloco todo dentro de un try, no vaya ha ser que explote TODO
        try {
            // Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);

            // Para obtener el ID del alumno
            ps.setInt(1, alumno.getIdAlumno());

            // Ejecuto la consulta
            ResultSet rs = ps.executeQuery();

            // Recorro el rs
            while (rs.next()) {
                // Los agrego a los valores a la lista utilizando el metodo
                // obtenerMateriaPorId que el nuevo objeto mat hereda de Materia
                listaDeMateriasNoInscripto.add(matData.buscarMateria(rs.getInt("idMateria")));
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia: " + ex.getMessage());
        }

        // Si todo salio bien, entonces retorno la lista con las materias que
        // no posea la tabla materia en la DB universidadulp
        return listaDeMateriasNoInscripto;
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // List<Alumno> obtenerAlumnoXMateria(int idMateria)
    // /////////////////////////////////////////////////////////////////////////
    public ArrayList<Alumno> obtenerAlumnoXMateria(Materia materia) {
        ArrayList<Alumno> listaAlumnoXMateria = new ArrayList<Alumno>();
        Alumno alu;
        String sql = "SELECT idAlumno FROM inscripcion WHERE idMateria = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, materia.getIdMateria());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                listaAlumnoXMateria.add(aluData.buscarAlumno(rs.getInt("idAlumno")));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla alumno o materia: " + ex.getMessage());
        }
        return listaAlumnoXMateria;
    }

    // /////////////////////////////////////////////////////////////////////////
    // Declaración sugerida:
    // -------------------------------------------------------------------------
    // List<Alumno> obtenerAlumnosXMateria(int idMateria)metodo sobrecargado tiene mismo nombre que el de arriba
    // /////////////////////////////////////////////////////////////////////////
    public ArrayList<Alumno> obtenerAlumnosXMateria(int idMateria) {
        ArrayList<Alumno> listaAlumnosXMateria = new ArrayList<>();

        // Por las dudas coloco todo dentro de un try, no vaya ha ser que explote TODO
        try {
            // Consulta para filtrar alumnos que esten inscriptos en una
            // determinada materia
            String sql = "SELECT a.idAlumno FROM inscripcion i ,alumno a WHERE i.idAlumno = a.idAlumno AND idMateria = ? AND a.estado = 1";

            // Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);

            // Para obtener el ID del materia
            ps.setInt(1, idMateria);
            
            // Ejecuto la consulta
            ResultSet rs = ps.executeQuery();
            // Recorro el rs mientras tenga filas para recorrer
            while (rs.next()) {
                // Los agrego a los valores al ArrayList utilizando el metodo
                // obtenerMateriaPorId que el nuevo objeto mat hereda de Materia
                listaAlumnosXMateria.add(aluData.buscarAlumno(rs.getInt("idAlumno")));
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a una de las tabla: " + ex.getMessage());
        }

        // Si todo salio bien, entonces retorno la lista con las materias que
        // no posea la tabla materia en la DB universidadulp
        return listaAlumnosXMateria;
    }

    public ArrayList<Object[]> obtenerMateriasCursadasAriel(int idAlumno) {

        ArrayList<Object[]> listaDeMateriasInscripto = new ArrayList<>();

        try {
            String sql = "SELECT i.idMateria, i.nota, m.nombre, m.anio FROM inscripcion AS i JOIN materia AS m ON (i.idMateria = m.idMateria) WHERE i.idAlumno = ?";

            // Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);

            // Para obtener el ID del alumno
            ps.setInt(1, idAlumno);

            // Ejecuto la consulta
            ResultSet rs = ps.executeQuery();

            // Recorro el rs mientras tenga elementos
            while (rs.next()) {
                // Creo el nuevo objeto que hereda de Materia
                Materia materia = new Materia();
                Inscripcion ins = new Inscripcion();

                // Le cargo los valores que necesito
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                ins.setNota(rs.getDouble("nota"));

                // Agrego la materia al array materia
                Object[] fila ={materia.getIdMateria(),materia.getNombre(),ins.getNota()};
                listaDeMateriasInscripto.add(fila);
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia: " + ex.getMessage());
        }

        // Si todo salio bien, entonces retorno la lista con las materias que
        // posea la tabla materia en la DB universidadulp
        return listaDeMateriasInscripto;
    }
    
}
