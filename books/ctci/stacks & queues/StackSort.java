import java.util.Stack;

public class StackSort {

    public static Stack<Integer> doSort(Stack<Integer> stack) {
        Stack<Integer> buffer = new Stack<>();
        buffer.push(stack.pop());
        while (!buffer.isEmpty()) {
            int el = buffer.pop();
            int current = stack.pop();
            if (current > el) {
                buffer.push(el);
                buffer.push(current);
            } else {
                stack.push(el);
                buffer.push(current);
            }
        }
        return buffer;
    }

    public static void sort(Stack<Integer> s) {
        Stack<Integer> r = new Stack<Integer>();
        while (!s.isEmpty()) {
            int temp = s.pop();
            while (!r.isEmpty() && r.peek() > temp) s.push(r.pop());
            r.push(temp);
        }
        while (!r.isEmpty()) s.push(r.pop());
    }
}