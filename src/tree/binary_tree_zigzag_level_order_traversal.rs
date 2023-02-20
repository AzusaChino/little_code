use crate::{Solution, TreeNode};

use std::cell::RefCell;
use std::rc::Rc;

impl Solution {
    pub fn zigzag_level_order(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<Vec<i32>> {
        let mut ret = Vec::new();
        let mut queue = Vec::new();

        if let Some(root) = root {
            queue.push(root);
            let mut zigzag_direction = false;
            while !queue.is_empty() {
                let mut cur_level = Vec::new();
                let mut new_queue = Vec::new();

                for n in queue {
                    let n = n.borrow();
                    if let Some(l) = n.left.to_owned() {
                        new_queue.push(l);
                    }
                    if let Some(r) = n.right.to_owned() {
                        new_queue.push(r);
                    }
                    if zigzag_direction {
                        cur_level.insert(0, n.val);
                    } else {
                        cur_level.push(n.val);
                    }
                }

                zigzag_direction = !zigzag_direction;
                queue = new_queue;
                ret.push(cur_level.to_owned());
            }
        }
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
