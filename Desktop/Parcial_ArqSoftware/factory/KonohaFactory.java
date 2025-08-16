package factory;

import modelo.Aldea;
import modelo.Jutsu;
import modelo.Ninja;
import modelo.Rango;
import java.util.Arrays;
import java.util.List;

public class KonohaFactory extends NinjaFactory {
    @Override
    public List<Ninja> crearNinjas() {
        Aldea konoha = new Aldea("Konoha");

        Jutsu rasengan = new Jutsu("Rasengan", "Rotatorio", 30);
        Jutsu kageBunshin = new Jutsu("Kage Bunshin no Jutsu", "Clonación", 25);
        Jutsu rasenshuriken = new Jutsu("Rasenshuriken", "Rotatorio", 60);

        Ninja naruto = new Ninja("Naruto Uzumaki", Rango.GENIN, 90, 70, 120, konoha,
                Arrays.asList(rasengan, kageBunshin, rasenshuriken));

        Jutsu chidori = new Jutsu("Chidori", "Rayo", 40);
        Jutsu fireball = new Jutsu("Fireball Jutsu", "Fuego", 30);
        Jutsu sharingan = new Jutsu("Sharingan (capacidad)", "Dōjutsu", 0);

        Ninja sasuke = new Ninja("Sasuke Uchiha", Rango.GENIN, 95, 80, 100, konoha,
                Arrays.asList(chidori, fireball, sharingan));

        Jutsu raikiri = new Jutsu("Raikiri", "Rayo", 50);
        Jutsu summons = new Jutsu("Summoning Dogs", "Invocación", 20);

        Ninja kakashi = new Ninja("Kakashi Hatake", Rango.JONIN, 100, 90, 110, konoha,
                Arrays.asList(raikiri, sharingan, summons));

        return Arrays.asList(naruto, sasuke, kakashi);
    }
}
