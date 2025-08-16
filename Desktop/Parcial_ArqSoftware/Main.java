import builder.NinjaBuilder;
import factory.KonohaFactory;
import factory.NinjaFactory;
import factory.SunaFactory;
import modelo.Mision;
import modelo.Ninja;
import visitor.ExportVisitorArchivo;
import visitor.Visitor;

public class Main {
    public static void main(String[] args) {
        // Uso de FactoryMethod para Ninja Genin de Konoha
        NinjaFactory konohaFactory = new KonohaFactory();
        Ninja ninjaBaseKonoha = konohaFactory.crearNinja("Ninja de la aldea de la hoja", "Genin");
        // Uso builder para Konoha
        Ninja naruto = new NinjaBuilder()
            .setNombre("Naturo")
            .setRango("Genin")
            .setAtaque(35).setDefensa(40).setChakra(40)
            .setAldea(ninjaBaseKonoha.getAldea())
            .addJutsu("Rasengan")
            .addJutsu("Kage Bunshin")
            .build();
        
        Ninja sasuke = new NinjaBuilder()
            .setNombre("Sasuke")
            .setRango("Chunin")
            .setAtaque(75).setDefensa(60).setChakra(60)
            .setAldea(ninjaBaseKonoha.getAldea())
            .addJutsu("Chidori")
            .addJutsu("Katon: Gokakyu")
            .build();

        //Uso Factory para Iwaga    
        NinjaFactory IwagaFactory = new factory.IwagaFactory();
        Ninja ninjaBaseIwaga = IwagaFactory.crearNinja("Ninja de la aldea de la piedra", "Genin");
        // Uso del builder para Iwaga
        Ninja Onoki = new NinjaBuilder()
            .setNombre("Onoki")
            .setRango("Kage")
            .setAtaque(95).setDefensa(85).setChakra(90)
            .setAldea(ninjaBaseIwaga.getAldea())
            .addJutsu("Dust Release")
            .build();

        // Usando solo el Factory por defecto para la aldea Suna
        NinjaFactory sunaFactory = new SunaFactory();
        Ninja gaara = sunaFactory.crearNinja("Gaara", "Jonin");
        
        naruto.mostrarInfo();
        sasuke.mostrarInfo();
        gaara.mostrarInfo();
        Onoki.mostrarInfo();

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
        Onoki.aceptarMision(m5);

        // Usando VISITOR
        Visitor exportador = new ExportVisitorArchivo("informes.txt");
        exportador.exportar(gaara);
        exportador.exportar(m5);
    }
}
