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
    private AlumnoData aluData;
    private MateriaData matData;

    public InscripcionData() {
        // Creo el objeto (con) que hereda de la Clase Conexion.java y es el que
        // realiza toda la magia de la conexión
        con = Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion ins) {
        // Preparo la consulta a la DB
        String sql = "INSERT INTO inscripcion (nota, idAlumno, idMateria) VALUES (?, ?, ?)";

        try {
            // Obtengo la clave del ID generada de la posicion 0 del DB
            // Esto es necesario por que aún no existe el ID que se crea en la DB
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // Cargo idAlumno, idMateria y nota de las posiciones 1, 2 y 3 respectivamente
            ps.setDouble(1, ins.getNota());
            ps.setInt(2, ins.getAlumno().getIdAlumno());
            ps.setInt(3, ins.getMateria().getIdMateria());

            // Ejecuto el INSERT y almaceno la consulta en la DB
            ps.executeUpdate();

            // Obtengo el ID de la clave primaria y actualizo el rs
            ResultSet rs = ps.getGeneratedKeys();

            // Verifico que exista el ID que insertamos
            if (rs.next()) {
                // Actualizo el ID de la inscripcion
                ins.setIdInscripcion(rs.getInt(1));
                
                // Hay que ver si le hacemos una barra de status para informar
                // de estos casos al operador y no detenerlo a cada rato con
                // mensajitos de dialogo emergentes que son bastante molestos
                JOptionPane.showMessageDialog(null, "Inscripción agregada de forma exitosa");
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción: " + ex.getMessage());
        }
        
        // Si todo salio bien, entonces no retorno nada por que es un metodo void
    }

    public ArrayList<Materia> obtenerMateriasInscriptas(Alumno alumno) {
        // Creo una lista listaDeMateriasInscripto para almacenar los resultados
        // en memoria temporalmente para trabajar
        ArrayList<Materia> listaDeMateriasInscripto = new ArrayList<Materia>();

        // Declaro mat para utilizarlo para crear una nueva materia
        Materia mat;

        // Preparo la consulta a la DB
        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";

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
                // Creo el nuevo objeto que hereda de Materia
                mat = new Materia();

                // Le cargo los valores que necesito
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnioMateria(rs.getInt("anio"));

                // Los agrego a los valores a la lista utilizando el metodo
                // obtenerMateriaPorId que el nuevo objeto mat hereda de Materia
                listaDeMateriasInscripto.add(mat.obtenerMateriaPorId(rs.getInt("idMateria")));
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

    public ArrayList<Materia> obtenerMateriaNoInscriptas(Alumno alumno) {
        // Creo una lista listaDeMateriasInscripto para almacenar los resultados
        // en memoria temporalmente para trabajar
        ArrayList<Materia> listaDeMateriasNoInscripto = new ArrayList<Materia>();

        // Declaro mat para utilizarlo para crear una nueva materia
        Materia mat;

        // Preparo la consulta a la DB
        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";

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
                // Creo el nuevo objeto que hereda de Materia
                mat = new Materia();

                // Le cargo los valores que necesito
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnioMateria(rs.getInt("anio"));

                // Los agrego a los valores a la lista utilizando el metodo
                // obtenerMateriaPorId que el nuevo objeto mat hereda de Materia
                listaDeMateriasNoInscripto.add(mat.obtenerMateriaPorId(rs.getInt("idMateria")));
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
                JOptionPane.showMessageDialog(null, "Inscripción borrada");
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

        // Si todo salio bien, entonces no retorno nada por que es un metodo void
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        // Preparo la consulta a la DB
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";

        // Por las dudas coloco todo dentro de un try, no vaya ha ser que explote TODO
        try {
            // Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);

            // Para obtener el ID del alumno y el ID de la materia
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            ps.setDouble(3, nota);

            // Ejecuto la consulta
            int rs = ps.executeUpdate();

            // Como la consulta es un executeUpdate que devuelve un entero,
            // entonces solo hay que verificar si es mayor a 0, de otra forma
            // algo no esta funcionando bien
            if (rs > 0) {
                // Hay que ver si le hacemos una barra de status para informar
                // de estos casos al operador y no detenerlo a cada rato con
                // mensajitos de dialogo emergentes que son bastante molestos
                JOptionPane.showMessageDialog(null, "Nota actualizada");
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

        // Si todo salio bien, entonces no retorno nada por que es un metodo void
    }

    public Inscripcion obtenerInscripcion(int idAlumno, int idMateria) {
        // Preparo la consulta a la DB
        String sql = "UPDATE inscripcion SET nota = ? WHERE idAlumno = ? AND idMateria = ?";

        // Declaro a (i) y lo inicializo a null por las dudas
        Inscripcion i = null;

        // Por las dudas coloco todo dentro de un try, no vaya ha ser que explote TODO
        try {
            // Preparo la consulta
            PreparedStatement ps = con.prepareStatement(sql);

            // Para obtener el ID del alumno y el ID de la materia
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            // Ejecuto la consulta
            ResultSet rs = ps.executeQuery();

            // Como la consulta es un executeQuery que devuelve un objeto,
            // entonces solo hay que procesarlo, de otra forma (i) se quedaria
            // null y algo no estaria funcionando bien, para eso recorro el
            // ResultSet (rs)
            while (rs.next()) {
                // Creo el famoso objeto (i)
                i = new Inscripcion();

                // Le agrego la ID de la inscripcion
                i.setIdInscripcion(rs.getInt("idInscripcion"));

                // Aqui buscamos el Alumno por su ID
                Alumno a = aluData.buscarAlumno(idAlumno);

                // Se lo cargo al objeto (i)
                i.setAlumno(a);

                // Realizo la misma operacion para materia y nota
                Materia m = matData.buscarMateria(idMateria);
                i.setMateria(m);
                i.setNota(rs.getDouble("nota"));
            }

            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            // En caso de que explote la consulta se lo informo al pobre
            // y desafortunado DataEntry
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion: " + ex.getMessage());
        }

        // Si todo salio bien, entonces retorno la inscripcion que obtuve
        return i;
    }
}
