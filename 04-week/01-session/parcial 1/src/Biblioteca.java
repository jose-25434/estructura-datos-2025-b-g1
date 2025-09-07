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
        System.arraycopy(sucursales, 0, existencias[total], 0, sucursales.length);
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
