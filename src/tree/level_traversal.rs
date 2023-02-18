use crate::{Solution, TreeNode};
use std::{cell::RefCell, ops::Div, rc::Rc};

use super::Node;

// leetcode - 102, 107, 199

impl Solution {
    pub fn _level_order(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<Vec<i32>> {
        let mut ret = Vec::new();

        if let Some(root) = root {
            let mut queue = Vec::new();
            queue.push(root);

            while !queue.is_empty() {
                let mut level = Vec::with_capacity(queue.len());
                let mut new_queue = Vec::with_capacity(queue.len() * 2);

                // simple using array & iter =>  queue.pop_front -> always take left first
                for node in queue.into_iter() {
                    level.push(node.borrow().val);
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
        }
        ret
    }

    pub fn level_in_iteration(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<Vec<i32>> {
        let mut ret = Vec::new();
        fn iterate(node: Option<Rc<RefCell<TreeNode>>>, levels: &mut Vec<Vec<i32>>, level: usize) {
            if let Some(node) = node {
                // add level
                if levels.len() == level {
                    levels.push(Vec::new());
                }
                levels[level].push(node.borrow().val);
                iterate(node.borrow().left.clone(), levels, level + 1);
                iterate(node.borrow().right.clone(), levels, level + 1);
            }
        }
        iterate(root, &mut ret, 0);
        ret
    }

    pub fn right_side_view(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        let r = Self::level_in_iteration(root);
        r.iter().map(|v| *v.last().unwrap()).collect()
    }

    pub fn average_of_levels(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<f64> {
        let r = Self::level_in_iteration(root);
        fn calc(v: &Vec<i32>) -> f64 {
            let sum = v.iter().fold(0, |acc, e| acc + e) as f64;
            sum.div(v.len() as f64)
        }
        r.iter().map(|v| calc(v)).collect()
    }

    pub fn nary_level_order(root: Option<Rc<RefCell<Node>>>) -> Vec<Vec<i32>> {
        let mut ret = Vec::new();
        fn iterate(node: Option<Rc<RefCell<Node>>>, levels: &mut Vec<Vec<i32>>, level: usize) {
            if let Some(node) = node {
                // add level
                if levels.len() == level {
                    levels.push(Vec::new());
                }
                levels[level].push(node.borrow().val);
                for child in node.borrow().children.to_owned() {
                    iterate(child, levels, level + 1)
                }
            }
        }
        iterate(root, &mut ret, 0);
        ret
    }

    pub fn largest_values(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        let r = Self::level_in_iteration(root);
        r.iter().map(|v| *v.iter().max().unwrap()).collect()
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
