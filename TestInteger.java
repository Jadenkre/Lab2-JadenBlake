public class TestInteger implements Comparable<TestInteger>{
    private int value;
    private static int counter = 0;

    public TestInteger(int value) {
        this.value = value;
    }

    public int compareTo(TestInteger o) {
        counter++;
        return Integer.compare(this.value, o.value);
    }

    public static int getCounter() {
        return counter;
    }

    public static void resetCounter() {
        counter = 0;
    }
    
}
