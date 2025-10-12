// Fecha: 2025-09-09 | Versión: 3.1 | Autor: Tu Nombre
public class Ejercicio5 {
    public static void main(String[] args) {
        ListaCircular lc = new ListaCircular();
        lc.agregarFinal(10);
        lc.agregarFinal(20);
        lc.agregarFinal(30);
        lc.imprimir();
        lc.eliminarValor(20);
        lc.imprimir();
    }
}