package sorting

// InsertionSort -> https://en.wikipedia.org/wiki/Insertion_sort
func InsertionSort(nums []int) {
	n := len(nums)
	for i := 1; i < n; i++ {
		j := i
		for j > 0 {
			if nums[j-1] > nums[j] {
				nums[j-1], nums[j] = nums[j], nums[j-1]
			}
			j = j - 1
		}
	}
}
