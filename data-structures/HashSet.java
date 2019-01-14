import java.util.HashMap;
import java.util.Iterator;

class HashSet<E> {
    private transient HashMap<E,Object> map;

    private static final Object PRESENT = new Object();

    public HashSet() {
        map = new HashMap<E,Object>();
    }

    public boolean add(E e) {
        return map.put(e, PRESENT) == null;
    }

    public boolean remove(E e) {
        return map.remove(e) == null;
    }

    public void clear() {
        map.clear();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public boolean contains(E e) {
        return map.containsKey(e);
    }

    public Iterator<E> iterator() {
        return map.keySet().iterator();
    }
}