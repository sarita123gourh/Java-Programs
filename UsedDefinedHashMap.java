import java.util.Objects;

class CustomHashMap<K, V> {
    private static final int DEFAULT_CAPACITY = 16; // Default size of HashMap
    private Entry<K, V>[] buckets;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        buckets = new Entry[DEFAULT_CAPACITY]; // Create an array of Entry objects
    }

    private static class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next; // Linked list for collision handling

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    private int getBucketIndex(K key) {
        return key == null ? 0 : Math.abs(key.hashCode() % buckets.length);
    }

    public void put(K key, V value) {
        int index = getBucketIndex(key);
        Entry<K, V> newEntry = new Entry<>(key, value);

        if (buckets[index] == null) {
            buckets[index] = newEntry; // Directly insert if the bucket is empty
        } else {
            Entry<K, V> current = buckets[index];

            while (true) {
                if (Objects.equals(current.key, key)) {
                    current.value = value; // Update value if key already exists
                    return;
                }
                if (current.next == null) {
                    break;
                }
                current = current.next;
            }
            current.next = newEntry; // Add new entry to the linked list (collision handling)
        }
        size++;
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        Entry<K, V> current = buckets[index];

        while (current != null) {
            if (Objects.equals(current.key, key)) {
                return current.value; // Return value if key matches
            }
            current = current.next;
        }
        return null; // Key not found
    }

    public boolean remove(K key) {
        int index = getBucketIndex(key);
        Entry<K, V> current = buckets[index];
        Entry<K, V> prev = null;

        while (current != null) {
            if (Objects.equals(current.key, key)) {
                if (prev == null) {
                    buckets[index] = current.next; // Remove first node in chain
                } else {
                    prev.next = current.next; // Bypass the node
                }
                size--;
                return true;
            }
            prev = current;
            current = current.next;
        }
        return false; // Key not found
    }

    public int size() {
        return size;
    }

    public void display() {
        for (int i = 0; i < buckets.length; i++) {
            Entry<K, V> current = buckets[i];
            if (current != null) {
                System.out.print("Bucket " + i + ": ");
                while (current != null) {
                    System.out.print("[" + current.key + "=" + current.value + "] -> ");
                    current = current.next;
                }
                System.out.println("null");
            }
        }
    }
}

public class CustomHashMapTest {
    public static void main(String[] args) {
        CustomHashMap<String, Integer> map = new CustomHashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 3);
        map.put("D", 4);
        map.put("A", 5); // Update key "A"

        System.out.println("Value for key A: " + map.get("A"));
        System.out.println("Value for key C: " + map.get("C"));

        map.remove("B");
        System.out.println("Value for key B after removal: " + map.get("B"));

        System.out.println("Size: " + map.size());
        map.display();
    }
}
