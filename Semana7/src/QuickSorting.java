import javax.swing.plaf.metal.MetalScrollBarUI;

public class QuickSorting {


    public static void sort(Comparable[] a) {   //sorts the array a using the quicksort algorithm
        shuffle(a);
        sortSubarray(a, 0, a.length - 1);
    }

    public static void sortSubarray(Comparable[] a, int lo, int hi) { //(recursively) sorts the sub-array a[lo] to a[hi]
        if (hi <= lo)
            return;
        int j = partition(a, lo, hi);
        sortSubarray(a, lo, j - 1);
        sortSubarray(a, j + 1, hi);
    }

//    public static void insertionSort(Comparable[] a, int lo, int hi) { //performs insertion sorting on the sub-array a[lo] to a[hi]
//
//    }

    public static int partition(Comparable[] a, int lo, int hi) {   //partition the sub-array a[lo] to a[hi]
        int i = lo;
        int j = hi + 1;

        while (true){
            while (lessOrEqual(a[++i], a[lo])){
                if (i == hi)
                    break;
            }
            while (lessOrEqual(a[lo], a[--j])){
                if (j == lo)
                    break;
            }
            if (i >= j)
                break;

            exchange(a, i, j);
        }

        exchange(a, lo, j);

        return j;
    }

//    public static int medianOfThree(Comparable[] a, int lo, int hi) {   //returns the index of the median of 3 random elements in the sub-array a[lo] to a[hi]
//
//    }

    public static boolean lessOrEqual(Comparable a, Comparable b) { //is a <= b?
        return a.compareTo(b) <= 0;
    }

    public static void exchange(Comparable[] a, int lo, int hi) {   //swaps a[i] and a[j]
        Comparable temp = a[lo];
        a[lo] = a[hi];
        a[hi] = temp;
    }

    public static void shuffle(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            int random = (int) ((i + 1) * Math.random());
            exchange(a, i, random);
        }
    }


    /************************************************** EXTRA **************************************************/
    public static boolean less(Comparable a, Comparable b) { //is a <= b?
        return a.compareTo(b) < 0;
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 0; i < a.length - 1; i++){
            if (less(a[i+1], a[i]))
                return false;
        }
        return true;
    }
}
