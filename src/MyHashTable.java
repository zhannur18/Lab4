import java.util.Objects;
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
    // public method to retrieve a value from the hash table by its key.
    public V get(K key) {
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        while (current != null) {
            if (current.key.equals(key)) {
                // If the key is found, return the corresponding value.
                return current.value;
            }
            current = current.next;
        }
        // If the key is not found, return null.
        return null;
    }
    public V remove(K key) { //removes a key-value pair from the hash table based on a given key
        int index = hash(key);
        HashNode<K, V> current = chainArray[index];
        // Keep track of the previous node as we iterate through the list
        HashNode<K, V> prev = null;
        while (current != null) {
            if (current.key.equals(key)) {
                // If this is the head node, update the head of the linked list
                if (prev == null) {
                    chainArray[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                size--;
                // Return the value of the removed node
                return current.value;
            }
            // Update the previous and current pointers
            prev = current;
            current = current.next;
        }
        return null;
    }

    public boolean contains(V value) {//returns true if the hash table contains a given value
    for (int i = 0; i < M; i++) {
        HashNode<K, V> current = chainArray[i];
        while (current != null) {
            // If the value of this node matches the target value, return true
            if (Objects.equals(current.value, value)) {
                return true;
            }
            // Move to the next node in the linked list
            current = current.next;
        }
    }
    return false;
}
    public K getKey(V value) {//returns the key of the node with the given value
        // Iterate through each linked list in the hash table
        for (int i = 0; i < M; i++) {
            HashNode<K, V> current = chainArray[i];
            while (current != null) {
                // If the value of this node matches the target value, return the key
                if (Objects.equals(current.value, value)) {
                    return current.key;
                }
                current = current.next;
            }
        }
        return null;
    }

}