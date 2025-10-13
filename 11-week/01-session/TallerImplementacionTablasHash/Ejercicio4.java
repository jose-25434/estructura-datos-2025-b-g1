public class Ejercicio4 {
    public static void main(String[] args) {
        HashTable<Integer, String> tabla = new HashTable<Integer, String>();
        int n = 1200;

        for (int i = 0; i < n; i++) tabla.put(i, "val" + i);

        System.out.println("Insertados: " + n);
        System.out.println("size() = " + tabla.size());
        System.out.println("isEmpty() = " + tabla.isEmpty());
        System.out.println("get(123) = " + tabla.get(123));
        System.out.println("remove(123) = " + tabla.remove(123));
        System.out.println("size() tras remove = " + tabla.size());
        System.out.println("buckets (capacidad interna) = " + tabla.bucketCount());
    }
}
