package modelo;
import java.util.List;


public class Ninja {
    private String nombre;
    private String rango; // Genin, Chunin, Jonin, Kage
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

    public boolean aceptarMision(Mision mision) {
    // Validamos si el rango del ninja le permite tomar la misión
    if (puedeTomarMision(this.rango, mision.getRango())) {
        System.out.println(nombre + " ha aceptado la misión: " + mision.getNombre() +
                " (Recompensa: " + mision.getRecompensa() + ")");
        return true;
    } else {
        System.out.println(nombre + " NO tiene rango suficiente para la misión: " + mision.getNombre());
        return false;
    }
}

// Método privado para comparar rangos
private boolean puedeTomarMision(String rangoNinja, String rangoMision) {
    String[] rangos = {"D", "C", "B", "A", "S"}; 
    int nivelNinja = -1, nivelMision = -1;

    // Definimos hasta qué nivel de misión puede llegar cada rango de ninja
    String maxRangoPermitido;
    switch (rangoNinja.toLowerCase()) {
        case "genin": maxRangoPermitido = "C"; break;   // Genin hasta C
        case "chunin": maxRangoPermitido = "B"; break; // Chunin hasta B
        case "jonin": maxRangoPermitido = "A"; break;  // Jonin hasta A
        case "kage": maxRangoPermitido = "S"; break;   // Kage hasta S
        default: maxRangoPermitido = "D"; // por defecto
    }

    for (int i = 0; i < rangos.length; i++) {
        if (rangos[i].equalsIgnoreCase(maxRangoPermitido)) nivelNinja = i;
        if (rangos[i].equalsIgnoreCase(rangoMision)) nivelMision = i;
    }

    return nivelNinja >= nivelMision;
}

}


