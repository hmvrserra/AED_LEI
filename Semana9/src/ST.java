import java.util.ArrayList;
import java.util.NoSuchElementException;

public class ST<Key extends Comparable<Key>, Value> {

    private class Node {
        public Key key;
        public Value value;
        public Node left, right;
        public int size;

        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }

    private Node root;
    private int size;

    public ST(){
        this.root = null;
        this.size = 0;
    }

    public void put(Key key, Value value){
        root = put(root, key, value);
        size = size(root);
    }

    private Node put(Node x, Key key, Value value){
        if (x == null)
            return new Node(key, value);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, value);
        else if (cmp > 0)
            x.right = put(x.right, key, value);
        else
            x.value = value;
        x.size = size(x.left) + size(x.right) + 1;
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
        size = size(root);
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

    public boolean contains(Key key){
        return get(key) != null;
    }

    public boolean isEmpty(){
        return this.root == null;
    }

    public int size(){
        return size(root);
    }

    private int size(Node x){
        if (x == null)
            return 0;
        return x.size;
    }

    public int height(){
        return height(root);
    }

    private int height(Node x){
        if (x == null)
            return -1;
        return 1 + Math.max(height(x.left), height(x.right));
    }

    public Key min(){
        if (isEmpty())
            throw new NoSuchElementException("called min() with empty symbol table");
        return min(root).key;
    }

    public Node min(Node x){
        if (x.left == null)
            return x;
        return min(x.left);
    }

    public Key max(){
        if (isEmpty())
            throw new NoSuchElementException("called max() with empty symbol table");
        return max(root).key;
    }

    public Node max(Node x){
        if (x.right == null)
            return x;
        return max(x.right);
    }

    public Key floor(Key key){
        Node x = floor(root, key);
        if (x == null)
            return null;
        else
            return x.key;
    }

    private Node floor(Node x, Key key){
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp < 0)
            return floor(x.left, key);
        Node t = floor(x.right, key);
        if (t != null)
            return t;
        else
            return x;
    }

    public Key ceiling(Key key){
        Node x = ceiling(root, key);
        if (x == null)
            return null;
        else
            return x.key;
    }

    private Node ceiling(Node x, Key key){
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0)
            return x;
        if (cmp > 0)
            return ceiling(x.right, key);
        Node t = ceiling(x.left, key);
        if (t != null)
            return t;
        else
            return x;
    }

    public int rank(Key key){
        return rank(key, root);
    }

    private int rank(Key key, Node x){
        if (x == null)
            return 0;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return rank(key, x.left);
        else if (cmp > 0)
            return 1 + size(x.left) + rank(key, x.right);
        else
            return size(x.left);
    }

    public Key select(int k){
        return select(root, k);
    }

    private Key select(Node x, int k){
        if (x == null)
            return null;
        int t = size(x.left);
        if (t > k)
            return select(x.left, k);
        else if (t < k)
            return select(x.right, k - t - 1);
        else
            return x.key;
    }

    public void deleteMin(){
        root = deleteMin(root);
        size--;
    }

    private Node deleteMin(Node x){
        if (x.left == null)
            return x.right;
        x.left = deleteMin(x.left);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public void deleteMax(){
        root = deleteMax(root);
        size--;
    }

    private Node deleteMax(Node x){
        if (x.right == null)
            return x.left;
        x.right = deleteMax(x.right);
        x.size = size(x.left) + size(x.right) + 1;
        return x;
    }

    public int size(Key lo, Key hi){
        return this.size;
    }

    private int size(Node x, Key lo, Key hi){
        if (x == null)
            return 0;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0)
            return size(x.left, lo, hi);
        if (cmphi > 0)
            return size(x.right, lo, hi);
        return 1 + size(x.left, lo, hi) + size(x.right, lo, hi);
    }

    public Iterable<Key> keys(Key lo, Key hi){
        if (lo == null || hi == null)
            throw new IllegalArgumentException("argument to keys() is null");
        ArrayList<Key> keyList = new ArrayList<>();
        keys(root, keyList, lo, hi);
        return keyList;
    }

    public Iterable<Key> keys(){
        if (isEmpty()) return new ArrayList<Key>();
        return keys(min(), max());
    }

    private void keys(Node x, ArrayList<Key> keyList, Key lo, Key hi){
        if (x == null)
            return;
        int cmplo = lo.compareTo(x.key);
        int cmphi = hi.compareTo(x.key);
        if (cmplo < 0)
            keys(x.left, keyList, lo, hi);
        if (cmplo <= 0 && cmphi >= 0)
            keyList.add(x.key);
        if (cmphi > 0)
            keys(x.right, keyList, lo, hi);
    }

}