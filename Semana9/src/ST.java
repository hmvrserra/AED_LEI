import java.util.LinkedList;

public class ST<Key extends Comparable<Key>, Value> {

    public ST(){}

    public void put(Key key, Value val){}

    private Node put(Node x, Key key, Value val){}

    public Value get(Key key){}

    public void delete(Key key){}

    public boolean contains(Key key){}

    public boolean isEmpty(){}

    public int size(){}

    public int height(){}

    public Key min(){}

    public Key max(){}

    public Key floor(Key key){}

    public Key ceiling(Key key){}

    public int rank(Key key){}

    public Key select(int k){}

    public void deleteMin(){}

    public void deleteMax(){}

    public int size(Key lo, Key hi){}

    public Iterable<Key> keys(Key lo, Key hi){}

    public Iterable<Key> keys(){}

    private class Node {
        public Key key;
        public Value value;
        public Node left, right;

        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }
}


