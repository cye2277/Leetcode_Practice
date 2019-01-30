public class MyHashMap<K,V> {

    public static void main(String[] args) {
        MyHashMap<String, String> myMap = new MyHashMap<>();
        myMap.put("USA", "Washington DC");
        myMap.put("Nepal", "Kathmandu");
        myMap.put("India", "New Delhi");
        myMap.put("Australia", "Sydney");
        System.out.println(myMap.size);
        System.out.println(myMap.get("Nepal"));
        System.out.println(myMap.get("Australia"));
        //HashMap hashMap = new HashMap();
    }
    private Entry<K,V>[] buckets ;
    private static final int INITIAL_CAPACITY = 1<<4; //16
    private int size = 0;

    /** Initialize your data structure here. */
    public MyHashMap() {
        this(INITIAL_CAPACITY);
    }
    public MyHashMap(int capacity){
        this.buckets = new Entry[capacity];
    }

    public class Entry<K,V>{
        final K id;
        V value;
        Entry<K,V> next;

        public Entry(K id, V value){
            this.id = id;
            this.value = value;
        }

    }

    /** value will always be non-negative. */
    public void put(K key, V value) {
        Entry<K,V> entry = new Entry<>(key, value);
        int bucket = getHash(key) % getBucketSize();

        Entry existing = buckets[bucket];
        if (existing == null){
            buckets[bucket] = entry;
            size++;
        }else{
            while (existing.next != null){
                if (existing.id == entry.id){
                    existing.value = value;
                    return;
                }
                existing = existing.next;
            }
            if (existing.id == entry.id){
                existing.value = value;
            }else{
                existing.next = entry;
                size++;
            }

        }


    }
    public int getHash(K key){
        return key.hashCode();
    }

    public int getBucketSize(){
        return buckets.length;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public V get(K key) {
        int bucket = getHash(key) % getBucketSize();
        Entry existing = buckets[bucket];
        while (existing != null){
            if (existing.id == key){
                return (V) existing.value;
            }
            existing = existing.next;
        }
        return null;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(K key) {
        int bucket = getHash(key) % getBucketSize();
        Entry existing = buckets[bucket];
        Entry prev = null;
        if (existing == null){
            return;
        }
        if (existing.id == key){
            existing.next = null;
        }
        while (existing.next != null){
            prev = existing;
            existing = existing.next;
            if (existing.id == key){
                prev.next = existing.next;
            }


        }
    }
}
