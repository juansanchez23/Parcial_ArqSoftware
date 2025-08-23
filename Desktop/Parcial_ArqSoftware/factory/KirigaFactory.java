package factory;
import java.util.Arrays;

import modelo.Jutsu;
import modelo.Ninja;

public class KirigaFactory implements NinjaFactory {
    @Override
    public Ninja crearNinja(String nombre, String rango) {
        return new Ninja(nombre, rango, 30, 30, 30, "Kiriga",
                    Arrays.asList(
                    new Jutsu("Bunshinjutsu",40,"Neutral",10), new Jutsu("Kawarimi no Jutsu",40,"Tierra",10)));
    }
}
