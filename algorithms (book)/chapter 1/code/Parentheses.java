import java.util.*;

import edu.princeton.cs.algs4.*;

public class Parentheses {

    private static boolean isBalanced(String s) {
        HashSet<Character> leftSize = new HashSet<Character>(Arrays.asList('(', '[', '{'));
        HashSet<Character> rightSize = new HashSet<Character>(Arrays.asList(')', ']', '}'));
        StackLinkedList<Character> stack = new StackLinkedList<Character>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (leftSize.contains(c)) 
                    stack.push(c);
            else if (rightSize.contains(c)) {
                if (stack.isEmpty()) return false;
                else {
                    char topOfStack = stack.pop();
                    if (c == ')' && topOfStack != '(' ||
                        c == ']' && topOfStack != '[' ||
                        c == '}' && topOfStack != '{') 
                        return false;
                }
            }
            else continue;
        } 
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        while(!StdIn.isEmpty()) {
            String s = StdIn.readString();
            StdOut.println("Result: balanced - " + isBalanced(s));
        }
    }
}