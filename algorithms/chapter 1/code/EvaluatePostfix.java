import edu.princeton.cs.algs4.*;

public class EvaluatePostfix {

    private static int evaluate(String s) {
        int result = 0;
        StackLinkedList<Character> stack = new StackLinkedList<Character>();
        for (int index = 0; index < s.length(); index++) {
            StdOut.println(ch);
            char ch = s.charAt(index);
            if (Character.isDigit(ch)) stack.push(ch);
            else {
                while (!stack.isEmpty()){
                    int temp = stack.pop();
                    switch(ch) {
                        case '+':
                            result+=temp;
                            break;
                        case '-':
                            result-=temp;
                            break;
                        case '*':
                            result*=temp;
                            break;
                        case '/':
                            result/=temp;
                            break;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            StdOut.println("Result: " + evaluate(s));
        }
        StdOut.println();
    }

}