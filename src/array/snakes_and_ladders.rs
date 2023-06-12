use crate::Solution;

impl Solution {
    pub fn snakes_and_ladders(board: Vec<Vec<i32>>) -> i32 {
        let board: Vec<i32> = board
            .into_iter()
            .rev()
            .enumerate()
            .flat_map(|(idx, mut v)| match idx % 2 {
                0 => v,
                _ => {
                    v.reverse();
                    v
                }
            })
            .collect();
        let n = board.len();
        let mut visited = vec![false; n];
        let mut q = std::collections::VecDeque::new();
        q.push_back((0usize, 0i32));
        while let Some((curr, dist)) = q.pop_front() {
            if curr == n - 1 {
                return dist;
            }
            for i in (curr + 1)..=usize::min(curr + 6, n - 1) {
                let dest = match board[i] {
                    -1 => i,
                    x => x as usize - 1,
                };
                if !visited[dest] {
                    q.push_back((dest, dist + 1));
                    visited[dest] = true;
                }
            }
        }
        -1
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
