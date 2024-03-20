import java.lang.reflect.Array;
import java.util.Arrays;

public class Sorting {

    public static boolean less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    public static void swap(Object[] a, int i, int j){
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sort(Comparable[] a){
        for (int i = 0; i < a.length; i++){
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--){
               swap(a, j, j - 1);
            }
        }
    }

    public boolean isSorted(Comparable[] a){
        for (int i = 0; i < a.length - 1; i++){
            if (less(a[i+1], a[i]))
                return false;
        }
        return true;
    }

    public static void shuffle(Object[] a){
        for (int i = 0; i < a.length; i++){
            int random = (int) ((i + 1) * Math.random());
            swap(a, i, random);
        }
    }

    public static void main(String[] args){
        Integer[] a = new Integer[] {5, 3, 2, 4, 1};
        shuffle(a);
        System.out.println(Arrays.toString(a));
        sort(a);
        System.out.println(Arrays.toString(a));
    }

}
