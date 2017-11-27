import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

class Brackets {

    void check() {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();

        Stack<Character> theStack = new Stack<>();  // make stack
        LinkedList<Integer> listOpenedBracketsIndexes = new LinkedList<>();

        for(int j = 0; j<input.length(); j++)  // get chars in turn
        {
            char ch = input.charAt(j);        // get char

            switch(ch) {

                case '{':                      // opening symbols
                case '[':
                case '(':
                    theStack.push(ch);          // push them
                    listOpenedBracketsIndexes.add(j);
                    break;

                case '}':                      // closing symbols
                case ']':
                case ')':
                    if( !theStack.isEmpty() )   // if stack not empty,
                    {
                        char chx = theStack.pop();  // pop and check
                        if( (ch == '}' && chx != '{')
                                || (ch == ']' && chx != '[')
                                || (ch == ')' && chx != '(') ) {
                            System.out.println(j + 1); //output closed bracket
                            return;
                        }
                        else {
                            listOpenedBracketsIndexes.removeLast();
                        }
                    }
                    else {                        // prematurely empty
                        System.out.println(j + 1); //output closed bracket
                        return;
                    }
                    break;
                default:    // no action on other characters
                    break;
            }  // end switch
        }  // end for

        // at this point, all characters have been processed
        if( !theStack.isEmpty() )
            System.out.println(listOpenedBracketsIndexes.getLast() + 1);
        else
            System.out.println("Success");

    }  // end check()

}
