use crate::Solution;

impl Solution {
    pub fn min_time(n: i32, edges: Vec<Vec<i32>>, has_apple: Vec<bool>) -> i32 {
        let mut graph: Vec<Vec<i32>> = vec![Vec::new(); n as usize];
        let mut visited: Vec<bool> = vec![false; n as usize];
        let mut ret = 0;

        // 记录每个节点的连接节点
        for edge in edges.into_iter() {
            graph[edge[0] as usize].push(edge[1]);
            graph[edge[1] as usize].push(edge[0]);
        }

        for node in (0..has_apple.len()).rev() {
            // 有苹果，且未访问过，且不是根节点
            if has_apple[node] && !visited[node] && node != 0 {
                // 当前 index
                let mut cur = node;
                // 用于记录 向上返回的 index (最小，即是 父节点)
                let mut len = 0;
                while cur != 0 {
                    if visited[cur] {
                        break;
                    }
                    visited[cur] = true;
                    // 在 关联节点中 找到最小的那个
                    cur = *graph[cur].iter().min().unwrap() as usize;
                    len += 1;
                }
                ret += len;
            }
        }
        ret * 2
    }
}

#[cfg(test)]
mod tests {
    #[test]
    fn test() {
        let n = 4;
        let edges = vec![vec![0, 2], vec![0, 3], vec![1, 2]];
        let has_apple = vec![false, true, false, false];

        let r = crate::Solution::min_time(n, edges, has_apple);
        println!("{}", r);
    }

    #[test]
    fn test2() {
        let n = 7;
        let edges = vec![
            vec![0, 1],
            vec![0, 2],
            vec![1, 4],
            vec![1, 5],
            vec![2, 3],
            vec![2, 6],
        ];
        let has_apple = vec![false, false, true, false, true, true, false];

        let r = crate::Solution::min_time(n, edges, has_apple);
        println!("{}", r);
    }
}
