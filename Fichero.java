
package control;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Inventario;
import model.Producto;

/**
 *
 * @author juare
 */
public class Fichero {
    Scanner entrada = new Scanner(System.in);
    Producto agregar = new Producto();
    Inventario invet = new Inventario();
    
    public File archivo;
 
    public String nombrefichero, sino;
    
    public void GuardarDatos() {

        FileWriter escribir;
        PrintWriter mostrar = null;
        

        try {
            String archivo = null;
            Producto prod = new Producto();
            Inventario invet = new Inventario();
            escribir = new FileWriter(archivo, true);
            mostrar = new PrintWriter(escribir);
            
            mostrar.println(invet.getFechafin()+"|"+prod.getId_producto()+"|"+prod.getNom_producto()+"|"+prod.getCompras()+"|"+prod.getVentas()+"|"+prod.getTotal()+"|"+invet.getFechafin());
            

        } catch (IOException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void CrearFichero() {
        sino = JOptionPane.showInputDialog("Desea guardar los datos en un fichero");
        if(!"si".equals(sino)){
            JOptionPane.showMessageDialog(null, "Los datos no se guardaran en ningun archivo");
              
        }
        else
        {
            
            nombrefichero = JOptionPane.showInputDialog("Digite el nombre del archivo");
            
            archivo = new File("C:\\Users\\juare\\Desktop\\Programacion 2\\Proyecto Final\\"+nombrefichero+".txt");
            
            if (!archivo.exists()) {
                try {
                    archivo.createNewFile();
                } catch (IOException e) {
                }
            } else {
                JOptionPane.showMessageDialog(null, "El archivo ya existe, los datos\nse guardaran alli");
                System.out.println("El archivo ya existe, los datos");
            }
        }
        

    }
}
    

