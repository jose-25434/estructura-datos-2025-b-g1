// Fecha: 2025-09-09 | Versión: 3.1 | Autor: Tu Nombre
class ListaSimple {
    private Nodo inicio;

    public void agregarInicio(int x) {
        Nodo n = new Nodo(x);
        n.sig = inicio;
        inicio = n;
    }

    public void agregarFinal(int x) {
        Nodo n = new Nodo(x);
        if (inicio == null) { inicio = n; return; }
        Nodo cur = inicio;
        while (cur.sig != null) cur = cur.sig;
        cur.sig = n;
    }

    public void agregarEn(int x, int idx) {
        if (idx <= 0) { agregarInicio(x); return; }
        Nodo cur = inicio;
        int i = 0;
        while (cur != null && i < idx - 1) { cur = cur.sig; i++; }
        if (cur == null) { agregarFinal(x); return; }
        Nodo n = new Nodo(x);
        n.sig = cur.sig;
        cur.sig = n;
    }

    public boolean eliminarInicio() {
        if (inicio == null) return false;
        inicio = inicio.sig;
        return true;
    }

    public boolean eliminarFinal() {
        if (inicio == null) return false;
        if (inicio.sig == null) { inicio = null; return true; }
        Nodo cur = inicio;
        while (cur.sig.sig != null) cur = cur.sig;
        cur.sig = null;
        return true;
    }

    public boolean eliminarEn(int idx) {
        if (idx <= 0) return eliminarInicio();
        if (inicio == null) return false;
        Nodo cur = inicio;
        int i = 0;
        while (cur.sig != null && i < idx - 1) { cur = cur.sig; i++; }
        if (cur.sig == null) return false;
        cur.sig = cur.sig.sig;
        return true;
    }

    public void imprimir() {
        if (inicio == null) { System.out.println("Lista vacía"); return; }
        Nodo p = inicio;
        while (p != null) {
            System.out.print(p.valor);
            if (p.sig != null) System.out.print(" -> ");
            p = p.sig;
        }
        System.out.println();
    }
}