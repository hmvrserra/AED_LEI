import java.util.LinkedList;

public class ST<Key extends Comparable<Key>, Value> {

    private int size;
    private Node root;
    private Key[] keys;
    private Value[] vals;

    public ST(){ //create a symbol table
        size = 0;
        root = null;
    }

    public void put(Key key, Value val){ //put key-value pair into the table
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val){
        if (x == null){
            size++;
            return new Node(key, val);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.value = val;
        return x;
    }

    public Value get(Key key){ //value paired with key
        if (isEmpty())
            return null;
        while (root != null){
            int cmp = key.compareTo(root.key);
            if (cmp < 0)
                root = root.left;
            else if (cmp > 0)
                root = root.right;
            else
                return root.value;
        }
        return null;
    }

    public void delete(Key key){ //remove key (and its value) from table
        put(key, null);
    }

    public boolean contains(Key key){ //is there a value paired with key?
        return get(key) != null;
    }

    public boolean isEmpty(){ //is the table empty?
        return size == 0;
    }

    public int size(){ //number of key-value pairs
        return size;
    }

    public int height(){    //height of the tree
        return 0;
    }

    public Key min(){ //smallest key
        return keys[0];
    }

    public Key max(){ //largest key
        return keys[size - 1];
    }

    public Key floor(Key key){ //largest key <= key
        int i = rank(key);
        if (i < size && keys[i].compareTo(key) == 0)
            return keys[i];
        if (i == 0)
            return null;
        else
            return keys[i - 1];
    }

    public Key ceiling(Key key){ //smallest key >= key
        int i = rank(key);
        if (i == size)
            return null;
        else
            return keys[i];
    }

    public int rank(Key key){ //number of keys less than key
        int lo = 0, hi = size - 1;
        while (lo <= hi){
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0)
                hi = mid - 1;
            else if (cmp > 0)
                lo = mid + 1;
            else
                return mid;
        }
        return lo;
    }

    public Key select(int k){  //key of rank k
        return keys[k];
    }

    public void deleteMin(){ //delete the minimum key
        delete(min());
    }

    public void deleteMax(){ //delete the maximum key
        delete(max());
    }

    public int size(Key lo, Key hi){ //number of keys in [lo..hi]
        if (lo.compareTo(hi) > 0)
            return 0;
        else if (contains(hi))
            return rank(hi) - rank(lo) + 1;
        else
            return rank(hi) - rank(lo);
    }

    public Iterable<Key> keys(Key lo, Key hi){ //keys in [lo, ..., hi], in sorted order
        LinkedList<Key> q = new LinkedList<>();
        for (int i = rank(lo); i < rank(hi); i++)
            q.add(keys[i]);
        if (contains(hi))
            q.add(keys[rank(hi)]);
        return q;
    }

    public Iterable<Key> keys(){ //all keys in the table, in sorted order
        return keys(min(), max());
    }

    private class Node { //binary search tree
        public Key key;
        public Value value;
        public Node left, right;

        public Node(Key key, Value value){
            this.key = key;
            this.value = value;
        }
    }
}


