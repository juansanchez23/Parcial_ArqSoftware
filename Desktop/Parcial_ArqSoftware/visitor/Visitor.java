package visitor;

import modelo.Ninja;
import modelo.Mision;

public interface Visitor {
    void exportar(Ninja ninja);
    void exportar(Mision mision);
}
