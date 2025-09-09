// Fecha: 2025-09-09 | Versión: 4.0 | Autor: Jose Gabriel David Mendez Roncancio
class ListaSimple {
    private Nodo cabeza;

    public void insertarInicio(int valor) {
        Nodo n = new Nodo(valor);
        n.siguiente = cabeza;
        cabeza = n;
    }

    public void insertarFinal(int valor) {
        Nodo n = new Nodo(valor);
        if (cabeza == null) { cabeza = n; return; }
        Nodo cur = cabeza;
        while (cur.siguiente != null) cur = cur.siguiente;
        cur.siguiente = n;
    }

    public void insertarEnPosicion(int valor, int pos) {
        if (pos <= 0) { insertarInicio(valor); return; }
        Nodo cur = cabeza; int i = 0;
        while (cur != null && i < pos - 1) { cur = cur.siguiente; i++; }
        if (cur == null) { insertarFinal(valor); return; }
        Nodo n = new Nodo(valor);
        n.siguiente = cur.siguiente;
        cur.siguiente = n;
    }

    public boolean eliminarInicio() {
        if (cabeza == null) return false;
        cabeza = cabeza.siguiente;
        return true;
    }

    public boolean eliminarFinal() {
        if (cabeza == null) return false;
        if (cabeza.siguiente == null) { cabeza = null; return true; }
        Nodo cur = cabeza;
        while (cur.siguiente.siguiente != null) cur = cur.siguiente;
        cur.siguiente = null;
        return true;
    }

    public boolean eliminarEnPosicion(int pos) {
        if (pos <= 0) return eliminarInicio();
        if (cabeza == null) return false;
        Nodo cur = cabeza; int i = 0;
        while (cur.siguiente != null && i < pos - 1) { cur = cur.siguiente; i++; }
        if (cur.siguiente == null) return false;
        cur.siguiente = cur.siguiente.siguiente;
        return true;
    }

    public void mostrar() {
        if (cabeza == null) { System.out.println("Lista vacía"); return; }
        Nodo p = cabeza;
        while (p != null) {
            System.out.print(p.dato);
            if (p.siguiente != null) System.out.print(" -> ");
            p = p.siguiente;
        }
        System.out.println();
    }
}
