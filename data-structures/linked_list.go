package datastructs

type List struct {
	Item interface{}
	Next *List
}

func InsertList(n *List, item interface{}) bool {
	if n.Next == nil {
		n.Next = &List{Item: item}
		return true
	} else {
		return InsertList(n.Next, item)
	}
}

func SearchList(n *List, item interface{}) *List {
	if n == nil {
		return nil
	}
	if n.Item == item {
		return n
	}
	return SearchList(n.Next, item)
}

func RemoveList(n *List, item interface{}) bool {
	if n.Next == nil && n.Item != item {
		return false
	}
	if n.Next.Item == item {
		n.Next = n.Next.Next
		return true
	}
	return RemoveList(n.Next, item)
}
