Clase Registro:
 Nodo de lista doble que almacena operaciones en la bitácora.
*/
public class Registro {
    String tipo;
    String detalle;
    Registro sig;
    Registro ant;

    public Registro(String t, String d) {
        tipo = t;
        detalle = d;
        sig = null;
        ant = null;
    }

    public String toString() {
        return "[" + tipo + "] " + detalle;
    }
}