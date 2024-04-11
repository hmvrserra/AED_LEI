import java.util.Random;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int N = 10000000;

        Integer[] a = new Integer[N];
        for (int i = 0; i < a.length; i++)
            a[i] =(int) (N * Math.random());


        System.out.println("Array Inicial:");
        System.out.println(Arrays.toString(a));

        System.out.println("Está ordenado: " + QuickSorting.isSorted(a) + "\n"); //Should print false

        QuickSorting.sort(a);
        System.out.println("Array Ordenado:");
        System.out.println(Arrays.toString(a));

        System.out.println("Está ordenado: " + QuickSorting.isSorted(a) + "\n"); //Should print true
    }
}