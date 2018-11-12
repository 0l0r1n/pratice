public class IterableStackClient {

    public static <Item> StackLinkedList<Item> copy(StackLinkedList<Item> stackToCopy) {
        StackLinkedList<Item> copy = new StackLinkedList<Item>();
        for (Item item : stackToCopy) copy.push(item);
        return copy;
    }

}