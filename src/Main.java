
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
    private static class MyTestingClass {
        // Example class for testing purposes
        private int x;
        private int y;

        public MyTestingClass() {
            this.x = (int) (Math.random() * 100);
            this.y = (int) (Math.random() * 100);
        }

        //check if the current object is equal to the given object o based on the x and y attributes.
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            MyTestingClass that = (MyTestingClass) o;
            return x == that.x && y == that.y;
        }
    }
    }

