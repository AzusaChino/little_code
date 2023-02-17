use crate::{Solution, TreeNode};
use std::cell::RefCell;
use std::rc::Rc;

impl Solution {
    pub fn min_diff_in_bst(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        let (mut ret, mut prev) = (i32::MAX, -1);
        // using inorder to check differences
        fn inorder(node: &Option<Rc<RefCell<TreeNode>>>, prev: &mut i32, ret: &mut i32) {
            match node {
                Some(n) => {
                    inorder(&n.borrow().left, prev, ret);
                    // the question desribes that, not negatives
                    if *prev >= 0 {
                        let v = n.borrow().val - *prev;
                        *ret = v.min(*ret);
                    }
                    *prev = n.borrow().val;
                    inorder(&n.borrow().right, prev, ret);
                }
                None => {}
            }
        }
        inorder(&root, &mut prev, &mut ret);
        ret
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        println!("{}", Solution::default());
    }
}
