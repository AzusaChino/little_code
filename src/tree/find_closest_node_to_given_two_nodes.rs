use crate::Solution;

use std::cmp::max;

impl Solution {
    fn dfs(u: i32, d: &mut Vec<i32>, vis: &mut Vec<bool>, edges: &Vec<i32>) {
        // mark it visited
        vis[u as usize] = true;
        // check the outgoing edge
        let v = edges[u as usize];
        // -1 means there is no outgoing edge, so we skip it
        // if it is visited, we also skip it
        if v != -1 && !vis[v as usize] {
            // the dist going to node v form node u is simply d[u] + 1
            d[v as usize] = d[u as usize] + 1;
            // dfs on neigbour node `v`
            Self::dfs(v, d, vis, edges);
        }
    }

    pub fn closest_meeting_node(edges: Vec<i32>, node1: i32, node2: i32) -> i32 {
        let n = edges.len();
        // d1[i]: shortest dist to node i starting from node 1
        // d2[i]: shortest dist to nodes i starting from node 2
        let mut d1 = vec![i32::MAX; n];
        let mut d2 = vec![i32::MAX; n];
        // vis1[i]: true if node i is visited else false. used for building d1
        // vis2[i]: true if node i is visited else false. used for building d2
        let mut vis1 = vec![false; n];
        let mut vis2 = vec![false; n];
        // dist to node1 from node1 is 0, same as node2
        d1[node1 as usize] = 0;
        d2[node2 as usize] = 0;
        // build the dist for d1
        Self::dfs(node1, &mut d1, &mut vis1, &edges);
        // build the dist for d2
        Self::dfs(node2, &mut d2, &mut vis2, &edges);
        // iterate each node to find the min max dist
        let mut ans = -1;
        let mut mi = i32::MAX;
        for i in 0..n {
            if max(d1[i], d2[i]) < mi {
                mi = max(d1[i], d2[i]);
                ans = i as i32;
            }
        }
        return ans;
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
