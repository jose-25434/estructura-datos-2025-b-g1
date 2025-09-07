public class Bitacora {
    private Registro inicio;
    private Registro fin;

    // Insertar al final (O(1))
    public void agregar(String tipo, String detalle) {
        Registro nuevo = new Registro(tipo, detalle);
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else {
            fin.sig = nuevo;
            nuevo.ant = fin;
            fin = nuevo;
        }
    }

    // Recorrer hacia adelante (O(n))
    public void mostrarAdelante() {
        Registro actual = inicio;
        while (actual != null) {
            System.out.println("[" + actual.tipo + "] " + actual.detalle);
            actual = actual.sig;
        }
    }

    // Recorrer hacia atrás (O(n))
    public void mostrarAtras() {
        Registro actual = fin;
        while (actual != null) {
            System.out.println("[" + actual.tipo + "] " + actual.detalle);
            actual = actual.ant;
        }
    }
}