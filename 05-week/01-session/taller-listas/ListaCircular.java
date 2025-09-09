// Fecha: 2025-09-09 | Versión: 4.0 | Autor: Jose Gabriel David Mendez Roncancio
class ListaCircular {
    private Nodo ultimo; // ultimo.siguiente es la cabeza

    public void insertarFinal(int v){
        Nodo n = new Nodo(v);
        if (ultimo == null){
            ultimo = n;
            ultimo.siguiente = ultimo;
            return;
        }
        n.siguiente = ultimo.siguiente;
        ultimo.siguiente = n;
        ultimo = n;
    }

    public boolean eliminarValor(int v){
        if (ultimo == null) return false;
        Nodo cur = ultimo.siguiente, ant = ultimo;
        do{
            if (cur.dato == v){
                if (cur == ant){ // un solo nodo
                    ultimo = null;
                } else {
                    ant.siguiente = cur.siguiente;
                    if (cur == ultimo) ultimo = ant;
                }
                return true;
            }
            ant = cur; cur = cur.siguiente;
        }while(cur != ultimo.siguiente);
        return false;
    }

    public void mostrar(){
        if (ultimo == null){ System.out.println("Lista vacía"); return; }
        Nodo p = ultimo.siguiente;
        do{
            System.out.print(p.dato);
            p = p.siguiente;
            if (p != ultimo.siguiente) System.out.print(" -> ");
        }while(p != ultimo.siguiente);
        System.out.println(" (circular)");
    }
}
