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
    
    public ArrayList<Materia> obtenerMateriasInscriptas(Alumno alumno) {
        ArrayList<Materia> listaDeMateriasInscripto = new ArrayList<Materia>();
        Materia mat;
            
//        String sql = "SELECT * FROM materia WHERE idMateria NO IN(SELECT idMateria FROM inscripto"
//                + "AND materia.estado = true";
        
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
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia: " + ex.getMessage());
        }
        return listaDeMateriasInscripto;
    }
    
    public ArrayList<Materia> obtenerMateriaNoInscriptas(Alumno alumno) {
        ArrayList<Materia> listaDeMateriasNoInscripto = new ArrayList<Materia>();
        Materia mat;
            
//        String sql = "SELECT * FROM materia WHERE idMateria NO IN(SELECT idMateria FROM inscripto"
//                + "AND materia.estado = false";
        
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
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla materia: " + ex.getMessage());
        }
        return listaDeMateriasNoInscripto;
    }
}
