import java.util.Arrays;

public class Main {
    public static int runs = 5;
    public static int n = 10000;
    // Divisor for converting nanoseconds to milliseconds
    public static final float TIME_DIV = 1000000.0f;

    public static void runExperiment(String testName, TestInteger[] baseArray){
        System.out.println("------------------------------------------");
        System.out.printf("Running experiment for: %s (N=%d)\n", testName, n);

        for (int run = 1; run <= runs; run++) {

            // Create copies of the same array to ensure a fair test for each algorithm
            TestInteger[] arr1 = Arrays.copyOf(baseArray, baseArray.length);
            TestInteger[] arr2 = Arrays.copyOf(baseArray, baseArray.length);
            TestInteger[] arr3 = Arrays.copyOf(baseArray, baseArray.length);
            TestInteger[] arr4 = Arrays.copyOf(baseArray, baseArray.length);

            // 1. Standard Quick Sort Test
            TestInteger.resetCounter();
            float start = System.nanoTime();
            Quicksort.quickSort(arr1, 0, arr1.length - 1);
            float end = System.nanoTime();
            long quickCount = TestInteger.getCounter();
            float quickTimer = end - start;

            // 2. Merge Sort (using Java's built-in Timsort) Test
            TestInteger.resetCounter();
            start = System.nanoTime();
            Arrays.sort(arr2);
            end = System.nanoTime();
            long mergeCount = TestInteger.getCounter();
            float mergeTimer = end - start;

            // 3. Random Pivot Quick Sort Test
            TestInteger.resetCounter();
            start = System.nanoTime();
            RandomQuicksort.quickSort(arr3, 0, arr3.length - 1);
            end = System.nanoTime();
            long randQuickCount = TestInteger.getCounter();
            float randQuickTimer = end - start;

            // 4. Quick-Insertion Sort Hybrid Test
            TestInteger.resetCounter();
            start = System.nanoTime();
            QuickInsertionsort.quickInsertionsort(arr4, 0, arr4.length - 1);
            end = System.nanoTime();
            long quickInCount = TestInteger.getCounter();
            float quickInTimer = end - start;

            System.out.printf("""
                    
                    --- Run %d ---
                    Comparisons:
                      Quick Sort:             %d
                      Merge Sort:             %d
                      R-Pivot Quick Sort:     %d
                      Quick-Insertion Sort:   %d
                    
                    Runtime (ms):
                      Quick Sort:             %.2f
                      Merge Sort:             %.2f
                      R-Pivot Quick Sort:     %.2f
                      Quick-Insertion Sort:   %.2f
                    """,
                    run,
                    quickCount,
                    mergeCount,
                    randQuickCount,
                    quickInCount,
                    quickTimer / TIME_DIV,
                    mergeTimer / TIME_DIV,
                    randQuickTimer / TIME_DIV,
                    quickInTimer / TIME_DIV);
        }

        System.out.println("\n------------------------------------------");
    }

    public static void main(String[] args) {
        runExperiment("Random Array", ArrayPopulate.randomArray(n));
        runExperiment("Increasing Array", ArrayPopulate.increasingArray(n));
        runExperiment("Sorted Chunks", ArrayPopulate.sortedChunks(n, 1000));
        runExperiment("Reversed Chunks", ArrayPopulate.reverseChunks(n, 1000));
    }
}