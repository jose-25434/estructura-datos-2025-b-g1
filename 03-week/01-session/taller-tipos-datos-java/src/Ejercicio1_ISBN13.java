public class Ejercicio1_ISBN13 {
    public static boolean isVsalidISBN13(String isbn) {
        if (isbn == null || isbn.length() != 13) return false;
        int suma = 0;
        for (int i = 0; i < isbn.length(); i++){
            char c = isbn.charAt(i);
            if (!Character.isDigit(c)) return false;
            int d = c - '0';
            suma += d * (i % 2 == 0 ? 1 : 3);
        }
        return suma % 10 == 0;
    }

    public static void main(String[] args) {
        String prueba = "9780306406157";
        System.out.println ("ISBN válido?" + isVsalidISBN13(prueba) );

    }
}