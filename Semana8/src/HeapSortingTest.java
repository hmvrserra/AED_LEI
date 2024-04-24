import java.util.Arrays;

public class HeapSortingTest {
    public static void main(String[] args) {
        int correctTests = 0;
        String[] functionsNeedFixing = new String[21]; // Updated size to accommodate new tests

        // Test sort method
        correctTests += testSort(functionsNeedFixing);

        // Test heapify method
        correctTests += testHeapify(functionsNeedFixing);

        // Test sortdown method
        correctTests += testSortDown(functionsNeedFixing);

        // Test sink method
        correctTests += testSink(functionsNeedFixing);

        // Test parent method
        correctTests += testParent(functionsNeedFixing);

        // Test left method
        correctTests += testLeft(functionsNeedFixing);

        // Test right method
        correctTests += testRight(functionsNeedFixing);

        // Additional Tests
        correctTests += testEmptyArray(functionsNeedFixing);
        correctTests += testAlreadySortedArray(functionsNeedFixing);
        correctTests += testDuplicateValues(functionsNeedFixing);
        correctTests += testSingleElementArray(functionsNeedFixing);
        correctTests += testNegativeValues(functionsNeedFixing);
        correctTests += testLargeArray(functionsNeedFixing);
        correctTests += testDescendingOrderArray(functionsNeedFixing);
        correctTests += testAscendingOrderArray(functionsNeedFixing);
        correctTests += testRandomOrderArray(functionsNeedFixing);
        correctTests += testOddNumberOfElements(functionsNeedFixing);

        // Additional Tests
        correctTests += testNullArray(functionsNeedFixing);
        correctTests += testLargeNegativeValues(functionsNeedFixing);
        correctTests += testMixedPositiveAndNegativeValues(functionsNeedFixing);
        correctTests += testLongArraySameValues(functionsNeedFixing);

        // Summary
        printSummary(correctTests, functionsNeedFixing);
    }

