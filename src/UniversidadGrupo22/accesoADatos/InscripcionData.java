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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author german
 */
public class InscripcionData {

    private Connection con = null;
    private MateriaData matData;
    private AlumnoData aluData;

    public InscripcionData() {
        con = Conexion.getConexion();
    }

    public void guardarInscripcion(Inscripcion ins) {
        String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota) VALUES (?, ?, ?)";

        try {
            // Obtengo la clave del ID generada de la posicion 0 del DB
            // Esto es necesario por que aún no existe el ID que se crea en la DB
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            
            // Cargo idAlumno, idMateria y nota de las posiciones 1, 2 y 3 respectivamente
            ps.setInt(1, ins.getAlumno().getIdAlumno());
            ps.setInt(2, ins.getMateria().getIdMateria());
            ps.setDouble(3, ins.getNota());
            
            // Ejecuto el INSERT y almaceno la consulta en la DB
            ps.executeUpdate();
            
            // Obtengo el ID de la clave primaria y actualizo el rs
            ResultSet rs = ps.getGeneratedKeys();

            // Verifico que exista el ID que insertamos
            if (rs.next()) {
                // Actualizo el ID de la inscripcion
                ins.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción agregada de forma exitosa");
            }
            
            // Cierro la consulta
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripción: " + ex.getMessage());
        }
    }
    
    public void borrarInscripcion(int idAlumno, int idMateria) {
        String sql = "DELETE FROM inscripcion WHERE idAlumno = ? AND idMateria = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            
            int rs = ps.executeUpdate();
            
            if (rs > 0) {
                JOptionPane.showMessageDialog(null, "Inscripción borrada");
            } else {
                JOptionPane.showMessageDialog(null, "La inscripción no se pudo encontrar");
            }
            ps.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion: " + ex.getMessage());
        }
    }
    
    public ArrayList<Materia> obtenerMateriasInscriptas(Alumno alumno) {
        // Creo una lista para almacenar los resultados en memoria temporalmente para trabajar
        ArrayList<Materia> listaDeMateriasInscripto = new ArrayList<Materia>();
        
        // Declaro mat para utilizarlo para crear una nueva materia
        Materia mat;
        
//        String sql = "SELECT * FROM materia WHERE idMateria NO IN(SELECT idMateria FROM inscripto"
//                + "AND materia.estado = true";
//
//        String sql = "SELECT * FROM inscripcion JOIN materia ON inscripcion.idMateria = materia.idMateria"
//                + "AND inscripcion.idAlumno = ?;";
        
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
        ArrayList<Materia> listaDeMateriasNoInscripto = new ArrayList<Materia>();
        Materia mat;
        
        String sql = "SELECT * FROM inscripcion WHERE idAlumno = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, alumno.getIdAlumno());
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                mat = new Materia();
                
                mat.setIdMateria(rs.getInt("idMateria"));
                mat.setNombre(rs.getString("nombre"));
                mat.setAnioMateria(rs.getInt("anio"));
                
                listaDeMateriasNoInscripto.add(mat.obtenerMateriaPorId(rs.getInt("idMateria")));
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia: " + ex.getMessage());
        }
        return listaDeMateriasNoInscripto;
    }
}
