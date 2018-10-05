package algorithms

// RecursiveIncrement recursevily calculates the increment of a given integer
func RecursiveIncrement(n int) int {
	if n == 0 {
		return 1
	}
	if n%2 == 1 {
		return 2 * RecursiveIncrement(n/2)
	}
	return n + 1
}
