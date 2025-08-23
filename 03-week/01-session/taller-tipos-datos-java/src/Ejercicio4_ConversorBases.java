public class Ejercicio4_ConversorBases {
    public static void main(String[] args) {
        // Número de ejemplo en base 2
        String numeroOriginal = "1111000011110000";
        int baseEntrada = 2;

        // Preparar número
        numeroOriginal = numeroOriginal.trim().toUpperCase();
        boolean usoBigInteger = false;
        java.math.BigInteger numeroConvertido;

        // Intentar primero con long
        try {
            long valorLong = Long.parseLong(numeroOriginal, baseEntrada);
            numeroConvertido = java.math.BigInteger.valueOf(valorLong);
        } catch (NumberFormatException e) {
            numeroConvertido = new java.math.BigInteger(numeroOriginal, baseEntrada);
            usoBigInteger = true;
        }

        // Generar representaciones en diferentes bases
        String base2 = numeroConvertido.toString(2);
        String base10 = numeroConvertido.toString(10);
        String base16 = numeroConvertido.toString(16).toUpperCase();

        // Mostrar resultados
        System.out.println("Entrada: " + numeroOriginal + " (Base " + baseEntrada + ")");
        System.out.println("Representación en binario: " + base2);
        System.out.println("Representación en decimal: " + base10);
        System.out.println("Representación en hexadecimal: " + base16);
        System.out.println("¿Se utilizó BigInteger?: " + usoBigInteger);
    }
}