#![allow(unused)]

mod data_stream_as_disjoint_intervals;
mod lfu_cache;
mod linked_list;
mod lru_cache;
mod trie;


struct UnionFind {
    parent: Vec<usize>,
    rank: Vec<usize>,
    count: usize,
}

impl UnionFind {
    pub fn new(n: usize) -> UnionFind {
        Self {
            parent: (0..n).collect(),
            rank: vec![1; n],
            count: n,
        }
    }

    pub fn find(&mut self, x: usize) -> usize {
        if x != self.parent[x] {
            self.parent[x] = self.find(self.parent[x]);
        }
        self.parent[x]
    }

    pub fn union(&mut self, p: usize, q: usize) {
        let root_p = self.find(p);
        let root_q = self.find(q);
        if root_p == root_q {
            return;
        }
        if self.rank[root_p] > self.rank[root_q] {
            self.parent[root_q] = root_p;
            self.rank[root_p] += self.rank[root_q]
        } else {
            self.parent[root_p] = root_q;
            self.rank[root_q] += self.rank[root_p]
        }
        self.count -= 1;
    }

    pub fn count(&self) -> usize {
        self.count
    }
}
