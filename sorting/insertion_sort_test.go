package sorting

import (
	"sort"
	"testing"
)

func TestInsertionSort(t *testing.T) {
	data := []int{5, 3, 1, 24}
	BubbleSort(data)
	if !sort.IntsAreSorted(data) {
		t.Errorf("Data not sorted: %v", data)
	}
}
