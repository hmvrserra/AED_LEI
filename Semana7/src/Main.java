import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] a = new Integer[] {1,2,3,4,5,6,7,8,9,10};
        System.out.println("Array Inicial:");
        System.out.println(Arrays.toString(a));

        System.out.println("Está ordenado: " + QuickSorting.isSorted(a) + "\n"); //Should print true

        QuickSorting.shuffle(a);
        System.out.println("Array Baralhado:");
        System.out.println(Arrays.toString(a));

        System.out.println("Está ordenado: " + QuickSorting.isSorted(a) + "\n"); //Should print false
    }
}