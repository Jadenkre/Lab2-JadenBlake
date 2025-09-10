public class QuickInsertionsort {
    public static void quickInsertionsort(TestInteger[] arr, int low, int high) {
        int CUTOFF = 5; 

        if (low < high) {
            // If the size of the subarray is less than or equal to the cutoff, use insertion sort
            if (high - low + 1 <= CUTOFF) {
                insertionSort(arr, low, high);
            } else {
                int pi = partition(arr, low, high);
                quickInsertionsort(arr, low, pi - 1);
                quickInsertionsort(arr, pi + 1, high);
            }
        }
    }
    static int partition(TestInteger[] arr, int low, int high) {
        TestInteger pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    static void swap(TestInteger[] arr, int i, int j) {
        TestInteger temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void insertionSort(TestInteger arr[], int low, int high) {
        for (int i = low + 1; i <= high; ++i) {
            TestInteger key = arr[i];
            int j = i - 1;

            while (j >= low && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
}
