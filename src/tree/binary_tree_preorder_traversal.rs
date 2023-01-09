use std::cell::RefCell;
use std::rc::Rc;

use crate::{Solution, TreeNode};

type OptNode = Option<Rc<RefCell<TreeNode>>>;

impl Solution {
    pub fn preorder_traversal(root: OptNode) -> Vec<i32> {
        let mut v: Vec<i32> = Vec::new();
        Self::do_traversal(&root, &mut v);
        v
    }

    fn do_traversal(node: &OptNode, v: &mut Vec<i32>) {
        if let Some(rv) = node.as_ref() {
            let b = rv.borrow();
            v.push(b.val);
            Self::do_traversal(&b.left, v);
            Self::do_traversal(&b.right, v);
        }
    }
}
