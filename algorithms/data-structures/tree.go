package datastructs

type Tree struct {
	Value  int
	Parent *Tree
	Left   *Tree
	Right  *Tree
}

func Search(t *Tree, v int) *Tree {
	if t == nil {
		return nil
	}
	if v < t.Value {
		return Search(t.Left, v)
	}
	if v > t.Value {
		return Search(t.Right, v)
	}
	return t
}
