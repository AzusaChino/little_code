use std::{
    cell::RefCell,
    fmt::Display,
    rc::{Rc, Weak},
};

// array related problems
mod array;

// backtrack
mod backtrack;

// dynamic programming problems
mod dp;

// math solve problem
mod math;

// matrix problem
mod matrix;

// number related problems
mod number;

// string problems
mod string;

// struct design problems
mod structs;

// tree problems
mod tree;

mod utils;

// sliding window problems
mod window;

// declare pub use
pub use utils::{convert_slice_vec, gcd};

#[derive(Debug, Default)]
pub struct Solution {}

impl Display for Solution {
    fn fmt(&self, f: &mut std::fmt::Formatter<'_>) -> std::fmt::Result {
        write!(f, "(Solution)")
    }
}

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

#[derive(Debug, Default)]
pub struct UnionFind {
    id: Vec<i32>,
    rank: Vec<i32>,
    cnt: i32,
}

impl UnionFind {
    pub fn new(cnt: i32) -> Self {
        let uc = cnt as usize;

        let mut v = vec![0; uc];
        for i in 0..uc {
            v[i] = i as i32;
        }

        Self {
            id: v,
            rank: vec![0; uc],
            cnt,
        }
    }

    pub fn find(&mut self, p: i32) -> i32 {
        let pu = p as usize;
        if self.id[pu] == p {
            p
        } else {
            self.id[pu] = self.find(self.id[pu]);
            return self.id[pu];
        }
    }

    pub fn connected(&mut self, p: i32, q: i32) -> bool {
        self.find(p) == self.find(q)
    }

    pub fn connect(&mut self, p: i32, q: i32) {
        let x = self.find(p);
        let y = self.find(q);
        if x == y {
            return;
        }
        let i = x as usize;
        let j = y as usize;
        if self.rank[i] < self.rank[j] {
            self.id[i] = y;
        } else {
            self.id[j] = x;
            if self.rank[i] == self.rank[j] {
                self.rank[j] += 1;
            }
        }
        self.cnt -= 1;
    }
}

pub struct LinkedList<T> {
    pub prev: Option<Weak<RefCell<LinkedList<T>>>>,
    pub next: Option<Rc<RefCell<LinkedList<T>>>>,
    pub val: T,
}

impl<T> LinkedList<T> {
    pub fn new(val: T) -> Rc<RefCell<Self>> {
        Rc::new(RefCell::new(Self {
            prev: None,
            next: None,
            val,
        }))
    }
    fn insert_after(node: Rc<RefCell<LinkedList<T>>>, to_add: Rc<RefCell<LinkedList<T>>>) {
        let mut old_next = node.borrow_mut().next.take();
        to_add.borrow_mut().prev = Some(Rc::downgrade(&node));
        if let Some(on) = old_next.as_mut() {
            on.borrow_mut().prev = Some(Rc::downgrade(&to_add));
        }
        to_add.borrow_mut().next = old_next;
        node.borrow_mut().next = Some(to_add);
    }
    fn delete_node(node: Rc<RefCell<LinkedList<T>>>) -> Rc<RefCell<LinkedList<T>>> {
        let next = node.borrow_mut().next.take();
        let prev = node.borrow_mut().prev.take();
        if let Some(next_node) = next.as_ref() {
            next_node.borrow_mut().prev = prev.clone();
        }
        if let Some(prev_node_weak) = prev {
            if let Some(prev_node) = prev_node_weak.upgrade() {
                prev_node.borrow_mut().next = next;
            }
        }
        node
    }
}

#[cfg(test)]
mod tests {

    #[test]
    fn test() {
        let uc: usize = 5;
        let mut v = vec![0; uc];
        for i in 0..uc {
            v[i] = i as i32;
        }

        println!("{:?}", v);
    }
}
