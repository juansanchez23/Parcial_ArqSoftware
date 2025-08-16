package visitor;

import modelo.Ninja;
import modelo.Mision;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ExportVisitorArchivo implements Visitor {
    private String archivo;

    public ExportVisitorArchivo(String archivo) {
        this.archivo = archivo;
    }

    @Override
    public void exportar(Ninja ninja) {
        escribirEnArchivo("[EXPORTANDO NINJA] " + ninja.toString());
    }

    @Override
    public void exportar(Mision mision) {
        escribirEnArchivo("[EXPORTANDO MISION] " + mision.toString());
    }

    // Método privado que escribe en el archivo
    private void escribirEnArchivo(String texto) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true))) {
            writer.write(texto);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
