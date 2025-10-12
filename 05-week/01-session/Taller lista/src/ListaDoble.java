// Fecha: 2025-09-09 | Versión: 3.1 | Autor: Tu Nombre
class ListaDoble {
    static class DNodo {
        int valor;
        DNodo ant, sig;
        DNodo(int v){ valor = v; }
    }

    private DNodo cabeza, cola;

    public void agregarInicio(int x){
        DNodo n = new DNodo(x);
        n.sig = cabeza;
        if (cabeza != null) cabeza.ant = n;
        cabeza = n;
        if (cola == null) cola = n;
    }

    public void agregarFinal(int x){
        DNodo n = new DNodo(x);
        n.ant = cola;
        if (cola != null) cola.sig = n;
        cola = n;
        if (cabeza == null) cabeza = n;
    }

    public void eliminarInicio(){
        if (cabeza == null) return;
        cabeza = cabeza.sig;
        if (cabeza != null) cabeza.ant = null; else cola = null;
    }

    public void eliminarFinal(){
        if (cola == null) return;
        cola = cola.ant;
        if (cola != null) cola.sig = null; else cabeza = null;
    }

    public void imprimir(){
        if (cabeza == null) { System.out.println("Lista vacía"); return; }
        DNodo p = cabeza;
        while(p != null){
            System.out.print(p.valor);
            if (p.sig != null) System.out.print(" <-> ");
            p = p.sig;
        }
        System.out.println();
    }
}