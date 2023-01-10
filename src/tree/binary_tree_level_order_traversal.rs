use std::ops::Deref;

use super::OptNode;

use crate::Solution;

impl Solution {
    pub fn level_order(root: OptNode) -> Vec<Vec<i32>> {
        let mut queue = Vec::new();
        let mut ret = Vec::new();

        if let Some(r) = root {
            queue.push(r);
        }

        while !queue.is_empty() {
            let mut level = Vec::with_capacity(queue.len());
            let mut new_queue = Vec::with_capacity(queue.len() * 2);

            for node in queue.iter() {
                level.push(node.deref().borrow().val);
                if let Some(left) = node.borrow_mut().left.take() {
                    new_queue.push(left);
                }
                if let Some(right) = node.borrow_mut().right.take() {
                    new_queue.push(right);
                }
            }
            ret.push(level);
            queue = new_queue;
        }

        ret
    }
}
