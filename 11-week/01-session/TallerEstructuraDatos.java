import java.util.ArrayList;
import java.util.Scanner;

public class TallerEstructuraDatos{

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        // ArrayList dinámico para los artículos (productos)
        ArrayList<String> inventario = new ArrayList<>();

        // Arreglo fijo para las categorías
        String[] rubros = {"Electrónica", "Ferretería", "Limpieza", "Bebidas", "Confitería"};

        int opcion;
        do {
            System.out.println("\n=== PANEL DE GESTIÓN - MERCADITO ===");
            System.out.println("1) Registrar artículo");
            System.out.println("2) Ver inventario");
            System.out.println("3) Quitar artículo");
            System.out.println("4) Ver rubros (categorías)");
            System.out.println("0) Salir");
            System.out.print("Elija una opción: ");

            // Control de opción no numérica
            while (!teclado.hasNextInt()) {
                System.out.print("Entrada inválida. Elija una opción numérica: ");
                teclado.next(); // descarta lo ingresado
            }
            opcion = teclado.nextInt();
            teclado.nextLine(); // limpia salto de línea

            switch (opcion) {
                case 1 -> {
                    System.out.print("Nombre del artículo a registrar: ");
                    String nuevo = teclado.nextLine().trim();

                    if (nuevo.isEmpty()) {
                        System.out.println("El nombre no puede estar vacío.");
                    } else {
                        // Evitar duplicados exactos (ignorando mayúsculas/minúsculas)
                        boolean existe = false;
                        for (String a : inventario) {
                            if (a.equalsIgnoreCase(nuevo)) {
                                existe = true;
                                break;
                            }
                        }
                        if (existe) {
                            System.out.println("Ya existe un artículo con ese nombre.");
                        } else {
                            inventario.add(nuevo);
                            System.out.println("Artículo registrado correctamente.");
                        }
                    }
                }

                case 2 -> {
                    if (inventario.isEmpty()) {
                        System.out.println("Inventario vacío. Aún no hay artículos.");
                    } else {
                        System.out.println("\nListado de artículos:");
                        for (int i = 0; i < inventario.size(); i++) {
                            System.out.println((i + 1) + ". " + inventario.get(i));
                        }
                    }
                }

                case 3 -> {
                    if (inventario.isEmpty()) {
                        System.out.println("No hay artículos para quitar.");
                    } else {
                        System.out.println("Puede escribir el NOMBRE del artículo a quitar.");
                        System.out.print("Artículo a quitar: ");
                        String objetivo = teclado.nextLine().trim();

                        if (objetivo.isEmpty()) {
                            System.out.println("El nombre no puede estar vacío.");
                        } else {
                            // Buscar por nombre (ignorando mayúsculas/minúsculas)
                            int indice = -1;
                            for (int i = 0; i < inventario.size(); i++) {
                                if (inventario.get(i).equalsIgnoreCase(objetivo)) {
                                    indice = i;
                                    break;
                                }
                            }
                            if (indice == -1) {
                                System.out.println("No se encontró el artículo en el inventario.");
                            } else {
                                String quitado = inventario.remove(indice);
                                System.out.println("Se quitó: " + quitado);
                            }
                        }
                    }
                }

                case 4 -> {
                    System.out.println("Rubros disponibles:");
                    for (String r : rubros) {
                        System.out.println("- " + r);
                    }
                }

                case 0 -> System.out.println("Cerrando el panel. ¡Hasta pronto!");

                default -> System.out.println("Opción fuera de rango. Intente nuevamente.");
            }

        } while (opcion != 0);

        teclado.close();
    }
}