class HashMap<K, V> {

    private Entry<K, V>[] buckets;
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 16;

    public HashMap() {
        this(DEFAULT_CAPACITY);
    }

    public HashMap(int capacity) {
        this.buckets = new Entry[capacity];
    }

    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value, null);
        int bucket = getHash(key) % getBucketSize();
        Entry<K, V> existingEntry = buckets[bucket];
        if (existingEntry == null) {
            buckets[bucket] = entry;
            size++;
        } else {
            while (existingEntry.next != null) {
                if (existingEntry.key.equals(key)) {
                    existingEntry.value = value;
                    return;
                } 
                existingEntry = existingEntry.next;
            }
            if (existingEntry.key.equals(key)) existing.value = value;
            else {
                existing.next = entry;
                size++;
            }
        }
    }

    public V get(K key) {
        Entry<K, V> bucket = buckets[getHash(key) % getBucketSize()];
        while (bucket != null) {
            if (bucket.key.equals(key)) return bucket.value;
            bucket = bucket.next;
        }
        return null;
    }

    private int getBucketSize() {
        return buckets.length;
    }  

    private int getHash(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    // an entry is a linked list
    class Entry<K, V> {
        final K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }
}