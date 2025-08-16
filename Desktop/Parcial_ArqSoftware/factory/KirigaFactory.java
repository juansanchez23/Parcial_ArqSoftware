package factory;
import java.util.Arrays;
import modelo.Ninja;

public class KirigaFactory implements NinjaFactory {
    @Override
    public Ninja crearNinja(String nombre, String rango) {
        return new Ninja(nombre, rango, 0, 0, 0, "Kiriga",
                    Arrays.asList("Un ataque", "Otro ataque"));
    }
}
