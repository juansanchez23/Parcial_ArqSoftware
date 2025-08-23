package modelo;

import visitor.Exportable;
import visitor.Visitor;

public class Mision implements Exportable{
    @Override
    public void accept(Visitor visitor) {
        visitor.exportar(this);
    }
    private String nombre;
    private String rango; // D, C, B, A, S
    private int recompensa;

    public Mision(String nombre, String rango, int recompensa) {
        this.nombre = nombre;
        this.rango = rango;
        this.recompensa = recompensa;
    }
    
    public String getNombre() { return nombre; }
    public String getRango() { return rango; }
    public int getRecompensa() { return recompensa; }

    @Override
    public String toString() {
        return "Mision{" +
                "nombre='" + nombre + '\'' +
                ", rango='" + rango + '\'' +
                ", recompensa=" + recompensa +
                '}';
    }
}

