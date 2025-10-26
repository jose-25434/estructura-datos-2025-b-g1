import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

/**
 * TallerEstructuras.java
 * Contiene TODAS las estructuras y demos requeridos por el taller:
 * 1) Pila con Deshacer/Rehacer
 * 2) Cola con prioridad (sistema de atención)
 * 3) HashMap de usuarios únicos por identificación
 * 4) Árbol binario con recorridos (in, pre, post)
 * 5) AVL con inserciones y reporte de rotaciones
 * 6) BST con búsqueda, inserción y eliminación
 * 7) Grafo (lista de adyacencia) con Dijkstra y BFS
 * 8) Impresión de complejidades Big-O de cada caso
 *
 * Para evaluar rápido: ejecutar main() y seguir el flujo de demostración.
 * Código comentado, identado y pensado para entregarse como 1 solo .java.
 */
public class TallerEstructuras {

    // ============= 1) PILA: Editor con Deshacer / Rehacer =============
    static class EditorUndoRedo {
        private final Deque<String> undo = new ArrayDeque<>();
        private final Deque<String> redo = new ArrayDeque<>();
        private String texto = "";

        // Acción: escribir agrega al historial y limpia el stack de rehacer
        public void escribir(String agregado) {
            undo.push(texto);
            texto = texto + agregado;
            redo.clear();
        }

        public boolean deshacer() {
            if (undo.isEmpty()) return false;
            redo.push(texto);
            texto = undo.pop();
            return true;
        }

        public boolean rehacer() {
            if (redo.isEmpty()) return false;
            undo.push(texto);
            texto = redo.pop();
            return true;
        }

        public String getTexto() { return texto; }
    }

    // ============= 2) COLA DE PRIORIDAD: Sistema de atención ===========
    static class Paciente {
        final String nombre;
        final int prioridad; // mayor número => más urgente
        final long llegada;  // desempate FIFO dentro de la misma prioridad
        public Paciente(String n, int p, long t) { nombre = n; prioridad = p; llegada = t; }
        @Override public String toString() { return nombre + " (prio=" + prioridad + ")"; }
    }
    static class SistemaAtencion {
        private final PriorityQueue<Paciente> pq = new PriorityQueue<>(
                Comparator.<Paciente>comparingInt(p -> -p.prioridad) // mayor primero
                        .thenComparingLong(p -> p.llegada)          // más antiguo primero
        );
        private long reloj = 0;
        public void llegar(String nombre, int prioridad) { pq.add(new Paciente(nombre, prioridad, reloj++)); }
        public Paciente atender() { return pq.poll(); }
        public int enCola() { return pq.size(); }
    }

    // ============= 3) TABLA HASH: Usuarios únicos por ID ===============
    static class UsuariosUnicos {
        private final Map<Integer, String> mapa = new HashMap<>();
        public boolean registrar(int id, String nombre) {
            return mapa.putIfAbsent(id, nombre) == null; // true si fue nuevo
        }
        public String consultar(int id) { return mapa.get(id); }
        public int cantidad() { return mapa.size(); }
        public Set<Map.Entry<Integer, String>> entradas() { return mapa.entrySet(); }
    }

    // ============= 4) ÁRBOL BINARIO + recorridos =======================
    static class NodoBin {
        int val; NodoBin izq, der;
        NodoBin(int v){ this.val = v; }
    }
    static class ArbolBinario {
        NodoBin raiz;
        public void insertar(int v){ raiz = insertarRec(raiz, v); }
        private NodoBin insertarRec(NodoBin n, int v){
            if(n==null) return new NodoBin(v);
            if(v<=n.val) n.izq = insertarRec(n.izq, v);
            else n.der = insertarRec(n.der, v);
            return n;
        }
        public List<Integer> inOrden(){ List<Integer> r=new ArrayList<>(); in(raiz,r); return r; }
        public List<Integer> preOrden(){ List<Integer> r=new ArrayList<>(); pre(raiz,r); return r; }
        public List<Integer> postOrden(){ List<Integer> r=new ArrayList<>(); post(raiz,r); return r; }
        private void in(NodoBin n,List<Integer> r){ if(n==null)return; in(n.izq,r); r.add(n.val); in(n.der,r); }
        private void pre(NodoBin n,List<Integer> r){ if(n==null)return; r.add(n.val); pre(n.izq,r); pre(n.der,r); }
        private void post(NodoBin n,List<Integer> r){ if(n==null)return; post(n.izq,r); post(n.der,r); r.add(n.val); }
    }

