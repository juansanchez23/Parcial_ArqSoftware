package factory;

import modelo.Ninja;
    // Interfaz
public interface NinjaFactory {
    Ninja crearNinja(String nombre, String rango);
}


