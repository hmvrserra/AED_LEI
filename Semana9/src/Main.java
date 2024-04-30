public class Main {
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<>();

        // put some key-value pairs into the symbol table
        st.put("apple", 1);
        st.put("banana", 2);
        st.put("cherry", 3);
        st.put("date", 4);
        st.put("elderberry", 5);

        // get and print the values associated with the keys
        System.out.println("Value associated with apple: " + st.get("apple"));  // should print 1
        System.out.println("Value associated with banana: " + st.get("banana"));    // should print 2
        System.out.println("Value associated with cherry: " + st.get("cherry"));    // should print 3

        // check if the symbol table contains a key
        System.out.println("Contains key 'apple': " + st.contains("apple"));    // should print true
        System.out.println("Contains key 'date': " + st.contains("date"));  // should print true

        // test min, max, floor, ceiling, rank, select
        System.out.println("Min key: " + st.min());  // should print "apple"
        System.out.println("Max key: " + st.max());  // should print "elderberry"
        System.out.println("Floor of 'date': " + st.floor("date"));  // should print "date"
        System.out.println("Ceiling of 'date': " + st.ceiling("date"));  // should print "date"
        System.out.println("Rank of 'date': " + st.rank("date"));  // should print 3
        System.out.println("Select rank 2: " + st.select(2));  // should print "cherry"

        // test deleteMin, deleteMax, size
        st.deleteMin();
        System.out.println("Min key after deleteMin: " + st.min());  // should print "banana"
        st.deleteMax();
        System.out.println("Max key after deleteMax: " + st.max());  // should print "date"
        System.out.println("Size: " + st.size());  // should print 3

        // delete a key-value pair and check again
        st.delete("banana");
        System.out.println("Contains key 'banana' after deletion: " + st.contains("banana"));   // should print false
    }
}