package modelo;

public class Jutsu {
    private String nombre;
    private int poder;
    private String tipo; 
    private int chakraCost;

    public Jutsu(String nombre, int poder, String tipo, int chakraCost) {
        this.nombre = nombre;
        this.poder = poder;
        this.tipo = tipo;
        this.chakraCost = chakraCost;
    }

    public String getNombre() { return nombre; }
    public int getPoder() {return poder;}
    public String getTipo() { return tipo; }
    public int getChakraCost() { return chakraCost; }

    @Override
    public String toString() {
        return nombre + " (" + tipo + ", poder:"+ poder + ", coste:" + chakraCost + ")";
    }
}
