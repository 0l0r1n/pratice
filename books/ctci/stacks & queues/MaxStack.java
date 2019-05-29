import java.util.Stack;

public class MaxStack extends Stack<Integer> {

    Stack<Integer> max;

    public MaxStack() {
        max = new Stack<>();
    }

    public void push(int value) {
        if (getMax() < value) {
            max.push(value);
        }
        super.push(value);
    }

    public Integer pop() {
        int value = super.pop();
        if (value == getMax()) {
            s2.pop();
        }
        return value;
    }

    private Integer getMax() {
        if (max.isEmpty()) {
            return Integer.max_VALUE;
        }
        return max.peek();
    }
}