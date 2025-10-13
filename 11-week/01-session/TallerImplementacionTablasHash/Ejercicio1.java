import java.util.Scanner;

public class Ejercicio1 {
    public static void main(String[] args) {
        HashTable<String, String> dic = new HashTable<String, String>();
        Scanner sc = new Scanner(System.in);
        int op;

        do {
            System.out.println("\n=== Diccionario usuario → rol ===");
            System.out.println("1) Agregar/Actualizar");
            System.out.println("2) Consultar");
            System.out.println("3) Eliminar");
            System.out.println("4) Estado");
            System.out.println("0) Salir");
            System.out.print("Opción: ");

            while (!sc.hasNextInt()) { sc.next(); System.out.print("Número: "); }
            op = sc.nextInt(); sc.nextLine();

            switch (op) {
                case 1:
                    System.out.print("Usuario: ");
                    String u = sc.nextLine().trim();
                    System.out.print("Rol: ");
                    String rol = sc.nextLine().trim();
                    String prev = dic.put(u, rol);
                    System.out.println(prev == null ? "Guardado." : "Actualizado (antes: " + prev + ").");
                    break;
                case 2:
                    System.out.print("Usuario: ");
                    String q = sc.nextLine().trim();
                    String r = dic.get(q);
                    System.out.println(r == null ? "No existe." : "Rol: " + r);
                    break;
                case 3:
                    System.out.print("Usuario: ");
                    String del = sc.nextLine().trim();
                    String out = dic.remove(del);
                    System.out.println(out == null ? "No existía." : "Eliminado rol=" + out);
                    break;
                case 4:
                    System.out.println("size=" + dic.size() + " | isEmpty=" + dic.isEmpty()
                            + " | buckets=" + dic.bucketCount());
                    break;
                case 0:
                    System.out.println("Fin.");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (op != 0);

        sc.close();
    }
}
