public interface Stack<Item> {
    boolean isEmpty();
    int size();
    Item pop();
    void push(Item item);
    Item peek();
}