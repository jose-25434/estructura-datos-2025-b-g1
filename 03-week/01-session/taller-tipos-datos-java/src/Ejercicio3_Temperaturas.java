public class Ejercicio3_Temperaturas {
    public static void main(String[] args) {
        // Cadena de temperaturas
        String datos = "18.5, 20.1, 19.8, 22.4, 21.0, 23.7";

        // Separar valores y convertir a arreglo de double
        String[] partes = datos.split(",");
        double[] temperaturas = new double[partes.length];
        for (int i = 0; i < partes.length; i++) {
            temperaturas[i] = Double.parseDouble(partes[i].trim());
        }

        // Llamar métodos auxiliares
        double tempMin = obtenerMinimo(temperaturas);
        double tempMax = obtenerMaximo(temperaturas);
        double media = obtenerPromedio(temperaturas);
        double desviacionEstandar = obtenerDesviacion(temperaturas, media);

        // Mostrar resultados
        System.out.printf("Mínima registrada: %.2f\n", tempMin);
        System.out.printf("Máxima registrada: %.2f\n", tempMax);
        System.out.printf("Temperatura media: %.2f\n", media);
        System.out.printf("Desviación estándar: %.2f\n", desviacionEstandar);
    }

    public static double obtenerMinimo(double[] array) {
        double menor = Double.MAX_VALUE;
        for (double valor : array) {
            if (valor < menor) menor = valor;
        }
        return menor;
    }

    public static double obtenerMaximo(double[] array) {
        double mayor = Double.MIN_VALUE;
        for (double valor : array) {
            if (valor > mayor) mayor = valor;
        }
        return mayor;
    }

    public static double obtenerPromedio(double[] array) {
        double suma = 0;
        for (double valor : array) {
            suma += valor;
        }
        return suma / array.length;
    }

    public static double obtenerDesviacion(double[] array, double promedio) {
        double sumaDifCuadrado = 0;
        for (double valor : array) {
            sumaDifCuadrado += Math.pow(valor - promedio, 2);
        }
        return Math.sqrt(sumaDifCuadrado / array.length);
    }
}
