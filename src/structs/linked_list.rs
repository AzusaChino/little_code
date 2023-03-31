use std::cell::RefCell;

#[derive(Clone, Debug)]
struct Node {
    val: i32,
    next: Option<Box<RefCell<Node>>>,
}

impl Node {
    fn new(val: i32) -> Box<RefCell<Node>> {
        Box::new(RefCell::new(Node { val, next: None }))
    }
}

struct LinkedList {
    head: Option<Box<RefCell<Node>>>,
    tail: Option<Box<RefCell<Node>>>,
    pub length: u64,
}

impl LinkedList {
    pub fn new() -> Self {
        Self {
            head: None,
            tail: None,
            length: 0,
        }
    }

    pub fn push(&mut self, val: i32) {
        let new_node = Node::new(val);
        match self.tail.take() {
            Some(old) => old.borrow_mut().next = Some(new_node.to_owned()),
            None => self.head = Some(new_node.to_owned()),
        }
        self.length += 1;
        self.tail = Some(new_node);
    }

    pub fn pop(&mut self) -> Option<i32> {
        self.head.take().map(|head| {
            if let Some(next) = head.borrow_mut().next.take() {
                self.head = Some(next);
            } else {
                self.tail.take();
            }
            self.length -= 1;
            head.borrow().val
        })
    }
}

#[test]
fn test() {
    let mut ll = LinkedList::new();
    ll.push(1);
    ll.push(2);
    println!("{}", ll.pop().unwrap());
}
