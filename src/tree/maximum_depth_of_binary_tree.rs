use super::OptNode;
use crate::Solution;

impl Solution {
    pub fn max_depth(root: &OptNode) -> i32 {
        match &root {
            Some(n) => {
                1 + Solution::max_depth(&n.borrow().left)
                    .max(Solution::max_depth(&n.borrow().right))
            }
            None => 0,
        }
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let _ = Solution::default();
    }
}
