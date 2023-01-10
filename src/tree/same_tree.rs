use std::ops::Deref;

use crate::Solution;

use super::OptNode;

impl Solution {
    pub fn is_same_tree(p: OptNode, q: OptNode) -> bool {
        fn dfs(p: &OptNode, q: &OptNode) -> bool {
            match (p, q) {
                (Some(x), Some(y)) => {
                    let x = x.deref().borrow();
                    let y = y.deref().borrow();
                    x.val == y.val && dfs(&x.left, &y.left) && dfs(&x.right, &y.right)
                }
                (None, None) => true,
                _ => false,
            }
        }
        dfs(&p, &q)
    }
}
