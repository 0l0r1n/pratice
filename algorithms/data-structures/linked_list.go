package datastrucs

type Node struct {
	Item interface{}
	Next *Node
}

func InsertList(n *Node, item interface{}) bool {
	if n.Next == nil {
		n.Next = &Node{Item: item}
		return true
	} else {
		return InsertList(n.Next, item)
	}
}

func SearchList(n *Node, item interface{}) *Node {
	if n == nil {
		return nil
	}
	if n.Item == item {
		return n
	}
	return SearchList(n.Next, item)
}

func RemoveList(n *Node, item interface{}) bool {
	if n.Next == nil && n.Item != item {
		return false
	}
	if n.Next.Item == item {
		n.Next = n.Next.Next
		return true
	}
	return RemoveList(n.Next, item)
}
