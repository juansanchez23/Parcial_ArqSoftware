
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import builder.NinjaBuilder;
import factory.IwagaFactory;
import factory.KirigaFactory;
import factory.KonohaFactory;
import factory.KumogaFactory;
import factory.SunaFactory;
import modelo.Jutsu;
import modelo.Mision;
import modelo.Ninja;
import visitor.ExportVisitorArchivo;




public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static List<Ninja> ninjas = new ArrayList<>();
    private static List<Mision> misiones = Arrays.asList(
            new Mision("Recolectar hierbas", "D", 100),
            new Mision("Proteger al puente", "C", 500),
            new Mision("Capturar ninja renegado", "B", 1200),
            new Mision("Espionaje en otra aldea", "A", 2000),
            new Mision("Eliminar a Akatsuki", "S", 5000)
    );

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("\n--- MENÚ PRINCIPAL ---");
            System.out.println("1. Crear Ninja");
            System.out.println("2. Ver Ninjas");
            System.out.println("3. Aceptar Misión");
            System.out.println("4. Entrenar Ninja");
            System.out.println("5. Combate");
            System.out.println("6. Exportar Ninjas a TXT");
            System.out.println("7. Exportar misiones a TXT");
            System.out.println("8. Crear Ninja Personalizado(Cobarde)");
            System.out.println("0. Salir");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1: crearNinja(); break;
                case 2: verNinjas(); break;
                case 3: aceptarMision(); break;
                case 4: entrenarNinja(); break;
                case 5: combate(); break;
                case 6: exportarNinjas(); break;
                case 7: exportarMisiones(); break;
                case 8: crearNinjaPersonalizado();break;
            }
        } while (opcion != 0);

        sc.close();
    }

    // Crear Ninja con Factory
    private static void crearNinja() {
         System.out.print("Nombre del ninja: ");
    String nombre = sc.nextLine();

    // Selección de aldea
    System.out.print("Aldea (Konoha/Suna/Iwawa/Kiriga/Kumoga): ");
    String aldea = sc.nextLine();

    Ninja nuevo = null;
    switch (aldea.toLowerCase()) {
        case "konoha":
            nuevo = new KonohaFactory().crearNinja(nombre, "Genin");
            break;
        case "suna":
            nuevo = new SunaFactory().crearNinja(nombre, "Genin");
            break;
        case "iwaga":
            nuevo = new IwagaFactory().crearNinja(nombre, "Genin");
            break;
        case "kiriga":
            nuevo = new KirigaFactory().crearNinja(nombre, "Genin");
            break;
        case "kumoga":
            nuevo = new KumogaFactory().crearNinja(nombre, "Genin");
            break;
        default:
            System.out.println("Aldea no válida.");
            return;
    }

    ninjas.add(nuevo);
    System.out.println("Ninja creado con éxito! (" + nuevo.getRango() + ")");
}

    // Ver ninjas
    private static void verNinjas() {
        if (ninjas.isEmpty()) {
            System.out.println("No hay ninjas creados.");
            return;
        }
        for (int i = 0; i < ninjas.size(); i++) {
            System.out.println(i + ". " + ninjas.get(i));
        }
    }

    // Aceptar mision
    private static void aceptarMision() {
        if (ninjas.isEmpty()) {
            System.out.println("Primero debes crear un ninja.");
            return;
        }
        verNinjas();
        System.out.print("Selecciona el índice del ninja: ");
        int idx = sc.nextInt();

        System.out.println("--- Misiones disponibles ---");
        for (int i = 0; i < misiones.size(); i++) {
            System.out.println(i + ". " + misiones.get(i));
        }
        System.out.print("Selecciona la misión: ");
        int mIdx = sc.nextInt();

        ninjas.get(idx).aceptarMision(misiones.get(mIdx));
    }

    // Entrenamineto
    private static void entrenarNinja() {
        if (ninjas.isEmpty()) {
            System.out.println("Primero debes crear un ninja.");
            return;
        }
        verNinjas();
        System.out.print("Selecciona el índice del ninja a entrenar: ");
        int idx = sc.nextInt();
        sc.nextLine();
        System.out.print("¿Qué atributo entrenar? (ataque/defensa/chakra): ");
        String atr = sc.nextLine();
        ninjas.get(idx).entrenar(atr, 200, 10);
    }

    //  Combate
    private static void combate() {
        if (ninjas.size() < 2) {
            System.out.println("Debes tener al menos 2 ninjas.");
            return;
        }
        verNinjas();
        System.out.print("Selecciona índice del primer ninja: ");
        int idx1 = sc.nextInt();
        System.out.print("Selecciona índice del segundo ninja: ");
        int idx2 = sc.nextInt();

        Ninja n1 = ninjas.get(idx1);
        Ninja n2 = ninjas.get(idx2);

        // Elegir jutsus
        System.out.println("--- Jutsus de " + n1.getNombre() + " ---");
        for (int i = 0; i < n1.getJutsus().size(); i++) {
            System.out.println(i + ". " + n1.getJutsus().get(i));
        }
        System.out.print("Elige jutsu para " + n1.getNombre() + ": ");
        int j1Idx = sc.nextInt();

        System.out.println("--- Jutsus de " + n2.getNombre() + " ---");
        for (int i = 0; i < n2.getJutsus().size(); i++) {
            System.out.println(i + ". " + n2.getJutsus().get(i));
        }
        System.out.print("Elige jutsu para " + n2.getNombre() + ": ");
        int j2Idx = sc.nextInt();

        Ninja.combate(n1, j1Idx, n2, j2Idx);
    }
    //Aplicar visitor para transcribir ninjas y misiones
    private static void exportarNinjas() {
    ExportVisitorArchivo visitor = new ExportVisitorArchivo("ninjas_exportados.txt");

    for (Ninja n : ninjas) {
        n.accept(visitor);
    }

    System.out.println(" Ninjas exportados a ninjas_exportados.txt");
}
private static void exportarMisiones() {
    ExportVisitorArchivo visitor = new ExportVisitorArchivo("misiones_exportadas.txt");

    for (Mision m : misiones) {
        m.accept(visitor);
    }

    System.out.println(" Misiones exportadas a misiones_exportadas.txt");
}

