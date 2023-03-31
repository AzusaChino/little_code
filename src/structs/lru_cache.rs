use std::collections::LinkedList;

#[derive(Clone, Debug)]
struct LRUCache {
    inner: LinkedList<i32>,
    sz: usize,
}

impl LRUCache {
    pub fn new(sz: usize) -> Self {
        Self {
            inner: LinkedList::new(),
            sz,
        }
    }

    pub fn add(&mut self, val: i32) {
        if self.inner.contains(&val) {
            let index = self.index_of(val).unwrap();
            // self.inner.remove(index);

        } else {
            if self.inner.len() >= self.sz {
                self.inner.pop_back();
            }
            self.inner.push_front(val);
            self.sz += 1;
        }
    }

    fn index_of(&self, val: i32) -> Option<usize> {
        self.inner.iter().position(|&x| x == val)
    }
}
