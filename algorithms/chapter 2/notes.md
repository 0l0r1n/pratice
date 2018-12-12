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

## Insertion sort

For insertion sort, we make space to insert the current item by moving larger items one position to the right, before inserting the current item into the vacated position.

```java
class Insertion extends Sort {
    @Override
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
                exchange(a, j, j - 1);
        }
    }
}
```

## Shell Short

This is an algorithm based on insertion sort, but faster. The idea is to rearrange the array to give it the property that taking every hth entry yields a sorted subsequence (insertion sort works well for partially sorted arrays). An h-sorted array is h independent sorted subsequences, interleaved together. By h-sorting for some large value of h, we can move items in the rray long distances and thus make it easier to h-sort for smaller values of h.

```java
public class Shell extends Sort {

    public static void sort(Comparable[] a) {
        int n = a.length;
        int h = 1;
        while (h < n/3) h = 3*h + 1;
        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j>=h&& less(a[j], a[j-h]; j-=h)) exchange(a, j, j-h);
            }
            h = h/3;
        }
    }
}
```

## Merge Sort

The attractive property of merge sort is that it guarantees to sort any array of n items in time proportional to n log n. Its disadvantages is that is uses extra space poportional to n.

```java
private static void merge (Comparable[] a, int lo, int mid, int hi) {
    int i = lo, j = mid+1;

    for (int k = low; k <= hi; k++) auk[k] = a[k];

    for (int k = low; k <= hi; k++) {
        if (i > mid) a[k] = aux[j++];
        else if (j > hi) a[k] = aux[j++];
        else if (less(aux[j], aux[i])) a[k] = aux[j++];
        else a[k] = aux[j++];
    }
}
```