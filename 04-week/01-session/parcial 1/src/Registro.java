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

    @Override
    public String toString() {
        return "[" + tipo + "] " + detalle;
    }
}