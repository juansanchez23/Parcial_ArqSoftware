package factory;
import java.util.Arrays;

import modelo.Jutsu;
import modelo.Ninja;

public class IwagaFactory implements NinjaFactory {
    @Override
    public Ninja crearNinja(String nombre, String rango) {
        return new Ninja(nombre, rango, 30, 30, 30, "Iwaga",
                Arrays.asList(
                    new Jutsu("Bunshinjutsu",40,"Neutral",10), new Jutsu("Kawarimi no Jutsu",40,"Tierra",10), new Jutsu("Fragmentacion del suelo... nojutsu",100,"Tierra", 40)));
    }
    
}
