use crate::Solution;

impl Solution {
    pub fn longest_path(parent: Vec<i32>, s: String) -> i32 {
        let mut node_children: Vec<Vec<i32>> = vec![vec![]; parent.len()];
        // 记录各个节点的子节点
        for i in 1..parent.len() {
            node_children[parent[i] as usize].push(i as i32);
        }

        let mut ret = 0;

        fn dfs(node_children: &Vec<Vec<i32>>, s: &String, ret: &mut i32, i: i32) -> i32 {
            let mut prev = 0;
            let mut next = 0;
            for j in &node_children[i as usize] {
                let cur = dfs(node_children, s, ret, *j);
                if s.as_bytes()[i as usize] == s.as_bytes()[*j as usize] {
                    continue;
                }
                if cur > next {
                    next = cur;
                }
                if next > prev {
                    std::mem::swap(&mut prev, &mut next);
                }
            }
            let tmp = prev + next + 1;
            if tmp > *ret {
                *ret = tmp;
            }

            prev + 1
        }
        dfs(&node_children, &s, &mut ret, 0);
        ret
    }
}

#[cfg(test)]
mod tests {
    use crate::Solution;

    #[test]
    fn test() {
        let nodes = vec![-1, 0, 0, 0];
        let s = String::from("aabc");
        println!("{}", Solution::longest_path(nodes, s));
    }
}
