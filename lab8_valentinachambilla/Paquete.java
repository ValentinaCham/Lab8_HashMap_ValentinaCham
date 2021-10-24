// Laboratorio Nro 8 - Ejercicio 1
// Autor: Valentina Milagros Chambilla Perca

package lab8_valentinachambilla;

public class Paquete {
    private String nombre;
    private double costo;
    private int kilos;
    
    public Paquete(String nom, double cos, int ki){
        nombre = nom;
        costo = cos;
        kilos = ki;
    }
    
    public String getNom(){
        return nombre;
    }
    
    public double getCos(){
        return costo;
    }
    
    public int getKil(){
        return kilos;
    }
}
