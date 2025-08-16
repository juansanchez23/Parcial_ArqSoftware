package modelo;

import java.util.ArrayList;
import java.util.List;

public class Aldea {
    private String nombre;
    private List<Ninja> ninjas;

    public Aldea(String nombre) {
        this.nombre = nombre;
        this.ninjas = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Ninja> getNinjas() {
        return ninjas;
    }

    public void addNinja(Ninja n) {
        if (n != null) {
            ninjas.add(n);
        }
    }

    @Override
    public String toString() {
        return "Aldea{" +
                "nombre='" + nombre + '\'' +
                ", ninjas=" + ninjas.size() +
                '}';
    }
}
