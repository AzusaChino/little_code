use std::{cell::RefCell, rc::Rc};

use crate::{Solution, TreeNode};

use super::OptNode;

impl Solution {
    pub fn sorted_array_to_bst(nums: Vec<i32>) -> OptNode {
        Self::recurse(&nums)
    }

    fn recurse(nums: &[i32]) -> OptNode {
        if nums.is_empty() {
            OptNode::None
        } else {
            // split at mid index
            let (l, r) = nums.split_at(nums.len() / 2);
            // always take right part as highest
            let (curr, right) = r.split_first().unwrap();

            OptNode::Some(Rc::new(RefCell::new(TreeNode {
                val: *curr,
                left: Self::recurse(l),
                right: Self::recurse(right),
            })))
        }
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let nums = vec![-10, -3, 0, 5, 9];
        println!("{:?}", Solution::sorted_array_to_bst(nums));
    }
}
