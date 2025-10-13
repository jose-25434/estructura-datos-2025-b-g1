public class Ejercicio3 {

    static final class ClaveColision {
        final String id;
        ClaveColision(String id) { this.id = id; }
        @Override public int hashCode() { return 42; } // fuerza colisión
        @Override public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof ClaveColision)) return false;
            ClaveColision c = (ClaveColision) o;
            return id.equals(c.id);
        }
        public String toString() { return id; }
    }

    public static void main(String[] args) {
        HashTable<ClaveColision, Integer> tabla = new HashTable<ClaveColision, Integer>();

        for (int i = 1; i <= 5; i++) tabla.put(new ClaveColision("c" + i), i);

        System.out.println("get(c3) = " + tabla.get(new ClaveColision("c3")));
        System.out.println("size = " + tabla.size());
        System.out.println("remove(c2) = " + tabla.remove(new ClaveColision("c2")));
        System.out.println("size = " + tabla.size());
        System.out.println("buckets = " + tabla.bucketCount());
    }
}
