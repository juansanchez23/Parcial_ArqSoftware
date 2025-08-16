package modelo;
import java.util.List;


public class Ninja {
    private String nombre;
    private String rango; // Genin, Chunin, Jonin
    private int ataque;
    private int defensa;
    private int chakra;
    private String aldea;
    private List<String> jutsus;

    public Ninja(String nombre, String rango, int ataque, int defensa, int chakra, String aldea, List<String> jutsus) {
        this.nombre = nombre;
        this.rango = rango;
        this.ataque = ataque;
        this.defensa = defensa;
        this.chakra = chakra;
        this.aldea = aldea;
        this.jutsus = jutsus;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getRango() { return rango; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getChakra() { return chakra; }
    public String getAldea() { return aldea; }
    public List<String> getJutsus() { return jutsus; }

    // Mostrar info
    public void mostrarInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Ninja{" +
                "nombre='" + nombre + '\'' +
                ", rango='" + rango + '\'' +
                ", ataque=" + ataque +
                ", defensa=" + defensa +
                ", chakra=" + chakra +
                ", aldea='" + aldea + '\'' +
                ", jutsus=" + jutsus +
                '}';
    }
}


