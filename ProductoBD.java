
package model;

//import com.mysql.cj.jdbc.PreparedStatementWrapper;
//import com.sun.jdi.connect.spi.Connection;
import control.ConectarMysql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Connection;

public class ProductoBD {
   ConectarMysql conexion = new ConectarMysql();
   Connection con;
   PreparedStatement ps;   
   ResultSet rs;
   
    
    //Guardar
    public void guardar(Producto producto){
        String sql = "INSERT INTO producto (idproducto, nombre_producto, stock_inicial, entradas, salidas, total) VALUES (?, ?, ?, ?, ?, ?);";
        try {
            con = conexion.getConnection();
            
            ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getId_producto());
            ps.setString(2, producto.getNom_producto());
            ps.setInt(3, producto.getStock_inicial());
            ps.setInt(4, producto.getCompras());
            ps.setInt(5, producto.getVentas());
            ps.setInt(6, producto.getTotal());
            ps.executeUpdate();
                        
        } catch (SQLException e) {
            System.out.println("ERROR EN GUARDAR: "+e);
        }
        
        
    }//Fin guardar
    
}
