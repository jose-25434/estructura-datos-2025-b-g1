public class Triangulo implements Figuras {
    private double lado1;
    private double lado2;
    private double lado3;
    private String nombre;

    public Triangulo(double lado1, double lado2, double lado3, String nombre) {
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
        this.nombre = nombre;
    }

    @Override
    public double calcularArea() {
        double s = (lado1 + lado2 + lado3) / 2;
        return Math.sqrt(s * (s - lado1) * (s - lado2) * (s - lado3));
    }

    @Override
    public double calcularPerimetro() {
        return lado1 + lado2 + lado3;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Triángulo [" + nombre + "] - lados: (" + lado1 + ", " + lado2 + ", " + lado3 + ")" +
                ", área: " + String.format("%.2f", calcularArea()) +
                ", perímetro: " + String.format("%.2f", calcularPerimetro()));
    }
}
