package strings

// FindMatch is based on findmatch from Skiena's Algorithm Design Manual
func FindMatch(s, p string) bool {
	for i := 0; i <= len(s)-len(p); i++ {
		j := 0

		m := len(p)
		n := len(s)

		for j < m-n && s[i+j] == p[j] {
			j = j + 1
			if j == len(p) {
				return true
			}
		}
	}
	return false
}
