import java.util.LinkedList;
import java.util.Queue;

public class LinearProbingHashST <Key, Value>{

    private int N;
    private int M;
    private Value[] values;
    private Key[] keys;

    public LinearProbingHashST(int M) {
        this.M = M;
        this.keys = (Key[]) new Object[M];
        this.values = (Value[]) new Object[M];
    }

    private int hash(Key key){
        return (key.hashCode() & 0x7fffffff) % M;
    }

    public void put(Key key, Value value) {
        int i = hash(key);
        while (keys[i] != null && !key.equals(keys[i]))
            i = (i + 1) % M;
        keys[i] = key;
        values[i] = value;
        N++;
    }

    public Value get(Key key) {
        int i = hash(key);
        while (keys[i] != null && !key.equals(keys[i]))
            i = (i + 1) % M;
        return values[i];
    }

    public void delete(Key key) {
        if (!contains(key)) return;
        int i = hash(key);
        while (!key.equals(keys[i]))
            i = (i + 1) % M;
        keys[i] = null;
        values[i] = null;
        i = (i + 1) % M;
        while (keys[i] != null) {
            Key keyToRedo = keys[i];
            Value valToRedo = values[i];
            keys[i] = null;
            values[i] = null;
            N--;
            put(keyToRedo, valToRedo);
            i = (i + 1) % M;
        }
        N--;
        if (N > 0 && N == M/8) resize(M/2);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int size() {
        return N;
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new LinkedList<Key>();
        for (int i = 0; i < M; i++)
            if (keys[i] != null) queue.add(keys[i]);
        return queue;
    }

    private void resize(int cap) {
        LinearProbingHashST<Key, Value> t;
        t = new LinearProbingHashST<Key, Value>(cap);
        for (int i = 0; i < M; i++)
            if (keys[i] != null)
                t.put(keys[i], values[i]);
        keys = t.keys;
        values = t.values;
        M = t.M;
    }

    // public static void main(String[] args) {

}
