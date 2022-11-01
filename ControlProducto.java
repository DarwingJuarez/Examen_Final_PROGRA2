package control;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import model.Inventario;
import model.InventarioBD;
//import javax.swing.table.DefaultTableModel;
import model.Producto;
import model.ProductoBD;
import vision.Interfa_grafica;

public class ControlProducto implements ActionListener {

    //instancias
    Producto producto = new Producto();
    ProductoBD productodb = new ProductoBD();
    InventarioBD inventariobd = new InventarioBD();
    Interfa_grafica vista = new Interfa_grafica();
    //DefaultTableModel modeltable = new DefaultTableModel();

    //variables globales
    private int idproducto;
    private String nombrep;
    private int stockInicial;
    private int entradas;
    private int salidas;
    private int total;
    private int idinventario;
    private String fechain;
    private String fechafin;

    public ControlProducto(){
        
    }
    public ControlProducto(Interfa_grafica vista) {
        this.vista = vista;
        vista.setVisible(true);
    }

    public void agregarEventos() {
        vista.getBotonGuardar().addActionListener(this);
        vista.getBotonGuardar().addMouseListener(new MouseAdapter() {
        });
                    
    }

    //validar formulario
    public boolean validardatos() {

        if ("".equals(vista.getCajaText1().getText()) || "".equals(vista.getCajaText2().getText()) || "".equals(vista.getCajaText3().getText()) || "".equals(vista.getCajaText4().getText()) || "".equals(vista.getCajaText5().getText()) || "".equals(vista.getCajaText6().getText()) || "".equals(vista.getCajaText7().getText()) || "".equals(vista.getCajaText8().getText())) {//comprobando que los campos no esten vacios
            JOptionPane.showMessageDialog(null, "Llenar todos los campos :)", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }

    public boolean cargarDatos() {
        try {
            idproducto = Integer.parseInt(vista.getCajaText3().getText());
            nombrep = vista.getCajaText4().getText();
            entradas = Integer.parseInt(vista.getCajaText5().getText());
            salidas = Integer.parseInt(vista.getCajaText6().getText());
            stockInicial = Integer.parseInt(vista.getCajaText7().getText());
            return true;

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Datos solo numericos", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println("ERROR AL CARGAR DATOS: " + e);
            return false;
        }

    }

    //para limpiar cajas de texto
    public void limpiar() {
        vista.getCajaText3().setText("");
        vista.getCajaText4().setText("");
        vista.getCajaText5().setText("");
        vista.getCajaText6().setText("");
        vista.getCajaText7().setText("");
        idproducto = 0;
        nombrep = "";
        entradas = 0;
        salidas = 0;
        stockInicial = 0;
    }

    public void agregarProducto() {
        try {
            if (validardatos()) { //true
                if (cargarDatos()) { //true
                    Producto producto = new Producto(idproducto, nombrep, stockInicial, entradas, salidas, total);
                    productodb.guardar(producto);
                    
                    Inventario inventario = new Inventario(idinventario, fechain, fechafin);
                    inventariobd.guardar(inventario);
                    JOptionPane.showMessageDialog(null, "SE GUARDO CORRECTAMENTE :)");
                    limpiar();
                }
            }
        } catch (HeadlessException e) {
            System.out.println("ERROR EN AGREGARC:" + e);
        }
    }

    //accionar botones
    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == vista.getBotonGuardar()) {
            agregarProducto();

        }
    }

}
