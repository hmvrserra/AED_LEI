public class Main {
    public static void main(String[] args) {
        LinearProbingHashST<String, Integer> st = new LinearProbingHashST<>(10);

        // put some key-value pairs
        st.put("apple", 1);
        st.put("banana", 2);
        st.put("cherry", 3);

        // print the size of the symbol table
        System.out.println("Size of symbol table: " + st.size());

        // print all keys
        for (String key : st.keys()) {
            System.out.println("Key: " + key + ", Value: " + st.get(key));
        }

        // delete a key
        st.delete("apple");

        // print the size of the symbol table after deletion
        System.out.println("Size of symbol table after deletion: " + st.size());

        // print all keys after deletion
        for (String key : st.keys()) {
            System.out.println("Key: " + key + ", Value: " + st.get(key));
        }
    }
}