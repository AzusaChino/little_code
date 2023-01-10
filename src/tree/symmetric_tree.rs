use std::ops::Deref;

use super::OptNode;

use crate::Solution;

impl Solution {
    pub fn is_symmetric(root: OptNode) -> bool {
        fn dfs(n1: &OptNode, n2: &OptNode) -> bool {
            match (n1, n2) {
                (Some(n1), Some(n2)) => {
                    n1.deref().borrow().val == n2.deref().borrow().val
                        && dfs(&n1.borrow().left, &n2.borrow().right)
                        && dfs(&n1.borrow().right, &n2.borrow().left)
                }
                (None, None) => true,
                (_, _) => false,
            }
        }
        dfs(&root, &root)
    }
}
