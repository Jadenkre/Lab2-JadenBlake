class MedianQuicksort {

    public static void quickSort(TestInteger[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
    static int partition(TestInteger[] arr, int low, int high) {
        int mid = low + (high - low) / 2;
        if (arr[low].compareTo(arr[mid]) > 0) {
            swap(arr, low, mid);
        }
        if (arr[low].compareTo(arr[high]) > 0) {
        swap(arr, low, high);
        }
        if (arr[mid].compareTo(arr[high]) > 0) {
            swap(arr, mid, high);
        }

        swap(arr, mid, high);
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
}
