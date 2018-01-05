import java.util.Scanner;

public class Heap {

    enum State { BUILD, SORT }

    private int[] array;
    private int size;

    private State state = State.BUILD;

    private int countSwaps;
    private StringBuilder SB = new StringBuilder();

    public void check() {
        init();
        sort();
        print();
    }

    private void init() {
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();

        int[] array = new int[length + 1];
        for (int i = 1; i <= length; i++)
            array[i] = in.nextInt();

        this.array = array;
        this.size = array.length - 1;
    }

    private void sort() {
        buildHeap();

        int n = size;
        while(n > 1) {
            swap(1, size);
            n--;
            sink(1);
        }
    }

    private void buildHeap() {
        for (int i = size/2; i >= 1; i--) {
            sink(i);
        }
        state = State.SORT;
    }

    private void sink(int ind) {
        int minIndex = ind;

        int leftIndex = left(ind);
        if (leftIndex <= size && array[leftIndex] < array[minIndex])
            minIndex = leftIndex;

        int rightIndex = right(ind);
        if (rightIndex <= size && array[rightIndex] < array[minIndex])
            minIndex = rightIndex;

        if (ind != minIndex) {
            swap(ind, minIndex);
            sink(minIndex);
        }
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;

        log(i, j);
    }

    private void log(int i, int j) {
        if (state != State.SORT) {
            countSwaps++;
            SB.append(i - 1).append(" ").append(j - 1).append("\n");
        }
    }

    private void print() {
        System.out.println(countSwaps);
        System.out.print(SB.toString());
    }

    private int parent(int ind) {
        return ind / 2;
    }

    private int left(int ind) {
        return ind * 2;
    }

    private int right(int ind) {
        return ind * 2 + 1;
    }

}
