package factory;
import java.util.Arrays;
import modelo.Ninja;

public class IwagaFactory implements NinjaFactory {
    @Override
    public Ninja crearNinja(String nombre, String rango) {
        return new Ninja(nombre, rango, 0, 0, 0, "Iwaga",
                Arrays.asList("null"));
    }
    
}
