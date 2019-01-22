import edu.princeton.cs.algs4.*;

public class EvaluatePostfix {

    public static void main(String[] args) {
        StackLinkedList<Integer> stack = new StackLinkedList<Integer>();
        int result = 0;
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
        
            if (Character.isDigit(s.charAt(0))) stack.push(Integer.parseInt(s));
            else {
                while (!stack.isEmpty()) {
                    int nextInt = stack.pop();
                    switch(s) {
                        case "+":
                            result += nextInt;
                            break;
                        case "-":
                            result -= nextInt;
                            break;
                        case "*":
                            result *= nextInt;
                            break;
                        case "/":
                            result /= nextInt;
                            break;
                        default:
                            throw new UnsupportedOperationException("That is not a character that we expected!");
                    }
                }
            }
            StdOut.println("Result: " + result);
        }
    }

}