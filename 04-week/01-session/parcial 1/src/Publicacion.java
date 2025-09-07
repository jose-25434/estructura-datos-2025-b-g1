public class Publicacion {
    int id;
    String titulo;
    String autor;
    int stock;
    boolean activo;

    public Publicacion(int id, String titulo, String autor, int stock) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.stock = stock;
        this.activo = true;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Título: " + titulo + " | Autor: " + autor +
               " | Ejemplares: " + stock + " | Activo: " + activo;
    }
}