    // ============= 5) AVL: inserción + rotaciones reportadas ===========
    static class NodoAVL {
        int val, h=1;
        NodoAVL izq, der;
        NodoAVL(int v){ val=v; }
    }
    static class AVL {
        NodoAVL raiz;
        // Guardamos el último tipo de rotación detectada para "evidencia"
        final List<String> rotaciones = new ArrayList<>();

        int altura(NodoAVL n){ return n==null?0:n.h; }
        int balance(NodoAVL n){ return n==null?0:altura(n.izq)-altura(n.der); }
        void act(NodoAVL n){ n.h = 1 + Math.max(altura(n.izq), altura(n.der)); }

        NodoAVL rotDer(NodoAVL y){
            NodoAVL x = y.izq; NodoAVL T2 = x.der;
            x.der = y; y.izq = T2; act(y); act(x);
            rotaciones.add("Rotación Simple Derecha (LL)");
            return x;
        }
        NodoAVL rotIzq(NodoAVL x){
            NodoAVL y = x.der; NodoAVL T2 = y.izq;
            y.izq = x; x.der = T2; act(x); act(y);
            rotaciones.add("Rotación Simple Izquierda (RR)");
            return y;
        }
        NodoAVL rotIzqDer(NodoAVL n){
            n.izq = rotIzq(n.izq);
            rotaciones.remove(rotaciones.size()-1); // limpiar etiqueta RR intermedia
            rotaciones.add("Rotación Doble Izquierda-Derecha (LR)");
            return rotDer(n);
        }
        NodoAVL rotDerIzq(NodoAVL n){
            n.der = rotDer(n.der);
            rotaciones.remove(rotaciones.size()-1);
            rotaciones.add("Rotación Doble Derecha-Izquierda (RL)");
            return rotIzq(n);
        }

        public void insertar(int v){ raiz = insertarRec(raiz,v); }
        private NodoAVL insertarRec(NodoAVL n,int v){
            if(n==null) return new NodoAVL(v);
            if(v < n.val) n.izq = insertarRec(n.izq,v);
            else if(v > n.val) n.der = insertarRec(n.der,v);
            else return n; // no dup
            act(n);
            int b = balance(n);
            // 4 casos
            if(b>1 && v < n.izq.val) return rotDer(n);               // LL
            if(b<-1 && v > n.der.val) return rotIzq(n);              // RR
            if(b>1 && v > n.izq.val) return rotIzqDer(n);            // LR
            if(b<-1 && v < n.der.val) return rotDerIzq(n);           // RL
            return n;
        }
        public List<Integer> inOrden(){ List<Integer> r=new ArrayList<>(); in(raiz,r); return r; }
        private void in(NodoAVL n,List<Integer> r){ if(n==null)return; in(n.izq,r); r.add(n.val); in(n.der,r); }
    }

    // ============= 6) BST: búsqueda, inserción y eliminación ===========
    static class BST {
        static class Nodo { int v; Nodo i,d; Nodo(int v){this.v=v;} }
        Nodo r;

        public void insertar(int v){ r = ins(r,v); }
        private Nodo ins(Nodo n,int v){ if(n==null)return new Nodo(v); if(v<n.v)n.i=ins(n.i,v); else if(v>n.v)n.d=ins(n.d,v); return n; }

