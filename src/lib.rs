use std::{cell::RefCell, rc::Rc};

// array related problems
mod array;

// dynamic programming problems
mod dp;

// tree problems
mod tree;

mod utils;

// declare pub use
pub use utils::convert_slice_vec;

#[derive(Debug, Default)]
pub struct Solution {}

#[derive(Debug, Default, PartialEq, Eq)]
pub struct TreeNode {
    pub val: i32,
    pub left: Option<Rc<RefCell<TreeNode>>>,
    pub right: Option<Rc<RefCell<TreeNode>>>,
}

impl TreeNode {
    #[inline]
    pub fn new(val: i32) -> Self {
        Self {
            val,
            left: None,
            right: None,
        }
    }
}
