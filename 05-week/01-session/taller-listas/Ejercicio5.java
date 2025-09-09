// Fecha: 2025-09-09 | Versión: 4.0 | Autor: Jose Gabriel David Mendez Roncancio
public class Ejercicio5 {
    public static void main(String[] args) {
        ListaCircular lc = new ListaCircular();
        lc.insertarFinal(10);
        lc.insertarFinal(20);
        lc.insertarFinal(30);
        lc.mostrar();
        lc.eliminarValor(20);
        lc.mostrar();
    }
}
