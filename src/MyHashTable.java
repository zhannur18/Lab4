public class MyHashTable<K, V> {
    private class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "{" + key + " " + value + "}";
        }
    }

    private HashNode<K, V>[] chainArray;
    private int M = 11;
    private int size;
    //creating hash tables with default or specified capacity.
    public MyHashTable() {
        chainArray = new HashNode[M];
    }

    public MyHashTable(int M) {
        this.M = M;
        chainArray = new HashNode[M];
    }
    private int hash(K key) {//private hash function to map keys to an index in the hash table array
        return Math.abs(key.hashCode()) % M;
    }
//public method to insert a key-value pair into the hash table
public void put(K key, V value) {
    int index = hash(key);
    HashNode<K, V> node = new HashNode<>(key, value);
    // If the bucket at the index is empty, store the new node.
    if (chainArray[index] == null) {
        chainArray[index] = node;
    } else {
        // If the bucket already has one or more nodes, search for the key.
        HashNode<K, V> current = chainArray[index];
        while (current.next != null) {
            if (current.key.equals(key)) {
                // If the key is found, update the corresponding value.
                current.value = value;
                return;
            }
            current = current.next;
        }
        if (current.key.equals(key)) {
            // If the key is found at the end of the chain, update the corresponding value.
            current.value = value;
        } else {
            // If the key is not found, append the new node to the end of the chain.
            current.next = node;
        }
    }
    size++;
}


}