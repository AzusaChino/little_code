use crate::Solution;

impl Solution {
    pub fn shortest_alternating_paths(
        n: i32,
        red_edges: Vec<Vec<i32>>,
        blue_edges: Vec<Vec<i32>>,
    ) -> Vec<i32> {
        use std::collections::VecDeque;

        let mut adj: Vec<Vec<(usize, usize)>> = vec![vec![]; n as usize];

        for it in red_edges {
            adj[it[0] as usize].push((it[1] as usize, 1));
        }

        for it in blue_edges {
            adj[it[0] as usize].push((it[1] as usize, 0));
        }

        let mut vis = vec![vec![false; 2]; n as usize]; // for both colors

        let mut dist = vec![-1; n as usize];
        dist[0] = 0;
        vis[0][0] = true;
        vis[0][1] = true;

        let mut q = VecDeque::new();
        q.push_back((0, 0, 9)); // can insert anything usize, except 0 and 1, in place of 9

        while !q.is_empty() {
            let (node, temp_dis, is_red) = q.pop_front().unwrap();

            for it in &adj[node] {
                if !vis[it.0][it.1] && it.1 != is_red {
                    if dist[it.0] == -1 {
                        dist[it.0] = temp_dis + 1;
                    }

                    vis[it.0][it.1] = true;
                    q.push_back((it.0, temp_dis + 1, it.1));
                }
            }
        }

        dist
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let n = 3;
        let red_edges = vec![vec![0, 1], vec![1, 2]];
        let blue_edges = vec![];
        println!(
            "{:?}",
            Solution::shortest_alternating_paths(n, red_edges, blue_edges)
        );
    }
}
