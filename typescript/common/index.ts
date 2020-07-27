interface TreeNodeInterface {
    val: number;
    left: TreeNode | null;
    right: TreeNode | null;
}

export class TreeNode implements TreeNodeInterface {
    left: TreeNode | null;
    right: TreeNode | null;
    val: number;

    constructor(val?: number, left?: TreeNode | null, right?: TreeNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.left = (left === undefined ? null : left)
        this.right = (right === undefined ? null : right)
    }
}

export class ListNode {
    val: number;
    next: ListNode | null;
    before: ListNode | null;

    constructor(val: number) {
        this.val = val;
    }

}