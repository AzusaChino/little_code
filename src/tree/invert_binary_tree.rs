use crate::{Solution, TreeNode};
use std::cell::RefCell;
use std::rc::Rc;

impl Solution {
    pub fn invert_tree(root: Option<Rc<RefCell<TreeNode>>>) -> Option<Rc<RefCell<TreeNode>>> {
        match root {
            Some(root) => {
                let l = root.borrow().left.clone();
                let r = root.borrow().right.clone();

                root.borrow_mut().left = Self::invert_tree(r);
                root.borrow_mut().right = Self::invert_tree(l);

                Some(root)
            }
            None => None,
        }
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
