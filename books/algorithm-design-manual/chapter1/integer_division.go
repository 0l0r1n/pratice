package algorithms

// IntegerDivision performs a division without * or / operands
func IntegerDivision(dividend, divisor int) int {
	result := 1
	denominator := divisor
	for dividend > denominator {
		denominator <<= 1
		result <<= 1
	}
	for denominator > dividend {
		denominator -= divisor
		result--
	}
	return result
}
