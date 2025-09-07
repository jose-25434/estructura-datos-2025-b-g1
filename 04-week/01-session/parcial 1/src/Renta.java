public class Renta {
    int idPublicacion;
    String usuario;
    boolean devuelto;
    Renta siguiente;

    public Renta(int id, String u) {
        idPublicacion = id;
        usuario = u;
        devuelto = false;
        siguiente = null;
    }
}