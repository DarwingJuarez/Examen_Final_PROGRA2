
package model;

//import com.mysql.cj.jdbc.PreparedStatementWrapper;
//import com.sun.jdi.connect.spi.Connection;
import control.ConectarMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class InventarioBD {
   ConectarMysql conexion = new ConectarMysql();
   Connection con;
   PreparedStatement ps;   
   ResultSet rs;
   
    
    //Guardar
    public void guardar(Inventario inventario){
        Producto producto = new Producto();
        String sql = "INSERT INTO producto (idinventario, fecha_inicio, idproducto, fecha_fin) VALUES (?, ?, ?, ?);";
        try {
            con = conexion.getConnection();
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, inventario.getIdinventario());
            ps.setString(2, inventario.getFechain());
            ps.setInt(3, producto.getId_producto());
            ps.setString(4, inventario.getFechafin());
            
            ps.executeUpdate();
                        
        } catch (SQLException e) {
            System.out.println("ERROR EN GUARDAR: "+e);
        }
        
        
    }//Fin guardar
    
}