package factory;
import java.util.Arrays;

import modelo.Ninja;
public class KumogaFactory implements NinjaFactory {
    @Override
    public Ninja crearNinja(String nombre, String rango) {
        return new Ninja(nombre, rango, 0, 0, 0, "Kumoga", Arrays.asList("null"));
    }
    
}