// Utiliza el buider para crear un ninja personalizado
private static void crearNinjaPersonalizado() {
    System.out.print("Nombre del ninja: ");
    String nombre = sc.nextLine();
    System.out.print("Rango inicial (Genin/Chunin/Jonin/Kage): ");
    String rango = sc.nextLine();
    System.out.print("Ataque: ");
    int ataque = sc.nextInt();
    System.out.print("Defensa: ");
    int defensa = sc.nextInt();
    System.out.print("Chakra: ");
    int chakra = sc.nextInt();
    sc.nextLine();
    System.out.print("Aldea: ");
    String aldea = sc.nextLine();

    NinjaBuilder builder = new NinjaBuilder()
            .setNombre(nombre)
            .setRango(rango)
            .setAtaque(ataque)
            .setDefensa(defensa)
            .setChakra(chakra)
            .setAldea(aldea);

    System.out.println("¿Cuántos jutsus quieres añadir?");
    int n = sc.nextInt();
    sc.nextLine();
    for (int i = 0; i < n; i++) {
        System.out.print("Nombre del jutsu: ");
        String jName = sc.nextLine();
        System.out.print("Poder del jutsu: ");
        int poder = sc.nextInt();
        sc.nextLine();
        System.out.print("Tipo del jutsu (Agua/Fuego/Viento/Tierra/Rayo/Neutral): ");
        String tipo = sc.nextLine();
        System.out.print("Cantidad de chakra que utiliza: ");
        int costChakra = sc.nextInt();
        builder.addJutsu(new Jutsu(jName, poder, tipo, costChakra));
    }

    Ninja nuevo = builder.build();
    ninjas.add(nuevo);
    System.out.println(" Ninja personalizado creado con éxito!");
}
}
