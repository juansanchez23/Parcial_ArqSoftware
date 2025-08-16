package factory;
import java.util.Arrays;
import modelo.Ninja;
// Fábrica concreta: Suna

public class SunaFactory implements NinjaFactory {
    @Override
    public Ninja crearNinja(String nombre, String rango) {
        return new Ninja(nombre, rango, 65, 55, 75, "Suna",
                Arrays.asList("Sabaku Kyuu", "Sabaku Taiso"));
    }
}
