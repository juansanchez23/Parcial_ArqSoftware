package factory;
import java.util.Arrays;

import modelo.Jutsu;
import modelo.Ninja;
public class KumogaFactory implements NinjaFactory {
    @Override
    public Ninja crearNinja(String nombre, String rango) {
        return new Ninja(nombre, rango, 30, 30, 30, "Kumoga", Arrays.asList(
                    new Jutsu("Bunshinjutsu",40,"Neutral",10), new Jutsu("Kawarimi no Jutsu",40,"Tierra",10)));
    }
    
}
