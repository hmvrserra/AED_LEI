public class MinHeap<T extends Comparable<T>>{

    private T[] pq;
    private int size;

    public MinHeap(int capacity){
        this.pq = (T[]) new Comparable[capacity];
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void insert(T item){
        pq[++size] = item;
        swim(size);
    }

    public T delMin(){
        T min = pq[1];

        exchange(1, size);
        pq[size--] = null;
        sink(1);

        return min;
    }

    /************************************************** PRIVATE ******************************************************/
    private void exchange(int i, int j){
        T temp = pq[i];
        pq[i] = pq[j];
        pq[j] = temp;
    }

    private boolean greaterOrEqual(int i, int j){
        return pq[i].compareTo(pq[j]) >= 0;
    }

    private int left(int k){
        return 2 * k;
    }

    private int right(int k){
        return 2 * k + 1;
    }

    private int parent(int k){
        return k / 2;
    }

    private void swim(int k){
        while (k > 1 && greaterOrEqual(parent(k), k)){
            exchange(k , parent(k));
            k = parent(k);
        }
    }

    private void sink(int k){
        while (left(k) <= size){
            int child = left(k);
            if (right(k) < size && greaterOrEqual(child, right(k)))
                child = right(k);
            if (!greaterOrEqual(k, child))
                break;
            exchange(k, child);
            k = child;
        }

    }

    public static void main(String[] args){
        MinHeap<Integer> heap = new MinHeap<>(10);

        heap.insert(7);
        heap.insert(5);
        heap.insert(3);
        heap.insert(2);
        heap.insert(8);
        heap.insert(1);
        heap.insert(6);
        heap.insert(9);
        heap.insert(4);

        while (!heap.isEmpty())
            System.out.println(heap.delMin());
    }
}
