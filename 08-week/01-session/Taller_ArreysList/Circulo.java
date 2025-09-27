public class Circulo implements Figuras {
    private double radio;
    private String nombre;

    public Circulo(double radio, String nombre) {
        this.radio = radio;
        this.nombre = nombre;
    }

    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }

    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Círculo [" + nombre + "] - radio: " + radio +
                ", área: " + String.format("%.2f", calcularArea()) +
                ", perímetro: " + String.format("%.2f", calcularPerimetro()));
    }
}
