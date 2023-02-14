use crate::Solution;

impl Solution {
    pub fn closed_island(grid: Vec<Vec<i32>>) -> i32 {
        if grid.is_empty() {
            0
        } else {
            let mut grid = grid;
            // 从四周入手，sink掉所有关联岛屿，剩余的都是closed lands
            let (x, y) = (grid.len(), grid[0].len());
            // sink y-axis
            for i in 0..y {
                Self::sink_islands_(&mut grid, 0, i as i32);
                Self::sink_islands_(&mut grid, (x - 1) as i32, i as i32);
            }
            // sink x-axis
            for i in 0..x {
                Self::sink_islands_(&mut grid, i as i32, 0);
                Self::sink_islands_(&mut grid, i as i32, (y - 1) as i32);
            }

            let mut ret = 0;
            for i in 0..x {
                for j in 0..y {
                    if grid[i][j] == 0 {
                        ret += 1;
                        Self::sink_islands_(&mut grid, i as i32, j as i32);
                    }
                }
            }
            ret
        }
    }

    fn sink_islands_(grid: &mut Vec<Vec<i32>>, i: i32, j: i32) {
        // not in grid
        if i < 0 || i >= grid.len() as i32 || j < 0 || j >= grid[0].len() as i32 {
            return;
        }
        let ii = i as usize;
        let jj = j as usize;
        // already sinked
        if grid[ii][jj] == 1 {
            return;
        }

        grid[ii][jj] = 1;
        Self::sink_islands_(grid, i - 1, j);
        Self::sink_islands_(grid, i + 1, j);
        Self::sink_islands_(grid, i, j - 1);
        Self::sink_islands_(grid, i, j + 1);
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
