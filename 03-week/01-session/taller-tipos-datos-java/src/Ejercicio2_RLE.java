public class Ejercicio2_RLE {
    public static void main(String[] args) {
        String cadena = "aaabbcccccd";  // Ejemplo de texto
        String rle = comprimirRLE(cadena);

        double ratio = (double) rle.length() / cadena.length();

        System.out.println("Original: " + cadena);
        System.out.println("Comprimido: " + rle);
        System.out.println("Longitud original: " + cadena.length());
        System.out.println("Longitud comprimida: " + rle.length());
        System.out.printf("Ratio de compresión: %.2f\n", ratio);
    }

    // Método que comprime usando RLE (Run-Length Encoding)
    public static String comprimirRLE(String texto) {
        if (texto == null || texto.length() == 0) {
            return "";
        }

        StringBuilder compresion = new StringBuilder();
        int i = 0;

        while (i < texto.length()) {
            char letra = texto.charAt(i);
            int cantidad = 1;

            // Contar cuántas veces se repite el mismo carácter
            while (i + 1 < texto.length() && texto.charAt(i + 1) == letra) {
                cantidad++;
                i++;
            }

            // Agregar carácter y cantidad al resultado
            compresion.append(letra).append(cantidad);
            i++;
        }

        return compresion.toString();
    }
}