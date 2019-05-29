import java.util.Stack;

public class MinStack extends Stack<Integer> {

    Stack<Integer> min;

    public MinStack() {
        min = new Stack<>();
    }

    public void push(int value) {
        if (getMin() > value) {
            min.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == getMin()) {
            s2.pop();
        }
        return value;
    }

    private Integer getMin() {
        if (min.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return min.peek();
    }
}