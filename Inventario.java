
package model;

/**
 *
 * @author juare
 */
public class Inventario {
    private int idinventario;
    private String fechain;
    private String fechafin;

    public Inventario() {
    }

    public Inventario(int idinventario, String fechain, String fechafin) {
        this.idinventario = idinventario;
        this.fechain = fechain;
        this.fechafin = fechafin;
    }

    
    public int getIdinventario() {
        return idinventario;
    }

    public void setIdinventario(int idinventario) {
        this.idinventario = idinventario;
    }

    public String getFechain() {
        return fechain;
    }

    public void setFechain(String fechain) {
        this.fechain = fechain;
    }

    public String getFechafin() {
        return fechafin;
    }

    public void setFechafin(String fechafin) {
        this.fechafin = fechafin;
    }
    
    
    
}
