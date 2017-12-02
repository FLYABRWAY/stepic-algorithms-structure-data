import java.util.*;

class MaxShiftWindow {

    private LinkedList<Integer> list = new LinkedList<>();
    private TreeMap<Integer, List<Integer>> maxQueue = new TreeMap<>(Comparator.reverseOrder());
    private StringBuilder SB = new StringBuilder();

    void check() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] numbers = new int[n];
        for (int i = 0; i<n; i++)
            numbers[i] = in.nextInt();

        int m = in.nextInt();

        for (int i = 0; i<m; i++) {
            list.add(numbers[i]);
            addValue(numbers[i]);
        }

        SB.append(maxQueue.firstEntry().getValue().get(0)).append(" ");
        System.out.println(maxQueue.values());

        for (int i = m; i<n; i++) {
            int removedNumber = list.removeFirst();

            if (maxQueue.containsKey(removedNumber)) {
                List<Integer> array = maxQueue.get(removedNumber);
                if (array.size() == 1)
                    maxQueue.remove(removedNumber);
                else
                    array.remove(array.size() - 1);
            }

            list.addLast(numbers[i]);
            addValue(numbers[i]);

            SB.append(maxQueue.firstEntry().getValue().get(0)).append(" ");
            System.out.println(maxQueue.values());
        }

        System.out.println(SB.toString());
    }

    void addValue(Integer i) {
        if (maxQueue.get(i) == null) {
            List<Integer> array = new ArrayList<>();
            array.add(i);
            maxQueue.put(i, array);
        }
        else {
            maxQueue.get(i).add(i);
        }
    }
}
