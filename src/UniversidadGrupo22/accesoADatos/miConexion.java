
package UniversidadGrupo22.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class miConexion {
    private String url;
    private String usuario; 
    private String password;
    private static Connection conexion=null;

    public miConexion(String url, String usario, String Password) {
        this.url = url;
        this.usuario = usario;
        this.password = password;
    }

    public Connection buscarConexion(){
        if (conexion==null){
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion=DriverManager.getConnection(url, usuario , password);
                       
                        } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null,"error al cargar el Driver"+ex.getMessage());
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null,"error al conectarse"+ex.getMessage()) ;
            }
                    
        }
        return conexion;
    }
    
   
}
