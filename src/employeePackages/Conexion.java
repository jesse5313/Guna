
package employeePackages;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class Conexion {
    
    Connection enlazar = null;
    
    public Connection conectar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            enlazar = DriverManager.getConnection("jdbc:mysql://localhost:3306/guna","root","");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e + "No fue posible establecer la conexión");
        }
        return enlazar;
    }
    
    
}
