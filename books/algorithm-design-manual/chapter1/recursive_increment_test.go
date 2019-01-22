package algorithms

import (
	"testing"
)

func TestRecursiveIncrement(t *testing.T) {
	n := RecursiveIncrement(4)
	if n != 5 {
		t.Errorf("Increment failed: %d", n)
	}
}
