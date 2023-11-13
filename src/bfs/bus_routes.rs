use crate::Solution;
use std::collections::{HashMap, HashSet};

impl Solution {
    pub fn num_buses_to_destination(routes: Vec<Vec<i32>>, source: i32, target: i32) -> i32 {
        let mut map = HashMap::<i32, HashSet<i32>>::new();
        for (i, route) in routes.iter().enumerate() {
            let ii32 = i as i32;
            for j in route {
                map.entry(*j).or_insert(HashSet::new()).insert(ii32);
            }
        }
        let mut bfs = vec![[source, 0]];
        let mut seen = HashSet::new();
        seen.insert(source);
        while !bfs.is_empty() {
            let [cur, step] = bfs.remove(0);
            if cur == target {
                return step;
            }
            if let Some(routes) = map.get(&cur) {
                for route in routes {
                    if seen.contains(route) {
                        continue;
                    }
                    seen.insert(*route);
                    for stop in routes {
                        if !seen.contains(stop) {
                            bfs.push([*stop, step + 1]);
                        }
                    }
                }
            }
        }
        -1
    }
}
