public class HeapSorting {

    public static void sort(Comparable[] a){    //sorts the array a using the Heapsort
        sortdown(a, a.length);
    }

    public static void heapify(Comparable[] a, int N){  //creates a max-heap with the N items in the array a
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
    }

    public static void sortdown(Comparable[] a, int N){ //repeatedly removes the max/biggest ite min the array
        heapify(a, N);
        while (N > 1){
            exchange(a, 1, N--);
            sink(a, 1, N);
        }
    }

    public static void sink(Comparable[] a, int k, int N){  //sink node k
        while (2 * k <= N){
            int j = 2 * k;
            if (j < N && less(a, j, j + 1))
                j++;
            if (!less(a, k, j))
                break;
            exchange(a, k, j);
            k = j;
        }
    }

    public static int parent(int k){    //parent of node k
        return (k - 1) / 2;
    }

    public static int left(int k){  //left child of node k
        return 2 * k + 1;
    }

    public static int right(int k){ //right child of node k
        return 2 * k + 2;
    }

    /************************************************** EXTRA **************************************************/

    private static boolean less(Comparable[] a, int i, int j){
        return a[i - 1].compareTo(a[j - 1]) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j){
        Comparable swap = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = swap;
    }
}
