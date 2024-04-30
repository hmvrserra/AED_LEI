public class Main {
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<>();

        // put some key-value pairs into the symbol table
        st.put("apple", 1);
        st.put("banana", 2);
        st.put("cherry", 3);

        // get and print the values associated with the keys
        System.out.println("Value associated with apple: " + st.get("apple"));  // should print 1
        System.out.println("Value associated with banana: " + st.get("banana"));    // should print 2
        System.out.println("Value associated with cherry: " + st.get("cherry"));    // should print 3

        // check if the symbol table contains a key
        System.out.println("Contains key 'apple': " + st.contains("apple"));    // should print true
        System.out.println("Contains key 'date': " + st.contains("date"));  // should print false

        // delete a key-value pair and check again
        st.delete("apple");
        System.out.println("Contains key 'apple' after deletion: " + st.contains("apple"));   // should print false
    }
}