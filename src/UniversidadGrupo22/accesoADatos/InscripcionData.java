/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UniversidadGrupo22.accesoADatos;

import UniversidadGrupo22.entidades.Inscripcion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author german
 */
public class InscripcionData {
    private Connection con=null;
    private MateriaData matData;
    private AlumnoData aluData;
    
    public InscripcionData(){
        con=Conexion.getConexion();
    }
    
    public void guardarInscripcion(Inscripcion ins) {
        String sql = "INSERT INTO inscripcion (idAlumno, idMateria, nota) VALUES (?, ?, ?)";

        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, ins.getAlumno().getIdAlumno());
            ps.setInt(2, ins.getMateria().getIdMateria());
            ps.setDouble(3, ins.getNota());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();

            if (rs.next()) {
                ins.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción exitosa");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla inscripcion: " + ex.getMessage());
        }
    }
}
