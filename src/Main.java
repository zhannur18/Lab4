
public class Main {
    public static void main(String[] args) {
        MyHashTable<Object, Object> table;
        table = new MyHashTable<Object, Object>();

        // Adding 10000 random elements to the hashtable
        for (int i = 0; i < 10000; i++) {
            MyTestingClass key = new MyTestingClass();
            Test value = new Test();
            table.put(key, value);
        }

        // Printing the number of elements in each bucket
        table.printBucketSizes();

    }

    private static class Test {
        // Test class for testing purposes
    }

    }

