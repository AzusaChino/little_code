use crate::{Solution, TreeNode};

use std::cell::RefCell;
use std::rc::Rc;

// py
// class Solution:
//     def buildTree(self, inorder, postorder):
//         if not inorder or not postorder:
//             return None

//         root = TreeNode(postorder.pop())
//         inorderIndex = inorder.index(root.val) # Line A

//         root.right = self.buildTree(inorder[inorderIndex+1:], postorder) # Line B
//         root.left = self.buildTree(inorder[:inorderIndex], postorder) # Line C

//         return root

impl Solution {
    pub fn build_tree(inorder: Vec<i32>, postorder: Vec<i32>) -> Option<Rc<RefCell<TreeNode>>> {
        fn build(
            inorder: &Vec<i32>,
            x: usize,
            y: usize,
            postorder: &Vec<i32>,
            a: usize,
            b: usize,
        ) -> Option<Rc<RefCell<TreeNode>>> {
            if x > y || a > b {
                return None;
            }
            let val = postorder[b];
            let node = Rc::new(RefCell::new(TreeNode::new(val)));
            let mut index = x;
            while val != inorder[index] {
                index += 1;
            }
            node.borrow_mut().left = build(inorder, x, index - 1, postorder, a, a + index - x - 1);
            node.borrow_mut().right = build(inorder, index + 1, y, postorder, a + index - x, b - 1);
            Some(node)
        }
        build(
            &inorder,
            0,
            inorder.len() - 1,
            &postorder,
            0,
            postorder.len() - 1,
        )
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        println!("{:?}", Solution::build_tree(vec![], vec![]));
    }
}
