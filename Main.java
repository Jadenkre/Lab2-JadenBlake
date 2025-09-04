import java.util.Arrays;

public class Main {
    public static int runs = 5;
    public static int n = 10000;



    public static void runExperiment(String testName, TestInteger[] baseArray){
        //Create a copy of the same array to split the sorting apart
        for (int run = 1; run <= runs; run++) {


            TestInteger[] arr1 = Arrays.copyOf(baseArray, baseArray.length);
            TestInteger[] arr2 = Arrays.copyOf(baseArray, baseArray.length);
            TestInteger[] arr3 = Arrays.copyOf(baseArray, baseArray.length);
            //quick sort test

            //reset counter
            TestInteger.resetCounter();
            //This will sort the array from low-end 0 to high-end length of array
            //Adding Timer
            float start = System.nanoTime();
            Quicksort.quickSort(arr1, 0, arr1.length - 1);
            float end = System.nanoTime();
            //Create unique count for quick sort
            long quickCount = TestInteger.getCounter();
            float quickTimer = end - start;


            //Merge sort test

            //reset counter
            TestInteger.resetCounter();
            // using the array library Merge Sort aka TimSort for the second array
            //Adding Timer
            start = System.nanoTime();
            Arrays.sort(arr2);
            end = System.nanoTime();
            //Create unique count for merge sort
            long mergeCount = TestInteger.getCounter();
            float mergeTimer = end - start;

            //Random Pivot Quick sort

            //reset counter
            start = System.nanoTime();
            RandomQuicksort.quickSort(arr3, 0, arr3.length - 1);
            end = System.nanoTime();
            //Create unique count for random pivot quick sort
            long randQuickCount = TestInteger.getCounter();
            float randQuickTimer = end - start;


            System.out.printf("""
                    %s test %d Result Comparison:
                    Quick Sort: %d
                     \
                    Merge Sort: %d
                     \
                    R_Pivot Quick Sort: %d
                     \
                    Quicksort run time: %.2f ms
                     \
                    Mergesort run time: %.2f ms
                     \
                    R-Pivot Quick Sort: %.2f ms
                    """,testName,run, quickCount, mergeCount,randQuickCount, quickTimer / 1000000, mergeTimer / 1000000, randQuickTimer / 1000000);


        }

        System.out.println("------------------------------------------");
    }




    public static void main(String[] args) {
        runExperiment("Random Array",ArrayPopulate.randomArray(n));
        runExperiment("Increasing Array",ArrayPopulate.increasingArray(n));
        runExperiment("Sorted Chunks",ArrayPopulate.sortedChunks(n, 1000));
        runExperiment("Reversed Chunks",ArrayPopulate.reverseChunks(n, 1000));

    }
}
