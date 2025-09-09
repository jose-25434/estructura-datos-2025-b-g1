// Fecha: 2025-09-09 | Versión: 4.0 | Autor: Jose Gabriel David Mendez Roncancio
class ListaDoble {
    static class NodoD {
        int dato; NodoD ant, sig;
        NodoD(int d){ dato = d; }
    }
    private NodoD cabeza, cola;

    public void insertarInicio(int v){
        NodoD n = new NodoD(v);
        n.sig = cabeza;
        if (cabeza != null) cabeza.ant = n;
        cabeza = n;
        if (cola == null) cola = n;
    }
    public void insertarFinal(int v){
        NodoD n = new NodoD(v);
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
    public void mostrar(){
        if (cabeza == null) { System.out.println("Lista vacía"); return; }
        NodoD p = cabeza;
        while(p != null){
            System.out.print(p.dato);
            if (p.sig != null) System.out.print(" <-> ");
            p = p.sig;
        }
        System.out.println();
    }
}