        public boolean buscar(int v){ return find(r,v)!=null; }
        private Nodo find(Nodo n,int v){ if(n==null||n.v==v) return n; return v<n.v?find(n.i,v):find(n.d,v); }

        public void eliminar(int v){ r = del(r,v); }
        private Nodo del(Nodo n,int v){
            if(n==null) return null;
            if(v<n.v) n.i = del(n.i,v);
            else if(v>n.v) n.d = del(n.d,v);
            else {
                // caso 0/1 hijo
                if(n.i==null) return n.d;
                if(n.d==null) return n.i;
                // caso 2 hijos: sucesor
                Nodo s = n.d;
                while(s.i!=null) s = s.i;
                n.v = s.v;
                n.d = del(n.d, s.v);
            }
            return n;
        }
        public List<Integer> in(){ List<Integer> r=new ArrayList<>(); in(r,this.r); return r; }
        private void in(List<Integer> a, Nodo n){ if(n==null)return; in(a,n.i); a.add(n.v); in(a,n.d); }
    }

    // ============= 7) GRAFO: Dijkstra (pesos >=0) y BFS =================
    static class Grafo {
        static class Arista { String to; int w; Arista(String t,int w){this.to=t;this.w=w;} }
        private final Map<String, List<Arista>> g = new HashMap<>();

        public void agregarVertice(String v){ g.putIfAbsent(v, new ArrayList<>()); }
        public void agregarArista(String u, String v, int w){
            agregarVertice(u); agregarVertice(v);
            g.get(u).add(new Arista(v,w));
            g.get(v).add(new Arista(u,w)); // no dirigido (mapa de ciudades)
        }

        // BFS: niveles desde origen
        public List<String> bfs(String origen){
            List<String> orden = new ArrayList<>();
            Set<String> vis = new HashSet<>();
            Deque<String> q = new ArrayDeque<>();
            q.add(origen); vis.add(origen);
            while(!q.isEmpty()){
                String u = q.poll(); orden.add(u);
                for(Arista a: g.getOrDefault(u, List.of())){
                    if(!vis.contains(a.to)){ vis.add(a.to); q.add(a.to); }
                }
            }
            return orden;
        }

        // Dijkstra: ruta más corta (distancias y camino)
        public List<String> dijkstraCamino(String origen, String destino){
            Map<String,Integer> dist = new HashMap<>();
            Map<String,String> padre = new HashMap<>();
            PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparingInt(dist::get));
            for(String v: g.keySet()) dist.put(v, Integer.MAX_VALUE);
            dist.put(origen, 0); pq.add(origen);

