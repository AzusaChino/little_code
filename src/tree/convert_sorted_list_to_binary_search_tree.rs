use crate::{ListNode, Solution, TreeNode};

use std::cell::RefCell;
use std::rc::Rc;

type Node = Option<Rc<RefCell<TreeNode>>>;

impl Solution {
    pub fn sorted_list_to_bst(mut head: Option<Box<ListNode>>) -> Node {
        //  turn linked list into array -> vec into binary tree
        let mut stack = Vec::new();
        while let Some(node) = head {
            stack.push(node.val);
            head = node.next;
        }
        Solution::_sorted_array_to_bst(&stack[..])
    }
    fn _sorted_array_to_bst(nums: &[i32]) -> Node {
        let n = nums.len();

        match n {
            0 => None,
            _ => {
                let m = n / 2;
                let mut node = TreeNode::new(nums[m]);
                node.left = Solution::_sorted_array_to_bst(&nums[..m]);
                node.right = Solution::_sorted_array_to_bst(&nums[m + 1..]);

                Some(Rc::new(RefCell::new(node)))
            }
        }
    }
}
