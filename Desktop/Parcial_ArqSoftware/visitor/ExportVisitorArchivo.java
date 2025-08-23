package visitor;

import modelo.Ninja;
import modelo.Mision;


import java.io.FileWriter;
import java.io.IOException;

public class ExportVisitorArchivo implements Visitor {
    private String archivo;

    public ExportVisitorArchivo(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public void exportar(Ninja ninja) {
    try (FileWriter writer = new FileWriter(archivo, true)) {
            writer.write("Ninja: " + ninja.getNombre() + "\n");
            writer.write("Rango: " + ninja.getRango() + "\n");
            writer.write("Ataque: " + ninja.getAtaque() + "\n");
            writer.write("Defensa: " + ninja.getDefensa() + "\n");
            writer.write("Chakra: " + ninja.getChakra() + "\n");
            writer.write("Aldea: " + ninja.getAldea() + "\n");
            writer.write("Jutsus: " + ninja.getJutsus() + "\n");
            writer.write("Dinero: " + ninja.getDinero() + "\n");
            writer.write("------------------------\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void exportar(Mision mision) {
    try (FileWriter writer = new FileWriter(archivo, true)) {
        writer.write("Misión: " + mision.getNombre() + "\n");
        writer.write("Rango: " + mision.getRango() + "\n");
        writer.write("Recompensa: " + mision.getRecompensa() + "\n");
        writer.write("------------------------\n");
    } catch (IOException e) {
        e.printStackTrace();
    }

    }
}
