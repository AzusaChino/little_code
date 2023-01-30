#![allow(unused)]

use crate::LinkedList;
use std::cell::RefCell;
use std::collections::HashMap;
use std::rc::{Rc, Weak};

struct KeyValueNode<K, V> {
    key: K,
    value: V,
    freq_ref: Option<Weak<RefCell<LinkedList<PerFreqList<K, V>>>>>,
}

impl<K, V> KeyValueNode<K, V> {
    fn new(key: K, value: V) -> Self {
        Self {
            key,
            value,
            freq_ref: None,
        }
    }
}

struct PerFreqList<K, V> {
    freq: usize,
    head: Rc<RefCell<LinkedList<KeyValueNode<K, V>>>>,
    tail: Rc<RefCell<LinkedList<KeyValueNode<K, V>>>>,
    size: usize,
}

impl<K: Default, V: Default> PerFreqList<K, V> {
    fn new(freq: usize) -> Self {
        let mut head = LinkedList::new(KeyValueNode::new(K::default(), V::default()));
        let mut tail = LinkedList::new(KeyValueNode::new(K::default(), V::default()));
        let weak = Rc::downgrade(&head);
        head.borrow_mut().next = Some(tail.clone());
        tail.borrow_mut().prev = Some(weak);
        Self {
            freq: freq,
            head: head,
            tail: tail,
            size: 0,
        }
    }
    fn insert_node(&mut self, node: Rc<RefCell<LinkedList<KeyValueNode<K, V>>>>) {
        LinkedList::insert_after(self.head.clone(), node);
        self.size += 1;
    }
    fn evict_node(&mut self) -> Result<Rc<RefCell<LinkedList<KeyValueNode<K, V>>>>, ()> {
        let prev = self.tail.borrow().prev.clone();
        if self.size == 0 {
            return Err(());
        }
        match prev.and_then(|p| p.upgrade()) {
            Some(node) => {
                LinkedList::delete_node(node.clone());
                self.size -= 1;
                Ok(node)
            }
            _ => Err(()),
        }
    }
}

struct LFUCache {
    capacity: usize,
    size: usize,
    freq_list: Rc<RefCell<LinkedList<PerFreqList<i32, i32>>>>,
    map: HashMap<i32, Rc<RefCell<LinkedList<KeyValueNode<i32, i32>>>>>,
}

/**
 * `&self` means the method takes an immutable reference.
 * If you need a mutable reference, change it to `&mut self` instead.
 */
impl LFUCache {
    fn new(capacity: i32) -> Self {
        Self {
            capacity: (capacity as usize),
            size: 0,
            freq_list: LinkedList::new(PerFreqList::new(1)),
            map: HashMap::new(),
        }
    }

    fn get(&mut self, key: i32) -> i32 {
        if let Some(node) = self.map.get(&key) {
            let result = node.borrow().val.value;
            self.update_node(node.clone());
            result
        } else {
            -1
        }
    }

    fn put(&mut self, key: i32, value: i32) {
        if self.capacity == 0 {
            return;
        }

        if let Some(node) = self.map.get(&key) {
            // Update
            node.borrow_mut().val.value = value;
            self.update_node(node.clone());
        } else {
            if self.size == self.capacity {
                self.evict_node();
            }
            self.insert_node(key, value);
        }
    }

    fn evict_node(&mut self) -> Result<(), ()> {
        let to_evict = if self.freq_list.borrow().val.size > 0 {
            self.freq_list.clone()
        } else {
            match self.freq_list.borrow().next.as_ref() {
                Some(node) => node.clone(),
                _ => return Err(()),
            }
        };
        if to_evict.borrow().val.size == 0 {
            return Err(());
        }
        let node = to_evict.borrow_mut().val.evict_node()?;
        self.map.remove(&node.borrow().val.key);
        self.size -= 1;

        if to_evict.borrow().val.size == 0 && to_evict.borrow().val.freq != 1 {
            LinkedList::delete_node(to_evict);
        }
        Ok(())
    }

    fn insert_node(&mut self, key: i32, value: i32) {
        let node = LinkedList::new(KeyValueNode::new(key, value));
        self.map.insert(key, node.clone());
        self.size += 1;
        self.freq_list.borrow_mut().val.insert_node(node.clone());
        let weak = Rc::downgrade(&self.freq_list);
        node.borrow_mut().val.freq_ref = Some(weak);
    }

    fn update_node(&mut self, node: Rc<RefCell<LinkedList<KeyValueNode<i32, i32>>>>) {
        LinkedList::delete_node(node.clone());

        let old_freq_node_ref = node.borrow_mut().val.freq_ref.take();
        if let Some(old_freq_node) = old_freq_node_ref.and_then(|n| n.upgrade()) {
            // Leetcode rust version does not yet support let-else
            old_freq_node.borrow_mut().val.size -= 1;
            let next_freq = old_freq_node.borrow().val.freq + 1;
            let next_ref = old_freq_node.borrow().next.clone();
            let mut freq_node = match next_ref {
                Some(freq_node) if freq_node.borrow().val.freq == next_freq => freq_node,
                _ => {
                    let mut freq_node = LinkedList::new(PerFreqList::new(next_freq));
                    LinkedList::insert_after(old_freq_node.clone(), freq_node.clone());
                    freq_node
                }
            };

            freq_node.borrow_mut().val.insert_node(node.clone());
            let weak = Rc::downgrade(&freq_node);
            node.borrow_mut().val.freq_ref = Some(weak);

            if old_freq_node.borrow().val.size == 0 && old_freq_node.borrow().val.freq != 1 {
                LinkedList::delete_node(old_freq_node);
            }
        }
    }
}
