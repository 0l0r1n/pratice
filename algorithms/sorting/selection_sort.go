package sorting

// SelectionSort -> https://en.wikipedia.org/wiki/Selection_sort
func SelectionSort(nums []int) {
	n := len(nums)
	for i := 1; i < n; i++ {
		min := i
		for j := i + 1; j < n; j++ {
			if nums[j] < nums[min] {
				min = j
			}
			nums[j], nums[min] = nums[min], nums[j]
		}
	}
}
