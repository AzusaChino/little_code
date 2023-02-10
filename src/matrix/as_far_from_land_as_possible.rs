use crate::Solution;

use std::collections::VecDeque;

const LAND: i32 = 1;

impl Solution {
    pub fn max_distance(grid: Vec<Vec<i32>>) -> i32 {
        let mut queue = VecDeque::new();
        let mut dist = vec![vec![i32::MAX; grid[0].len()]; grid.len()];

        for r in 0..grid.len() {
            for c in 0..grid[r].len() {
                if grid[r][c] == LAND {
                    queue.push_back(((r, c), 0));
                    dist[r][c] = 0;
                }
            }
        }

        // There is either no land or water in the grid
        if queue.is_empty() || queue.len() == grid.len() * grid[0].len() {
            return -1;
        }

        let mut answer = -1;
        while let Some(((r, c), d)) = queue.pop_front() {
            if dist[r][c] <= d && d != 0 {
                continue;
            }

            dist[r][c] = d;
            answer = answer.max(d);

            if r > 0 && dist[r - 1][c] > d + 1 {
                queue.push_back(((r - 1, c), d + 1));
            }

            if c > 0 && dist[r][c - 1] > d + 1 {
                queue.push_back(((r, c - 1), d + 1));
            }

            if c < grid[r].len() - 1 && dist[r][c + 1] > d + 1 {
                queue.push_back(((r, c + 1), d + 1));
            }

            if r < grid.len() - 1 && dist[r + 1][c] > d + 1 {
                queue.push_back(((r + 1, c), d + 1));
            }
        }

        answer
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
