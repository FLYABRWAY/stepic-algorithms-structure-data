import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class HighTree {

    void check() {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        int[] array = new int[n];
        for (int i = 0; i<n; i++)
            array[i] = in.nextInt();

        Map<Integer, List<Integer>> parentAndChilds = new HashMap<>(n);

        for (int i = 0; i<array.length; i++) {
            if (parentAndChilds.containsKey(array[i])) {
                parentAndChilds.get(array[i]).add(i);
            } else {
                List<Integer> arr = new ArrayList<>();
                arr.add(i);
                parentAndChilds.put(array[i], arr);
            }
        }

        if (!parentAndChilds.containsKey(-1)) {
            System.out.println(0);
        } else {
            int height = height(-1, parentAndChilds);
            System.out.println(height);
        }

    }

    int height(int data, Map<Integer, List<Integer>> parentAndChilds) {
        List<Integer> childs = parentAndChilds.get(data);
        if (childs == null)
            return 0;

        int height = 1;
        for (int i = 0; i<childs.size(); i++)
            height = Math.max(height, 1 + height(childs.get(i), parentAndChilds));

        return height;
    }

}