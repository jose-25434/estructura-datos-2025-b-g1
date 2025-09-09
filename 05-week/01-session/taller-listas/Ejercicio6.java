// Fecha: 2025-09-09 | Versión: 4.0 | Autor: Jose Gabriel David Mendez Roncancio
public class Ejercicio6 {
    public static void main(String[] args) {
        ListaSimple cola = new ListaSimple();
        cola.insertarFinal(101);
        cola.insertarFinal(102);
        cola.insertarFinal(103);
        cola.mostrar();
        cola.eliminarEnPosicion(0); // atender primero
        cola.mostrar();
    }
}
