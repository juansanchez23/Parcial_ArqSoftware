package factory;

import modelo.Ninja;
import java.util.Arrays;
import java.util.List;

public abstract class NinjaFactory {
    public abstract List<Ninja> crearNinjas();
}


class KonohaFactoKonohary extends NinjaFactory {
    @Override
    public List<Ninja> crearNinjas() {
        Ninja naruto = new Ninja(
                "Naruto Uzumaki",
                "Genin",
                90,
                70,
                120,
                "Konoha",
                Arrays.asList("Rasengan", "Kage Bunshin no Jutsu", "Rasenshuriken")
        );

        Ninja sasuke = new Ninja(
                "Sasuke Uchiha",
                "Genin",
                95,
                80,
                100,
                "Konoha",
                Arrays.asList("Chidori", "Fireball Jutsu", "Sharingan")
        );

        Ninja kakashi = new Ninja(
                "Kakashi Hatake",
                "Jounin",
                100,
                90,
                110,
                "Konoha",
                Arrays.asList("Raikiri", "Sharingan", "Summoning Dogs")
        );

        return Arrays.asList(naruto, sasuke, kakashi);
    }
}

// Fábrica de la Arena
class SunaFactory extends NinjaFactory {
    @Override
    public List<Ninja> crearNinjas() {
        Ninja gaara = new Ninja(
                "Gaara",
                "Kazekage",
                100,
                120,
                150,
                "Sunagakure",
                Arrays.asList("Sand Coffin", "Sand Burial", "Sand Shield")
        );

        Ninja temari = new Ninja(
                "Temari",
                "Jounin",
                85,
                75,
                100,
                "Sunagakure",
                Arrays.asList("Wind Scythe Jutsu", "Great Wind Scythe Jutsu")
        );

        Ninja kankuro = new Ninja(
                "Kankuro",
                "Jounin",
                80,
                70,
                95,
                "Sunagakure",
                Arrays.asList("Puppet Technique", "Black Ant", "Crow Puppet")
        );

        return Arrays.asList(gaara, temari, kankuro);
    }
}

class MainDemo {
    public static void main(String[] args) {
        NinjaFactory konoha = new KonohaFactory();
        NinjaFactory suna = new SunaFactory();

        konoha.crearNinjas().forEach(Ninja::mostrarInfo);
        suna.crearNinjas().forEach(Ninja::mostrarInfo);
    }
}

