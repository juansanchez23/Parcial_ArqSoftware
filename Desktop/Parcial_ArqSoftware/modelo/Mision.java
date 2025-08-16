package modelo;

public class Mision {
    private String nombre;
    private String rango; // D, C, B, A, S
    private int recompensa;

    public Mision(String nombre, String rango, int recompensa) {
        this.nombre = nombre;
        this.rango = rango;
        this.recompensa = recompensa;
    }

    @Override
    public String toString() {
        return "Mision{" +
                "nombre='" + nombre + '\'' +
                ", rango='" + rango + '\'' +
                ", recompensa=" + recompensa +
                '}';
    }
}

