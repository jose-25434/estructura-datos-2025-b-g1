// Fecha: 2025-09-09 | Versión: 4.0 | Autor: Jose Gabriel David Mendez Roncancio
public class Ejercicio3 {
    public static void main(String[] args) {
        ListaSimple ls = new ListaSimple();
        for (int v : new int[]{1,2,3,4}) ls.insertarFinal(v);
        ls.mostrar();
        System.out.println("Eliminar pos 2: " + ls.eliminarEnPosicion(2));
        System.out.println("Eliminar pos 10 (inválida): " + ls.eliminarEnPosicion(10));
        ls.mostrar();
    }
}
