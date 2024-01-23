use crate::Solution;
use std::borrow::Borrow;
use std::cell::RefCell;
use std::rc::Rc;

use super::TreeNode;

impl Solution {
    pub fn amount_of_time(root: Option<Rc<RefCell<TreeNode>>>, start: i32) -> i32 {
        fn find_target(node: &Option<Rc<RefCell<TreeNode>>>, tar: i32) -> (i32, i32) {
            match node {
                Some(x) => {
                    let (l_dep, level_L) = find_target(&x.borrow().left, tar);
                    let (r_dep, level_R) = find_target(&x.borrow().right, tar);

                    if x.borrow().val == tar {
                        return (l_dep.max(r_dep) + 1, 1);
                    }

                    if level_L > 0 {
                        (l_dep.max(r_dep + 1 + level_L), level_L + 1)
                    } else if level_R > 0 {
                        (r_dep.max(l_dep + 1 + level_R), level_R + 1)
                    } else {
                        (l_dep.max(r_dep) + 1, 0)
                    }
                }
                None => (0, 0),
            }
        }

        find_target(&root, start).0 - 1
    }
}
