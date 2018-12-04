# Sorting

Sorting is the process of rearranging a sequence of objhects so as to put them in some logical order. For example. your credit card bill presents transactions in order by date. In the early days of computing, 30% of all computing cycles were spent sorting.

Primary concern is for rearranging arrays where every item contains a key.

## Selection Sort

One of the simplest sorting algorithms:

- Find the smallest item in the array and exchange it with the first entry (itself if the first entry is already the smallest)
- Find the next smallest item and exchange with the second entry
- Continue until the array is sorted

```java
class Selection extends Sort {

    @Override
    public static void sort(Comparable[]a ) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i + 1; j < n; j++) {
                if (less(a[j], a[min])) min = j;
            exchange(a, i, min);
            }
        }
    }
}
```