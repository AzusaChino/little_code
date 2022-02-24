package bst

import (
	"strconv"
	"strings"
)

const NIL = "nil"

type Codec struct {
}

func Constructor() Codec {
	return Codec{}
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) string {
	return serializeHelper(root, "")
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
	dataList := strings.Split(data, ",")
	return desHelper(dataList)
}

func serializeHelper(root *TreeNode, str string) string {
	if root == nil {
		str += NIL + ","
		return str
	}
	str += strconv.Itoa(root.Val) + ","
	str = serializeHelper(root.Left, str)
	str = serializeHelper(root.Right, str)

	return str
}

func desHelper(list []string) *TreeNode {
	if NIL == list[0] {
		list = list[1:]
		return nil
	}
	val, _ := strconv.Atoi(list[0])
	root := TreeNode{Val: val}
	list = list[1:]

	root.Left = desHelper(list)
	root.Right = desHelper(list)

	return &root
}
