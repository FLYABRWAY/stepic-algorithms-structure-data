import java.util.Scanner;
import java.util.Stack;

class StackMaxNumber {

    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stackWithMax = new Stack<>();

    void check() {
        Scanner in = new Scanner(System.in);
        int number = in.nextInt();

        for (int i = 0; i<number; i++) {
            String operation = in.next();

            if (operation.equals("push")) {
                int numberToPush = in.nextInt();
                stack.push(numberToPush);

                if (stackWithMax.isEmpty())
                    stackWithMax.push(numberToPush);
                else {
                    Integer max = stackWithMax.peek();
                    if (max > numberToPush)
                        stackWithMax.push(max);
                    else
                        stackWithMax.push(numberToPush);
                }
            }
            else if (operation.equals("pop")) {
                stack.pop();
                stackWithMax.pop();
            }
            else if (operation.equals("max")) {
                System.out.println(stackWithMax.peek());
            }
        }
    }

}
