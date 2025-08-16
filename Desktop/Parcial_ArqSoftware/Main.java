import builder.NinjaBuilder;
import factory.KonohaFactory;
import factory.NinjaFactory;
import factory.SunaFactory;
import modelo.Mision;
import modelo.Ninja;

public class Main {
    public static void main(String[] args) {
        // Uso de FactoryMethod para Ninja Genin de Konoha
        NinjaFactory konohaFactory = new KonohaFactory();
        Ninja naruto = konohaFactory.crearNinja("Naruto", "Genin");
        // Uso del builder
        Ninja sasuke = new NinjaBuilder()
            .setNombre("Sasuke")
            .setRango("Chunin")
            .setAtaque(85).setDefensa(70).setChakra(90)
            .setAldea("Konoha")
            .addJutsu("Chidori")
            .addJutsu("Katon: Gokakyu")
            .build();
        
        NinjaFactory sunaFactory = new SunaFactory();
        Ninja gaara = sunaFactory.crearNinja("Gaara", "Jonin");
        
        naruto.mostrarInfo();
        sasuke.mostrarInfo();
        gaara.mostrarInfo();

        // Crear misiones
        Mision m1 = new Mision("Recolectar hierbas", "D", 100);
        Mision m2 = new Mision("Proteger al puente", "C", 500);
        Mision m3 = new Mision("Capturar ninja renegado", "B", 1200);
        Mision m4 = new Mision("Espionaje en otra aldea", "A", 2000);
        Mision m5 = new Mision("Eliminar a Akatsuki", "A", 5000);

        //intentan aceptarlas
        naruto.aceptarMision(m1); // puede
        naruto.aceptarMision(m2); // en teoria puede
        naruto.aceptarMision(m3); // no puede (es Genin)
        sasuke.aceptarMision(m4); // no puede
        gaara.aceptarMision(m5); // en teoria puede
    }
}
