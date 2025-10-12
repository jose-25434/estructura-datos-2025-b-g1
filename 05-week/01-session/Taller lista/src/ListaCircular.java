// Fecha: 2025-09-09 | Versión: 3.1 | Autor: Tu Nombre
class ListaCircular {
    private Nodo ultimo;

    public void agregarFinal(int x){
        Nodo n = new Nodo(x);
        if (ultimo == null){
            ultimo = n;
            ultimo.sig = ultimo;
            return;
        }
        n.sig = ultimo.sig;
        ultimo.sig = n;
        ultimo = n;
    }

    public boolean eliminarValor(int x){
        if (ultimo == null) return false;
        Nodo cur = ultimo.sig, ant = ultimo;
        do {
            if (cur.valor == x){
                if (cur == ant){
                    ultimo = null;
                } else {
                    ant.sig = cur.sig;
                    if (cur == ultimo) ultimo = ant;
                }
                return true;
            }
            ant = cur; cur = cur.sig;
        } while (cur != ultimo.sig);
        return false;
    }

    public void imprimir(){
        if (ultimo == null){ System.out.println("Lista vacía"); return; }
        Nodo p = ultimo.sig;
        do {
            System.out.print(p.valor);
            p = p.sig;
            if (p != ultimo.sig) System.out.print(" -> ");
        } while (p != ultimo.sig);
        System.out.println(" (circular)");
    }
}