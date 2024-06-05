public class Main {
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<>();

        // Insert some key-value pairs
        st.put("apple", 10);
        st.put("banana", 20);
        st.put("cherry", 30);
        st.put("date", 40);
        st.put("elderberry", 50);

        // Print the symbol table
        System.out.println("Symbol Table:");
        for (String key : st.keys()) {
            System.out.println(key + " -> " + st.get(key));
        }

        // Test get and contains
        System.out.println("Get 'banana': " + st.get("banana"));
        System.out.println("Contains 'cherry': " + st.contains("cherry"));
        System.out.println("Contains 'fig': " + st.contains("fig"));

        // Test floor and ceiling
        System.out.println("Floor of 'd': " + st.floor("d"));
        System.out.println("Ceiling of 'e': " + st.ceiling("e"));

        // Test rank and select
        System.out.println("Rank of 'cherry': " + st.rank("cherry"));
        System.out.println("Select 2: " + st.select(2));

        // Test delete
        st.delete("banana");
        System.out.println("After deleting 'banana':");
        for (String key : st.keys()) {
            System.out.println(key + " -> " + st.get(key));
        }

        // Test size and height
        System.out.println("Size: " + st.size());
        System.out.println("Height: " + st.height());
    }
}