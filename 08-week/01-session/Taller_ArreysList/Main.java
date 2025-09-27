import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Figuras> listaFiguras = new ArrayList<>();

        // Crear y agregar figuras
        listaFiguras.add(new Circulo(6.0, "C1"));
        listaFiguras.add(new Circulo(2.8, "C2"));
        listaFiguras.add(new Rectangulo(8.0, 3.5, "R1"));
        listaFiguras.add(new Rectangulo(4.2, 4.2, "R2"));
        listaFiguras.add(new Triangulo(7.0, 5.0, 4.0, "T1"));
        listaFiguras.add(new Triangulo(9.0, 9.0, 5.0, "T2"));

        // Recorrer el ArrayList
        for (Figuras figura : listaFiguras) {
            figura.mostrarInformacion();
        }
    }
}
