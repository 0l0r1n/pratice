package sorting

// InsertionSort runs at quadratic time
func InsertionSort(items []int) {
	n := len(items)
	for i := 0; i < n; i++ {
		j := i
		for j > 0 {
			if items[j-1] > items[i] {
				items[j-1], items[j] = items[j], items[j-1]
			}
		}
		j = j - 1
	}
}
