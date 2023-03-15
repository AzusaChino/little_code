use crate::{Solution, TreeNode};

use std::cell::RefCell;
use std::rc::Rc;

impl Solution {
    // level order iteration
    pub fn is_complete_tree(root: Option<Rc<RefCell<TreeNode>>>) -> bool {
        let mut v = std::collections::VecDeque::new();
        v.push_back(root);
        while v.back().is_some() {
            let n = v.pop_back().expect("what tf");
            if let Some(n) = n {
                v.push_back(n.borrow().left.to_owned());
                v.push_back(n.borrow().right.to_owned());
            }
        }
        // there should be no Some after any None
        while !v.is_empty() && v.back().expect("tf").is_none() {
            v.pop_back();
        }
        v.is_empty()
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        println!("{}", Solution::is_complete_tree(None));
    }
}
