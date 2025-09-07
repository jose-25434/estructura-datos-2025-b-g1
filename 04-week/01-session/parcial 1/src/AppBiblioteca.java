import java.util.Scanner;
public class AppBiblioteca {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(5, 3);
        GestorRentas gestor = new GestorRentas();
        Bitacora bitacora = new Bitacora();
        try (Scanner sc = new Scanner(System.in)) {
            int opcion;
            do {
                System.out.println("\n=== MENÚ PRINCIPAL ===");
                System.out.println("1. Agregar publicación");
                System.out.println("2. Quitar publicación");
                System.out.println("3. Buscar por título");
                System.out.println("4. Modificar stock");
                System.out.println("5. Mostrar biblioteca");
                System.out.println("6. Registrar renta");
                System.out.println("7. Registrar devolución");
                System.out.println("8. Ver bitácora adelante");
                System.out.println("9. Ver bitácora atrás");
                System.out.println("10. Salir");
                System.out.print("Opción: ");
                opcion = sc.nextInt();
                sc.nextLine();
                
                switch (opcion) {
                    case 1 -> {
                        System.out.print("ID: ");
                        int id = sc.nextInt(); sc.nextLine();
                        System.out.print("Título: ");
                        String t = sc.nextLine();
                        System.out.print("Autor: ");
                        String a = sc.nextLine();
                        System.out.print("Stock: ");
                        int s = sc.nextInt();
                        
                        Publicacion nueva = new Publicacion(id, t, a, s);
                        int[] dist = new int[3];
                        for (int i = 0; i < dist.length; i++) {
                            System.out.print("Disponibilidad sucursal " + (i + 1) + ": ");
                            dist[i] = sc.nextInt();
                        }
                        
                        if (biblioteca.agregarPublicacion(nueva, dist)) {
                            System.out.println("Publicación agregada.");
                            bitacora.agregar("ALTA", "Publicación " + id + " - " + t);
                        } else {
                            System.out.println("No se pudo agregar.");
                        }
                    }
                    
                    case 2 -> {
                        System.out.print("ID a quitar: ");
                        int idQ = sc.nextInt();
                        if (biblioteca.quitarPublicacion(idQ)) {
                            System.out.println("Publicación quitada.");
                            bitacora.agregar("BAJA", "Publicación " + idQ);
                        } else {
                            System.out.println("No encontrada.");
                        }
                    }
                    
                    case 3 -> {
                        System.out.print("Título a buscar: ");
                        String tb = sc.nextLine();
                        Publicacion r = biblioteca.buscarPorTitulo(tb);
                        if (r != null) {
                            System.out.println(r);
                        } else {
                            System.out.println("No encontrada.");
                        }
                    }
                    
                    case 4 -> {
                        System.out.print("ID: ");
                        int idM = sc.nextInt();
                        System.out.print("Nuevo stock: ");
                        int ns = sc.nextInt();
                        if (biblioteca.modificarStock(idM, ns)) {
                            System.out.println("Stock modificado.");
                            bitacora.agregar("STOCK", "Publicación " + idM + " nuevo stock=" + ns);
                        } else {
                            System.out.println("Error en modificación.");
                        }
                    }
                    
                    case 5 -> biblioteca.mostrarBiblioteca();
                    
                    case 6 -> {
                        System.out.print("ID de publicación: ");
                        int idP = sc.nextInt(); sc.nextLine();
                        System.out.print("Usuario: ");
                        String u = sc.nextLine();
                        
                        Publicacion pub = biblioteca.buscarPorId(idP);
                        if (pub != null && pub.activo && pub.stock > 0) {
                            pub.stock--;
                            gestor.registrarRenta(idP, u);
                            System.out.println("Renta registrada.");
                            bitacora.agregar("RENTA", "Publicación " + idP + " a " + u);
                        } else {
                            System.out.println("No disponible.");
                        }
                    }
                    
                    case 7 -> {
                        System.out.print("ID de publicación: ");
                        int idD = sc.nextInt(); sc.nextLine();
                        System.out.print("Usuario: ");
                        String us = sc.nextLine();
                        
                        if (gestor.devolverRenta(idD, us)) {
                            Publicacion pD = biblioteca.buscarPorId(idD);
                            if (pD != null) pD.stock++;
                            System.out.println("Devolución registrada.");
                            bitacora.agregar("DEVOLUCION", "Publicación " + idD + " de " + us);
                        } else {
                            System.out.println("Renta no encontrada.");
                        }
                    }
                    
                    case 8 -> bitacora.mostrarAdelante();
                    
                    case 9 -> bitacora.mostrarAtras();
                    
                    case 10 -> System.out.println("Saliendo...");
                    
                    default -> System.out.println("Opción inválida.");
                }
            } while (opcion != 10);
        }
    }
}