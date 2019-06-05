import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Stack;

public class SetOfStacks {

    private ArrayList<Stack> stacks = new ArrayList<>();
    private int threshold;    

    public SetOfStacks(int threshold) {
        this.threshold = threshold;
    }

    public void push(int value) {
        Stack last = getLastStack();
        if (last != null && !last.isFull()) last.push(value);
        else {
            Stack stack = new Stack(this.threshold);
            stack.push(value);
            stacks.add(s);
        }
    }

    public int pop() {
        Stack last = getLastStack();
        if (last == null) throw new EmptyStackException();
        int v = last.pop();
        if (last.size() == 0) stacks.remove(stacks.size() - 1);
        return v;
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    public int leftShift(int index, boolean removeTop) {
        Stack stack = stacks.get(index);
        int removedItem;
        if (removeTop) removedItem = stack.pop();
        else removedItem = stack.removeBottom();
        if (stack.isEmpty) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1) {
            int v = leftShift(index + 1, false);
            stack.push(v);
        }
        return removedItem;
    }

    private Stack getLastStack() {
        if (stacks.size() == 0) return null;
        return stacks.get(stacks.size() - 1);
    }
}