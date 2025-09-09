// Fecha: 2025-09-09 | Versión: 4.0 | Autor: Jose Gabriel David Mendez Roncancio
public class Ejercicio4 {
    public static void main(String[] args) {
        ListaDoble ld = new ListaDoble();
        ld.insertarInicio(2);
        ld.insertarFinal(3);
        ld.insertarInicio(1);
        ld.mostrar(); // 1 <-> 2 <-> 3
        ld.eliminarInicio();
        ld.eliminarFinal();
        ld.mostrar(); // 2
    }
}
