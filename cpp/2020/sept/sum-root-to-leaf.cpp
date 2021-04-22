int sumRootToLeaf(TreeNode *r, int val = 0) {
    if (r == nullptr) return 0;
    val = ((val << 1) + r->val) % 1000000007;
    return (r->left == r->right ? val : sumRootToLeaf(r->left, val) + sumRootToLeaf(r->right, val)) % 1000000007;
}