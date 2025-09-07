Clase Biblioteca:
 Administra publicaciones usando un array fijo y una matriz 2D para sucursales.
 Complejidad:
 - Alta/Baja/Búsqueda: O(n)
 - Modificar stock: O(1)
*/
public class Biblioteca {
    Publicacion[] publicaciones;
    int[][] existencias;
    int max;
    int total;

    public Biblioteca(int max, int sucursales) {
        this.max = max;
        publicaciones = new Publicacion[max];
        existencias = new int[max][sucursales];
        total = 0;
    }

    public boolean agregarPublicacion(Publicacion p, int[] sucursales) {
        if (total >= max) return false;

        // evitar duplicados
        for (int i = 0; i < total; i++) {
            if (publicaciones[i] != null && publicaciones[i].id == p.id && publicaciones[i].activo) {
                return false;
            }
        }

        publicaciones[total] = p;
        for (int j = 0; j < sucursales.length; j++) {
            existencias[total][j] = sucursales[j];
        }
        total++;
        return true;
    }

    public boolean quitarPublicacion(int id) {
        for (int i = 0; i < total; i++) {
            if (publicaciones[i] != null && publicaciones[i].id == id && publicaciones[i].activo) {
                publicaciones[i].activo = false;
                return true;
            }
        }
        return false;
    }

    public Publicacion buscarPorTitulo(String t) {
        for (int i = 0; i < total; i++) {
            if (publicaciones[i] != null && publicaciones[i].activo &&
                publicaciones[i].titulo.equalsIgnoreCase(t)) {
                return publicaciones[i];
            }
        }
        return null;
    }

    public Publicacion buscarPorId(int id) {
        for (int i = 0; i < total; i++) {
            if (publicaciones[i] != null && publicaciones[i].id == id && publicaciones[i].activo) {
                return publicaciones[i];
            }
        }
        return null;
    }

    public boolean modificarStock(int id, int nuevoStock) {
        for (int i = 0; i < total; i++) {
            if (publicaciones[i] != null && publicaciones[i].id == id && publicaciones[i].activo) {
                publicaciones[i].stock = nuevoStock;
                return true;
            }
        }
        return false;
    }

    public void mostrarBiblioteca() {
        System.out.println("\n=== Catálogo de Publicaciones ===");
        for (int i = 0; i < total; i++) {
            if (publicaciones[i] != null && publicaciones[i].activo) {
                System.out.println(publicaciones[i]);
            }
        }
    }
}