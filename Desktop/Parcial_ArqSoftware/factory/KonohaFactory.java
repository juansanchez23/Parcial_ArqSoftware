package factory;
import java.util.Arrays;

import modelo.Ninja;
// Fábrica concreta: Konoha
public class KonohaFactory implements NinjaFactory {
    @Override
    public Ninja crearNinja(String nombre, String rango) {
        return new Ninja(nombre, rango, 70, 60, 80, "Konoha",
                Arrays.asList("Rasengan", "Kage Bunshin"));
    }
}
