package sorting

// BubbleSort -> https://en.wikipedia.org/wiki/Bubble_sort
func BubbleSort(nums []int) {
	n := len(nums)
	swapped := true
	for swapped {
		swapped = false
		for i := 1; i < n; i++ {
			if nums[i-1] > nums[i] {
				nums[i-1], nums[i] = nums[i], nums[i-1]
				swapped = true
			}
		}
	}
}
