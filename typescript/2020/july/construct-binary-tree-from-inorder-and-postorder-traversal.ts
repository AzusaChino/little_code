import {TreeNode} from "../../common";


const buildTree = (inorder: Array<number>, postorder: Array<number>): TreeNode | null => {
    let p = 0, i = 0;
    const build = (stop: number) => {
        if (inorder[i] != stop) {
            let root = new TreeNode(postorder[p++],);
            root.left = build(root.val);
            i++;
            root.right = build(stop);
            return root;
        }
        return null;
    }
    return build(-1);
}
