// Fecha: 2025-09-09 | Versión: 4.0 | Autor: Jose Gabriel David Mendez Roncancio
public class Ejercicio2 {
    public static void main(String[] args) {
        ListaSimple ls = new ListaSimple();
        ls.insertarEnPosicion(5, 0);
        ls.insertarEnPosicion(10, 1);
        ls.insertarEnPosicion(7, 1);
        ls.mostrar(); // 5 -> 7 -> 10
    }
}
