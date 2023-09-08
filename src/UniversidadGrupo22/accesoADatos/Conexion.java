package UniversidadGrupo22.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {

    private static final String url="jdbc:mariadb://localhost/";
    private static final String db="universidadulp";
    private static final String usuario="root";
    private static final String password="";
    private static Connection conexion = null;

    

    public static Connection getConexion() {
        if (conexion == null) {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(url+db, usuario, password);

            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Error al cargar el Driver" + ex.getMessage());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error al conectarse" + ex.getMessage());
            }
        }
        return conexion;
    }
}


