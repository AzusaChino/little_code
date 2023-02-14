use crate::Solution;

impl Solution {
    pub fn num_islands(grid: Vec<Vec<char>>) -> i32 {
        if grid.is_empty() || grid[0].is_empty() {
            return 0;
        }
        let mut ret = 0;

        let mut grid = grid;

        for i in 0..grid.len() as i32 {
            for j in 0..grid[0].len() as i32 {
                if grid[i as usize][j as usize] == '1' {
                    ret += 1;
                    Self::sink_islands(&mut grid, i, j);
                }
            }
        }

        ret
    }

    fn sink_islands(grid: &mut Vec<Vec<char>>, i: i32, j: i32) {
        // not in grid
        if i < 0 || i >= grid.len() as i32 || j < 0 || j >= grid[0].len() as i32 {
            return;
        }
        let ii = i as usize;
        let jj = j as usize;
        // already sinked
        if grid[ii][jj] == '0' {
            return;
        }

        grid[ii][jj] = '0';
        Self::sink_islands(grid, i - 1, j);
        Self::sink_islands(grid, i + 1, j);
        Self::sink_islands(grid, i, j - 1);
        Self::sink_islands(grid, i, j + 1);
    }
}
#[cfg(test)]
mod tests {
    use super::Solution;

    #[test]
    fn test() {
        let grid = vec![
            vec!['1', '1', '1', '1', '0'],
            vec!['1', '1', '0', '1', '0'],
            vec!['1', '1', '0', '0', '0'],
            vec!['0', '0', '0', '0', '0'],
        ];
        println!("{}", Solution::num_islands(grid));
    }
}
