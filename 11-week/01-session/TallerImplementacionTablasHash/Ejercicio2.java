import java.util.Scanner;

public class Ejercicio2 {
    public static void main(String[] args) {
        HashTable<String, Integer> cont = new HashTable<String, Integer>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Escribe un texto:");
        String linea = sc.nextLine();

        String[] palabras = linea.split("\\W+");
        for (String p : palabras) {
            if (p.isEmpty()) continue;
            String w = p.toLowerCase();
            Integer c = cont.get(w);
            cont.put(w, c == null ? 1 : c + 1);
        }

        System.out.println("Palabras distintas: " + cont.size());
        System.out.println("Ejemplo: 'java' → " + cont.get("java"));
        sc.close();
    }
}
