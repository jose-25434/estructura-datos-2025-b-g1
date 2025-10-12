// Fecha: 2025-09-09 | Versión: 3.1 | Autor: Tu Nombre
public class Ejercicio3 {
    public static void main(String[] args) {
        ListaSimple ls = new ListaSimple();
        for (int x : new int[]{1,2,3,4}) ls.agregarFinal(x);
        ls.imprimir();
        System.out.println("Eliminar idx 2: " + ls.eliminarEn(2));
        System.out.println("Eliminar idx 10 (inválido): " + ls.eliminarEn(10));
        ls.imprimir();
        System.out.println("Eliminar inicio: " + ls.eliminarInicio());
        System.out.println("Eliminar final: " + ls.eliminarFinal());
        ls.imprimir();
    }
}