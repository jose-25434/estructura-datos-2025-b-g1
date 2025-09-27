public class Rectangulo implements Figuras {
    private double ancho;
    private double alto;
    private String nombre;

    public Rectangulo(double ancho, double alto, String nombre) {
        this.ancho = ancho;
        this.alto = alto;
        this.nombre = nombre;
    }

    @Override
    public double calcularArea() {
        return ancho * alto;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * (ancho + alto);
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Rectángulo [" + nombre + "] - ancho: " + ancho + ", alto: " + alto +
                ", área: " + String.format("%.2f", calcularArea()) +
                ", perímetro: " + String.format("%.2f", calcularPerimetro()));
    }
}
