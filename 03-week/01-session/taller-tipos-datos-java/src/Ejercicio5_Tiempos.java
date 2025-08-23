public class Ejercicio5_Tiempos{
    public static void main(String[] args) {
        // Datos actualizados
        String[] listaTiempos = {"01:15:20", "00:45:10", "02:10:05", "00:30:30"};

        long[] tiempoEnSegundos = new long[listaTiempos.length];
        long acumulado = 0;

        // Convertir cada tiempo a segundos
        for (int i = 0; i < listaTiempos.length; i++) {
            String[] partes = listaTiempos[i].split(":");
            int horas = Integer.parseInt(partes[0]);
            int minutos = Integer.parseInt(partes[1]);
            int segundos = Integer.parseInt(partes[2]);

            tiempoEnSegundos[i] = horas * 3600 + minutos * 60 + segundos;
            acumulado += tiempoEnSegundos[i];
        }

        // Cálculo del promedio
        double promedio = (double) acumulado / listaTiempos.length;

        // Encontrar el tramo más largo
        long masLargo = tiempoEnSegundos[0];
        int indiceMasLargo = 0;
        for (int i = 1; i < tiempoEnSegundos.length; i++) {
            if (tiempoEnSegundos[i] > masLargo) {
                masLargo = tiempoEnSegundos[i];
                indiceMasLargo = i;
            }
        }

        // Mostrar resultados
        System.out.println("Tiempo acumulado: " + formatoHora(acumulado));
        System.out.println("Duración promedio: " + formatoHora((long) promedio));
        System.out.println("Mayor duración registrada: " + listaTiempos[indiceMasLargo]);

        // Mostrar porcentajes
        System.out.println("\nParticipación de cada tramo:");
        for (int i = 0; i < tiempoEnSegundos.length; i++) {
            double porcentaje = (tiempoEnSegundos[i] * 100.0) / acumulado;
            System.out.printf("%s -> %.2f%%\n", listaTiempos[i], porcentaje);
        }
    }

    // Método para convertir segundos en formato HH:MM:SS
    private static String formatoHora(long totalSegundos) {
        long horas = totalSegundos / 3600;
        long minutos = (totalSegundos % 3600) / 60;
        long segundos = totalSegundos % 60;
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }
}

