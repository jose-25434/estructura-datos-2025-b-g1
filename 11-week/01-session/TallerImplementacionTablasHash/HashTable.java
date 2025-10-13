import java.util.Objects;

public class HashTable<K, V> {
    private static final int DEFAULT_CAPACITY = 16;
    private static final float LOAD_FACTOR = 0.75f;

    private Entry<K, V>[] table;
    private int size;
    private int threshold;

    @SuppressWarnings("unchecked")
    public HashTable() {
        table = (Entry<K, V>[]) new Entry[DEFAULT_CAPACITY];
        threshold = (int) (DEFAULT_CAPACITY * LOAD_FACTOR);
    }

    private int indexFor(Object key, int len) {
        int h = (key == null) ? 0 : key.hashCode();
        h ^= (h >>> 16);
        return h & (len - 1);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    public boolean containsKey(K key) {
        int idx = indexFor(key, table.length);
        for (Entry<K, V> e = table[idx]; e != null; e = e.next) {
            if (Objects.equals(e.key, key)) return true;
        }
        return false;
    }

    public V get(K key) {
        int idx = indexFor(key, table.length);
        for (Entry<K, V> e = table[idx]; e != null; e = e.next) {
            if (Objects.equals(e.key, key)) return e.value;
        }
        return null;
    }

    public V put(K key, V value) {
        if (size + 1 > threshold) resize();

        int idx = indexFor(key, table.length);
        for (Entry<K, V> e = table[idx]; e != null; e = e.next) {
            if (Objects.equals(e.key, key)) {
                V old = e.value;
                e.value = value;
                return old;
            }
        }

        table[idx] = new Entry<K, V>(key, value, table[idx]);
        size++;
        return null;
    }

    public V remove(K key) {
        int idx = indexFor(key, table.length);
        Entry<K, V> prev = null, cur = table[idx];

        while (cur != null) {
            if (Objects.equals(cur.key, key)) {
                if (prev == null) table[idx] = cur.next;
                else prev.next = cur.next;
                size--;
                return cur.value;
            }
            prev = cur;
            cur = cur.next;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private void resize() {
        int newCap = table.length << 1;
        Entry<K, V>[] newTable = (Entry<K, V>[]) new Entry[newCap];

        for (int i = 0; i < table.length; i++) {
            Entry<K, V> node = table[i];
            while (node != null) {
                Entry<K, V> next = node.next;
                int newIdx = indexFor(node.key, newCap);
                node.next = newTable[newIdx];
                newTable[newIdx] = node;
                node = next;
            }
        }
        table = newTable;
        threshold = (int) (newCap * LOAD_FACTOR);
    }

    // Método auxiliar para evidencias
    public int bucketCount() { return table.length; }
}
