package modelo;

public class Jutsu {
    private String nombre;
    private String tipo; 
    private int chakraCost;

    public Jutsu(String nombre, String tipo, int chakraCost) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.chakraCost = chakraCost;
    }

    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public int getChakraCost() { return chakraCost; }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ", cost:" + chakraCost + ")";
    }
}
