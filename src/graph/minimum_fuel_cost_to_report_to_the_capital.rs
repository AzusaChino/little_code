use crate::Solution;

impl Solution {
    pub fn minimum_fuel_cost(roads: Vec<Vec<i32>>, seats: i32) -> i64 {
        match roads
            .iter()
            .fold(vec![Vec::new(); roads.len() + 1], |mut graph, e| {
                match e[..] {
                    [from, to] => {
                        graph[from as usize].push(to as usize);
                        graph[to as usize].push(from as usize);
                        graph
                    }
                    _ => panic!("never"),
                }
            }) {
            graph => match |i, from| travel(i, from, &graph, seats as usize) {
                travel => travel(0, None),
            },
        }
        .1
    }
}

fn travel(i: usize, from: Option<usize>, graph: &Vec<Vec<usize>>, seats: usize) -> (usize, i64) {
    match graph[i].iter().fold((1, 0), |pass @ (c, ans), &n| {
        match from.map_or(true, |from| n != from) {
            true => match travel(n, Some(i), graph, seats) {
                (nc, na) => (c + nc, ans + na),
            },
            false => pass,
        }
    }) {
        (c, ans) => (
            c,
            match from {
                None => ans,
                _ => ans + (c / seats) as i64 + if c % seats != 0 { 1 } else { 0 },
            },
        ),
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
