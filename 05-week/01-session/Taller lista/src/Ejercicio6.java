// Fecha: 2025-09-09 | Versión: 3.1 | Autor: Tu Nombre
public class Ejercicio6 {
    public static void main(String[] args) {
        ListaSimple cola = new ListaSimple();
        cola.agregarFinal(101);
        cola.agregarFinal(102);
        cola.agregarFinal(103);
        cola.imprimir();
        cola.eliminarEn(0);
        cola.imprimir();
    }
}