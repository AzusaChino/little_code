use crate::Solution;

use std::collections::VecDeque;

const LAND: i32 = 1;

impl Solution {
    // wrong answer
    pub fn _max_distance(grid: Vec<Vec<i32>>) -> i32 {
        let len: usize = grid.len();
        let mut grid = grid.clone();
        let mut q = VecDeque::new();
        for i in 0..len {
            for j in 0..len {
                if grid[i][j] == LAND {
                    q.push_back((i, j, 0));
                }
            }
        }

        if q.is_empty() || q.len() == len * len {
            return -1;
        }

        let mut d = -1;
        let dir: Vec<(i32, i32)> = vec![(1, 0), (-1, 0), (0, 1), (0, -1)];

        while let Some((i, j, n)) = q.pop_front() {
            for (x, y) in &dir {
                let nx: i32 = i as i32 + *x;
                let ny: i32 = j as i32 + *y;
                if nx >= 0
                    && nx < (n as i32)
                    && ny >= 0
                    && ny < (n as i32)
                    && grid[nx as usize][ny as usize] == 0
                {
                    grid[nx as usize][ny as usize] = 1;
                    q.push_back((nx as usize, ny as usize, n + 1));
                    d = d.max(n + 1);
                }
            }
        }
        d
    }

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
        let grid = vec![vec![1, 0, 1], vec![0, 0, 0], vec![1, 0, 1]];
        println!("{}", Solution::_max_distance(grid));
    }
}
