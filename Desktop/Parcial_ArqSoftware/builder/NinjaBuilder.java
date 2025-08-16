package builder;


import modelo.Ninja;
import java.util.ArrayList;
import java.util.List;

public class NinjaBuilder {
    private String nombre;
    private String rango;
    private int ataque;
    private int defensa;
    private int chakra;
    private String aldea;
    private List<String> jutsus = new ArrayList<>();

    public NinjaBuilder setNombre(String nombre) { this.nombre = nombre; return this; }
    public NinjaBuilder setRango(String rango) { this.rango = rango; return this; }
    public NinjaBuilder setAtaque(int ataque) { this.ataque = ataque; return this; }
    public NinjaBuilder setDefensa(int defensa) { this.defensa = defensa; return this; }
    public NinjaBuilder setChakra(int chakra) { this.chakra = chakra; return this; }
    public NinjaBuilder setAldea(String aldea) { this.aldea = aldea; return this; }
    public NinjaBuilder addJutsu(String jutsu) { this.jutsus.add(jutsu); return this; }

    public Ninja build() {
        return new Ninja(nombre, rango, ataque, defensa, chakra, aldea, jutsus);
    }
}

