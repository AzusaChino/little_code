use std::cell::RefCell;
use std::rc::Rc;

use crate::TreeNode;

pub type OptNode = Option<Rc<RefCell<TreeNode>>>;

mod binary_tree_level_order_traversal;
mod binary_tree_preorder_traversal;
mod check_completeness_of_a_binary_tree;
mod convert_sorted_array_to_binary_search_tree;
mod convert_sorted_list_to_binary_search_tree;
mod find_closest_node_to_given_two_nodes;
mod find_duplicate_subtrees;
mod invert_binary_tree;
mod level_traversal;
mod longest_path_with_different_adjacent_characters;
mod maximum_depth_of_binary_tree;
mod minimum_distance_between_bst_nodes;
mod minimum_time_to_collect_all_apples_in_a_tree;
mod number_of_good_paths;
mod number_of_nodes_in_the_sub_tree_with_the_same_label;
mod same_tree;
mod sum_root_to_leaf_numbers;
mod symmetric_tree;
mod binary_tree_zigzag_level_order_traversal;

#[derive(Debug, PartialEq, Eq)]
pub struct Node {
    pub val: i32,
    pub children: Vec<Option<Rc<RefCell<Node>>>>,
}

impl Node {
    #[inline]
    pub fn new(val: i32) -> Self {
        Node {
            val,
            children: Vec::new(),
        }
    }

    pub fn from_vec(v: Vec<Option<i32>>) -> Option<Rc<RefCell<Node>>> {
        let mut v = std::collections::VecDeque::from(v);
        let v0 = v.pop_front()??;
        let root = Some(Rc::new(RefCell::new(Node::new(v0))));
        let mut queue = std::collections::VecDeque::new();
        queue.push_back(root.clone());
        let none = v.pop_front()?;
        assert!(none.is_none());
        while !v.is_empty() {
            let node = queue.pop_front()?;
            loop {
                if v.is_empty() {
                    break;
                }
                let val = v.pop_front()?;
                if let Some(val) = val {
                    let child = Some(Rc::new(RefCell::new(Node::new(val))));
                    node.as_ref()?.borrow_mut().children.push(child.clone());
                    queue.push_back(child);
                } else {
                    break;
                }
            }
        }
        root
    }
}

#[cfg(test)]
mod tests {

    use std::{cell::RefCell, rc::Rc};

    use crate::TreeNode;

    use super::OptNode;

    #[test]
    fn tests() {
        let root = OptNode::None;
        preorder(&root);
        inorder(&root);
        postorder(&root);
        let _ = preorder_traversal(None);
        let _ = inorder_traversal(None);
        let _ = postorder_traversal(None);
        let _ = traversal(None);
        let _ = invert(None);
    }

    fn preorder(root: &OptNode) {
        match root {
            None => {}
            Some(node) => {
                let v = &node.borrow().val;
                println!("{}", v);
                preorder(&node.borrow().left);
                preorder(&node.borrow().right);
            }
        }
    }

    fn inorder(root: &OptNode) {
        match root {
            None => {}
            Some(node) => {
                preorder(&node.borrow().left);
                let v = &node.borrow().val;
                println!("{}", v);
                preorder(&node.borrow().right);
            }
        }
    }

    fn postorder(root: &OptNode) {
        match root {
            None => {}
            Some(node) => {
                preorder(&node.borrow().left);
                preorder(&node.borrow().right);
                let v = &node.borrow().val;
                println!("{}", v);
            }
        }
    }

    //前序
    pub fn preorder_traversal(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        let mut res = vec![];
        let mut stack = vec![root];
        while !stack.is_empty() {
            if let Some(node) = stack.pop().unwrap() {
                res.push(node.borrow().val);
                stack.push(node.borrow().right.clone());
                stack.push(node.borrow().left.clone());
            }
        }
        res
    }
    //中序
    pub fn inorder_traversal(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        let mut res = vec![];
        let mut stack = vec![];
        let mut node = root;

        while !stack.is_empty() || node.is_some() {
            while let Some(n) = node {
                node = n.borrow().left.clone();
                stack.push(n);
            }
            if let Some(n) = stack.pop() {
                res.push(n.borrow().val);
                node = n.borrow().right.clone();
            }
        }
        res
    }
    //后序
    pub fn postorder_traversal(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        let mut res = vec![];
        let mut stack = vec![root];
        while !stack.is_empty() {
            if let Some(node) = stack.pop().unwrap() {
                res.push(node.borrow().val);
                stack.push(node.borrow().left.clone());
                stack.push(node.borrow().right.clone());
            }
        }
        res.into_iter().rev().collect()
    }

    pub fn traversal(root: Option<Rc<RefCell<TreeNode>>>) -> Vec<i32> {
        let mut res = vec![];
        let mut stack = vec![];
        if root.is_some() {
            stack.push(root);
        }
        while !stack.is_empty() {
            if let Some(node) = stack.pop().unwrap() {
                if node.borrow().right.is_some() {
                    stack.push(node.borrow().right.clone());
                }
                stack.push(Some(node.clone()));
                stack.push(None);
                if node.borrow().left.is_some() {
                    stack.push(node.borrow().left.clone());
                }
            } else {
                res.push(stack.pop().unwrap().unwrap().borrow().val);
            }
        }
        res
    }

    pub fn invert(root: Option<Rc<RefCell<TreeNode>>>) -> Option<Rc<RefCell<TreeNode>>> {
        return if let Some(n) = root {
            let l = n.borrow().left.clone();
            let r = n.borrow().right.clone();
            n.borrow_mut().left = invert(r);
            n.borrow_mut().right = invert(l);
            Some(n)
        } else {
            None
        };
    }
}
