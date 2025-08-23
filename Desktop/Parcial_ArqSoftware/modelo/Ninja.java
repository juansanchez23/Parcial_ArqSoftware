package modelo;
import java.util.List;

import visitor.Exportable;
import visitor.Visitor;


public class Ninja implements Exportable{
    @Override
    public void accept(Visitor visitor) {
        visitor.exportar(this);
    }
    private String nombre;
    private String rango; // Genin, Chunin, Jonin, Kage
    private int ataque;
    private int defensa;
    private int chakra;
    private String aldea;
    private int dinero;
    private List<Jutsu> jutsus;

    public Ninja(String nombre, String rango, int ataque, int defensa, int chakra, String aldea, List<Jutsu> jutsus) {
        this.nombre = nombre;
        this.rango = rango;
        this.ataque = ataque;
        this.defensa = defensa;
        this.chakra = chakra;
        this.aldea = aldea;
        this.dinero = 0;
        this.jutsus = jutsus;
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getRango() { return rango; }
    public int getAtaque() { return ataque; }
    public int getDefensa() { return defensa; }
    public int getChakra() { return chakra; }
    public String getAldea() { return aldea; }
    public int getDinero() { return dinero; }
    public List<Jutsu> getJutsus() { return jutsus; }

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
                " (Recompensa: " + mision.getRecompensa() + " ryo)");
        this.addDinero(mision.getRecompensa());
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
        case "genin": maxRangoPermitido = "C"; break;   
        case "chunin": maxRangoPermitido = "B"; break; 
        case "jonin": maxRangoPermitido = "A"; break;  
        case "kage": maxRangoPermitido = "S"; break;   
        default: maxRangoPermitido = "D"; 
    }

    for (int i = 0; i < rangos.length; i++) {
        if (rangos[i].equalsIgnoreCase(maxRangoPermitido)) nivelNinja = i;
        if (rangos[i].equalsIgnoreCase(rangoMision)) nivelMision = i;
    }

    return nivelNinja >= nivelMision;
}
public void addDinero(int cantidad) {this.dinero += cantidad;}
public void gastarDinero(int cantidad) {this.dinero -= cantidad;}

public void entrenar(String atributo, int coste,int mejora) {
    if(dinero < coste) {
        System.out.println(nombre + "no tienes suficiente dinero para entrenar :c");
        return;
    }
    gastarDinero(coste);
    
    switch (atributo.toLowerCase()){
        case "ataque": ataque +=mejora; break;
        case "defensa": defensa +=mejora; break;
        case "chakra": chakra +=mejora; break;
        default: System.out.println("Atributo no valido"); return;
    }
    verificarRango();

    System.out.println(nombre + " entreno" + atributo + 
            "(+ " + mejora+ "). Nuevo estado: Ataque"+ ataque +", Defensa=" +defensa+", Chakra="+chakra+ "Dinero restante=" + dinero);
}
public static void combate(Ninja n1, int j1Idx, Ninja n2, int j2Idx) {
    System.out.println("\nCombate entre " + n1.getNombre() + " y " + n2.getNombre());

    Jutsu j1 = n1.getJutsus().get(j1Idx);
    Jutsu j2 = n2.getJutsus().get(j2Idx);

    int poderN1 = n1.getAtaque() + j1.getPoder() - n2.getDefensa();
    int poderN2 = n2.getAtaque() + j2.getPoder() - n1.getDefensa();

    System.out.println(n1.getNombre() + " usa " + j1 + " → Daño: " + poderN1);
    System.out.println(n2.getNombre() + " usa " + j2 + " → Daño: " + poderN2);

    if (poderN1 > poderN2) {
        System.out.println( n1.getNombre() + " gana el combate!");
        n1.entrenar("ataque", 0, 5);
    } else if (poderN2 > poderN1) {
        System.out.println( n2.getNombre() + " gana el combate!");
        n2.entrenar("ataque", 0, 5);
    } else {
        System.out.println("¡Empate!");
    }
}
public void verificarRango() {
    if (rango.equalsIgnoreCase("Genin") && ataque >= 100 && defensa >= 100 && chakra >= 100) {
        rango = "Chunin";
        System.out.println(nombre + " ha subido de rango a Chunin ");
    } else if (rango.equalsIgnoreCase("Chunin") && ataque >= 200 && defensa >= 200 && chakra >= 200) {
        rango = "Jonin";
        System.out.println(nombre + " ha subido de rango a Jonin ");
    } else if (rango.equalsIgnoreCase("Jonin") && ataque >= 300 && defensa >= 300 && chakra >= 300) {
        rango = "Kage";
        System.out.println(nombre + " ha alcanzado el rango Kage ");
    }
}


}


