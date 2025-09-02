import java.util.Random;

public class ArrayPopulate {

    // Create random object
    public static Random random = new Random();

    /*This will take in a number of choosing and generate that many random elements
      between 1-1,000,000
    */
    public static TestInteger[] randomArray(int n){
        TestInteger[] arr = new TestInteger[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new TestInteger(random.nextInt(1000000) + 1);
        }
        return arr;
    }

    // Increasing order
    public static TestInteger[] increasingArray(int n) {
        TestInteger[] arr = new TestInteger[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new TestInteger(i);
        }
        return arr;
    }

    // 10 sorted sequences of length 1000
    public static TestInteger[] sortedChunks(int n, int chunkSize) {
        TestInteger[] arr = new TestInteger[n];
        int index = 0;
        for (int c = 0; c < n / chunkSize; c++) {
            int start = random.nextInt(1000000);
            for (int i = 0; i < chunkSize; i++) {
                arr[index++] = new TestInteger(start + i);
            }
        }
        return arr;
    }

    // 10 reverse-sorted sequences of length 1000
    public static TestInteger[] reverseChunks(int n, int chunkSize) {
        TestInteger[] arr = new TestInteger[n];
        int index = 0;
        for (int c = 0; c < n / chunkSize; c++) {
            int start = random.nextInt(1000000);
            for (int i = 0; i < chunkSize; i++) {
                arr[index++] = new TestInteger(start - i);
            }
        }
        return arr;
    }


}
