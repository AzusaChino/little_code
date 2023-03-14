use crate::{Solution, TreeNode};
use std::cell::RefCell;
use std::rc::Rc;

impl Solution {
    pub fn sum_numbers(root: Option<Rc<RefCell<TreeNode>>>) -> i32 {
        let mut r = 0;
        fn iter_sum(root: &Option<Rc<RefCell<TreeNode>>>, n: &mut i32) -> i32 {
            match root {
                None => {
                    return 0;
                }
                Some(node) => {
                    *n = 10 * *n + node.borrow().val;

                    if node.borrow().left == node.borrow().right {
                        return *n;
                    }
                    return iter_sum(&node.borrow().left, n) + iter_sum(&node.borrow().right, n);
                }
            }
        }
        iter_sum(&root, &mut r);
        r
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        println!("{}", Solution::sum_numbers(None));
    }
}
