use std::{cell::RefCell, rc::Rc};

// array related problems
mod array;

// dynamic programming problems
mod dp;

// number related problems
mod number;

// string problems
mod string;
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
