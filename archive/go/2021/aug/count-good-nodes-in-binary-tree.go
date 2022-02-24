package aug

import "leetcode/common"

func goodNodes(root *common.TreeNode) int {
    return goodNodes_(root, -10000)
}

func goodNodes_(root *common.TreeNode, ma int) int {
    if root == nil {
        return 0
    }
    var res int
    if root.Val >= ma {
        res = 1
    } else {
        res = 0
    }
    res += goodNodes_(root.Left, max(ma, root.Val))
    res += goodNodes_(root.Right, max(ma, root.Val))

    return res
}
