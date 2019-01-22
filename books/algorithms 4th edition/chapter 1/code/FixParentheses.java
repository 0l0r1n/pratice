import java.util.Set;
import edu.princeton.cs.algs4.*;

public class FixParentheses {

    private static String fix(String s) {
        StackLinkedList<Character> operators = new StackLinkedList<Character>();
        StackLinkedList<String> operands = new StackLinkedList<String>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-' || c == '*' || c == '/') operators.push(c);
            else if (Character.isDigit(c)) operands.push(String.valueOf(c));
            else {
                StringBuilder builder = new StringBuilder();
                String secondOperand = operands.pop();
                String firstOperand = operands.pop();
                Character operator = operators.pop();
                builder.append("(");
                builder.append(firstOperand);
                builder.append(operator);
                builder.append(secondOperand);
                builder.append(")");
                operands.push(builder.toString());
            }
        }
        return operands.pop();
    }
    public static void main(String[] args) {
        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            StdOut.println("Result: " + fix(s));
        }
    }

}