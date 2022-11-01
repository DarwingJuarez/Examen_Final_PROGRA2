package control;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/*public class ConectarMysql {
    Connection conexion;
    String driver = "com.mysql.cj.jdbc.Driver";
    String basededatos = "examenfinal";
    String url = "jdbc:mysql://localhost:3306/"+basededatos+"?useSSL=false&serverTimezone=UTC";
    String usuario = "root";
    String clave = "DsStE.13_JB";
    
    public Connection conexionaBD(){
        try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, clave);
            JOptionPane.showMessageDialog(null, "Se conecto a la base de datos");
        } 
        catch (HeadlessException | ClassNotFoundException | SQLException e) {
           // JOptionPane.showMessageDialog(null, "No se conecto a la base de datos\npor el error:\n"+e);
            System.out.println("ERROR:"+e);
        }
        
        return conexion;
        
    }
     class Prueva {
         public static void main(String[] args){
             Connection conexion;
             ConectarMysql con = new ConectarMysql();
             conexion = con.contexionaBD();
             
         }
     }
}*/
public class ConectarMysql{
    private static String DRIVE = "com.mysql.cj.jdbc.Drives";
    private static String USUARIO = "root";
    private static String PASSWORD = "DaStE.13_JB";
    private static String URL = "jdbc:mysql://localhost:3306/examenfinal";
    
   /* static{
        try {
           Class.forName(DRIVE);
        } catch (Exception e) {
            System.out.println("hola");
        }
    }*/
    public Connection getConnection(){
        Connection con = null;
        try {
            con=DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("SE CONECTO A LA BASE DE DATOS");
        } catch (SQLException e) {
            System.out.println("ERROR: NO SE CONECTO A BASE DE DATOS");
        }
        return con;
    }
}