    public static int testSort(String[] functionsNeedFixing) {
        String functionName = "testSort";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = {5, 3, 8, 2, 7, 1, 6, 4};
        System.out.println("Content before sorting: " + Arrays.toString(intList));
        HeapSorting.sort(intList);
        System.out.println("Content after sorting: " + Arrays.toString(intList));
        System.out.println("Expected: [1, 2, 3, 4, 5, 6, 7, 8]");
        boolean result = Arrays.equals(intList, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testHeapify(String[] functionsNeedFixing) {
        String functionName = "testHeapify";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = {5, 3, 8, 2, 7, 1, 6, 4};
        System.out.println("Content before heapifying: " + Arrays.toString(intList));
        HeapSorting.heapify(intList, intList.length);
        System.out.println("Content after heapifying: " + Arrays.toString(intList));
        System.out.println("Expected: [8, 7, 6, 4, 3, 1, 5, 2]");
        boolean result = Arrays.equals(intList, new Integer[]{8, 7, 6, 4, 3, 1, 5, 2});
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testSortDown(String[] functionsNeedFixing) {
        String functionName = "testSortDown";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = {8, 7, 6, 4, 3, 1, 5, 2};
        System.out.println("Content before sorting down: " + Arrays.toString(intList));
        HeapSorting.sortdown(intList, intList.length);
        System.out.println("Content after sorting down: " + Arrays.toString(intList));
        System.out.println("Expected: [1, 2, 3, 4, 5, 6, 7, 8]");
        boolean result = Arrays.equals(intList, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testSink(String[] functionsNeedFixing) {
        String functionName = "testSink";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = {0, 7, 6, 4, 3, 1, 5, 2};
        System.out.println("Content before sinking: " + Arrays.toString(intList));
        HeapSorting.sink(intList, 1, intList.length);
        System.out.println("Content after sinking: " + Arrays.toString(intList));
        System.out.println("Expected: [0, 7, 6, 4, 3, 1, 5, 2]");
        boolean result = Arrays.equals(intList, new Integer[]{0, 7, 6, 4, 3, 1, 5, 2});
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testParent(String[] functionsNeedFixing) {
        String functionName = "testParent";
        System.out.println("\nStarting test: " + functionName);
        int k = 5;
        System.out.println("Parent of node " + k + ": " + HeapSorting.parent(k));
        System.out.println("Expected: 2");
        boolean result = HeapSorting.parent(k) == 2;
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testLeft(String[] functionsNeedFixing) {
        String functionName = "testLeft";
        System.out.println("\nStarting test: " + functionName);
        int k = 2;
        System.out.println("Left child of node " + k + ": " + HeapSorting.left(k));
        System.out.println("Expected: 5");
        boolean result = HeapSorting.left(k) == 5;
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testRight(String[] functionsNeedFixing) {
        String functionName = "testRight";
        System.out.println("\nStarting test: " + functionName);
        int k = 2;
        System.out.println("Right child of node " + k + ": " + HeapSorting.right(k));
        System.out.println("Expected: 6");
        boolean result = HeapSorting.right(k) == 6;
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testEmptyArray(String[] functionsNeedFixing) {
        String functionName = "testEmptyArray";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = {};
        System.out.println("Content before sorting: " + Arrays.toString(intList));
        HeapSorting.sort(intList);
        System.out.println("Content after sorting: " + Arrays.toString(intList));
        System.out.println("Expected: []");
        boolean result = Arrays.equals(intList, new Integer[]{});
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testAlreadySortedArray(String[] functionsNeedFixing) {
        String functionName = "testAlreadySortedArray";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Content before sorting: " + Arrays.toString(intList));
        HeapSorting.sort(intList);
        System.out.println("Content after sorting: " + Arrays.toString(intList));
        System.out.println("Expected: [1, 2, 3, 4, 5, 6, 7, 8]");
        boolean result = Arrays.equals(intList, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testDuplicateValues(String[] functionsNeedFixing) {
        String functionName = "testDuplicateValues";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = {5, 5, 3, 8, 2, 7, 1, 6, 4, 4};
        System.out.println("Content before sorting: " + Arrays.toString(intList));
        HeapSorting.sort(intList);
        System.out.println("Content after sorting: " + Arrays.toString(intList));
        System.out.println("Expected: [1, 2, 3, 4, 4, 5, 5, 6, 7, 8]");
        boolean result = Arrays.equals(intList, new Integer[]{1, 2, 3, 4, 4, 5, 5, 6, 7, 8});
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testSingleElementArray(String[] functionsNeedFixing) {
        String functionName = "testSingleElementArray";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = {1};
        System.out.println("Content before sorting: " + Arrays.toString(intList));
        HeapSorting.sort(intList);
        System.out.println("Content after sorting: " + Arrays.toString(intList));
        System.out.println("Expected: [1]");
        boolean result = Arrays.equals(intList, new Integer[]{1});
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testNegativeValues(String[] functionsNeedFixing) {
        String functionName = "testNegativeValues";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = {-5, -3, -8, -2, -7, -1, -6, -4};
        System.out.println("Content before sorting: " + Arrays.toString(intList));
        HeapSorting.sort(intList);
        System.out.println("Content after sorting: " + Arrays.toString(intList));
        System.out.println("Expected: [-8, -7, -6, -5, -4, -3, -2, -1]");
        boolean result = Arrays.equals(intList, new Integer[]{-8, -7, -6, -5, -4, -3, -2, -1});
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testLargeArray(String[] functionsNeedFixing) {
        String functionName = "testLargeArray";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = new Integer[1000];
        for (int i = 0; i < 1000; i++) {
            intList[i] = 1000 - i;
        }
        System.out.println("Content before sorting: [Large Array]");
        System.out.println("Content after sorting: [Large Array Sorted]");
        System.out.println("Expected: [Sorted Array]");
        HeapSorting.sort(intList);
        boolean result = true;
        for (int i = 0; i < 1000; i++) {
            if (intList[i] != i + 1) {
                result = false;
                break;
            }
        }
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testDescendingOrderArray(String[] functionsNeedFixing) {
        String functionName = "testDescendingOrderArray";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = {8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("Content before sorting: " + Arrays.toString(intList));
        HeapSorting.sort(intList);
        System.out.println("Content after sorting: " + Arrays.toString(intList));
        System.out.println("Expected: [1, 2, 3, 4, 5, 6, 7, 8]");
        boolean result = Arrays.equals(intList, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testAscendingOrderArray(String[] functionsNeedFixing) {
        String functionName = "testAscendingOrderArray";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Content before sorting: " + Arrays.toString(intList));
        HeapSorting.sort(intList);
        System.out.println("Content after sorting: " + Arrays.toString(intList));
        System.out.println("Expected: [1, 2, 3, 4, 5, 6, 7, 8]");
        boolean result = Arrays.equals(intList, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testRandomOrderArray(String[] functionsNeedFixing) {
        String functionName = "testRandomOrderArray";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = {5, 2, 7, 1, 8, 3, 6, 4};
        System.out.println("Content before sorting: " + Arrays.toString(intList));
        HeapSorting.sort(intList);
        System.out.println("Content after sorting: " + Arrays.toString(intList));
        System.out.println("Expected: [1, 2, 3, 4, 5, 6, 7, 8]");
        boolean result = Arrays.equals(intList, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testOddNumberOfElements(String[] functionsNeedFixing) {
        String functionName = "testOddNumberOfElements";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = {5, 3, 8, 2, 7, 1, 6, 4, 9};
        System.out.println("Content before sorting: " + Arrays.toString(intList));
        HeapSorting.sort(intList);
        System.out.println("Content after sorting: " + Arrays.toString(intList));
        System.out.println("Expected: [1, 2, 3, 4, 5, 6, 7, 8, 9]");
        boolean result = Arrays.equals(intList, new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testNullArray(String[] functionsNeedFixing) {
        String functionName = "testNullArray";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = null;
        System.out.println("Content before sorting: " + Arrays.toString(intList));
        try {
            HeapSorting.sort(intList);
            System.out.println("Content after sorting: " + Arrays.toString(intList));
            System.out.println("Test failed: Expected NullPointerException");
            addToFixList(functionName, functionsNeedFixing);
            return 0;
        } catch (NullPointerException e) {
            System.out.println("Exception caught: " + e);
            return 1;
        }
    }

    public static int testLargeNegativeValues(String[] functionsNeedFixing) {
        String functionName = "testLargeNegativeValues";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = {-1000, -500, -2000, -300, -700};
        System.out.println("Content before sorting: " + Arrays.toString(intList));
        HeapSorting.sort(intList);
        System.out.println("Content after sorting: " + Arrays.toString(intList));
        System.out.println("Expected: [-2000, -1000, -700, -500, -300]");
        boolean result = Arrays.equals(intList, new Integer[]{-2000, -1000, -700, -500, -300});
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testMixedPositiveAndNegativeValues(String[] functionsNeedFixing) {
        String functionName = "testMixedPositiveAndNegativeValues";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = {-5, 3, -8, 2, -7, 1, -6, 4};
        System.out.println("Content before sorting: " + Arrays.toString(intList));
        HeapSorting.sort(intList);
        System.out.println("Content after sorting: " + Arrays.toString(intList));
        System.out.println("Expected: [-8, -7, -6, -5, 1, 2, 3, 4]");
        boolean result = Arrays.equals(intList, new Integer[]{-8, -7, -6, -5, 1, 2, 3, 4});
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static int testLongArraySameValues(String[] functionsNeedFixing) {
        String functionName = "testLongArraySameValues";
        System.out.println("\nStarting test: " + functionName);
        Integer[] intList = new Integer[1000];
        Arrays.fill(intList, 5); // Fill array with same value
        System.out.println("Content before sorting: [Large Array with same values]");
        HeapSorting.sort(intList);
        System.out.println("Content after sorting: [Large Array with same values Sorted]");
        System.out.println("Expected: [Sorted Array with same values]");
        Integer[] expected = new Integer[1000];
        Arrays.fill(expected, 5); // Fill array with same value

        boolean result = Arrays.equals(intList, expected);
        System.out.println("Result correct: " + result);
        if (!result) {
            addToFixList(functionName, functionsNeedFixing);
        }
        return result ? 1 : 0;
    }

    public static void addToFixList(String functionName, String[] functionsNeedFixing) {
        // Find the first empty slot in the functionsNeedFixing array and add the function name
        for (int i = 0; i < functionsNeedFixing.length; i++) {
            if (functionsNeedFixing[i] == null) {
                functionsNeedFixing[i] = functionName;
                break;
            }
        }
    }

    public static void printSummary(int correctTests, String[] functionsNeedFixing) {
        int totalTests = functionsNeedFixing.length; // Total number of tests

        System.out.println("\nResults: " + correctTests + "/" + totalTests + " tests correct.");
        if (functionsNeedFixing[0] != null) {
            System.out.println("Functions that need fixing:");
            for (String functionName : functionsNeedFixing) {
                if (functionName != null) {
                    System.out.println("- " + functionName);
                }
            }
        } else {
            System.out.println("All functions passed the tests.");
        }
    }
}
