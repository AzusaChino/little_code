use crate::{Solution, TreeNode};

use std::cell::RefCell;
use std::rc::Rc;
impl Solution {
    pub fn find_duplicate_subtrees(
        root: Option<Rc<RefCell<TreeNode>>>,
    ) -> Vec<Option<Rc<RefCell<TreeNode>>>> {
        let mut map = std::collections::HashMap::new();
        let mut ret = Vec::new();
        fn traverse(
            node: Option<Rc<RefCell<TreeNode>>>,
            memo: &mut std::collections::HashMap<String, u32>,
            ret: &mut Vec<Option<Rc<RefCell<TreeNode>>>>,
        ) -> String {
            match node {
                Some(node) => {
                    let l = traverse(node.borrow().left.clone(), memo, ret);
                    let r = traverse(node.borrow().right.clone(), memo, ret);
                    let sub_tree = format!("{},{},{}", l, r, node.borrow().val);
                    let freq = memo.get(&sub_tree).unwrap_or(&0);
                    if *freq == 1 {
                        ret.push(Some(node.clone()));
                    }
                    memo.entry(sub_tree.clone())
                        .and_modify(|v| *v += 1)
                        .or_insert(1);
                    sub_tree
                }
                None => "#".to_owned(),
            }
        }
        traverse(root, &mut map, &mut ret);
        ret
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