            while(!pq.isEmpty()){
                String u = pq.poll();
                if(u.equals(destino)) break;
                for(Arista a: g.getOrDefault(u, List.of())){
                    if(dist.get(u)!=Integer.MAX_VALUE && dist.get(u)+a.w < dist.get(a.to)){
                        dist.put(a.to, dist.get(u)+a.w);
                        padre.put(a.to, u);
                        pq.remove(a.to); pq.add(a.to);
                    }
                }
            }
            // reconstruir
            LinkedList<String> camino = new LinkedList<>();
            String cur = destino;
            if(!padre.containsKey(destino) && !origen.equals(destino)) return List.of(); // no conectado
            while(cur!=null){
                camino.addFirst(cur);
                cur = padre.get(cur);
            }
            return camino;
        }
    }

    // ============= 8) Complejidad (texto para imprimir) =================
    static String complejidades() {
        return String.join("\n", List.of(
                "Complejidades (Big-O) resumidas:",
                "- Pila (push/pop/peek): O(1) amortizado.",
                "- PriorityQueue (insert/extraer máx): O(log n).",
                "- HashMap (put/get): O(1) promedio, O(n) peor caso patológico.",
                "- Árbol binario (recorridos): O(n).",
                "- AVL (buscar/insertar/eliminar): O(log n) siempre (balanceado).",
                "- BST (buscar/insertar/eliminar): promedio O(log n), peor O(n) si se desbalancea.",
                "- Grafo BFS: O(V+E).",
                "- Dijkstra con PQ binaria: O((V+E) log V)."
        ));
    }

    // =========================== DEMO ===================================
    public static void main(String[] args) {
        // 1) PILA: Editor
        EditorUndoRedo editor = new EditorUndoRedo();
        editor.escribir("Hola");
        editor.escribir(" Mundo");
        editor.deshacer(); // vuelve a "Hola"
        editor.rehacer();  // "Hola Mundo"

        // 2) COLA con prioridad
        SistemaAtencion sa = new SistemaAtencion();
        sa.llegar("Ana", 1);
        sa.llegar("Luis", 3);
        sa.llegar("Marta", 2);
        Paciente atendido1 = sa.atender(); // Luis

        // 3) Usuarios únicos
        UsuariosUnicos uu = new UsuariosUnicos();
        uu.registrar(101, "Sofía");
        uu.registrar(102, "Carlos");
        boolean repetido = uu.registrar(101, "OtraSofía"); // false

        // 4) Árbol Binario (usamos ints para recorridos)
        ArbolBinario ab = new ArbolBinario();
        for(int v : new int[]{7,4,9,2,5,8,11}) ab.insertar(v);

        // 5) AVL: inserciones que fuerzan rotaciones
        AVL avl = new AVL();
        for(int v : new int[]{30,20,10,25,28,27}) avl.insertar(v); // provoca LL y LR

        // 6) BST: ops completas
        BST bst = new BST();
        for(int v : new int[]{15,10,20,8,12,17,25}) bst.insertar(v);
        boolean existe12 = bst.buscar(12); // true
        bst.eliminar(10); // elimina nodo con 2 hijos

        // 7) Grafo: mapa de ciudades (no dirigido)
        Grafo g = new Grafo();
        g.agregarArista("A", "B", 4);
        g.agregarArista("A", "C", 2);
        g.agregarArista("C", "B", 1);
        g.agregarArista("B", "D", 5);
        g.agregarArista("C", "D", 8);
        g.agregarArista("D", "E", 3);

        List<String> bfs = g.bfs("A");
        List<String> camino = g.dijkstraCamino("A","E");

        // ================== SALIDAS PARA CAPTURAS ==================
        System.out.println("=== 1) Editor Deshacer/Rehacer ===");
        System.out.println("Texto final: " + editor.getTexto());

        System.out.println("\n=== 2) Sistema de Atención (PriorityQueue) ===");
        System.out.println("Atendido primero: " + atendido1);
        System.out.println("En cola restante: " + sa.enCola());

        System.out.println("\n=== 3) Usuarios únicos (HashMap) ===");
        System.out.println("Registro repetido (ID=101) aceptado? " + repetido);
        System.out.println("Usuarios:");
        for(var e : uu.entradas()) System.out.println("  " + e.getKey() + " -> " + e.getValue());

        System.out.println("\n=== 4) Árbol Binario: recorridos ===");
        System.out.println("In-orden:  " + ab.inOrden());
        System.out.println("Pre-orden: " + ab.preOrden());
        System.out.println("Post-orden:" + ab.postOrden());

        System.out.println("\n=== 5) AVL: inserciones y rotaciones detectadas ===");
        System.out.println("In-orden AVL: " + avl.inOrden());
        System.out.println("Rotaciones ocurridas: " + avl.rotaciones);

        System.out.println("\n=== 6) BST: búsqueda/insert/eliminar ===");
        System.out.println("BST contiene 12? " + existe12);
        System.out.println("BST in-orden (tras eliminar 10): " + bst.in());

        System.out.println("\n=== 7) Grafo: BFS y Dijkstra ===");
        System.out.println("BFS desde A: " + bfs);
        System.out.println("Camino más corto A->E (Dijkstra): " + camino);

        System.out.println("\n=== 8) Complejidad ===");
        System.out.println(complejidades());
    }
}
