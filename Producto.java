
package model;


public class Producto {
    private int id_producto;
    private String nom_producto;
    private int stock_inicial;
    private int compras;
    private int ventas;
    private int total;

    
    //constructor vacio
    public Producto() {
        
        
    }
    
    public Producto(int id_producto, String nom_producto, int stock_inicial, int compras, int ventas, int total) {
        this.id_producto = id_producto;
        this.nom_producto = nom_producto;
        this.stock_inicial = stock_inicial;
        this.compras = compras;
        this.ventas = ventas;
        this.total = total;
    }

    public int getId_producto() {
        return id_producto;
    }

    public void setId_producto(int id_producto) {
        this.id_producto = id_producto;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public int getStock_inicial() {
        return stock_inicial;
    }

    public void setStock_inicial(int stock_inicial) {
        this.stock_inicial = stock_inicial;
    }

    public int getCompras() {
        return compras;
    }

    public void setCompras(int compras) {
        this.compras = compras;
    }

    public int getVentas() {
        return ventas;
    }

    public void setVentas(int ventas) {
        this.ventas = ventas;
    }

    public int getTotal() {
        total = (compras+stock_inicial)-ventas;
        return total;
    }

    public void setTotal(int total) {
        
        this.total = total;
    }

    

    
}
