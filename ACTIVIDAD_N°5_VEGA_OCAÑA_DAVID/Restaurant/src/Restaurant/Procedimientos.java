
package Restaurant;

import java.sql.CallableStatement;
import java.sql.SQLException;

public class Procedimientos {
    
    public static void GuardarPedidos(String a, String b, String c) throws SQLException{
        CallableStatement entrada=Conexion.getConexion().prepareCall("{call GuardarPedido(?,?,?)}");
        entrada.setString(1, a);
        entrada.setString(2, b);
        entrada.setString(3, c);
        entrada.execute();
    }
    
}
