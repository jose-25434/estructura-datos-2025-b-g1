 Clase GestorRentas:
 Implementa lista simple de rentas activas.
 Complejidad:
 - Insertar/Eliminar: O(n)
 - Recorrer: O(n)
*/
public class GestorRentas {
    Renta inicio;

    public void registrarRenta(int id, String usuario) {
        Renta nuevo = new Renta(id, usuario);
        if (inicio == null) {
            inicio = nuevo;
        } else {
            Renta temp = inicio;
            while (temp.siguiente != null) {
                temp = temp.siguiente;
            }
            temp.siguiente = nuevo;
        }
    }

    public boolean devolverRenta(int id, String usuario) {
        Renta temp = inicio;
        Renta anterior = null;

        while (temp != null) {
            if (temp.idPublicacion == id && temp.usuario.equals(usuario) && !temp.devuelto) {
                temp.devuelto = true;
                if (anterior == null) {
                    inicio = temp.siguiente;
                } else {
                    anterior.siguiente = temp.siguiente;
                }
                return true;
            }
            anterior = temp;
            temp = temp.siguiente;
        }
        return false;
    }

    public void listarRentas() {
        System.out.println("\n--- Rentas activas ---");
        Renta temp = inicio;
        while (temp != null) {
            if (!temp.devuelto) {
                System.out.println("Publicación: " + temp.idPublicacion + " | Usuario: " + temp.usuario);
            }
            temp = temp.siguiente;
        }
    }
}