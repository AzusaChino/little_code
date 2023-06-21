use std::collections::HashMap;

use crate::{Solution, UnionFind};

impl Solution {
    pub fn number_of_good_paths(vals: Vec<i32>, edges: Vec<Vec<i32>>) -> i32 {
        let len = vals.len();
        let mut good_paths = 0;
        let mut adj: Vec<Vec<i32>> = vec![vec![]; len];
        let mut same_values = HashMap::<i32, Vec<i32>>::new();

        for (i, v) in vals.iter().enumerate() {
            let i = i as i32;
            if same_values.contains_key(v) {
                same_values.entry(*v).and_modify(|vec| vec.push(i));
            } else {
                same_values.insert(*v, vec![i]);
            }
        }
        for edge in edges {
            let u = edge[0];
            let v = edge[1];
            if vals[u as usize] >= vals[v as usize] {
                adj[u as usize].push(v);
            } else if vals[v as usize] >= vals[u as usize] {
                adj[v as usize].push(u);
            }
        }

        let mut uf = UnionFind::new(len as i32);

        for (_, nodes) in same_values.iter() {
            for u in nodes {
                for v in &adj[*u as usize] {
                    uf.connect(*u, *v);
                }
            }
            let mut group = HashMap::<i32, i32>::new();
            for n in nodes {
                let nf = uf.find(*n);
                if let std::collections::hash_map::Entry::Vacant(e) = group.entry(nf) {
                    e.insert(1);
                } else {
                    group.entry(nf).and_modify(|v| {
                        *v += 1;
                    });
                }
            }
            good_paths += nodes.len() as i32;

            for (_, sz) in group {
                good_paths += (sz * (sz - 1)) / 2;
            }
        }
        good_paths
    }
}

#[cfg(test)]
mod tests {
    use super::Solution;
    use crate::convert_slice_vec;

    #[test]
    fn test() {
        let vals = vec![1, 3, 2, 1, 3];
        let slc = [[0, 1], [0, 2], [2, 3], [2, 4]];
        let edges = convert_slice_vec(&slc);
        println!("{}", Solution::number_of_good_paths(vals, edges));
    }
}
