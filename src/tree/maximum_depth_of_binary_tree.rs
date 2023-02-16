use std::{cell::RefCell, rc::Rc};

use super::OptNode;
use crate::{Solution, TreeNode};

impl Solution {
    pub fn max_depth(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        Self::max_depth_helper(&root)
    }

    fn max_depth_helper(node: &Option<Rc<RefCell<TreeNode>>>) -> i32 {
        match &node {
            Some(n) => {
                1 + Self::max_depth_helper(&n.borrow().left)
                    .max(Self::max_depth_helper(&n.borrow().right))
            }
            None => 0,
        }
    }

    pub fn _max_depth(root: &OptNode) -> i32 {
        match &root {
            Some(n) => {
                1 + Solution::_max_depth(&n.borrow().left)
                    .max(Solution::_max_depth(&n.borrow().right))
            }
            None => 0,
        }
    }
}
