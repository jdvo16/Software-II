
package Restaurant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.Statement;

public class Conexion {


    static Connection conexion = null;
    
    public static Connection getConexion(){
        String url = "jdbc:sqlserver://localhost\\MSSQLSERVER:1433;databaseName=Restaurante";
        //conexion del driver
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
         
        }catch (ClassNotFoundException e){
            JOptionPane.showMessageDialog(null, "No se pudo establecer la Conexion" +e.getMessage(), 
            "Error de Conexion",JOptionPane.ERROR_MESSAGE);
            
        }
        //conexion del usuario y contraseña
        try{
            conexion = DriverManager.getConnection(url,"ronald","123456");
            System.out.print("Conexion Establecida");
        }catch (SQLException e){
             System.out.print("Conexion Erronea");
            JOptionPane.showMessageDialog(null, "Error: " +e.getMessage(),"Error de Conexion",
            JOptionPane.ERROR_MESSAGE);
        }
        return conexion;
    }
    
    //metodo de consulta directamente a la base de datos
    public static ResultSet Consulta(String consulta){
        Connection con = getConexion();
        Statement declara;
        try{
            declara=con.createStatement();
            ResultSet respuesta = declara.executeQuery(consulta);
            return respuesta;
            
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, "Error" +e.getMessage(),
                    "Error de Conexion",JOptionPane.ERROR_MESSAGE);
        }
        return null;
        
    }

    
}    
