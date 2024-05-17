import java.util.NoSuchElementException;

public class ST<Key extends Comparable<Key>, Value> {

    private Node root;
    private int size;

    public ST(){
        this.root = null;
        this.size = 0;
    }

    public void put(Key key, Value value){
        root = put(root, key, value);
    }

    public Node put(Node x, Key key, Value value){
        int cmp = key.compareTo(x.key);
        if (cmp > 0)
            x.left = put(x.left, key, value);
        else if (cmp < 0)
            x.right = put(x.right, key, value);
        else
            x.value = value;
        return x;
    }

    public Value get(Key key){
        return get(root, key);
    }
    
    private Value get(Node x, Key key){
        if (x == null)
            return null;
        int cmp  =key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);
        else if (cmp > 0)
            return get(x.right, key);
        else
            return x.value;
    }
    
    public void delete(Key key){
        root = delete(root, key);
    }

    private Node delete(Node x, Key key){
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = delete(x.left, key);
        else if (cmp > 0)
            x.right = delete(x.right, key);
        else {
            if (x.right == null)
                return x.left;
            if (x.left == null)
                return x.right;
            Node tmp = x;
            x = min(tmp.right);
            x.right = deleteMin(tmp.right);
            x.left = tmp.left;
        }
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public boolean contains(Key key){}

    public boolean isEmpty(){
        return root == null;
    }

    public int size(){}

    public int height(){}

    public Key min(){
        if (isEmpty())
            throw new NoSuchElementException("");
        return min(root);
    }

    private Key min(Node x){
        if (x.left == null)
            return x.key;
        return min(x.left);
    }

    public Key max(){
        return max(root);
    }

    private Key max(Node x){
        if (x.right == null)
            return x.key;
        return min(x.right);
    }

    public Key floor(Key key){}

    public Key ceiling(Key key){}

    public int rank(Key key){}

    public Key select(int k){}

    public void deleteMin(){}

    public void deleteMax(){}

    public int size(Key lo, Key hi){
        return size;
    }

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


