use crate::Solution;

#[derive(Debug, Clone)]
struct Node {
    edges: Vec<i32>,
    // 0-25 for a - z
    label: u8,
    visited: bool,
}

impl Solution {
    pub fn count_sub_trees(n: i32, edges: Vec<Vec<i32>>, labels: String) -> Vec<i32> {
        // Node index => node info.
        let mut graph: Vec<Node> = vec![
            Node {
                edges: Vec::new(),
                label: 0,
                visited: false,
            };
            n as usize
        ];

        for edge in edges {
            graph[edge[0] as usize].edges.push(edge[1]);
            graph[edge[1] as usize].edges.push(edge[0]);
        }
        for (i, l) in labels.as_bytes().iter().enumerate() {
            graph[i].label = l - b'a';
        }

        let mut result = vec![0; n as usize];

        // Returns count of a - z in this subtree. Fills result[node].
        fn dfs(node: i32, graph: &mut [Node], result: &mut [i32]) -> [i32; 26] {
            let current_node = &mut graph[node as usize];
            current_node.visited = true;
            let label = current_node.label as usize;
            let mut count = [0i32; 26];
            count[label] += 1;
            let edges_len = current_node.edges.len();
            // Use simple loop instead of iterator to make the borrow checker happy.
            for i in 0..edges_len {
                let child = graph[node as usize].edges[i];
                if !graph[child as usize].visited {
                    let cc = dfs(child, graph, result);
                    for i in 0..26 {
                        count[i] += cc[i];
                    }
                }
            }
            result[node as usize] = count[label];
            count
        }
        dfs(0, &mut graph, &mut result);
        result
    }
}

#[cfg(test)]
mod tests {
    use crate::Solution;

    #[test]
    fn test() {
        let edges = vec![vec![0, 2], vec![0, 3], vec![1, 2]];
        let n = 4;
        let labels = String::from("aeed");

        let r = Solution::count_sub_trees(n, edges, labels);
        for (i, v) in r.iter().enumerate() {
            println!("{}, {}", i, v);
        }
    }

    #[test]
    fn test_resize() {
        let mut v: Vec<i32> = Vec::with_capacity(1);
        println!("{}, {}", v.len(), v.capacity());
        for (i, v) in v.iter().enumerate() {
            println!("{},{}", i, v);
        }
        v.resize(3, 99);
        println!("{}, {}", v.len(), v.capacity());
        for (i, v) in v.iter().enumerate() {
            println!("{},{}", i, v);
        }
    }
}
